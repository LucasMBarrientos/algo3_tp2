package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaTalUnidad;
import edu.fiuba.algo3.modelo.geometria.direcciones.*;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso20 {
    @Test
    public void unaUnidadTerrestreNoPuedeEntrarAAreaEspacial(){
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugador = new JugadorZerg("La mente suprema", "#ff0000",500,500,200);
        algoStar.agregarJugador(jugador);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();


        Assertions.assertThrows(TerrenoNoAptoParaTalUnidad.class, ()->{
            jugador.moverUnidad(new Coordenada(1,1), new Arriba());
        });

    }
}
