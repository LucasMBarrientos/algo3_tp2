package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;

public class Dragon extends UnidadProtoss {

    public Dragon() {
        this.requerimientosMinerales = 125;
        this.requerimientosGas = 50;
        this.tiempoConstruccion = 6;
        this.danioAereo = 20;
        this.danioTerrestre = 20;
        this.rango = 4;
        this.vida = new Vida(100);
        this.escudo = new Escudo(80);
    }

}
