package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

import edu.fiuba.algo3.modelo.edificios.protoss.asimilador.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.extractor.Extractor;
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
        algoStar.empezarJuego();
        Mapa mapa = algoStar.devolverMapa();
        Jugador jugadorZerg = algoStar.devolverJugadorActual();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        Casilla casillaConTerenoVacio = mapa.hallarCasillaADistanciaRelativa(casillaConVolcan,1,1);

        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorZerg.construirEdificio(casillaConTerenoVacio.devolverCoordendas(), new Extractor());
        });
    }

    @Test
    public void extractorNoPuedeConstruirseSobreUnTerrenoConMoho() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Mapa mapa = algoStar.devolverMapa();
        Jugador jugadorZerg = algoStar.devolverJugadorActual();
        List<Casilla> casillasConMoho = mapa.buscarCasillasAdyacentes(jugadorZerg.hallarCasillaConEdificioInicial());

        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorZerg.construirEdificio(casillasConMoho.get(0).devolverCoordendas(), new Extractor());
        });
    }

    @Test
    public void extractorPuedeConstruirseSobreUnVolcan() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Jugador jugadorZerg = algoStar.devolverJugadorActual();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();

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
        algoStar.empezarJuego();
        algoStar.pasarTurno();
        Mapa mapa = algoStar.devolverMapa();
        Jugador jugadorProtoss = algoStar.devolverJugadorActual();
        Casilla casillaConVolcan = jugadorProtoss.hallarCasillaConVolcanInicial();
        Casilla casillaConTerenoVacio = mapa.hallarCasillaADistanciaRelativa(casillaConVolcan,-1,-1);

        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorProtoss.construirEdificio(casillaConTerenoVacio.devolverCoordendas(), new Asimilador());
        });
    }

    @Test
    public void asimiladorNoPuedeConstruirseSobreUnTerrenoConMoho() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Mapa mapa = algoStar.devolverMapa();
        Jugador jugadorZerg = algoStar.devolverJugadorActual();
        algoStar.pasarTurno();
        Jugador jugadorProtoss = algoStar.devolverJugadorActual();
        List<Casilla> casillasConMoho = mapa.buscarCasillasAdyacentes(jugadorZerg.hallarCasillaConEdificioInicial());

        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorProtoss.construirEdificio(casillasConMoho.get(0).devolverCoordendas(), new Asimilador());
        });
    }

    @Test
    public void asimiladorPuedeConstruirseSobreUnVolcan() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.pasarTurno();
        Jugador jugadorProtoss = algoStar.devolverJugadorActual();
        Casilla casillaConVolcan = jugadorProtoss.hallarCasillaConVolcanInicial();

        boolean intentoExitoso = true;
        try {
            jugadorProtoss.construirEdificio(casillaConVolcan.devolverCoordendas(), new Extractor());
        } catch (TerrenoNoAptoParaConstruirEsteEdificio e) {
            intentoExitoso = false;
        }
        Assertions.assertTrue(intentoExitoso);
    }

}
