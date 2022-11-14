package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.unidades.UnidadProtoss;

public class Dragon extends UnidadProtoss {

    public Dragon() {
        this.requerimientosMinerales = 125;
        this.requerimientosGas = 50;
        this.tiempoConstruccion = 6;
        this.danioAereo = new Danio(20);
        this.danioTerrestre = new Danio(20);
        this.rango = 4;
        this.vida = new Vida(100);
        this.escudo = new Escudo(80);
    }

}
