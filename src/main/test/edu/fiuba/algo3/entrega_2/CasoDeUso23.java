package edu.fiuba.algo3.entrega_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.excepciones.AtaqueImposibleDeRealizarse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

public class CasoDeUso23 {

    @Test
    public void zerlingNoPuedeAtacarFueraDeSuRango() {
        Mapa.devolverInstancia().establecerDimension(new Coordenada(100, 50));
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));
        Zerling zerling = new Zerling();
        Zealot zealot1 = new Zealot();
        Zealot zealot2 = new Zealot();

        Mapa.devolverInstancia().establecerUnidad(new Coordenada(2,1), zerling);
        Mapa.devolverInstancia().establecerUnidad(new Coordenada(3,1), zealot1);
        Mapa.devolverInstancia().establecerUnidad(new Coordenada(4,1), zealot2);

        for (int i=0; i<20; i++) {
            zerling.actualizar(inventario);
            zealot1.actualizar(inventario);
            zealot2.actualizar(inventario);
        }

        zerling.atacar(new Coordenada(3, 1));

        Assertions.assertThrows(AtaqueImposibleDeRealizarse.class, ()->{
            zerling.atacar(new Coordenada(4, 1));
        });
    }

    @Test
    public void hidraliscoNoPuedeAtacarFueraDeSuRango() {
        Mapa.devolverInstancia().establecerDimension(new Coordenada(100, 50));
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));

        Hidralisco hidralisco = new Hidralisco();
        Zealot zealot1 = new Zealot();
        Zealot zealot2 = new Zealot();

        Mapa.devolverInstancia().establecerUnidad(new Coordenada(2,1), hidralisco);
        Mapa.devolverInstancia().establecerUnidad(new Coordenada(6,1), zealot1);
        Mapa.devolverInstancia().establecerUnidad(new Coordenada(7,1), zealot2);


        for (int i=0; i<20; i++) {
            hidralisco.actualizar(inventario);
            zealot1.actualizar(inventario);
            zealot2.actualizar(inventario);
        }

        hidralisco.atacar(new Coordenada(6, 1));

        Assertions.assertThrows(AtaqueImposibleDeRealizarse.class, ()->{
            hidralisco.atacar(new Coordenada(7, 1));
        });
    }

    @Test
    public void mutalicoNoPuedeAtacarFueraDeSuRango() {
        Mapa.devolverInstancia().establecerDimension(new Coordenada(100, 50));
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));

        Mutalisco mutalisco = new Mutalisco();
        Zealot zealot1 = new Zealot();
        Zealot zealot2 = new Zealot();

        Mapa.devolverInstancia().establecerUnidad(new Coordenada(2,1), mutalisco);
        Mapa.devolverInstancia().establecerUnidad(new Coordenada(5,1), zealot1);
        Mapa.devolverInstancia().establecerUnidad(new Coordenada(6,1), zealot2);

        for (int i=0; i<20; i++) {
            mutalisco.actualizar(inventario);
            zealot1.actualizar(inventario);
            zealot2.actualizar(inventario);
        }

        mutalisco.atacar(new Coordenada(5, 1));

        Assertions.assertThrows(AtaqueImposibleDeRealizarse.class, ()->{
            mutalisco.atacar(new Coordenada(6, 1));
        });

    }

}
