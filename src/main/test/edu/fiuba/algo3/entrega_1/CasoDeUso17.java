package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.JugadorProtoss;
import edu.fiuba.algo3.modelo.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.edificios.protoss.acceso.Acceso;
import edu.fiuba.algo3.modelo.unidades.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.unidades.edificios.protoss.puertoEstelar.PuertoEstelar;
import edu.fiuba.algo3.modelo.unidades.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.unidades.edificios.zerg.espiral.Espiral;
import edu.fiuba.algo3.modelo.unidades.edificios.zerg.guarida.Guarida;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso17 {
    @Test
    public void noSePuedeConstruirUnPuertoEstelarSinUnAcceso() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 325, 0);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();
        jugadorProtoss.construirEdificio(new Coordenada(4, 4), new Pilon());
        for (int i = 0; i < 6; i++) {
            algoStar.pasarTurno();
        }

        Assertions.assertFalse(jugadorProtoss.construirEdificio(new Coordenada(4, 4), new PuertoEstelar()));
    }

    @Test
    public void SePuedeConstruirUnPuertoEstelarSiHayUnAcceso() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 325, 0);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();
        jugadorProtoss.construirEdificio(new Coordenada(4, 4), new Pilon());
        for (int i = 0; i < 6; i++) {
            algoStar.pasarTurno();
        }
        jugadorProtoss.construirEdificio(new Coordenada(4, 5), new Acceso());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        Assertions.assertTrue(jugadorProtoss.construirEdificio(new Coordenada(4, 4), new PuertoEstelar()));
    }

    @Test
    public void noSePuedeConstruirUnEspiralSinUnaGuarida() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 325, 0);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();
        jugadorZerg.construirEdificio(new Coordenada(4, 4), new Criadero());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        Assertions.assertFalse(jugadorZerg.construirEdificio(new Espiral(5, 5), new PuertoEstelar()));
    }

    @Test
    public void SePuedeConstruirUnEspiralSiHayUnaGuarida() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 325, 0);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();
        jugadorZerg.construirEdificio(new Coordenada(4, 4), new Criadero());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }
        jugadorZerg.construirEdificio(new Coordenada(4, 5), new Guarida());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        Assertions.assertTrue(jugadorZerg.construirEdificio(new Coordenada(5, 5), new Espiral()));
    }
}