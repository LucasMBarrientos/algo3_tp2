package edu.fiuba.algo3.modelo.edificios;

import java.util.List;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.recursos.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.terrenos.EstadoTerreno;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public abstract class EdificioZerg extends Edificio {

    public Terreno terreno;
    public Recursos costoEnMinerales;
    public List<EstadoTerreno> posiblesTerrenos;
    public List<Edificio> edificiosNecesarios;
    private String nombre;

    public abstract void actualizar(Inventario inventario);


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