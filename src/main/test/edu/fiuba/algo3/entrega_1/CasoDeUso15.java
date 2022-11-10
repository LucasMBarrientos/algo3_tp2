package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso15 {

    @Test
    public void noSePuedenSeguirSacandoRecursosDeUnExtractorVacio() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(1,1);
        algoStar.moverDerecha(1,1);
        algoStar.seleccionarCasilla(2,1).establecerTerreno(new TerrenoVolcan());
        algoStar.construirEdificio(2,1, new Extractor());

        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        Assertions.assertTrue(algoStar.seleccionarCasilla(2,1).devolverEdificio() instanceof Extractor); // Extractor fue construido en (2,1)
        algoStar.generarUnidad(1,1);
        algoStar.moverDerecha(1,1);
        algoStar.ingresarUnidad(2,1);
        algoStar.generarUnidad(1,1);
        algoStar.moverDerecha(1,1);
        algoStar.ingresarUnidad(2,1);
        algoStar.generarUnidad(1,1);
        algoStar.moverDerecha(1,1);
        algoStar.ingresarUnidad(2,1);

        for (int i = 0; i < 1000; i++) {
            algoStar.pasarTurno();
        }

        algoStar.pasarTurno();
        algoStar.pasarTurno();

        Assertions.assertEquals(5210,algoStar.hallarJugadorActual().devolverCantidadGas()); // Extractor fue construido en (2,1)

        algoStar.pasarTurno();
        algoStar.pasarTurno();

        Assertions.assertEquals(5210,algoStar.hallarJugadorActual().devolverCantidadGas()); // Extractor fue construido en (2,1)


    }

}
