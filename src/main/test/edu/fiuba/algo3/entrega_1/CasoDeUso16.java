package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.protoss.Asimilador;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso16 {

    @Test
    public void noSePuedeConstruirUnEdificioSobreOtro() {
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

        algoStar.pasarTurno();

        algoStar.generarUnidad(1,1);
        algoStar.moverDerecha(1,1);
        algoStar.construirEdificio(2,1, new Asimilador());

        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        Assertions.assertTrue(algoStar.seleccionarCasilla(2,1).devolverEdificio() instanceof Extractor);
    }

}
