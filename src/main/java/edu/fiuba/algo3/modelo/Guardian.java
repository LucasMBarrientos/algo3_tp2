package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.estadisticas.Vida;

public class Guardian extends UnidadZerg {

    public Guardian() {
        this.requerimientosMinerales = 50;
        this.requerimientosGas = 100;
        this.tiempoConstruccion = 4;
        this.danioTerrestre = 25;
        this.rango = 10;
        this.vida = new Vida(100);
        this.aerea = true;
    }

}
