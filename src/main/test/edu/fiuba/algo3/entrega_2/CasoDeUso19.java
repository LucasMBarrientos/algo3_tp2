package edu.fiuba.algo3.entrega_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.Guardian;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

public class CasoDeUso19 {

    @Test
    public void unZerlingPuedeAtacarAlScoutPeroNoLeHaceDaño() {
        Mapa.devolverInstancia().establecerDimension(new Coordenada(100, 50));
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(0));
        Zerling zerling = new Zerling();
        Scout scout = new Scout();

        Mapa.devolverInstancia().establecerUnidad(new Coordenada(2,1), zerling);
        Mapa.devolverInstancia().establecerUnidad(new Coordenada(2,2), scout);

        for (int i=0; i<20; i++) {
            zerling.actualizar(inventario);
            scout.actualizar(inventario);
        }

        for (int i = 0; i < 200; i++) {
            zerling.atacar(new Coordenada(2, 2));
        }

        for (int i = 0; i < 4; i++) {
            scout.atacar(new Coordenada(2, 1));
        }

        Assertions.assertThrows(UnidadEstaDestruida.class, ()->{
            scout.atacar(new Coordenada(2, 1));
        });
    }
    
    @Test
    public void unGuardianPuedeAtacarAlZealotPeroNoAlScout() {
        Mapa.devolverInstancia().establecerDimension(new Coordenada(100, 50));
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(0));
        Guardian guardian = new Guardian();
        Zealot zealot = new Zealot();
        Scout scout = new Scout();


        Mapa.devolverInstancia().establecerUnidad(new Coordenada(2,1), guardian);
        Mapa.devolverInstancia().establecerUnidad(new Coordenada(3,1), zealot);
        Mapa.devolverInstancia().establecerUnidad(new Coordenada(2,2), scout);


        for (int i=0; i<20; i++) {
            guardian.actualizar(inventario);
            zealot.actualizar(inventario);
            scout.actualizar(inventario);
        }

        for (int i = 0; i < 200; i++) {
            guardian.atacar(new Coordenada(2, 2));
        }

        for (int i = 0; i < 6; i++) {
            guardian.atacar(new Coordenada(3, 1));
        }

        // Puede destruir al zealot
        Assertions.assertThrows(UnidadEstaDestruida.class, ()->{
            guardian.atacar(new Coordenada(3, 1));
        });
    }    

}
