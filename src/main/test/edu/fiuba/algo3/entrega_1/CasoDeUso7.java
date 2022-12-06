package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.edificios.protoss.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Arriba;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.geometria.direcciones.Izquierda;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso7 {

	@Test
    public void elJugadorZergTendria300MineralesEn10TurnosIngresandoUnZanganoAUnTerrenoMineral() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000",0,200,200);
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
        jugadorZerg.ingresarUnidad(new Coordenada(4,3));
        //el zangano recolecta recursos
        for (int i = 0; i < 10; i++) {
            jugadorZerg.actualizar();
        }

        jugadorZerg.moverUnidad(new Coordenada(4,3), new Arriba());

        // Se construye un criadero, consumiendo asi 200 minerales del jugador
        jugadorZerg.construirEdificio(new Coordenada(4, 2), new Criadero());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        //se puede generar 4 zanganos y los minerales se acaban
        jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
        algoStar.pasarTurno();
        jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
        algoStar.pasarTurno();
        jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
        algoStar.pasarTurno();
        jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
        algoStar.pasarTurno();

        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
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

        // Tras 10 turnos, el jugador deberia tener 290 unidades de minerales en total
        for (int i = 0; i < 10; i++) {
            algoStar.pasarTurno();
        }


        // Se construye un pilon en la coordenada (5,2), consumiendo asi 100 minerales
        jugadorProtoss.construirEdificio(new Coordenada(5,2), new Pilon());

        //ademas de construir el pilon, se obtienen mas minerales
        for (int i = 0; i < 18; i++) {
            algoStar.pasarTurno();
        }
        // Se construye un acceso en la coordenada (3,2), consumiendo asi 150 minerales
        jugadorProtoss.construirEdificio(new Coordenada(3,2), new Acceso());


        // Se construye un acceso en la coordenada (3,2), consumiendo asi 150 minerales
        jugadorProtoss.construirEdificio(new Coordenada(3,3), new Acceso());

        // Se intenta construir un Acceso en la coordenada (3,4), pero el jugador no deberia tener la suficiente cantidad de minerales
        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            jugadorProtoss.construirEdificio(new Coordenada(3,4), new Acceso());
        });
    }

}
