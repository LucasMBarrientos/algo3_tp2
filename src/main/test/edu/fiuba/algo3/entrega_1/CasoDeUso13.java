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
      algoStar.moverDerecha(1, 1);

      // ATACAR EL CON DANIO MAYOR A LA VIDA QUE TIENE
      algoStar.seleccionarCasilla(1, 1).devolverEdificio().recibirDanio(510);

      Assertions.assertFalse(algoStar.seleccionarCasilla(1,1).devolverEdificio() instanceof Criadero);

      // DEBERIA PODER CONSTRUIR IGUAL CON EL MOHO YA EXISTENTE
      algoStar.construirEdificio(2, 1, new Criadero());

      algoStar.pasarTurno();
      algoStar.pasarTurno();
      algoStar.pasarTurno();
      algoStar.pasarTurno();
      algoStar.pasarTurno();
      algoStar.pasarTurno();

      Assertions.assertTrue(algoStar.seleccionarCasilla(2,1).devolverEdificio() instanceof Criadero);
    }
}