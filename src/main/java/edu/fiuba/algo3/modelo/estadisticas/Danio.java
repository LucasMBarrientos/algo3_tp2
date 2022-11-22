package edu.fiuba.algo3.modelo.estadisticas;

import edu.fiuba.algo3.modelo.excepciones.AtaqueImposibleDeRealizarse;

public class Danio {

    private int poder;

    public Danio(int poder) {
        this.poder = poder;
    }

    public int aplicarDanio(int estadistica) {
        if (this.poder == 0) {
            throw new AtaqueImposibleDeRealizarse();
        }
        return estadistica - this.poder;
    }

}
