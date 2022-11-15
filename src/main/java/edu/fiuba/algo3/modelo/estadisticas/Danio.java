package edu.fiuba.algo3.modelo.estadisticas;

public class Danio {

    private int danioDelGolpe;

    public Danio(int danioDelGolpe){
        this.danioDelGolpe = danioDelGolpe;
    }

    public int aplicarDanio(int estadistica){
        return estadistica - danioDelGolpe;
    }

}
