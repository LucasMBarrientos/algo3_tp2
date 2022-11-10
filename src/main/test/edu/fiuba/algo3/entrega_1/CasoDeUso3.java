package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;

import static org.junit.jupiter.api.Assertions.assertFalse;

import edu.fiuba.algo3.modelo.edificios.protoss.Asimilador;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CasoDeUso3 {

    @Test
    public void verificarQueElExtractorSoloPuedaSerConstruibleEnUnVolcan() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(1, 1);
        Unidad zanganoDisponible = algoStar.seleccionarCasilla(1, 1).devolverUnidad();

        algoStar.moverDerecha(1, 1);
        algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoVolcan());
        algoStar.construirEdificio(2, 1, new Extractor());

        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        Assertions.assertTrue(algoStar.seleccionarCasilla(2, 1).devolverEdificio() instanceof Extractor);

/*
        boolean finDelMapaAlcanzado = false;
        boolean volcanHallado = false;
        int x = 0;
        int y = 0;
        Boolean moviendoseALaIzquierda = false;

        // La gran aventura del zangano bucando un volcan en el mapa
        while (!volcanHallado) {
            while (!finDelMapaAlcanzado && !volcanHallado) {
                if (moviendoseALaIzquierda) {
                    x--;
                } else {
                    x++;
                }
                algoStar.moverUnidad(zanganoDisponible,x,y);
                casillaDelZangano = zanganoDisponible.devolverCasilla();
                if (casillaDelZangano.devolverX() != x) { // El movimiento no se realizo exitosamente
                    y++;
                    if (moviendoseALaIzquierda) {
                        x++;
                    } else {
                        x--;
                    }
                    algoStar.moverUnidad(zanganoDisponible,x,y);
                    moviendoseALaIzquierda = !moviendoseALaIzquierda;
                }
                if (casillaDelZangano.devolverTerreno() instanceof Volcan) {
                    volcanHallado = true;
                }
                algoStar.pasarTurno();
            }
        }
*/

    }

    @Test
    public void verificarQueElAsimiladorSoloPuedaSerConstruibleEnUnVolcan() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.pasarTurno();

        algoStar.seleccionarCasilla(9, 8).establecerTerreno(new TerrenoVolcan());
        algoStar.construirEdificio(9, 8, new Asimilador());

        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        Assertions.assertFalse(algoStar.seleccionarCasilla(2, 1).devolverEdificio() instanceof Extractor);

/*
        boolean finDelMapaAlcanzado = false;
        boolean volcanHallado = false;
        int x = 0;
        int y = 0;
        Boolean moviendoseALaIzquierda = false;

        // La gran aventura del zangano bucando un volcan en el mapa
        while (!volcanHallado) {
            while (!finDelMapaAlcanzado && !volcanHallado) {
                if (moviendoseALaIzquierda) {
                    x--;
                } else {
                    x++;
                }
                algoStar.moverUnidad(zanganoDisponible,x,y);
                casillaDelZangano = zanganoDisponible.devolverCasilla();
                if (casillaDelZangano.devolverX() != x) { // El movimiento no se realizo exitosamente
                    y++;
                    if (moviendoseALaIzquierda) {
                        x++;
                    } else {
                        x--;
                    }
                    algoStar.moverUnidad(zanganoDisponible,x,y);
                    moviendoseALaIzquierda = !moviendoseALaIzquierda;
                }
                if (casillaDelZangano.devolverTerreno() instanceof Volcan) {
                    volcanHallado = true;
                }
                algoStar.pasarTurno();
            }
        }
*/


    }
}
