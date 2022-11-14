package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.unidades.UnidadProtoss;
import edu.fiuba.algo3.modelo.estadisticas.Danio;

public class Scout extends UnidadProtoss {

    public Scout() {
        this.requerimientosMinerales = 300;
        this.requerimientosGas = 150;
        this.tiempoConstruccion = 9;
        this.danioAereo = new Danio(14);
        this.danioTerrestre = new Danio(8);
        this.rango = 4;
        this.vida = new Vida(150);
        this.escudo = new Escudo(100);
        this.aerea = true;
    }

}
