package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso4 {

    @Test
    public void extractorSinZanganosNoGeneraGas() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Jugador jugadorZerg = algoStar.devolverJugadorActual();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        jugadorZerg.construirEdificio(casillaConVolcan.devolverCoordendas(), new Extractor());
        for(int i = 0; i < 6; i++) { // Se finaliza la construccion del extractor
            algoStar.pasarTurno();
        }
        /* TODO: Implementar esto
        int cantidadDeGasOriginalmente = jugadorZerg.devolverCantidadGas();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        int cantidadDeGasObtenido = jugadorZerg.devolverCantidadGas() - cantidadDeGasOriginalmente;
        Assertions.assertEquals(0, cantidadDeGasObtenido);
        */
    }

    @Test
    public void extractorCon1ZanganoGenera10UnidadesDeGas() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Jugador jugadorZerg = algoStar.devolverJugadorActual();
        Casilla casillaConElCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        jugadorZerg.construirEdificio(casillaConVolcan.devolverCoordendas(), new Extractor());
        for(int i = 0; i < 6; i++) { // Se finaliza la construccion del extractor
            algoStar.pasarTurno();
        }
        /* TODO: Implementar esto
        jugadorZerg.generarUnidad(casillaConElCriadero.devolverCoordendas());
        jugadorZerg.moverUnidad(casillaConElCriadero.devolverCoordendas(), casillaConVolcan.devolverCoordenada()); // Mover la unidad desde el criadero hasta la casilla con el extractor
        jugadorZerg.ingresarUnidadAlEdificio(casillaConVolcan.devolverCoordenada()); // Meter al zangano adentro extractor
        
        int cantidadDeMineralesOriginalmente = jugadorZerg.devolverCantidadMinerales();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        int cantidadDeMineralesObtenidos = jugadorZerg.devolverCantidadMinerales() - cantidadDeMineralesOriginalmente;
        Assertions.assertEquals(10, cantidadDeMineralesObtenidos);
        */
    }

    @Test
    public void extractorCon2ZanganoGenera20UnidadesDeGas() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Jugador jugadorZerg = algoStar.devolverJugadorActual();
        Casilla casillaConElCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        jugadorZerg.construirEdificio(casillaConVolcan.devolverCoordendas(), new Extractor());
        for(int i = 0; i < 6; i++) { // Se finaliza la construccion del extractor
            algoStar.pasarTurno();
        }
        /* TODO: Implementar esto
        for (int i=0; i < 2; i++) { // Generar 2 zanganos y meterlos al extractor
            jugadorZerg.generarUnidad(casillaConElCriadero.devolverCoordendas());
            jugadorZerg.moverUnidad(casillaConElCriadero.devolverCoordendas(), casillaConVolcan.devolverCoordenada()); // Mover la unidad desde el criadero hasta la casilla con el extractor
            jugadorZerg.ingresarUnidadAlEdificio(casillaConVolcan.devolverCoordenada()); // Meter al zangano adentro extractor
        }

        int cantidadDeMineralesOriginalmente = jugadorZerg.devolverCantidadMinerales();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        int cantidadDeMineralesObtenidos = jugadorZerg.devolverCantidadMinerales() - cantidadDeMineralesOriginalmente;
        Assertions.assertEquals(20, cantidadDeMineralesObtenidos);
        */
    }

    @Test
    public void extractorCon3ZanganoGenera30UnidadesDeGas() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Jugador jugadorZerg = algoStar.devolverJugadorActual();
        Casilla casillaConElCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        jugadorZerg.construirEdificio(casillaConVolcan.devolverCoordendas(), new Extractor());
        for(int i = 0; i < 6; i++) { // Se finaliza la construccion del extractor
            algoStar.pasarTurno();
        }
        /* TODO: Implementar esto
        for (int i=0; i < 3; i++) { // Generar 3 zanganos y meterlos al extractor
            jugadorZerg.generarUnidad(casillaConElCriadero.devolverCoordendas());
            jugadorZerg.moverUnidad(casillaConElCriadero.devolverCoordendas(), casillaConVolcan.devolverCoordenada()); // Mover la unidad desde el criadero hasta la casilla con el extractor
            jugadorZerg.ingresarUnidadAlEdificio(casillaConVolcan.devolverCoordenada()); // Meter al zangano adentro extractor
        }
        
        int cantidadDeMineralesOriginalmente = jugadorZerg.devolverCantidadMinerales();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        int cantidadDeMineralesObtenidos = jugadorZerg.devolverCantidadMinerales() - cantidadDeMineralesOriginalmente;
        Assertions.assertEquals(30, cantidadDeMineralesObtenidos);
        */
    }

    @Test
    public void noSePuedeMeterUnCuartoZanganoAUnExtractor() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Jugador jugadorZerg = algoStar.devolverJugadorActual();
        Casilla casillaConElCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        jugadorZerg.construirEdificio(casillaConVolcan.devolverCoordendas(), new Extractor());
        for(int i = 0; i < 6; i++) { // Se finaliza la construccion del extractor
            algoStar.pasarTurno();
        }
        /* TODO: Implementar esto
        for (int i=0; i < 3; i++) { // Generar 3 zanganos y meterlos al extractor ()
            jugadorZerg.generarUnidad(casillaConElCriadero.devolverCoordendas());
            jugadorZerg.moverUnidad(casillaConElCriadero.devolverCoordendas(), casillaConVolcan.devolverCoordenada()); // Mover la unidad desde el criadero hasta la casilla con el extractor
            jugadorZerg.ingresarUnidadAlEdificio(casillaConVolcan.devolverCoordenada()); // Meter al zangano adentro extractor
            algoStar.pasarTurno();
            algoStar.pasarTurno();
        }
        algoStar.pasarTurno();
        algoStar.pasarTurno();


        jugadorZerg.generarUnidad(casillaConElCriadero.devolverCoordendas());
        jugadorZerg.moverUnidad(casillaConElCriadero.devolverCoordendas(), casillaConVolcan.devolverCoordenada()); // Mover la unidad desde el criadero hasta la casilla con el extractor

        boolean intentoExitoso = true;
        try{
            jugadorZerg.ingresarUnidadAlEdificio(casillaConVolcan.devolverCoordenada()); // Meter al zangano adentro extractor
        } catch (EdificioEstaAlLimiteDeCapacidad e){
            intentoExitoso = false;
        }
        Assertions.assertTrue(intentoExitoso);
        */
    }
}
