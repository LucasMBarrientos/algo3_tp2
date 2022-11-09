package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso2 {

    @Test
    public void criaderoSeConstruyeEnTiempoAdecuado() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Casilla casillaConZangano = algoStar.generarUnidad(algoStar.seleccionarCasilla(1,1)); // Se genera una unidad en la casilla(0,0)
        casillaConZangano.construirEdificio();
        algoStar.pasarTurno();        
        algoStar.pasarTurno();        
        algoStar.pasarTurno();
        Assertions.assertFalse(casillaConZangano.devolverOcupante() instanceof Criadero);
        algoStar.pasarTurno();
        Assertions.assertTrue(casillaConZangano.devolverOcupante() instanceof Criadero);
    }

    @Test
    public void criaderoEstaOperativoLuegoDeConstruirse(){
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Casilla casillaConZangano = algoStar.generarUnidad(algoStar.seleccionarCasilla(1,1)); // Se genera una unidad en la casilla(0,0)
        casillaConZangano.construirEdificio();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        Assertions.assertTrue(casillaConZangano.devolverOcupante() instanceof Criadero);
        Casilla otraCasillaConZangano =algoStar.generarUnidad(casillaConZangano);
        Assertions.assertTrue(otraCasillaConZangano.devolverOcupante() instanceof Zangano);
    }

}