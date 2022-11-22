package edu.fiuba.algo3.modelo.edificios;

import java.util.List;

import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.excepciones.ConstruccionRequiereDeOtroEdificio;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.EstadoTerreno;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

public abstract class EdificioZerg extends Edificio {

    public abstract void validarCorrelativasDeConstruccion(Inventario inventario);

    public abstract void ocupar(Terreno terreno);

    public void establecerTerreno(Terreno terreno) {
        this.terreno = terreno;
    }

    /*public boolean reducirTiempoConstruccion(int tiempoAReducir) {
        if (this.tiempoDeConstruccion-tiempoAReducir > 0) {
            this.tiempoDeConstruccion = this.tiempoDeConstruccion-tiempoAReducir;
            return false;
        } else {
            return true;
        }
    }*/

    /*public void recibirDanio(Danio danio) throws EdificioEstaDestruido {
        vida.recibirDanio(danio);
    }*/

    public void ejecutarDanio(Danio danio){
      if(this.vida.recibirDanio(danio)){
        this.establecerEstado(this.estadoDestruido);
      }
    }

    public void regenerar(){
      vida.regenerar();
    }

}
