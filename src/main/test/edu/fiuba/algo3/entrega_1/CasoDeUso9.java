package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Mapa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.edificios.protoss.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;

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




























      /*
      JugadorProtoss jugador = new JugadorProtoss();
      Pilon pilon1 = new Pilon();
      Pilon pilon2 = new Pilon();
      Acceso acceso = new Acceso();
      jugador.construirEdificio(new Coordenada(2,2), pilon1);
      jugador.construirEdificio(new Coordenada(2,4), pilon2);
      jugador.construirEdificio(new Coordenada(2,3), acceso);

      for(int i=0; i<10; i++ ){
          jugador.actualizar(); //termino de construir los edificios
      }

      pilon1.recibirDanio(new Danio(700)); //pilon1 pasa a estar destruido

      Assertions.assertNotNull(acceso.generarUnidad(new Zealot())); //acceso deberia seguir operativo
  */

  /*

  @Test
  public void unEdificioProtossPasaAEstarInoperativoSiNoHayPilonQueLoEnergice() {
      JugadorProtoss jugador = new JugadorProtoss();
      Pilon pilon = new Pilon();
      Acceso acceso = new Acceso();
      jugador.construirEdificio(new Coordenada(2,2), pilon);
      jugador.construirEdificio(new Coordenada(2,3), acceso);

      for(int i=0; i<10; i++ ){
          jugador.actualizar(); //termino de construir los edificios
      }

      pilon.recibirDanio(new Danio(700)); //pilon pasa a estar destruido

      Assertions.assertThrows(EdificioNoOperativo.class, ()->{
          acceso.generarUnidad(new Zealot());
      });
  }
*/
}


