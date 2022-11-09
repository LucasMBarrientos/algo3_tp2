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

    //public abstract void construirEdificio(int x, int y, Edificio edificio);

    public void construirEdificio(int x, int y, Edificio edificio) {
        if (this.mapa.buscarCasilla(x,y).devolverOcupante() instanceof Constructor) {
            // Si ya esta construyendo algo entonces empieza otra construccion nueva
            Casilla ubicacionDelEdificio = mapa.buscarCasilla(x,y);
            Constructor unidadConstructora = (Constructor)ubicacionDelEdificio.devolverOcupante();
            unidadConstructora.construir(edificio, ubicacionDelEdificio);
        }
    };

    public void construirEdificio(Unidad unidad, Edificio edificio) {
        ((Constructor)unidad).construir(edificio, unidad.devolverCasilla());
    }

}
