package edu.fiuba.algo3.modelo.estadisticas;

public class Danio {

    private int poder;

    public Danio(int poder) {
        this.poder = poder;
    }

    public int aplicarDanio(int estadistica) {
        return estadistica - this.poder;
    }

}
