package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.JugadorProtoss;
import edu.fiuba.algo3.modelo.JugadorZerg;
import edu.fiuba.algo3.modelo.direcciones.Arriba;
import edu.fiuba.algo3.modelo.direcciones.Derecha;
import edu.fiuba.algo3.modelo.edificios.zerg.espiral.Espiral;
import org.junit.jupiter.api.Test;

public class CasoDeUso20 {

    @Test
    public void unidadTerrestreNoPuedeEntrarAAreaEspacial(){
        AlgoStar algoStar = new AlgoStar();
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
        algoStar.agregarJugador(jugadorZerg);
        algoStar.empezarJuego();

        jugadorZerg.construirEdificio(new Coordenada(10,9),new Espiral());

        //jugadorZerg.devolInventario().;

        algoStar.hallarJugadorActual().generarUnidad(new Coordenada(10,9));

        algoStar.hallarJugadorActual().moverse(new Coordenada(10,9),new Arriba());


    }
}
