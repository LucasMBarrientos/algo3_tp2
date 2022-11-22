package edu.fiuba.algo3.entrega_2;

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
    public void unZerlingPuedeAtacarAlZealotPeroNoAlScout() {
        Mapa mapa = new Mapa(new Coordenada(100, 50));
        Zerling zerling = new Zerling();
        Zealot zealot = new Zealot();
        Scout scout = new Scout();

        mapa.establecerUnidad(new Coordenada(2, 1), zerling);
        mapa.establecerUnidad(new Coordenada(3, 1), zealot);
        mapa.establecerUnidad(new Coordenada(2, 2), scout);

        for (int i=0; i<20; i++) {
            zerling.actualizar();
            zealot.actualizar();
            scout.actualizar();
        }

        zerling.atacar(new Coordenada(3, 1), mapa);

        Assertions.assertThrows(AtaqueImposibleDeRealizarse.class, ()->{
            zerling.atacar(new Coordenada(2, 2), mapa);
        });
    }
    
    @Test
    public void unGuardianPuedeAtacarAlZealotPeroNoAlScout() {
        Mapa mapa = new Mapa(new Coordenada(100, 50));
        Guardian guardian = new Guardian();
        Zealot zealot = new Zealot();
        Scout scout = new Scout();

        mapa.establecerUnidad(new Coordenada(2, 1), guardian);
        mapa.establecerUnidad(new Coordenada(3, 1), zealot);
        mapa.establecerUnidad(new Coordenada(2, 2), scout);

        for (int i=0; i<20; i++) {
            guardian.actualizar();
            zealot.actualizar();
            scout.actualizar();
        }

        guardian.atacar(new Coordenada(3, 1), mapa);

        Assertions.assertThrows(AtaqueImposibleDeRealizarse.class, ()->{
            guardian.atacar(new Coordenada(2, 2), mapa);
        });
    }    

}
