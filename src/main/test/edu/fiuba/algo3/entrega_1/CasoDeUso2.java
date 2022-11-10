package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso2 {

    @Test
    public void criaderoSeConstruyeEnTiempoAdecuado() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Edificio edificioEnCasilla = algoStar.seleccionarCasilla(1,1).devolverEdificio();
        algoStar.generarUnidad(1,1); // Se generara una unidad en la casilla(1,1)
        Unidad zanganoDisponible = algoStar.seleccionarCasilla(1,1).devolverUnidad();
        algoStar.moverDerecha(1,1);
        Casilla casillaConZangano = algoStar.seleccionarCasilla(2,1);
        Assertions.assertTrue( casillaConZangano.devolverUnidad() instanceof Zangano);
        algoStar.construirEdificio(2,1, new Criadero());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        Assertions.assertFalse(algoStar.seleccionarCasilla(2,1).devolverEdificio() instanceof Criadero);
        algoStar.pasarTurno();
        Assertions.assertTrue(algoStar.seleccionarCasilla(2,1).devolverEdificio() instanceof Criadero);
    }

    @Test
    public void criaderoEstaOperativoLuegoDeConstruirse() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(1,1); // Se generara una unidad en la casilla(0,0)
        algoStar.moverDerecha(1,1);
        algoStar.construirEdificio(2,1, new Criadero());

        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        algoStar.generarUnidad(2,1);
        Assertions.assertTrue(algoStar.seleccionarCasilla(2,1).devolverUnidad() instanceof Zangano);
    }
    
}