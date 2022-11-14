package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;
import edu.fiuba.algo3.modelo.estadisticas.Danio;

public class Zerling extends UnidadZerg {

    public Zerling() {
        this.requerimientosMinerales = 25;
        this.tiempoConstruccion = 2;
        this.danioTerrestre = new Danio(4);
        this.rango = 1;
        this.vida = new Vida(35);
    }

}
