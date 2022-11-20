package edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoConoceEstaUnidad;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

public class ReservaDeReproduccionOperativa implements EstadoReservaDeReproduccion {

    private ReservaDeReproduccion reservaDeReproduccion;

    
    @Override
    public ReservaDeReproduccion terminarConstruccion() {
        return reservaDeReproduccion;
    }

    @Override
    public ReservaDeReproduccion deshacerConstruccion() {
        reservaDeReproduccion.establecerEstado(new ReservaDeReproduccionEnConstruccion());
        return reservaDeReproduccion;
    }

    @Override
    public void establecerReservaDeReproduccion(ReservaDeReproduccion reservaDeReproduccion) {
        this.reservaDeReproduccion = reservaDeReproduccion;
    }

    public Unidad generarUnidad(Zerling unidad){
        return unidad;
    }

    @Override
    public void actualizar() {
        this.reservaDeReproduccion.vida.regenerar();
    }
}
