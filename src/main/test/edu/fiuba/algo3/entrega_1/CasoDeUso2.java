package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso2 {

    @Test
    public void edificioTardaLoApropiadoEnConstruirse() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(algoStar.seleccionarCasilla(1,1)); // Se genera una unidad en la casilla(0,0) 
        algoStar.construirEdificio(0,0, new Criadero());
        algoStar.pasarTurno();        
        algoStar.pasarTurno();        
        algoStar.pasarTurno();
        Assertions.assertFalse(algoStar.seleccionarCasilla(0,0).devolverOcupante() instanceof Criadero);
        algoStar.pasarTurno();
        Assertions.assertTrue(algoStar.seleccionarCasilla(0,0).devolverOcupante() instanceof Criadero);
    }

}