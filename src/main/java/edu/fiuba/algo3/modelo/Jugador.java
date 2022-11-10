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
        if (this.mapa.buscarCasilla(x,y).devolverUnidad() instanceof Constructor) {
            Constructor unidadConstructora = (Constructor) this.mapa.buscarCasilla(x,y).devolverUnidad();
            unidadConstructora.construir(edificio,mapa.buscarCasilla(x,y));
        }
    }

}
