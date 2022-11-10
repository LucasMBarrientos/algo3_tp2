package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMineral;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;

public class CasoDeUso7 {

    @Test
    public void verificarQueElNexoMineralSeaConstruibleSobreUnMineral() {
      AlgoStar algoStar = new AlgoStar();
      algoStar.empezarJuego();

      algoStar.pasarTurno();

      algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoMineral());
      algoStar.construirEdificio(2, 1, new NexoMineral());

      algoStar.pasarTurno();
      algoStar.pasarTurno();
      algoStar.pasarTurno();
      algoStar.pasarTurno();

      Assertions.assertTrue(algoStar.seleccionarCasilla(2, 1).devolverEdificio() instanceof NexoMineral);
    }

    @Test
    public void verificarQueElNexoMineralSoloSeaConstruibleSobreUnTerrenoMineral() {
      AlgoStar algoStar = new AlgoStar();
      algoStar.empezarJuego();

      algoStar.pasarTurno();

      algoStar.construirEdificio(2, 1, new NexoMineral());

      algoStar.pasarTurno();
      algoStar.pasarTurno();
      algoStar.pasarTurno();
      algoStar.pasarTurno();

      Assertions.assertFalse(algoStar.seleccionarCasilla(2, 1).devolverEdificio() instanceof NexoMineral);
    }

    @Test
    public void verificarQueProtossPuedaRecolectarMinerales() {
      AlgoStar algoStar = new AlgoStar();
      algoStar.empezarJuego();

      algoStar.pasarTurno();

      algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoMineral());
      algoStar.construirEdificio(2, 1, new NexoMineral());

      algoStar.pasarTurno();
      algoStar.pasarTurno();

      Assertions.assertEquals(150, algoStar.devolverCantidadMinerales());

      algoStar.pasarTurno();
      algoStar.pasarTurno();

      Assertions.assertEquals(160, algoStar.devolverCantidadMinerales());
    }
    
    @Test
    public void verificarQueZergPuedaRecolectarMinerales() {
      AlgoStar algoStar = new AlgoStar();
      algoStar.empezarJuego();
      algoStar.generarUnidad(1, 1);
      algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoMineral());
      algoStar.moverDerecha(1, 1);
      algoStar.pasarTurno();
      // Turno de los protoss
      algoStar.pasarTurno();
      // Turno de los zerg

      // PONER A TRABAJAR UN ZANGANO SOBRE UN MINERAL?

      Assertions.assertEquals(210,algoStar.devolverCantidadMinerales());
      algoStar.pasarTurno();
      algoStar.pasarTurno();
      Assertions.assertEquals(220,algoStar.devolverCantidadMinerales());
    }
}
