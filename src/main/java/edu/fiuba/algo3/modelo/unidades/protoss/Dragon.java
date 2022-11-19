package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.unidades.UnidadProtoss;

public class Dragon extends UnidadProtoss {

    public Dragon() {
        this.costoEnMinerales = new Mineral(125);
        this.costoEnGas = new GasVespeno(50);
        this.tiempoConstruccion = 6;
        this.danioAereo = new Danio(20);
        this.danioTerrestre = new Danio(20);
        this.rango = 4;
        this.vida = new Vida(100);
        this.escudo = new Escudo(80);
    }

}
