package edu.fiuba.algo3.entrega_1;

import java.util.List;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.protoss.nexoMineral.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Jugador;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;

public class CasoDeUso9 {

  @Test
  public void verificarSiEdificioProtossOperaCuandoDebe() {
    AlgoStar algoStar = new AlgoStar();
    JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
    algoStar.agregarJugador(jugadorProtoss);
    JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
    algoStar.agregarJugador(jugadorZerg);
    algoStar.empezarJuego();
    algoStar.pasarTurno();

    Casilla casillaConPilon = jugadorProtoss.hallarCasillaConEdificioInicial();
    List<Coordenada> coordenadasConTerrenosEnergizados = casillaConPilon.hallarCoordenadasAdyacentes();
    jugadorProtoss.construirEdificio(coordenadasConTerrenosEnergizados.get(0), new Pilon());

    List<Casilla> casillasMinerales = jugadorProtoss.hallarCasillasConMineralesIniciales();
    jugadorProtoss.construirEdificio(casillasMinerales.get(0).devolverCoordendas(), new NexoMineral());
    jugadorProtoss.construirEdificio(casillasMinerales.get(1).devolverCoordendas(), new NexoMineral());
    

    for(int i=0; i<10; i++){
      algoStar.pasarTurno();
    }


    /*Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      jugadorProtoss.construirEdificio(casillasMinerales.get(2).devolverCoordendas(), new NexoMineral());
    });*/



  }
    /*
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();
    algoStar.pasarTurno();

    algoStar.construirEdificio(8,8,new Pilon());

    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();

    Assertions.assertTrue(algoStar.seleccionarCasilla(8,8).devolverEdificio() instanceof Pilon);

    algoStar.pasarTurno();

    Jugador jugador = algoStar.hallarJugadorActual(); 

    algoStar.seleccionarCasilla(9, 8).establecerTerreno(new TerrenoMineral());
    algoStar.construirEdificio(9, 8,new NexoMineral());

    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();

    Assertions.assertTrue(algoStar.seleccionarCasilla(9,8).devolverEdificio() instanceof NexoMineral);

    // Agregar muchos recursos
    for (int i=0;i<100; i++) {
      algoStar.pasarTurno();
    }

    algoStar.construirEdificio(8, 9,new Acceso());
    // Termino el edificio
    for (int i=0;i<10; i++) {
      algoStar.pasarTurno();
    }

    // destruimos el Pilon construido luego de empezar el juego
    algoStar.seleccionarCasilla(7,8).establecerUnidad(new Zangano());
    for (int i=0;i<100; i++) {
      algoStar.atacarEdificioALaDerecha(7,8);
      algoStar.pasarTurno();
    }
    Assertions.assertTrue(algoStar.seleccionarCasilla(8,8).devolverEdificio() == null);

    Assertions.assertTrue(((EdificioProtoss) algoStar.seleccionarCasilla(8,9).devolverEdificio()).devolverOperatividad() == true);

    Assertions.assertTrue(algoStar.seleccionarCasilla(8,9).devolverTerreno() instanceof TerrenoEnergizado);
*/
  }


