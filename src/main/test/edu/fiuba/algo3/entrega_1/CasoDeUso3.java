package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

import edu.fiuba.algo3.modelo.edificios.protoss.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.recursos.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.terrenos.TerrenoNoAptoParaConstruirEsteEdificio;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CasoDeUso3 {

    @Test
    public void extractorNoPuedeConstruirseSobreUnTerrenoVacio() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Mapa mapa = algoStar.devolverMapa();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        Casilla casillaConTerenoVacio = mapa.hallarCasillaADistanciaRelativa(casillaConVolcan,1,1);
        Casilla casillaConCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        /* TODO: Implementar esto
        jugadorZerg.generarUnidad(casillaConCriadero);
        jugadorZerg.moverUnidad(casillaConCriadero, casillaConTerenoVacio);
        */

        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorZerg.construirEdificio(casillaConTerenoVacio, new Extractor());
        });
    }

    @Test
    public void extractorNoPuedeConstruirseSobreUnTerrenoConMoho() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Mapa mapa = algoStar.devolverMapa();
        Casilla casillaConCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaConMoho = mapa.hallarCasillaADistanciaRelativa(casillaConCriadero,1,0);
        /* TODO: Implementar esto
        jugadorZerg.generarUnidad(casillaConCriadero);
        jugadorZerg.moverUnidad(casillaConCriadero, casillaConMoho);
        */

        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorZerg.construirEdificio(casillaConMoho, new Extractor());
        });
    }

    @Test
    public void extractorPuedeConstruirseSobreUnVolcan() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Casilla casillaConCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        /* TODO: Implementar esto
        jugadorZerg.generarUnidad(casillaConCriadero);
        jugadorZerg.moverUnidad(casillaConCriadero, casillaConVolcan);
        */

        boolean intentoExitoso = true;
        try {
            jugadorZerg.construirEdificio(casillaConVolcan.devolverCoordendas(), new Extractor());
        } catch (TerrenoNoAptoParaConstruirEsteEdificio e) {
            intentoExitoso = false;
        }
        Assertions.assertTrue(intentoExitoso);
    }

    @Test
    public void asimiladorNoPuedeConstruirseSobreUnTerrenoVacio() {
        AlgoStar algoStar = new AlgoStar();
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
        algoStar.agregarJugador(jugadorZerg);
        algoStar.empezarJuego();

        Mapa mapa = algoStar.devolverMapa();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        Casilla casillaConTerenoVacio = mapa.hallarCasillaADistanciaRelativa(casillaConVolcan,1,1);

        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorProtoss.construirEdificio(casillaConTerenoVacio, new Asimilador());
        });
    }

    @Test
    public void asimiladorNoPuedeConstruirseSobreUnTerrenoConMoho() {
        AlgoStar algoStar = new AlgoStar();
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
        algoStar.agregarJugador(jugadorZerg);
        algoStar.empezarJuego();

        Mapa mapa = algoStar.devolverMapa();
        Casilla casillaConCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaConMoho = mapa.hallarCasillaADistanciaRelativa(casillaConCriadero,1,0);

        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorProtoss.construirEdificio(casillaConMoho, new Asimilador());
        });
    }

    @Test
    public void asimiladorPuedeConstruirseSobreUnVolcan() {
        AlgoStar algoStar = new AlgoStar();
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
        algoStar.agregarJugador(jugadorZerg);
        algoStar.empezarJuego();
        
        Casilla casillaConVolcan = jugadorProtoss.hallarCasillaConVolcanInicial();

        boolean intentoExitoso = true;
        try {
            jugadorProtoss.construirEdificio(casillaConVolcan, new Asimilador());
        } catch (TerrenoNoAptoParaConstruirEsteEdificio e) {
            intentoExitoso = false;
        }
        Assertions.assertTrue(intentoExitoso);
    }

}
