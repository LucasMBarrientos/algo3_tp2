package edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class ReservaDeReproduccionEnConstruccion implements EstadoReservaDeReproduccion {

    private ReservaDeReproduccion reservaDeReproduccion;

    @Override
    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Mineral mineral, Coordenada coordenada) throws EdificioNoTerminoDeConstruirse{
        throw new EdificioNoTerminoDeConstruirse();
    }

    @Override
    public ReservaDeReproduccion terminarConstruccion() {
        reservaDeReproduccion.establecerEstado(new ReservaDeReproduccionOperativa());
        return reservaDeReproduccion;
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
