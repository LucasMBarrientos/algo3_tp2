package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.espiral.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.guarida.Guarida;
import edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.NoHaySuministrosSuficientes;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.*;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso29 {
  /*@Test
  public void teniendo39CriaderosY50MutaliscoNoPuedoCrearMutaliscoSumandoOtroCriadero() {
    AlgoStar algoStar = new AlgoStar();
    JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 500, 500,0);
    algoStar.agregarJugador(jugadorZerg);
    JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
    algoStar.agregarJugador(jugadorProtoss);
    algoStar.empezarJuego();
    
    jugadorZerg.construirEdificio(new Coordenada(1, 1), new Criadero());
    for (int i = 0; i < 8; i++) {
        algoStar.pasarTurno();
    }

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
    });
  }*/

  /*@Test
  public void teniendo40PilonesY50ScoutNoPuedoCrearMutaliscoSumandoOtroCriadero() {
    AlgoStar algoStar = new AlgoStar();
    JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000");
    algoStar.agregarJugador(jugadorZerg);
    JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff", 500, 4000,0);
    algoStar.agregarJugador(jugadorProtoss);
    algoStar.empezarJuego();
    
    
  //  jugadorProtoss.construirEdificio(new Coordenada(1,1), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(1,2), new Pilon());
  //  jugadorProtoss.construirEdificio(new Coordenada(1,1), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(1,3), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(1,4), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(1,5), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(1,6), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(2,1), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(2,2), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(2,3), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(2,4), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(2,5), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(2,6), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(3,1), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(3,2), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(3,3), new Pilon());
//    jugadorProtoss.construirEdificio(new Coordenada(3,4), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(3,5), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(3,6), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(4,1), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(4,2), new Pilon());
//    jugadorProtoss.construirEdificio(new Coordenada(4,3), new Pilon());
//    jugadorProtoss.construirEdificio(new Coordenada(4,4), new Pilon());
//   jugadorProtoss.construirEdificio(new Coordenada(4,5), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(4,6), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(5,1), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(5,2), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(5,3), new Pilon());
//    jugadorProtoss.construirEdificio(new Coordenada(5,4), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(5,5), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(5,6), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(6,1), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(6,2), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(6,3), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(6,4), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(6,5), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(6,6), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(7,1), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(7,2), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(7,3), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(7,4), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(7,5), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(7,6), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(8,1), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(8,2), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(8,3), new Pilon());
    jugadorProtoss.construirEdificio(new Coordenada(8,4), new Pilon());

    //JugadorProtoss.generarUnidad(new Coordenada(1, 1), new Zangano());



    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      JugadorProtoss.generarUnidad(new Coordenada(1, 1), new Zangano());
    });
  }*/
}
