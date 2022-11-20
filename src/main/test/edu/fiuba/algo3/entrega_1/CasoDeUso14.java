package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.JugadorProtoss;
import edu.fiuba.algo3.modelo.unidades.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMoho;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso14 {/*
    @Test
    public void EnergizadoNoPisaMoho() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 325, 0);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();
        // Se construye un criadero
        jugadorZerg.construirEdificio(new Coordenada(2,2), new Criadero());
        jugadorProtoss.construirEdificio(new Coordenada(4,4), new Pilon());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }
        //Assertions.assertThrows(EdificioDestruido.class, pilon::actualizar); //TODO agregar state edificio destruido @Leti
        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorProtoss.construirEdificio(new Coordenada(15,2), new pilon());
        });
    }
  */  
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