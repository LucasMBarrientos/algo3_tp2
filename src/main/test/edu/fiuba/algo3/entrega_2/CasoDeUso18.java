package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso18 {

    @Test
    public void zerlingAtacaAPilon150VecesYALaProximaDevuelveErrorPorEdificioDestruido() {
        Mapa.devolverInstancia().establecerDimension(new Coordenada(20, 20));
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(400), new Suministro(200));
        Zerling zerling = new Zerling();
        Pilon pilon = new Pilon();
        pilon.establecerPosicion(new Coordenada(2,2));

        Mapa.devolverInstancia().establecerEdificio(new Coordenada(2,2), pilon);
        Mapa.devolverInstancia().establecerUnidad(new Coordenada(1,2), zerling);

        for (int i = 0; i < 10; i++) {
            pilon.actualizar(inventario);
        }

        zerling.actualizar(inventario);
        zerling.actualizar(inventario);
        zerling.actualizar(inventario);
        zerling.actualizar(inventario);
        zerling.actualizar(inventario);
        zerling.actualizar(inventario);

        for(int i = 0; i < 149; i++) {
            zerling.atacar(new Coordenada(2,2));
        }

        Assertions.assertThrows(EdificioEstaDestruido.class, ()->{
            zerling.atacar(new Coordenada(2,2));
        });
    }

    @Test
    public void hidraliscoAtacaAPilon60VecesYALaProximaDevuelveErrorPorEdificioDestruido() {
        Mapa.devolverInstancia().establecerDimension(new Coordenada(20, 20));
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));
        Hidralisco hidralisco = new Hidralisco();
        Pilon pilon = new Pilon();

        hidralisco.establecerCoordenada(new Coordenada(1,2));

        pilon.ocupar(Mapa.devolverInstancia().buscarTerreno(new Coordenada(2, 2)));

        for (int i = 0; i < 10; i++) {
            pilon.actualizar(inventario);
        }

        hidralisco.actualizar(inventario);
        hidralisco.actualizar(inventario);
        hidralisco.actualizar(inventario);
        hidralisco.actualizar(inventario);
        hidralisco.actualizar(inventario);
        hidralisco.actualizar(inventario);

        for(int i = 0; i < 59; i++) {
            hidralisco.atacar(new Coordenada(2,2));
        }

        Assertions.assertThrows(EdificioEstaDestruido.class, ()->{
            hidralisco.atacar(new Coordenada(2,2));
        });
    }

    @Test
    public void mutaliscoAtacaAPilon66VecesYALaProximaDevuelveErrorPorEdificioDestruido() {
        Mapa.devolverInstancia().establecerDimension(new Coordenada(20, 20));
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));
        Mutalisco mutalisco = new Mutalisco();
        Pilon pilon = new Pilon();

        mutalisco.establecerCoordenada(new Coordenada(1,2));

        pilon.ocupar(Mapa.devolverInstancia().buscarTerreno(new Coordenada(2, 2)));

        for (int i = 0; i < 10; i++) {
            pilon.actualizar(inventario);
        }

        mutalisco.actualizar(inventario);
        mutalisco.actualizar(inventario);
        mutalisco.actualizar(inventario);
        mutalisco.actualizar(inventario);
        mutalisco.actualizar(inventario);
        mutalisco.actualizar(inventario);
        mutalisco.actualizar(inventario);

        for(int i = 0; i < 66; i++) {
            mutalisco.atacar(new Coordenada(2,2));
        }

        Assertions.assertThrows(EdificioEstaDestruido.class, ()->{
            mutalisco.atacar(new Coordenada(2,2));
        });
    }
/*
    @Test
    public void zealotAtacaACriadero62VecesYALaProximaDevuelveErrorPorEdificioDestruido() {
        Mapa.devolverInstancia().establecerDimension(new Coordenada(20, 20));
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));
        Zealot zealot = new Zealot();
        Pilon pilon = new Pilon();
        Mapa mapa = new Mapa(new Coordenada(20,20));

        zealot.establecerCoordenada(new Coordenada(1,2));

        pilon.ocupar(mapa.buscarTerreno(new Coordenada(2,2)));

        for (int i = 0; i < 10; i++) {
            pilon.actualizar(inventario);
        }

        zealot.actualizar(inventario);
        zealot.actualizar(inventario);
        zealot.actualizar(inventario);
        zealot.actualizar(inventario);
        zealot.actualizar(inventario);
        zealot.actualizar(inventario);
        zealot.actualizar(inventario);

        for(int i = 0; i < 74; i++) {
            zealot.atacar(new Coordenada(2,2), mapa);
        }

        Assertions.assertThrows(EdificioEstaDestruido.class, ()->{
            zealot.atacar(new Coordenada(2,2), mapa);
        });
    }

    @Test
    public void dragonAtacaACriadero25VecesYALaProximaDevuelveErrorPorEdificioDestruido() {
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));
        Dragon dragon = new Dragon();
        Pilon pilon = new Pilon();
        Mapa mapa = new Mapa(new Coordenada(20,20));

        dragon.establecerCoordenada(new Coordenada(1,2));

        pilon.ocupar(mapa.buscarTerreno(new Coordenada(2,2)));

        for (int i = 0; i < 10; i++) {
            pilon.actualizar(inventario);
        }

        dragon.actualizar(inventario);
        dragon.actualizar(inventario);
        dragon.actualizar(inventario);
        dragon.actualizar(inventario);
        dragon.actualizar(inventario);
        dragon.actualizar(inventario);

        for(int i = 0; i < 29; i++) {
            dragon.atacar(new Coordenada(2,2), mapa);
        }

        Assertions.assertThrows(EdificioEstaDestruido.class, ()->{
            dragon.atacar(new Coordenada(2,2), mapa);
        });
    }

    @Test
    public void scoutAtacaACriadero62VecesYALaProximaDevuelveErrorPorEdificioDestruido() {
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));
        Scout scout = new Scout();
        Pilon pilon = new Pilon();
        Mapa mapa = new Mapa(new Coordenada(20,20));

        scout.establecerCoordenada(new Coordenada(1,2));

        pilon.ocupar(mapa.buscarTerreno(new Coordenada(2,2)));

        for (int i = 0; i < 10; i++) {
            pilon.actualizar(inventario);
        }

        scout.actualizar(inventario);
        scout.actualizar(inventario);
        scout.actualizar(inventario);
        scout.actualizar(inventario);
        scout.actualizar(inventario);
        scout.actualizar(inventario);
        scout.actualizar(inventario);
        scout.actualizar(inventario);
        scout.actualizar(inventario);

        for(int i = 0; i < 74; i++) {
            scout.atacar(new Coordenada(2,2), mapa);
        }

        Assertions.assertThrows(EdificioEstaDestruido.class, ()->{
            scout.atacar(new Coordenada(2,2), mapa);
        });
    }
*/
}
