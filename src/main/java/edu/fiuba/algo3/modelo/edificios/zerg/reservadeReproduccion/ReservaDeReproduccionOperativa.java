package edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

public class ReservaDeReproduccionOperativa implements EstadoReservaDeReproduccion {

    private ReservaDeReproduccion reservaDeReproduccion;

    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Minerales minerales, Coordenada coordenada) {
        return edificioConLarvas.consumirLarvasYGenerarUnidad(new Zerling(gasVespeno, minerales, coordenada));
    }
    
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

    @Override
    public void actualizar() {
        this.reservaDeReproduccion.vida.regenerar();
    }
}
