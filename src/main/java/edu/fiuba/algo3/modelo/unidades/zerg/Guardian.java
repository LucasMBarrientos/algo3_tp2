package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;

public class Guardian extends UnidadZerg {

    public Guardian() {
        this.costoEnMinerales = new Minerales(50);
        this.costoEnGas = new GasVespeno(100);
        this.tiempoConstruccion = 4;
        this.danioTerrestre = new Danio(25);
        this.rango = 10;
        this.vida = new Vida(100);
        this.aerea = true;
    }

}
