package edu.fiuba.algo3.modelo.edificios;

import java.util.List;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.EdificioDestruido;
import edu.fiuba.algo3.modelo.excepciones.EdificioRequiereDeOtro;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.terrenos.EstadoTerreno;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public abstract class EdificioZerg extends Edificio {

    public Terreno terreno;
    public Recursos costoEnMinerales;
    public Recursos costoEnGas;
    public List<EstadoTerreno> posiblesTerrenos;
    public List<Edificio> edificiosNecesarios;
    public Vida vida;
    private String nombre;
    public int tiempoDeConstruccion;

    public Edificio construir(Inventario inventario){
      try {
        if(this.validarCorrelativas(inventario)){
          this.consumirRecursosParaConstruccion(inventario);
          return this;
        }else{
          throw new EdificioRequiereDeOtro();
        }
      } catch(RecursosInsuficientes e) {
        throw new RecursosInsuficientes();
      }
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

    public boolean reducirTiempoConstruccion(int tiempoAReducir){
      if (this.tiempoDeConstruccion-tiempoAReducir > 0) {
        this.tiempoDeConstruccion = this.tiempoDeConstruccion-tiempoAReducir;
        return false;
      } else {
        return true;
      }
    }

    public void recibirGolpe(Danio danio) throws EdificioDestruido {
        vida.recibirDanio(danio);
    }
/*
    protected void regenerarVida() {
        if (vida < vidaMax) {
            vida += (0.1 * vidaMax);
        }
        if (vida > vidaMax) {
            vida = vidaMax;
        }
    }

    public boolean recibirDanio(int unidades) {
        reducirVida(unidades);
        return (vida <= 0);
    }
*/
}