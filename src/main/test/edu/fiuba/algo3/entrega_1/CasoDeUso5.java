package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
public class CasoDeUso5 {

    @Test
    public void ErrorAlConstruirEdificioLejosDeUnPilon() {
      AlgoStar algoStar = new AlgoStar();
      algoStar.empezarJuego();

      // CONTRUYE UN PILON LEJOS DE LA ENERGIA
      algoStar.construirEdificio(5, 1, new Pilon());

      // DEBERIA DEVOLVER ERROR AL TRATAR DE CONSTRUIR LEJOS DEL PILON
    }

    @Test
    public void ErrorAlConstruirEdificioFueraDelMoho() {
      AlgoStar algoStar = new AlgoStar();
      algoStar.empezarJuego();

      // GENERO ZANGANO LEJOS DEL MOHO
      algoStar.generarUnidad(1,1);

      algoStar.moverDerecha(1, 1);
      algoStar.moverDerecha(2, 1);
      algoStar.moverDerecha(3, 1);
      algoStar.moverDerecha(4, 1);
      algoStar.moverDerecha(5, 1);


      // CONTRUYE UN CRIADERO LEJOS DEL MOHO
      algoStar.construirEdificio(6, 1, new Criadero());

      // DEBERIA DEVOLVER ERROR AL TRATAR DE CONSTRUIR LEJOS DEL MOHO
    }
}
