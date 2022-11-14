package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;

public class Hidralisco extends UnidadZerg {

    public Hidralisco() {
        this.requerimientosMinerales = 75;
        this.requerimientosGas = 25;
        this.tiempoConstruccion = 4;
        this.danioAereo = new Danio(10);
        this.danioTerrestre = new Danio(10);
        this.rango = 4;
        this.vida = new Vida(80);
    }

}
