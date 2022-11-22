package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Arriba;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.geometria.direcciones.Izquierda;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import javafx.scene.layout.CornerRadii;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMovimientos {
    @Test
    public void moverseDerechaFunciona(){
        Mapa mapa = new Mapa(new Coordenada(20,20));

        Zangano zangano = new Zangano();

        zangano.actualizar();
        zangano.actualizar();
        zangano.actualizar();

        mapa.establecerUnidad(new Coordenada(1,1),zangano);
        zangano.moverse(new Derecha(),mapa);

        Assertions.assertTrue(zangano.compararCoordenadas(new Coordenada(2,1)));

    }
    @Test
    public void moverseAbajoFunciona(){
        Mapa mapa = new Mapa(new Coordenada(20,20));

        Zangano zangano = new Zangano();

        zangano.actualizar();
        zangano.actualizar();
        zangano.actualizar();

        mapa.establecerUnidad(new Coordenada(2,2),zangano);
        zangano.moverse(new Abajo(),mapa);

        Assertions.assertTrue(zangano.compararCoordenadas(new Coordenada(2,3)));

    }
    @Test
    public void moverseArribaFunciona(){
        Mapa mapa = new Mapa(new Coordenada(20,20));

        Zangano zangano = new Zangano();

        zangano.actualizar();
        zangano.actualizar();
        zangano.actualizar();

        mapa.establecerUnidad(new Coordenada(2,2),zangano);
        zangano.moverse(new Arriba(),mapa);

        Assertions.assertTrue(zangano.compararCoordenadas(new Coordenada(2,1)));

    }
    @Test
    public void moverseIzquierdaFunciona(){
        Mapa mapa = new Mapa(new Coordenada(20,20));

        Zangano zangano = new Zangano();

        zangano.actualizar();
        zangano.actualizar();
        zangano.actualizar();

        mapa.establecerUnidad(new Coordenada(2,2),zangano);
        zangano.moverse(new Izquierda(),mapa);

        Assertions.assertTrue(zangano.compararCoordenadas(new Coordenada(1,2)));

    }

}
