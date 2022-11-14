package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.estadisticas.Vida;

public class Hidralisco extends UnidadZerg {

    public Hidralisco() {
        this.requerimientosMinerales = 75;
        this.requerimientosGas = 25;
        this.tiempoConstruccion = 4;
        this.danioAereo = 10;
        this.danioTerrestre = 10;
        this.rango = 4;
        this.vida = new Vida(80);
    }

}
