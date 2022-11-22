package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaTalUnidad;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoPoseeUnaUnidad;
import edu.fiuba.algo3.modelo.excepciones.UnidadNoEncontrada;
import edu.fiuba.algo3.modelo.geometria.direcciones.*;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.espiral.Espiral;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso20 {
    @Test
    public void unaUnidadTerrestreNoPuedeEntrarAAreaEspacial(){
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugador = new JugadorZerg("La mente suprema", "#ff0000",500,500);
        algoStar.agregarJugador(jugador);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        algoStar.pasarTurno();
        algoStar.pasarTurno();

        jugador.moverUnidad(new Coordenada(1,1), new Derecha());
        jugador.moverUnidad(new Coordenada(2,1), new Abajo());

        jugador.construirEdificio(new Coordenada(2,2), new Criadero());
        for(int i=0; i<6; i++ ){ jugador.actualizar(); }

        jugador.generarUnidad(new Coordenada(2,2), new Zangano());

        for(int i=0; i<3; i++ ){ jugador.actualizar(); }

        jugador.moverUnidad(new Coordenada(2,1), new Arriba());

        //en la coordenada en (2,0) hay area espacial
        Assertions.assertThrows(UnidadNoEncontrada.class, ()->{
            jugador.moverUnidad(new Coordenada(2,0), new Derecha());
        });
    }
}
