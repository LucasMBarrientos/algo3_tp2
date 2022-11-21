package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.espiral.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

import org.junit.jupiter.api.Test;

import com.tngtech.archunit.lang.ArchRule.Assertions;

public class CasoDeUso27 {

    /*

    @Test
    public void unMutalizcoPuedeEvolucionarEnUnDevoradorSiHaySuficientesRecursosYLuegoPuedeAtacarAUnEnemigoA5CoordenadasDeDistancia() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 800, 800); // TODO: Marcar los recursos estrictamente necesarios para lograr pasar esta prueba
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        jugadorZerg.construirEdificio(new Coordenada(1, 1), new Criadero());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        // Construir una reserva de reproduccion
        jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.construirEdificio(new Coordenada(2, 1), new ReservaDeReproduccion()); // TODO: Suponiendo que el zangano de antes se genere en la coordenada (2,1)
        for (int i = 0; i < 12; i++) {
            algoStar.pasarTurno();
        }

        // construir una guarida
        jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(new Coordenada(1,2), new Abajo()); // TODO: Suponiendo que el zangano de antes se genere en la coordenada (1,2)
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.construirEdificio(new Coordenada(1, 3), new Guarida());
        for (int i = 0; i < 12; i++) {
            algoStar.pasarTurno();
        }

        // construir una espiral
        jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(new Coordenada(1,2), new Derecha());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(new Coordenada(2,2), new Derecha());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.construirEdificio(new Coordenada(3, 2), new Espiral());
        for (int i = 0; i < 10; i++) {
            algoStar.pasarTurno();
        }

        // generar un mutalisco
        jugadorZerg.generarUnidad(new Coordenada(3,2), new Mutalisco());
        for (int i = 0; i < 14; i++) {
            algoStar.pasarTurno();
        }

        // Evolucionar el mutalisco en un devorador
        jugadorZerg.evolucionarUnidad(new Coordenada(3,1), new Devorador());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        // TODO: jugadorProtoss debe construir una unidad en la coordenada (8,1)

        // Se intenta atacar una unidad que esta a 5 de rango
        Assertions.assertThrows(UnidadDestruida.class, ()->{
            jugadorZerg.atacar(new Coordenada(3,1), new Coordenada(8,1));
        });
    }

    */

}
