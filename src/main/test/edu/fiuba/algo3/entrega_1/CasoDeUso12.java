package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso12 {
  @Test
    public void alDañarEdicioProtossConUnDanioMayorAlEscudoSeRegeneraSoloSuEscudo() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();
    algoStar.pasarTurno();

    algoStar.construirEdificio(8,8,new Pilon());

    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();

    // ATACAR EL CON DANIO MENOR AL ESCUDO
    algoStar.seleccionarCasilla(8, 8).devolverEdificio().recibirDanio(400);


    // PROBAR QUE SE REGENERA
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();

    Assertions.assertEquals(algoStar.seleccionarCasilla(8,8).devolverEdificio().devolverVida(), 200);

    Assertions.assertEquals(((EdificioProtoss)algoStar.seleccionarCasilla(8,8).devolverEdificio()).devolverEscudo(), 300);
    }
}