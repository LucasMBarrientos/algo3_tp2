package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;

public class Guardian extends UnidadZerg {

    public Guardian() {
        this.requerimientosMinerales = 50;
        this.requerimientosGas = 100;
        this.tiempoConstruccion = 4;
        this.danioTerrestre = new Danio(25);
        this.rango = 10;
        this.vida = new Vida(100);
        this.aerea = true;
    }

}
