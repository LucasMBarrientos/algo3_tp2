package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Arriba;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.geometria.direcciones.Izquierda;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import org.junit.jupiter.api.Test;

public class CasoDeUso7 {


	@Test
    public void elJugadorZergTendria290MineralesEn9TurnosColocandoUnZanganoSobreUnTerrenoConMinerales() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        algoStar.pasarTurno();
        algoStar.pasarTurno();

        jugadorZerg.moverUnidad(new Coordenada(1,1), new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(2,1), new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(3,1), new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(4,1), new Abajo());
        jugadorZerg.moverUnidad(new Coordenada(4,2), new Abajo());
        jugadorZerg.moverUnidad(new Coordenada(4,3), new Abajo());

        for (int i = 0; i < 100; i++) {
            jugadorZerg.ingresarUnidad(new Coordenada(4,3));
        }

        jugadorZerg.moverUnidad(new Coordenada(4,3), new Arriba());

        // Se construye un criadero, consumiendo asi 200 minerales del jugador
        jugadorZerg.construirEdificio(new Coordenada(4, 2), new Criadero());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        // Se genera 2 zanganos, consumiendo asi 50 minerales del jugador

        jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(new Coordenada(5, 2), new Derecha());
        jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        // Se mueve un zangano a la coordenada (4,3), en donde deberia haber minerales
        jugadorZerg.moverUnidad(new Coordenada(5, 2), new Abajo());

        // Tras 4 turnos del jugador zerg (8 turnos en total), el jugador deberia tener 140 unidades de minerales en total
        for (int i = 0; i < 4; i++) {
            algoStar.pasarTurno();
        }
    }
    /*
        // Se construye un extractor, consumiendo asi 100 minerales
        jugadorZerg.moverUnidad(new Coordenada(4,3), new Abajo());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.construirEdificio(new Coordenada(4,4), new Extractor());

        // Se intenta construir un criadero, pero el jugador no deberia tener la suficiente cantidad de minerales
        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            jugadorZerg.construirEdificio(new Coordenada(3,2), new Criadero());
        });
    }

	@Test 
    public void elJugadorZergTendria300MineralesEn10TurnosColocandoUnZanganoSobreUnTerrenoConMinerales() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        // Se construye un criadero, consumiendo asi 50 minerales del jugador
        jugadorZerg.construirEdificio(new Coordenada(2,2), new Criadero());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        // Se genera 2 zanganos, consumiendo asi 50 minerales del jugador
        jugadorZerg.generarUnidad(new Coordenada(2,2), new Derecha(), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(new Coordenada(3,2), new Derecha());
        jugadorZerg.generarUnidad(new Coordenada(2,2), new Derecha(), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        // Se mueve un zangano a la coordenada (4,3), en donde deberia haber minerales
        jugadorZerg.moverUnidad(new Coordenada(4,2), new Abajo());

        // Tras 5 turnos del jugador zerg (10 turnos en total), el jugador deberia tener 150 unidades de minerales en total
        for (int i = 0; i < 10; i++) {
            algoStar.pasarTurno();
        }

        // Se construye una reserva de reproduccion, consumiendo asi 150 minerales
        // Se construye un extractor, consumiendo asi 100 minerales
        jugadorZerg.moverUnidad(new Coordenada(4,3), new Abajo());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.construirEdificio(new Coordenada(4,4), new ReservaDeReproduccion());

        // Se intenta construir un criadero, pero el jugador no deberia tener la suficiente cantidad de minerales
        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            jugadorZerg.construirEdificio(new Coordenada(3,2), new Criadero());
        });
    }

	@Test
    public void elJugadorProtossTendria290MineralesEn9TurnosUsandoUnNexoMineral() {
        AlgoStar algoStar = new AlgoStar();
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        algoStar.empezarJuego();

        // Se construye un nexo mineral en la casilla (4,3), en donde deberia haber minerales
        jugadorProtoss.construirEdificio(new Coordenada(4,3), new NexoMineral());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        // Tras 9 turnos del jugador protoss (18 turnos en total), el jugador deberia tener 290 unidades de minerales en total
        for (int i = 0; i < 18; i++) {
            algoStar.pasarTurno();
        }

        // Se construye un acceso en la coordenada (3,2), consumiendo asi 150 minerales
        jugadorProtoss.construirEdificio(new Coordenada(3,2), new Acceso());

        // Se construye un pilon en la coordenada (5,2), consumiendo asi 100 minerales
        jugadorProtoss.construirEdificio(new Coordenada(5,2), new Pilon());

        // Se intenta construir un nexo mineral en la coordenada (3,4), pero el jugador no deberia tener la suficiente cantidad de minerales
        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            jugadorProtoss.construirEdificio(new Coordenada(3,4), new NexoMineral());
        });
    }

	@Test
    public void elJugadorProtossTendria300MineralesEn10TurnosUsandoUnNexoMineral() {
        AlgoStar algoStar = new AlgoStar();
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        algoStar.empezarJuego();

        // Se construye un nexo mineral en la casilla (4,3), en donde deberia haber minerales
        jugadorProtoss.construirEdificio(new Coordenada(4,3), new NexoMineral());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        // Tras 10 turnos del jugador protoss (20 turnos en total), el jugador deberia tener 300 unidades de minerales en total
        for (int i = 0; i < 10; i++) {
            algoStar.pasarTurno();
        }

        // Se construye un acceso en la coordenada (3,2), consumiendo asi 150 minerales
        jugadorProtoss.construirEdificio(new Coordenada(3,2), new Acceso());

        // Se construye un pilon en la coordenada (5,2), consumiendo asi 100 minerales
        jugadorProtoss.construirEdificio(new Coordenada(5,2), new Pilon());

        jugadorProtoss.construirEdificio(new Coordenada(3,4), new NexoMineral());

        // Se intenta construir un nexo mineral en la coordenada (3,4), pero el jugador no deberia tener la suficiente cantidad de minerales
        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            jugadorProtoss.construirEdificio(new Coordenada(4,5), new NexoMineral());
        });
    }

    */

}
