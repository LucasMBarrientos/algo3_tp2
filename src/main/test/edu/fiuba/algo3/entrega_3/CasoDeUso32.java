package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.edificios.protoss.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoAlcanzado;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Izquierda;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso32 {
  
    @Test
    public void finDelJuegoAlcanzadoCuandoTodosLosEdificiosSonDestruidos() {
        Logger.setEnableLog(true);
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 0, 500,200);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff",500,500,200);
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        //construyo un pilon
        jugadorProtoss.construirEdificio(new Coordenada(30, 2), new Pilon());
        for (int i = 0; i < 7; i++) {
            algoStar.pasarTurno();
        }

        //construyo un acceso
        algoStar.pasarTurno();
        jugadorProtoss.construirEdificio(new Coordenada(29, 2), new Acceso());
        for (int i = 0; i < 9; i++) {
            algoStar.pasarTurno();
        }

        // Genero un zealot en el acceso
        jugadorProtoss.generarUnidad(new Coordenada(29,2), new Zealot());
        for (int i = 0; i < 5; i++) {
            algoStar.pasarTurno();
        }

        //Muevo el zealot
        for (int x = 29; x > 2; x--) {
            jugadorProtoss.moverUnidad(new Coordenada(x,1), new Izquierda());
            algoStar.pasarTurno();
        }

        //construyo un criadero
        jugadorZerg.construirEdificio(new Coordenada(1,1), new Criadero());
        for (int i = 0; i < 5; i++) {
            algoStar.pasarTurno();
        }

        //zealot mata al criadero
        for (int i = 0; i < 63; i++) {
            try{
                jugadorProtoss.atacar(new Coordenada(2,1), new Coordenada(1,1));
            } catch (EdificioEstaDestruido e){}
        }

        Assertions.assertThrows(FinDelJuegoAlcanzado.class, ()->{
            algoStar.pasarTurno();
        });
    }

}
