package edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoConoceEstaUnidad;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoTerminoDeConstruirse;
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

public class ReservaDeReproduccionEnConstruccion implements EstadoReservaDeReproduccion {

    private ReservaDeReproduccion reservaDeReproduccion;

    @Override
    public ReservaDeReproduccion terminarConstruccion() {
        reservaDeReproduccion.establecerEstado(new ReservaDeReproduccionOperativa());
        return reservaDeReproduccion;
    }

    public Unidad generarUnidad(Zerling unidad)throws EdificioNoTerminoDeConstruirse{
        throw new EdificioNoTerminoDeConstruirse();
    }

    @Override
    public ReservaDeReproduccion deshacerConstruccion() {
        return reservaDeReproduccion;
    }

    @Override
    public void establecerReservaDeReproduccion(ReservaDeReproduccion reservaDeReproduccion) {
        this.reservaDeReproduccion = reservaDeReproduccion;
    }

    @Override
    public void actualizar() {
        if(this.reservaDeReproduccion.reducirTiempoConstruccion(1)) {
            this.terminarConstruccion();
        }
    }
}
