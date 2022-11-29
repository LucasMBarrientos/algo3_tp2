package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public abstract class UnidadProtoss extends Unidad {

    protected Escudo escudo;
    
    public Escudo devolverEscudo() {
        return escudo;
    }

    public abstract boolean ocupar(Terreno terreno);

    public void consumirRecursosParaGenerarse(Inventario inventario){
        inventario.consumirMinerales(costoEnMinerales);
        inventario.consumirGasVespeno(costoEnGas);
        inventario.consumirSuministro(costoSuministro);
    }

    public void ejecutarDanio(Danio danioTerrestre, Danio danioAereo) {
      if (aerea) {
        if(this.vida.recibirDanio(new Danio(escudo.recibirDanio(danioAereo) * (-1)))){
          this.establecerEstado(new UnidadDestruida());
        }
      } else {
        if(this.vida.recibirDanio(new Danio(escudo.recibirDanio(danioTerrestre) * (-1)))){
          this.establecerEstado(new UnidadDestruida());
        }
      }
    }

    public void regenerar(){
      escudo.regenerar();
    }
}
