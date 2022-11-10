package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;

public class CasoDeUso6 {
  
  @Test
    public void ConstruirEdificioZanganoTieneQueEsperarCrecimientoMoho() {
      AlgoStar algoStar = new AlgoStar();
      algoStar.empezarJuego();

      algoStar.generarUnidad(1,1);

      algoStar.moverDerecha(1, 1);
      algoStar.moverDerecha(2, 1);
      algoStar.moverDerecha(3, 1);
      algoStar.moverDerecha(4, 1);
      algoStar.moverDerecha(5, 1);

      // CONTRUYE UN CRIADERO LEJOS DEL MOHO
      algoStar.construirEdificio(6, 1, new Criadero());
      // DEBERIA DEVOLVER ERROR AL TRATAR DE CONSTRUIR LEJOS DEL MOHO

      algoStar.pasarTurno();

      // CONTRUYE UN CRIADERO LEJOS DEL MOHO
      algoStar.construirEdificio(6, 1, new Criadero());
      // DEBERIA DEVOLVER ERROR YA QUE EL MOHO CRECE 1 CADA 2 TURNOS

      algoStar.pasarTurno();

      algoStar.construirEdificio(6, 1, new Criadero());
      
      algoStar.pasarTurno();
      algoStar.pasarTurno();
      algoStar.pasarTurno();
      
      Assertions.assertTrue(algoStar.seleccionarCasilla(6, 1).devolverEdificio() instanceof Criadero);
    }
}
