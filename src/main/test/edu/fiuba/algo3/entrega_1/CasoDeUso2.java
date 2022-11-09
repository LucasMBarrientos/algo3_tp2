package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CasoDeUso2 {

    @Test
    public void criaderoSeConstruyeEnTiempoAdecuado() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(1,1); // Se generara una unidad en la casilla(0,0)
        Unidad zanganoDisponible = algoStar.seleccionarUnidadDisponible(0);
        Casilla casillaDelZangano = zanganoDisponible.devolverCasilla();
        algoStar.construirEdificio(zanganoDisponible, new Criadero());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        Assertions.assertFalse(casillaDelZangano.devolverOcupante() instanceof Criadero);
        algoStar.pasarTurno();
        Assertions.assertTrue(casillaDelZangano.devolverOcupante() instanceof Criadero);
    }

    @Test
    public void criaderoEstaOperativoLuegoDeConstruirse(){
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(1,1); // Se generara una unidad en la casilla(0,0)
        Unidad zanganoDisponible = algoStar.seleccionarUnidadDisponible(0);
        Casilla casillaDelZangano = zanganoDisponible.devolverCasilla();
        algoStar.construirEdificio(zanganoDisponible, new Criadero());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        Assertions.assertTrue(casillaDelZangano.devolverOcupante() instanceof Criadero);
        algoStar.generarUnidad(casillaDelZangano); // Se generara una unidad en la casilla(1,0)
        Unidad nuevoZanganoDisponible = algoStar.seleccionarUnidadDisponible(1);
        Assertions.assertTrue(zanganoDisponible instanceof Zangano && nuevoZanganoDisponible instanceof Zangano);
    }
    

    
}