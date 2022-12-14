package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.edificios.protoss.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso24 {

    @Test
    public void jugadoresInicianEnLaEsquilasDelMapa() {
        Coordenada coordenadaDelVolcanInicialDelJugadorZerg = new Coordenada(4, 4);
        Coordenada coordenadaDelVolcanInicialDelJugadorProtoss = new Coordenada(95, 45);
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        for (int y = 1; y < 4; y++) {
            jugadorZerg.moverUnidad(new Coordenada(1, y), new Abajo());
            algoStar.pasarTurno();
            algoStar.pasarTurno();
        }
        for (int x = 1; x < 4; x++) {
            jugadorZerg.moverUnidad(new Coordenada(x, 4), new Derecha());
            algoStar.pasarTurno();
            algoStar.pasarTurno();
        }

        jugadorZerg.construirEdificio(coordenadaDelVolcanInicialDelJugadorZerg, new Extractor());
        algoStar.pasarTurno();
        jugadorProtoss.construirEdificio(coordenadaDelVolcanInicialDelJugadorProtoss, new Asimilador());

        // Se intenta construir un pilon en un terreno que deberia tener minerales
        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            jugadorProtoss.construirEdificio(coordenadaDelVolcanInicialDelJugadorProtoss.devolverCoordenadaRelativa(1, 0), new Pilon());
        });
    }

}
