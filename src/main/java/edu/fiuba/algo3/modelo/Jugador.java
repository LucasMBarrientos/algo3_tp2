package edu.fiuba.algo3.modelo;

public abstract class Jugador {

    public Mapa mapa;

    public void establecerMapa(Mapa mapa) {

        this.mapa = mapa;
    }



    public abstract void generarUnidad(Casilla casilla);


    public abstract void construirEdificio(int x, int y, Edificio edificio);


}
