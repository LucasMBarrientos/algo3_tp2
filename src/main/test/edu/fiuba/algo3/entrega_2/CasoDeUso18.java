package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.EdificioDestruido;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.*;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.Guardian;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso18 {

    @Test
    public void zerlingAtacaAPilon150VecesYALaProximaDevuelveErrorPorEdificioDestruido() {
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0));
        Zerling zerling = new Zerling();
        Pilon pilon = new Pilon();
        Mapa mapa = new Mapa(new Coordenada(20,20));

        zerling.establecerCoordenada(new Coordenada(1,2));

        pilon.ocupar(mapa.buscarTerreno(new Coordenada(2,2)));

        for (int i = 0; i < 10; i++) {
            pilon.actualizar(inventario);
        }

        zerling.actualizar(inventario);
        zerling.actualizar(inventario);
        zerling.actualizar(inventario);
        zerling.actualizar(inventario);
        zerling.actualizar(inventario);
        zerling.actualizar(inventario);

        for(int i = 0; i < 150; i++) {
            zerling.atacar(new Coordenada(2,2), mapa);
        }

        Assertions.assertThrows(EdificioEstaDestruido.class, ()->{
            zerling.atacar(new Coordenada(2,2), mapa);
        });
    }

    @Test
    public void hidraliscoAtacaAPilon60VecesYALaProximaDevuelveErrorPorEdificioDestruido() {
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0));
        Hidralisco hidralisco = new Hidralisco();
        Pilon pilon = new Pilon();
        Mapa mapa = new Mapa(new Coordenada(20,20));

        hidralisco.establecerCoordenada(new Coordenada(1,2));

        pilon.ocupar(mapa.buscarTerreno(new Coordenada(2,2)));

        for (int i = 0; i < 10; i++) {
            pilon.actualizar(inventario);
        }

        hidralisco.actualizar(inventario);
        hidralisco.actualizar(inventario);
        hidralisco.actualizar(inventario);
        hidralisco.actualizar(inventario);
        hidralisco.actualizar(inventario);
        hidralisco.actualizar(inventario);

        for(int i = 0; i < 60; i++) {
            hidralisco.atacar(new Coordenada(2,2), mapa);
        }

        Assertions.assertThrows(EdificioEstaDestruido.class, ()->{
            hidralisco.atacar(new Coordenada(2,2), mapa);
        });
    }

    @Test
    public void mutaliscoAtacaAPilon66VecesYALaProximaDevuelveErrorPorEdificioDestruido() {
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0));
        Mutalisco mutalisco = new Mutalisco();
        Pilon pilon = new Pilon();
        Mapa mapa = new Mapa(new Coordenada(20,20));

        mutalisco.establecerCoordenada(new Coordenada(1,2));

        pilon.ocupar(mapa.buscarTerreno(new Coordenada(2,2)));

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

        for(int i = 0; i < 67; i++) {
            mutalisco.atacar(new Coordenada(2,2), mapa);
        }

        Assertions.assertThrows(EdificioEstaDestruido.class, ()->{
            mutalisco.atacar(new Coordenada(2,2), mapa);
        });
    }

    @Test
    public void zealotAtacaACriadero62VecesYALaProximaDevuelveErrorPorEdificioDestruido() {
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0));
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

        for(int i = 0; i < 75; i++) {
            zealot.atacar(new Coordenada(2,2), mapa);
        }

        Assertions.assertThrows(EdificioEstaDestruido.class, ()->{
            zealot.atacar(new Coordenada(2,2), mapa);
        });
    }

    @Test
    public void dragonAtacaACriadero25VecesYALaProximaDevuelveErrorPorEdificioDestruido() {
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0));
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

        for(int i = 0; i < 30; i++) {
            dragon.atacar(new Coordenada(2,2), mapa);
        }

        Assertions.assertThrows(EdificioEstaDestruido.class, ()->{
            dragon.atacar(new Coordenada(2,2), mapa);
        });
    }

    @Test
    public void scoutAtacaACriadero62VecesYALaProximaDevuelveErrorPorEdificioDestruido() {
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0));
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

        for(int i = 0; i < 75; i++) {
            scout.atacar(new Coordenada(2,2), mapa);
        }

        Assertions.assertThrows(EdificioEstaDestruido.class, ()->{
            scout.atacar(new Coordenada(2,2), mapa);
        });
    }

}
