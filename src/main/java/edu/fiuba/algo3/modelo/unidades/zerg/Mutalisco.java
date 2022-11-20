package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;

public class Mutalisco extends UnidadZerg {

    public Mutalisco(GasVespeno gasVespenoDelJugador, Mineral mineralDelJugador, Coordenada coordenadaDeLaUnidad) {
        this.costoEnGas = new GasVespeno(25);
        this.costoEnMinerales = new Mineral(75);
        this.tiempoConstruccion = 7;
        this.danioAereo = new Danio(9);
        this.danioTerrestre = new Danio(9);
        this.rango = 3;
        this.vida = new Vida(120);
        this.aerea = true;
        this.coordenada = coordenadaDeLaUnidad;
    }

}
