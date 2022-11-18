package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;

public class Hidralisco extends UnidadZerg {

    public Hidralisco(GasVespeno gasVespenoDelJugador, Minerales mineralesDelJugador, Coordenada coordenadaDeLaUnidad) {
        gasVespenoDelJugador.gastar(new GasVespeno(25));
        mineralesDelJugador.gastar(new Minerales(75));
        this.tiempoConstruccion = 4;
        this.danioAereo = new Danio(10);
        this.danioTerrestre = new Danio(10);
        this.rango = 4;
        this.vida = new Vida(80);
        this.coordenada = coordenadaDeLaUnidad;
    }

}
