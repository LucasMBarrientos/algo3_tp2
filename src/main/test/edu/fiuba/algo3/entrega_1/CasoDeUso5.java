package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso5 {

    @Test
    public void ErrorAlConstruirEdificioLejosDeUnPilon() {
      // CUAL ES LA LOGICA PARA CREAR PROTOSS Y SUS EDIFICIOS?
      AlgoStar algoStar = new AlgoStar();
      algoStar.empezarJuego();
        
      // CONTRUYE UN ACCESO LEJOS DEL PILON
      algoStar.construirEdificio(casillaAConstruir, new Acceso());

      // DEBERIA DEVOLVER ERROR AL TRATAR DE CONSTRUIR LEJOS DEL PILON
    }

    @Test
    public void ErrorAlConstruirEdificioFueraDelMoho() {
      AlgoStar algoStar = new AlgoStar();
      algoStar.empezarJuego();
      algoStar.generarUnidad(1,1);
      Ocupante zangano = algoStar.seleccionarCasilla(1,1).devolverUnidad();
      
      // FALTA MOVER ZANGANO LEJOS DEL MOHO

      // CONTRUYE UN CRIADERO LEJOS DEL MOHO
      Casilla casillaDelZangano = zangano.devolverCasilla();
       algoStar.construirEdificio(zangano, new Criadero());

      // DEBERIA DEVOLVER ERROR AL TRATAR DE CONSTRUIR LEJOS DEL MOHO
    }
}
