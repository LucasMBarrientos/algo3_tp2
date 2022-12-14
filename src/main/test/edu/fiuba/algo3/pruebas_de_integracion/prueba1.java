package edu.fiuba.algo3.pruebas_de_integracion;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.edificios.protoss.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.edificios.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoAlcanzado;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.geometria.direcciones.Izquierda;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.zerg.AmoSupremo;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import org.junit.jupiter.api.Test;

public class prueba1 {

    @Test
    public void prueboPartidaConProtossGanador() {

      Logger.setEnableLog(true);
      AlgoStar a = new AlgoStar();
      a.agregarJugador(new JugadorZerg("Zerggg","#ff0000"));
      a.agregarJugador(new JugadorProtoss("Protoss","#0000ff"));
      a.empezarJuego();

      // El jugador zerg construye un criadero
      a.hallarJugadorActual().construirEdificio(new Coordenada(1, 1), new Criadero());

      a.pasarTurno();

      // El jugador protoss construye 2 nexos minerales y un asimilador
      a.hallarJugadorActual().construirEdificio(new Coordenada(95, 45), new Asimilador());
      a.hallarJugadorActual().construirEdificio(new Coordenada(95, 46), new NexoMineral());
      a.hallarJugadorActual().construirEdificio(new Coordenada(96, 45), new NexoMineral());
      for (int i = 0; i < 6; i++) { // Termino de construir los edificios
          a.pasarTurno();
      }

      // Paso varios turnos recolectando recursos para el jugador protoss
      for (int i = 0; i < 50; i++) {
          a.pasarTurno();
      }

      // El jugador protoss construye un pilon cerca del criadero incial del jugador zerg
      a.hallarJugadorActual().construirEdificio(new Coordenada(50, 1), new Pilon());
      for (int i = 0; i < 6; i++) { // Termino de construir el pilon
          a.pasarTurno();
      }

      // El jugador protoss construye un acceso en el rango del pilon previamente construido
      a.hallarJugadorActual().construirEdificio(new Coordenada(49, 1), new Acceso());
      for (int i = 0; i < 8; i++) { // Termino de construir el acceso
          a.pasarTurno();
      }

      // El jugador protoss construye un dragon
      a.hallarJugadorActual().generarUnidad(new Coordenada(49, 1), new Dragon());
      for (int i = 0; i < 6; i++) { // Termino de construir la unidad
          a.pasarTurno();
      }

      for (int x = 48; x > 2; x--) {
          a.hallarJugadorActual().moverUnidad(new Coordenada(x, 1), new Izquierda());
      }

      try {
          for (int i=0; i<25; i++ ) {
              a.hallarJugadorActual().atacar(new Coordenada(2, 1), new Coordenada(1,1));
          }
      } catch(EdificioEstaDestruido e) {
          System.out.println("Se destruyo el ultimo edificio de los zerg");
      }

      try {
        a.pasarTurno();
      }catch(FinDelJuegoAlcanzado e){
          System.out.println("Juego ganado por la raza " + a.devolverJugadorGanador().toData().get("raza"));
      }


    }

}
