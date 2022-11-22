package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso13 {

	@Test
    public void sePuedeConstruirSobreElMohoDeUnCriaderoDestruido() {
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

        // Se generan 2 zanganos
        jugadorZerg.generarUnidad(new Coordenada(2,2), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        //jugadorZerg.moverUnidad(new Coordenada(2,1), new Derecha());
        //jugadorZerg.generarUnidad(new Coordenada(2,2), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        algoStar.DEBUG_DEVOLVERMAPA().DEBUG_MOSTRARMAPATERRENO();

        // Se destruye el criadero
        jugadorZerg.destruirUnidad(new Coordenada(2,2));

        // Se construye una reserva de reproduccion sobre el moho generado previamente
        jugadorZerg.construirEdificio(new Coordenada(3,1), new ReservaDeReproduccion());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        // Se intenta construir una reserva de reproduccion fuera del rango del moho generado por ese criadero
        for (int x = 4; x < 15; x++) {
            jugadorZerg.moverUnidad(new Coordenada(x,2), new Derecha());
            algoStar.pasarTurno();
            algoStar.pasarTurno();
        }
        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            jugadorZerg.construirEdificio(new Coordenada(15,2), new ReservaDeReproduccion());
        });
    }
    
}
