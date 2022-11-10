package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso13 {
  @Test
    public void alDestruirUnCriaderoElMohoSigueFuncionando() {
      AlgoStar algoStar = new AlgoStar();
      algoStar.empezarJuego();

      algoStar.generarUnidad(1, 1);
      algoStar.moverIzquierda(1, 1);

      // ATACAR EL CON DANIO MAYOR A LA VIDA QUE TIENE
      for (int i = 0; i < 100; i++) {

        algoStar.atacarEdificioALaDerecha(0,1);
      }

      Assertions.assertFalse(algoStar.seleccionarCasilla(1,1).devolverEdificio() instanceof Criadero);

      algoStar.pasarTurno();
      algoStar.pasarTurno();
      // DEBERIA PODER CONSTRUIR IGUAL CON EL MOHO YA EXISTENTE

      algoStar.moverDerecha(0, 1);
      algoStar.construirEdificio(1, 1, new Criadero());

      algoStar.pasarTurno();
      algoStar.pasarTurno();
      algoStar.pasarTurno();
      algoStar.pasarTurno();
      algoStar.pasarTurno();
      algoStar.pasarTurno();

      Assertions.assertTrue(algoStar.seleccionarCasilla(1,1).devolverEdificio() instanceof Criadero);
    }
}