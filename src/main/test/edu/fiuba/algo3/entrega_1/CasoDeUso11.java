package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso11 {
  @Test
    public void alDañarEdicioProtossConUnDanioMenorAlEscudoEsteSeRegenera() {
      AlgoStar algoStar = new AlgoStar();
      algoStar.empezarJuego();

      algoStar.seleccionarCasilla(9,9).devolverEdificio();

      // algoStar.seleccionarCasilla(2, 1).devolverEdificio().vida()
      // algoStar.seleccionarCasilla(2, 1).devolverEdificio().escudo()

      // ATACAR EL CON DANIO MENOR AL ESCUDO
      algoStar.seleccionarCasilla(9, 9).devolverEdificio().recibirDanio(0);

      // PROBAR QUE SE BAJO LA VIDA DEL ESCUDO

      algoStar.pasarTurno();

      // algoStar.seleccionarCasilla(2, 1).devolverEdificio().vida() DEBERIA SER LA VIDA MAXIMA

      // algoStar.seleccionarCasilla(2, 1).devolverEdificio().escudo() PROBAR QUE SE REGENERÓ EL ESCUDO
    }
}
