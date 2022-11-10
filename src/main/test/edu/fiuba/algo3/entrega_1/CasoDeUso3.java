package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CasoDeUso3 {


  /*  @Test
    public void verificarQueLasUnidadesSePuedanMover() { 
        AlgoStar algoStar = new AlgoStar();
        Casilla casillaDelZangano;
        algoStar.empezarJuego();
        algoStar.generarUnidad(1,1);
        Unidad zanganoDisponible = algoStar.seleccionarUnidadDisponible(0);
        casillaDelZangano = zanganoDisponible.devolverCasilla();
        Assertions.assertTrue(casillaDelZangano.devolverX() == 0 && casillaDelZangano.devolverY() == 0);
        algoStar.moverUnidad(zanganoDisponible, 1,0);
        casillaDelZangano = zanganoDisponible.devolverCasilla();
        Assertions.assertTrue(casillaDelZangano.devolverX() == 1 && casillaDelZangano.devolverY() == 0);
        Assertions.assertFalse(casillaDelZangano.devolverX() == 0 && casillaDelZangano.devolverY() == 0);
        Casilla nuevaCasilla = algoStar.seleccionarCasilla(2, 0);
        algoStar.moverUnidad(zanganoDisponible, nuevaCasilla); // Movimiento es imposible porque la unidad no esta disponible
        casillaDelZangano = zanganoDisponible.devolverCasilla();
        Assertions.assertTrue(casillaDelZangano.devolverX() == 1 && casillaDelZangano.devolverY() == 0);
        algoStar.pasarTurno();
        algoStar.moverUnidad(zanganoDisponible, nuevaCasilla); // Movimiento es posible porque la unidad esta disponible
        casillaDelZangano = zanganoDisponible.devolverCasilla();
        Assertions.assertTrue(casillaDelZangano.devolverX() == 2 && casillaDelZangano.devolverY() == 0);
    }

    @Test
    public void verificarQueElExtractorSoloPuedaSerConstruibleEnUnVolcan() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(1,1);
        Unidad zanganoDisponible = algoStar.seleccionarUnidadDisponible(0);

        Casilla casillaDelZangano = zanganoDisponible.devolverCasilla();
        if (!(casillaDelZangano.devolverTerreno() instanceof Volcan)) {
            // El zangano arranco en un casillero que no es un volcan
            algoStar.construirEdificio(zanganoDisponible, new Extractor());
            algoStar.pasarTurno();
            algoStar.pasarTurno();
            algoStar.pasarTurno();
            algoStar.pasarTurno();
            algoStar.pasarTurno();
            algoStar.pasarTurno();
            Assertions.assertFalse(casillaDelZangano.devolverEdificio() instanceof Extractor);
        }
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
    /*
        casillaDelZangano = zanganoDisponible.devolverCasilla();
        Assertions.assertTrue(casillaDelZangano.devolverTerreno() instanceof Volcan);
        algoStar.construirEdificio(zanganoDisponible, new Extractor());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        Assertions.assertFalse(casillaDelZangano.devolverEdificio() instanceof Extractor);
        algoStar.pasarTurno();
        Assertions.assertTrue(casillaDelZangano.devolverEdificio() instanceof Extractor);
    }
    */
}
