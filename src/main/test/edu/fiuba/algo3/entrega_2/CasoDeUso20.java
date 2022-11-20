package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.geometria.direcciones.*;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.espiral.Espiral;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso20 {

    /*

    @Test
    public void unidadTerrestreNoPuedeEntrarAAreaEspacial(){
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Mapa mapa = algoStar.devolverMapa();

        Casilla casillaConAreaEspacial = mapa.buscarCasilla(new Coordenada(10,10));

        //algoStar.devolverMapa().buscarCasilla(new Coordenada(10,9)).establecerUnidad(new Zangano());

        jugadorZerg.construirEdificio(new Coordenada(10,9),new Criadero());

        for (int i = 0; i < 5; i++) {
            algoStar.pasarTurno();
        }

        Casilla casillaConCriadero = algoStar.devolverMapa().buscarCasilla(new Coordenada(10,9));

        jugadorZerg.generarUnidad(casillaConCriadero);

        jugadorZerg.moverUnidad(casillaConCriadero,new Arriba());

        Assertions.assertNull(casillaConAreaEspacial.devolverEdificio());


    }

    */

}
