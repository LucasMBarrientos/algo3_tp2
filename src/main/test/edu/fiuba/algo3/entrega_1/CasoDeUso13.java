package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.*;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso13 {

	@Test
    public void sePuedeConstruirSobreElMohoDeUnCriaderoDestruido() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 0, 500,200);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        // Se construye un criadero
        jugadorZerg.construirEdificio(new Coordenada(1,1), new Criadero());
        for (int i = 0; i < 5; i++) {
            algoStar.pasarTurno();
        }

        // Se generan 2 zanganos
        jugadorZerg.generarUnidad(new Coordenada(1,1), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        
        // Se destruye el criadero
        jugadorZerg.destruirEdificio(new Coordenada(1,1));


        jugadorZerg.moverUnidad(new Coordenada(2,1), new Abajo());

        jugadorZerg.construirEdificio(new Coordenada(2,2), new ReservaDeReproduccion());

        // Se construye una reserva de reproduccion sobre el moho generado previamente

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            jugadorZerg.generarUnidad(new Coordenada(2,2), new Zerling());
        });
    }

}
