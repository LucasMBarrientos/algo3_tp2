package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;

public class Zealot extends UnidadProtoss {

    public Zealot() {
        this.requerimientosMinerales = 100;
        this.tiempoConstruccion = 4;
        this.danioTerrestre = 8;
        this.rango = 1;
        this.vida = new Vida(100);
        this.escudo = new Escudo(60);
    }

}
