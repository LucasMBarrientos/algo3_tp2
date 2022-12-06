package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.excepciones.AtaqueImposibleDeRealizarse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.Guardian;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

public class CasoDeUso19 {

    @Test
    public void unZerlingPuedeAtacarAlScoutPeroNoLeHaceDaño() {
        Mapa mapa = new Mapa(new Coordenada(100, 50));
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(0));
        Zerling zerling = new Zerling();
        Scout scout = new Scout();

        mapa.establecerUnidad(new Coordenada(2, 1), zerling);
        mapa.establecerUnidad(new Coordenada(2, 2), scout);

        for (int i=0; i<20; i++) {
            zerling.actualizar(inventario);
            scout.actualizar(inventario);
        }

        for (int i = 0; i < 200; i++) {
            zerling.atacar(new Coordenada(2, 2), mapa);
        }

        Assertions.assertThrows(UnidadEstaDestruida.class, ()->{
            scout.moverse(new Derecha(),mapa);
        });
    }
    
    @Test
    public void unGuardianPuedeAtacarAlZealotPeroNoAlScout() {
        Mapa mapa = new Mapa(new Coordenada(100, 50));
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(0));
        Guardian guardian = new Guardian();
        Zealot zealot = new Zealot();
        Scout scout = new Scout();

        mapa.establecerUnidad(new Coordenada(2, 1), guardian);
        mapa.establecerUnidad(new Coordenada(3, 1), zealot);
        mapa.establecerUnidad(new Coordenada(2, 2), scout);

        for (int i=0; i<20; i++) {
            guardian.actualizar(inventario);
            zealot.actualizar(inventario);
            scout.actualizar(inventario);
        }

        guardian.atacar(new Coordenada(3, 1), mapa);

        Assertions.assertThrows(AtaqueImposibleDeRealizarse.class, ()->{
            guardian.atacar(new Coordenada(2, 2), mapa);
        });
    }    

}
