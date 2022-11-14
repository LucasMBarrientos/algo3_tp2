package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;

public class Scout extends UnidadProtoss {

    public Scout() {
        this.requerimientosMinerales = 300;
        this.requerimientosGas = 150;
        this.tiempoConstruccion = 9;
        this.danioAereo = 20;
        this.danioTerrestre = 8;
        this.rango = 4;
        this.vida = new Vida(150);
        this.escudo = new Escudo(100);
        this.aerea = true;
    }

}
