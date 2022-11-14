package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.estadisticas.Vida;

public class Mutalisco extends UnidadZerg {

    public Mutalisco() {
        this.requerimientosMinerales = 100;
        this.requerimientosGas = 100;
        this.tiempoConstruccion = 7;
        this.danioAereo = 9;
        this.danioTerrestre = 9;
        this.rango = 3;
        this.vida = new Vida(120);
        this.aerea = true;
    }

}
