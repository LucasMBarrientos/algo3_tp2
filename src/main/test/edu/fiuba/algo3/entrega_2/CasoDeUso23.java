package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.estadisticas.Danio;

import edu.fiuba.algo3.modelo.excepciones.AtaqueImposibleDeRealizarse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso23 {
    
    @Test
    public void zerlingNoPuedeAtacarFueraDeSuRango() {
        Mapa mapa = new Mapa(new Coordenada(100, 50));
        Zerling zerling = new Zerling();
        Zealot zealot1 = new Zealot();
        Zealot zealot2 = new Zealot();

        mapa.establecerUnidad(new Coordenada(2, 1), zerling);
        mapa.establecerUnidad(new Coordenada(3, 1), zealot1);
        mapa.establecerUnidad(new Coordenada(4, 1), zealot2);

        for (int i=0; i<20; i++) {
            zerling.actualizar();
            zealot1.actualizar();
            zealot2.actualizar();
        }

        zerling.atacar(new Coordenada(3, 1), mapa);

        Assertions.assertThrows(AtaqueImposibleDeRealizarse.class, ()->{
            zerling.atacar(new Coordenada(4, 1), mapa);
        });
    }

    @Test
    public void hidraliscoNoPuedeAtacarFueraDeSuRango() {
        Mapa mapa = new Mapa(new Coordenada(100, 50));
        Hidralisco hidralisco = new Hidralisco();
        Zealot zealot1 = new Zealot();
        Zealot zealot2 = new Zealot();

        mapa.establecerUnidad(new Coordenada(2, 1), hidralisco);
        mapa.establecerUnidad(new Coordenada(6, 1), zealot1);
        mapa.establecerUnidad(new Coordenada(7, 1), zealot2);

        for (int i=0; i<20; i++) {
            hidralisco.actualizar();
            zealot1.actualizar();
            zealot2.actualizar();
        }

        hidralisco.atacar(new Coordenada(6, 1), mapa);

        Assertions.assertThrows(AtaqueImposibleDeRealizarse.class, ()->{
            hidralisco.atacar(new Coordenada(7, 1), mapa);
        });
    }

    @Test
    public void mutalicoNoPuedeAtacarFueraDeSuRango() {
        Mapa mapa = new Mapa(new Coordenada(100, 50));
        Mutalisco mutalisco = new Mutalisco();
        Zealot zealot1 = new Zealot();
        Zealot zealot2 = new Zealot();

        mapa.establecerUnidad(new Coordenada(2, 1), mutalisco);
        mapa.establecerUnidad(new Coordenada(5, 1), zealot1);
        mapa.establecerUnidad(new Coordenada(6, 1), zealot2);

        for (int i=0; i<20; i++) {
            mutalisco.actualizar();
            zealot1.actualizar();
            zealot2.actualizar();
        }

        mutalisco.atacar(new Coordenada(5, 1), mapa);

        Assertions.assertThrows(AtaqueImposibleDeRealizarse.class, ()->{
            mutalisco.atacar(new Coordenada(6, 1), mapa);
        });

    }

}
