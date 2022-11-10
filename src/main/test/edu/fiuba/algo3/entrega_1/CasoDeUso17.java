package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.terrenos.*;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso17 {

    @Test
    public void noSePuedeConstruirUnPuertoEstelarSinUnAcceso() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.pasarTurno();

        algoStar.construirEdificio(8,8, new PuertoEstelar());
        // Intentar construir el edificio por un par de turnos
        for (int i=0; i<20; i++) {
            algoStar.pasarTurno();
        }

        Assertions.assertTrue(algoStar.seleccionarCasilla(8,8).devolverEdificio() == null);

        algoStar.seleccionarCasilla(9, 8).establecerEdificio(new Acceso());

        algoStar.construirEdificio(8,8, new PuertoEstelar());
        // Intentar construir el edificio por un par de turnos
        for (int i=0; i<20; i++) {
            algoStar.pasarTurno();
        }

        Assertions.assertTrue(algoStar.seleccionarCasilla(8,8).devolverEdificio() instanceof PuertoEstelar);
    }

    @Test
    public void noSePuedeConstruirUnEspiralSinUnaGuarida() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.moverDerecha(1,1);

        algoStar.construirEdificio(2,1, new Espiral());
        // Intentar construir el edificio por un par de turnos
        for (int i=0; i<20; i++) {
            algoStar.pasarTurno();
        }

        Assertions.assertTrue(algoStar.seleccionarCasilla(2,1).devolverEdificio() == null);

        algoStar.seleccionarCasilla(4, 5).establecerEdificio(new Guarida());

        algoStar.construirEdificio(2,1, new Espiral());
        // Intentar construir el edificio por un par de turnos
        for (int i=0; i<20; i++) {
            algoStar.pasarTurno();
        }

        Assertions.assertTrue(algoStar.seleccionarCasilla(2,1).devolverEdificio() instanceof Espiral);
    }
    
}
