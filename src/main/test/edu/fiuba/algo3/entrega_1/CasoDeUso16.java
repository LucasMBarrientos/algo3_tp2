package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso16 {
    
    @Test
    public void noSePuedeConstruirUnExtractorSobreOtroExtractor() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(1,1);
        algoStar.moverDerecha(1,1);
        algoStar.seleccionarCasilla(2,1).establecerTerreno(new Volcan());
        algoStar.construirEdificio(2,1, new Extractor());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        Assertions.assertFalse(algoStar.seleccionarCasilla(2,1).devolverEdificio() instanceof Extractor);
        algoStar.pasarTurno();
        Assertions.assertTrue(algoStar.seleccionarCasilla(2,1).devolverEdificio() instanceof Extractor); // Extractor fue construido en (2,1)
        algoStar.generarUnidad(1,1);
        algoStar.moverDerecha(1,1);
        algoStar.construirEdificio(2,1, new Extractor());
        Assertions.assertTrue(algoStar.seleccionarCasilla(2,1).devolverUnidad().construyendo() == false);
    }

}
