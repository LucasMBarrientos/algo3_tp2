package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Jugador {

    protected Mapa mapa;

    protected List<Unidad> unidadesDisponibles = new ArrayList<Unidad>();

    public void establecerMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public Unidad buscarUnidadDisponible(int id) {
        return this.unidadesDisponibles.get(id);
    }

    public void moverUnidad(Unidad unidad, Casilla nuevaCasilla) {
        if (this.mapa.validarMovimiento(unidad, nuevaCasilla)) {
            unidad.intentarMoverse(nuevaCasilla);
        }
    }

    public abstract Casilla generarUnidad(Casilla casilla);

    //public abstract void construirEdificio(int x, int y, Edificio edificio);

    public void construirEdificio(int x, int y, Edificio edificio) {
        if (this.mapa.buscarCasilla(x,y).devolverEdificio() instanceof Constructor) {
            Unidad unidadConstructora = this.mapa.buscarCasilla(x,y).devolverUnidad();
            this.construirEdificio(unidadConstructora, edificio);
        }
    };

    public void construirEdificio(Unidad unidad, Edificio edificio) {
        Casilla ubicacionDelEdificio = unidad.devolverCasilla();
        if (edificio.validarRequerimientosDelCasillero(ubicacionDelEdificio)) {
            ((Constructor)unidad).construir(edificio, unidad.devolverCasilla());
        }
    }

}
