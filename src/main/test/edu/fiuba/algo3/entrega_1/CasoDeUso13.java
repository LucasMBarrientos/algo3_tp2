package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.*;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso13 {

	@Test
    public void sePuedeConstruirSobreElMohoDeUnCriaderoDestruido() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 0, 500);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        // Se construye un criadero
        jugadorZerg.construirEdificio(new Coordenada(1,1), new Criadero());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        // Se generan 2 zanganos
        jugadorZerg.generarUnidad(new Coordenada(1,1), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(new Coordenada(2,1), new Abajo());
        jugadorZerg.generarUnidad(new Coordenada(1,1), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();


        // Se destruye el criadero
        jugadorZerg.destruirEdificio(new Coordenada(1,1));

        // Se construye una reserva de reproduccion sobre el moho generado previamente
        jugadorZerg.construirEdificio(new Coordenada(2,2), new ReservaDeReproduccion());
        for (int i = 0; i < 16; i++) {
            algoStar.pasarTurno();
        }

        // Se intenta construir una reserva de reproduccion fuera del rango del moho generado por ese criadero
        for (int x = 2; x < 23; x++) {
            jugadorZerg.moverUnidad(new Coordenada(x,1), new Derecha());
            algoStar.pasarTurno();
            algoStar.pasarTurno();
        }

        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            jugadorZerg.construirEdificio(new Coordenada(23,1), new ReservaDeReproduccion());
        });
    }
    
}
