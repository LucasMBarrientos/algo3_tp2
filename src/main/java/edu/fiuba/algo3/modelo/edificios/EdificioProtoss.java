package edu.fiuba.algo3.modelo.edificios;

import java.util.List;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.EdificioDestruido;
import edu.fiuba.algo3.modelo.excepciones.ConstruccionRequiereDeOtroEdificio;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.terrenos.EstadoTerreno;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public abstract class EdificioProtoss extends Edificio {

    
    public Terreno terreno;
    public Recursos costoEnMinerales;
    public Recursos costoEnGas;
    public List<EstadoTerreno> posiblesTerrenos;
    public List<Edificio> edificiosNecesarios;
    public Vida vida;
    public Escudo escudo;
    private String nombre;
    public int tiempoDeConstruccion;

    public Edificio construir(Inventario inventario){
      try {
        if (this.validarCorrelativas(inventario)) {
          this.consumirRecursosParaConstruccion(inventario);
          return this;
        } else {
          throw new ConstruccionRequiereDeOtroEdificio();
        }
      } catch(RecursosInsuficientes e) {
        throw new RecursosInsuficientes();
      }
    }

    public void consumirRecursosParaConstruccion(Inventario inventario){
        inventario.consumirMinerales(costoEnMinerales);
        //TODO: Revisar consumo de gas
    }

    public boolean validarCorrelativas(Inventario inventario){
      return !inventario.faltanEdificios(edificiosNecesarios);
    }

    public abstract void ocupar(Casilla casilla, Terreno terreno);
    
    public void establecerTerreno(Terreno terreno){
      this.terreno = terreno;
    }

    public List<EstadoTerreno> posiblesEstados(){
      return posiblesTerrenos;
    }

    public boolean compararCon(Edificio edificoAComparar){
      return (this.nombre == edificoAComparar.devolverNombre());
    }

    public String devolverNombre(){
      return this.nombre;
    }

    public boolean reducirTiempoConstruccion(int tiempoAReducir){
      if(this.tiempoDeConstruccion-tiempoAReducir > 0){
        this.tiempoDeConstruccion = this.tiempoDeConstruccion-tiempoAReducir;
        return false;
      }else{
        return true;
      }
    }
    public void recibirGolpe(Danio danio) throws EdificioDestruido {
        int escudoRestante;
        escudoRestante = escudo.recibirDanio(danio);
        if(escudoRestante < 0){
            vida.recibirDanio(new Danio(escudoRestante * (-1)));
        }
    }


    /*
    protected int escudo;
    protected int escudoMax;

    protected boolean operativo;

    protected void regenerarEscudo() {
        if (escudo < escudoMax) {
            escudo += (0.2 * escudoMax);
        }
        if (escudo > escudoMax) {
            escudo = escudoMax;
        }
    }

    protected void reducirEscudo(int unidades) {
        escudo -= unidades;
    }

    public boolean recibirDanio(int unidades) {
        if (unidades < escudo) {
            reducirEscudo(unidades);
        } else {
            reducirVida(unidades - escudo);
            escudo = 0;
        }
        return (vida <= 0);
    }

    public void establecerOperatividad(boolean operativo) {
        this.operativo = operativo;
    }

    public boolean devolverOperatividad() {
        return operativo;
    }

    public int devolverEscudo(){
        return escudo;
    }
    
*/
}
