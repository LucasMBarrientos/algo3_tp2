package edu.fiuba.algo3.entrega_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.edificios.protoss.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.Guarida;
import edu.fiuba.algo3.modelo.edificios.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.NoHaySuministrosSuficientes;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public class CasoDeUso31 {
  /*@Test
  public void alMorirElAmoSupremoNoPuedoGenerarOtraUnidad() {
    

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
    });
  }
  */

  @Test
  public void alDestruirElCriaderoNoPuedoGenerarOtraUnidad() {
    AlgoStar algoStar = new AlgoStar();
    JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 500, 2000,0);
    algoStar.agregarJugador(jugadorZerg);
    algoStar.empezarJuego();
    jugadorZerg.construirEdificio(new Coordenada(1, 1), new Criadero());

    for (int i = 0; i < 7; i++) {
      algoStar.pasarTurno();
    }

    // Construir una reserva de reproduccion
    jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    jugadorZerg.construirEdificio(new Coordenada(2, 1), new ReservaDeReproduccion());
    for (int i = 0; i < 12; i++) {
        algoStar.pasarTurno();
    }

    // construir una guarida
    jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    jugadorZerg.moverUnidad(new Coordenada(1, 2), new Abajo());
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    jugadorZerg.construirEdificio(new Coordenada(1, 3), new Guarida());
    for (int i = 0; i < 12; i++) {
        algoStar.pasarTurno();
    }

    // construir una espiral
    jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    jugadorZerg.moverUnidad(new Coordenada(1, 2), new Derecha());
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    jugadorZerg.moverUnidad(new Coordenada(2, 2), new Derecha());
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    jugadorZerg.construirEdificio(new Coordenada(3, 2), new Espiral());
    for (int i = 0; i < 10; i++) {
        algoStar.pasarTurno();
    }
    // construir un criadero
    jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    jugadorZerg.moverUnidad(new Coordenada(1, 2), new Derecha());
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    jugadorZerg.construirEdificio(new Coordenada(2, 2), new Criadero());
    for (int i = 0; i < 7; i++) {
        algoStar.pasarTurno();
    }

    // generar un mutalisco
    jugadorZerg.generarUnidad(new Coordenada(3, 2), new Mutalisco());
    jugadorZerg.generarUnidad(new Coordenada(3, 2), new Mutalisco());
    for (int i = 0; i < 14; i++) {
      algoStar.pasarTurno();
    }

    jugadorZerg.destruirEdificio(new Coordenada(2,2));
    
    Assertions.assertThrows(NoHaySuministrosSuficientes.class, ()->{
      jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
    });
  }

  @Test
  public void alDestruirElPilonNoPuedoGenerarOtraUnidad() {
    AlgoStar algoStar = new AlgoStar();
    JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff",1200, 1200,0);
    algoStar.agregarJugador(jugadorProtoss);
    algoStar.empezarJuego();

    jugadorProtoss.construirEdificio(new Coordenada(2, 3), new Pilon());
    for (int i = 0; i < 6; i++) {
      algoStar.pasarTurno();
    }
    jugadorProtoss.construirEdificio(new Coordenada(2, 2), new Acceso());
    for (int i = 0; i < 8; i++) {
      algoStar.pasarTurno();
    }
    jugadorProtoss.generarUnidad(new Coordenada(2, 2), new Zealot());
    
    jugadorProtoss.destruirEdificio(new Coordenada(2,3));

    Assertions.assertThrows(NoHaySuministrosSuficientes.class, ()->{
      jugadorProtoss.generarUnidad(new Coordenada(2, 2), new Zealot());
    });
  }
}
