package edu.fiuba.algo3.entrega_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoAlcanzado;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;

public class CasoDeUso32 {
  
    @Test
    public void finDelJuegoAlcanzadoCuandoTodosLosEdificiosSonDestruidos() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 0, 500,200);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff",0,250,200);
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        // Construyo un edificio inicial
        jugadorZerg.construirEdificio(new Coordenada(1,1), new Criadero());
        for (int i = 0; i < 10; i++) {
            algoStar.pasarTurno();
        }

        // Destruyo el edificio inicial
        jugadorZerg.destruirEdificio(new Coordenada(1,1));


        Assertions.assertThrows(FinDelJuegoAlcanzado.class, ()->{
            algoStar.pasarTurno();
        });
    }

}
