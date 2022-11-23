package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public abstract class UnidadZerg extends Unidad {


    public abstract boolean ocupar(Terreno terreno);

    public void consumirRecursosParaGenerarse(Inventario inventario){
        inventario.consumirLarva();
        inventario.consumirMinerales(costoEnMinerales);
        inventario.consumirGasVespeno(costoEnGas);
    }

    public void ejecutarDanio(Danio danioTerrestre, Danio danioAereo) {
      if (aerea) {
        if(this.vida.recibirDanio(danioAereo)){
          this.establecerEstado(new UnidadDestruida());
        }
      } else {
        if(this.vida.recibirDanio(danioAereo)){
          this.establecerEstado(new UnidadDestruida());
        }
      }
    }

    public void regenerar(){
      vida.regenerar();
    }

}
