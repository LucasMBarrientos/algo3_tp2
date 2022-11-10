package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.terrenos.*;

public class CasoDeUso9 {

  @Test
  public void verificarSiEdificioProtossOperaCuandoDebe() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();
    algoStar.pasarTurno();

    algoStar.construirEdificio(8,8,new Pilon());

    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();

    Assertions.assertTrue(algoStar.seleccionarCasilla(8,8).devolverEdificio() instanceof Pilon);

    algoStar.pasarTurno();

    Jugador jugador = algoStar.hallarJugadorActual(); 

    algoStar.seleccionarCasilla(9, 8).establecerTerreno(new TerrenoMineral());
    algoStar.construirEdificio(9, 8,new NexoMineral());

    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();

    Assertions.assertTrue(algoStar.seleccionarCasilla(9,8).devolverEdificio() instanceof NexoMineral);

    // Agregar muchos recursos
    for (int i=0;i<100; i++) {
      algoStar.pasarTurno();
    }

    algoStar.construirEdificio(8, 9,new Acceso());
    // Termino el edificio
    for (int i=0;i<10; i++) {
      algoStar.pasarTurno();
    }

    // destruimos el Pilon construido luego de empezar el juego
    algoStar.seleccionarCasilla(7,8).establecerUnidad(new Zangano());
    for (int i=0;i<100; i++) {
      algoStar.atacarEdificioALaDerecha(7,8);
      algoStar.pasarTurno();
    }
    Assertions.assertTrue(algoStar.seleccionarCasilla(8,8).devolverEdificio() == null);

    Assertions.assertTrue(((EdificioProtoss) algoStar.seleccionarCasilla(8,9).devolverEdificio()).devolverOperatividad() == true);

    Assertions.assertTrue(algoStar.seleccionarCasilla(8,9).devolverTerreno() instanceof TerrenoEnergizado);

  }

}
