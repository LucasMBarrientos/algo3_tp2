package edu.fiuba.algo3.modelo.estadisticas;

import edu.fiuba.algo3.modelo.excepciones.AtaqueImposibleDeRealizarse;

public class Danio {

    private int poder;

    public Danio(int poder) {
        this.poder = poder;
    }

    public int aplicarDanio(int estadistica) {
        return estadistica - this.poder;
    }

}
