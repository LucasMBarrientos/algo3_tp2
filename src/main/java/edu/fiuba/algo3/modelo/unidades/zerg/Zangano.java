package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;

public class Zangano extends UnidadZerg {

    public Zangano(GasVespeno gasVespenoDelJugador, Mineral mineralDelJugador, Coordenada coordenadaDeLaUnidad) {
        gasVespenoDelJugador.gastar(new GasVespeno(0));
        mineralDelJugador.gastar(new Mineral(25));
        this.tiempoConstruccion = 1;
        this.danioAereo = new Danio(0);
        this.danioTerrestre = new Danio(0);
        this.rango = 0;
        this.vida = new Vida(25);
        this.coordenada = coordenadaDeLaUnidad;
    }

    public void construirEdificio(EdificioZerg edificio, Coordenada coordenada) {
        // TODO: Implementar esto
    }

}
