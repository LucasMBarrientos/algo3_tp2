package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMoho;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso14 {
    @Test
    public void EnergizadoNoPisaMoho() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 0, 325);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        // Se construye un criadero
        jugadorZerg.construirEdificio(new Coordenada(1,1), new Criadero());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }
        algoStar.pasarTurno();
        jugadorProtoss.construirEdificio(new Coordenada(4,4), new Pilon());
        for (int i = 0; i < 12; i++) {
            algoStar.pasarTurno();
        }
        //Assertions.assertThrows(EdificioDestruido.class, pilon::actualizar); //TODO agregar state edificio destruido @Leti
        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            jugadorProtoss.construirEdificio(new Coordenada(15,2), new Pilon());
        });
    }

  /*
  @Test
  public void MohoNoPisaEnergizado(){
      AlgoStar algoStar = new AlgoStar();
      algoStar.empezarJuego();
      Assertions.assertTrue(algoStar.seleccionarCasilla(8,9).devolverTerreno() instanceof TerrenoEnergizado);
      for (int i = 0; i < 20; i++) {
          algoStar.pasarTurno();
      }
      Assertions.assertTrue(algoStar.seleccionarCasilla(8,9).devolverTerreno() instanceof TerrenoEnergizado);
  }
  @Test
  public void EnergizadoNoPisaMoho(){
      AlgoStar algoStar = new AlgoStar();
      algoStar.empezarJuego();
      for (int i = 0; i < 20; i++) {
          algoStar.pasarTurno();
      }
      Assertions.assertTrue(algoStar.seleccionarCasilla(7,6).devolverTerreno() instanceof TerrenoMoho);
      algoStar.construirEdificio(7,8,new Pilon());
      for (int i = 0; i < 10; i++) {
          algoStar.pasarTurno();
      }
      Assertions.assertTrue(algoStar.seleccionarCasilla(7,6).devolverTerreno() instanceof TerrenoMoho);
      algoStar.construirEdificio(7,6,new Pilon());
      for (int i = 0; i < 10; i++) {
          algoStar.pasarTurno();
      }
      Assertions.assertFalse(algoStar.seleccionarCasilla(7,6).devolverEdificio() instanceof Pilon);
  }*/
}