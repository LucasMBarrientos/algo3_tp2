package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.edificios.protoss.acceso.Acceso;
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
    public void terrenoEnergizadoNoPisaMoho() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff", 0, 250);
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        // Se construye un criadero
        jugadorZerg.construirEdificio(new Coordenada(1,1), new Criadero());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        algoStar.pasarTurno();

        // Se construye un pilon
        jugadorProtoss.construirEdificio(new Coordenada(11,1), new Pilon());
        for (int i = 0; i < 12; i++) {
            algoStar.pasarTurno();
        }

        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            jugadorProtoss.construirEdificio(new Coordenada(10,1), new Acceso());
        });
    }
    @Test
    public void terrenoMohoPuedePisarTerrenoEnergizado() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff", 0, 250);
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        // Se construye un criadero
        jugadorZerg.construirEdificio(new Coordenada(1,1), new Criadero());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        algoStar.pasarTurno();

        // Se construye un pilon
        jugadorProtoss.construirEdificio(new Coordenada(11,1), new Pilon());
        for (int i = 0; i < 12; i++) {
            algoStar.pasarTurno();
        }

        // Tiempo extra para que se expanda el moho
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            jugadorProtoss.construirEdificio(new Coordenada(11,2), new Acceso());
        });
    }

}