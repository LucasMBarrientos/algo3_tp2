package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;

public class CasoDeUso10 {
  @Test
    public void verificiarQueLasConstruccionesZergSeRegeneranHastaEl100() {
      AlgoStar algoStar = new AlgoStar();
      algoStar.empezarJuego();

      // como se hace el ataque?
      // algoStar.atacarEdificio(1,1); ?
      
      // algoStar.seleccionarCasilla(1, 1).devolverEdificio().vida() ?

      algoStar.pasarTurno();
      
      // Regenerar la vida
      // algoStar.seleccionarCasilla(1, 1).devolverEdificio().vida() 
    }
}
