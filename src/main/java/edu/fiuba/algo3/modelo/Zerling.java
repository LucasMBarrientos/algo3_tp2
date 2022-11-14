package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.estadisticas.Vida;

public class Zerling extends UnidadZerg {

    public Zerling() {
        this.requerimientosMinerales = 25;
        this.tiempoConstruccion = 2;
        this.danioTerrestre = 4;
        this.rango = 1;
        this.vida = new Vida(35);
    }

}
