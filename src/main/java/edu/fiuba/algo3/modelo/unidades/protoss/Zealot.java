package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.unidades.UnidadProtoss;

public class Zealot extends UnidadProtoss {

    public Zealot() {
        this.requerimientosMinerales = 100;
        this.tiempoConstruccion = 4;
        this.danioTerrestre = new Danio(8);
        this.rango = 1;
        this.vida = new Vida(100);
        this.escudo = new Escudo(60);
    }

}
