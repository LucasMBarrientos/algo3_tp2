package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import org.junit.jupiter.api.Test;

public class TestMovimientos {
    @Test
    public void moverseDerechaFunciona(){
        AlgoStar a = new AlgoStar();
        a.empezarJuego();
        a.DEBUG_DEVOLVERMAPA().DEBUG_MOSTRARMAPAUNIDADES();

        a.agregarJugador(new JugadorZerg("asdfgh","-"));
        a.devolverJugadorActual().construirEdificio(new Coordenada(5,5), new Criadero());


    }
}
