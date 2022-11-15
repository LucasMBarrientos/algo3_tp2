package edu.fiuba.algo3.modelo.edificios;

import java.util.List;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.recursos.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.terrenos.EstadoTerreno;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoNoAptoParaConstruirEsteEdificio;

public abstract class EdificioProtoss extends Edificio {

    
    public Terreno terreno;
    public Recursos costoEnMinerales;
    public List<EstadoTerreno> posiblesTerrenos;
    public List<Edificio> edificiosNecesarios;
    private String nombre;

    public void actualizar() {
        
    }

    public Edificio construir(Inventario inventario){
      try {
        if(this.validarCorrelativas(inventario)){
          this.consumirRecursosParaConstruccion(inventario);
          return this;
        }
      } catch(RecursosInsuficientes e) {
        throw new RecursosInsuficientes();
      }
      return null;
    }

    public void consumirRecursosParaConstruccion(Inventario inventario){
        inventario.consumirMinerales(costoEnMinerales);
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
