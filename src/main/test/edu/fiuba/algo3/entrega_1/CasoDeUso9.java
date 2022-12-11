package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.edificios.protoss.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaInoperativo;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Arriba;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso9 {

    @Test
    public void unEdificioProtossSigueOperativoCuandoPorLoMenosUnPilonLoEnergiza() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 0, 500,200);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff", 0, 350,200);
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        jugadorProtoss.construirEdificio(new Coordenada(2, 1), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(2, 3), new Pilon());
        for (int i = 0; i < 6; i++) {
            algoStar.pasarTurno();
        }

        jugadorProtoss.construirEdificio(new Coordenada(2, 2), new Acceso());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }
        jugadorProtoss.destruirEdificio(new Coordenada(2,3));

        Assertions.assertThrows(RecursosInsuficientes.class, () -> {
            jugadorProtoss.generarUnidad(new Coordenada(2, 2), new Zealot());
        });
    }


  @Test
  public void unEdificioProtossPasaAEstarInoperativoSiNoHayPilonQueLoEnergice() {
      AlgoStar algoStar = new AlgoStar();
      JugadorZerg jugadorZerg = new JugadorZerg("Goku el mejor", "#ff0000");
      algoStar.agregarJugador(jugadorZerg);
      JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff",500, 600, 200);
      algoStar.agregarJugador(jugadorProtoss);
      algoStar.empezarJuego();

      //muevo el zangano inicial hasta el Mineral en (4, 3)
      jugadorZerg.moverUnidad(new Coordenada(1, 1), new Derecha());
      jugadorZerg.moverUnidad(new Coordenada(2, 1), new Derecha());
      jugadorZerg.moverUnidad(new Coordenada(3, 1), new Derecha());
      jugadorZerg.moverUnidad(new Coordenada(4, 1), new Abajo());
      jugadorZerg.moverUnidad(new Coordenada(4, 2), new Abajo());

      //construyo un pilon
      jugadorProtoss.construirEdificio(new Coordenada(8,2), new Pilon());

      //Paso los turnos
      for (int i = 0; i < 20; i++) {
          algoStar.pasarTurno();
      }

      //construyo un acceso dentro del pilon
      jugadorProtoss.construirEdificio(new Coordenada(8,3), new Acceso());

      //Muevo el zangano para quitarlo del terreno mineral y construyo un criadero
      jugadorZerg.moverUnidad(new Coordenada(4, 3), new Arriba());
      jugadorZerg.construirEdificio(new Coordenada(4,2), new Criadero());

      //Termina de construirse el criadero
      for (int i = 0; i < 5; i++) {
          algoStar.pasarTurno();
      }

      //Genero un zangano para la contruccion
      jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
      algoStar.pasarTurno();

      //Construyo una reserva de reproduccion
      jugadorZerg.moverUnidad(new Coordenada(4,1), new Derecha());
      jugadorZerg.moverUnidad(new Coordenada(5,1), new Abajo());
      jugadorZerg.construirEdificio(new Coordenada(5,2), new ReservaDeReproduccion());
      for (int i = 0; i < 12; i++) {
          algoStar.pasarTurno();
      }

      //Genero un zerling y lo muevo hasta el primer Pilon
      jugadorZerg.generarUnidad(new Coordenada(5, 2), new Zerling());
      algoStar.pasarTurno();
      algoStar.pasarTurno();
      jugadorZerg.moverUnidad(new Coordenada(5, 1), new Derecha());
      jugadorZerg.moverUnidad(new Coordenada(6, 1), new Derecha());
      jugadorZerg.moverUnidad(new Coordenada(7, 1), new Derecha());

      //el zerling ataca el pilon hasta destruirlo y el acceso deberia quedar inoperativo
      for (int i = 0; i < 149; i++) {
          jugadorZerg.atacar(new Coordenada(8, 1),new Coordenada(8, 2));
      }

      try {
          jugadorZerg.atacar(new Coordenada(8, 1),new Coordenada(8, 2));
      } catch(EdificioEstaDestruido e) {
          System.out.println("Se destruyo el pilon");
      }

      Assertions.assertThrows(EdificioEstaInoperativo.class , () -> {
          jugadorProtoss.generarUnidad(new Coordenada(8, 3), new Zealot());
      });

  }

}


