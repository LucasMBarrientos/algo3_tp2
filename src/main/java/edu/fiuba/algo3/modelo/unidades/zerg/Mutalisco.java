package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.unidades.UnidadOperativa;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;

public class Mutalisco extends UnidadZerg {

    public Mutalisco() {
        this.costoEnMinerales = new Minerales(100);
        this.costoEnGas = new GasVespeno(100);
        this.tiempoConstruccion = 7;
        this.danioAereo = new Danio(9);
        this.danioTerrestre = new Danio(9);
        this.rango = 3;
        this.vida = new Vida(120);
        this.aerea = true;
    }


}
