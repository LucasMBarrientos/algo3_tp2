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

    public abstract Casilla generarUnidad(Casilla casilla);

    public abstract void construirEdificio(int x, int y, Edificio edificio);

}
