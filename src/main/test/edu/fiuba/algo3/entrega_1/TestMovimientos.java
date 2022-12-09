package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Arriba;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.geometria.direcciones.Izquierda;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMovimientos {
    @Test
    public void moverseDerechaFunciona() {
        Mapa.devolverInstancia().establecerDimension(new Coordenada(20, 20));
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));
        Zangano zangano = new Zangano();

        Mapa.devolverInstancia().establecerUnidad(new Coordenada(1,1),zangano);

        zangano.actualizar(inv);
        zangano.actualizar(inv);
        zangano.actualizar(inv);
        
        zangano.moverse(new Derecha());

        Assertions.assertTrue(zangano.compararCoordenadas(new Coordenada(2,1)));

    }
    @Test
    public void moverseAbajoFunciona() {
        Mapa.devolverInstancia().establecerDimension(new Coordenada(20, 20));
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));
        Zangano zangano = new Zangano();

        Mapa.devolverInstancia().establecerUnidad(new Coordenada(2,2),zangano);

        zangano.actualizar(inv);
        zangano.actualizar(inv);
        zangano.actualizar(inv);

        zangano.moverse(new Abajo());

        Assertions.assertTrue(zangano.compararCoordenadas(new Coordenada(2,3)));

    }
    @Test
    public void moverseArribaFunciona() {
        Mapa.devolverInstancia().establecerDimension(new Coordenada(20, 20));
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));
        Zangano zangano = new Zangano();

        Mapa.devolverInstancia().establecerUnidad(new Coordenada(2,2),zangano);

        zangano.actualizar(inv);
        zangano.actualizar(inv);
        zangano.actualizar(inv);

        zangano.moverse(new Arriba());

        Assertions.assertTrue(zangano.compararCoordenadas(new Coordenada(2,1)));
    }

    @Test
    public void moverseIzquierdaFunciona(){
        Mapa.devolverInstancia().establecerDimension(new Coordenada(20, 20));
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));
        Zangano zangano = new Zangano();

        Mapa.devolverInstancia().establecerUnidad(new Coordenada(2,2),zangano);

        zangano.actualizar(inv);
        zangano.actualizar(inv);
        zangano.actualizar(inv);
        
        zangano.moverse(new Izquierda());

        Assertions.assertTrue(zangano.compararCoordenadas(new Coordenada(1,2)));

    }

}
