package edu.fiuba.algo3.entrega_1;

import java.util.List;

import edu.fiuba.algo3.modelo.edificios.protoss.acceso.Acceso;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.recursos.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.JugadorProtoss;
import edu.fiuba.algo3.modelo.JugadorZerg;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.protoss.nexoMineral.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;

public class CasoDeUso9 {
/*
  @Test
  public void unEdificioProtossSigueOperativoCuandoPorLoMenosUnPilonLoEnergiza() {
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

      pilon1.recibirGolpe(new Danio(700)); //pilon1 pasa a estar destruido

      Assertions.assertNotNull(acceso.generarUnidad(new Zealot())); //acceso deberia seguir operativo
  }

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

      pilon.recibirGolpe(new Danio(700)); //pilon pasa a estar destruido

      Assertions.assertThrows(EdificioNoOperativo.class, ()->{
          acceso.generarUnidad(new Zealot());
      });
  }
*/
}


