package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMineral;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.protoss.nexoMineral.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.terrenos.TerrenoNoAptoParaConstruirEsteEdificio;

public class CasoDeUso7 {

    @Test
    public void verificarQueElNexoMineralSeaConstruibleSobreUnMineral() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.pasarTurno();
        Jugador jugadorProtoss = algoStar.devolverJugadorActual();
        Casilla casillaConVolcan = jugadorProtoss.hallarCasillaConVolcanInicial();
        List<Coordenada> coordenadasConTerrenosMinerales = casillaConVolcan.hallarCoordenadasAdyacentes();

        boolean intentoFueExitoso = true;
        try {
            jugadorProtoss.construirEdificio(coordenadasConTerrenosMinerales.get(0), new NexoMineral());
        } catch (TerrenoNoAptoParaConstruirEsteEdificio e) {
            intentoFueExitoso = false;
        }
        Assertions.assertTrue(intentoFueExitoso);
    }

    @Test
    public void verificarQueProtossRecolecteMineralesPorRonda() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.pasarTurno();
        Jugador jugadorProtoss = algoStar.devolverJugadorActual();
        Casilla casillaConVolcan = jugadorProtoss.hallarCasillaConVolcanInicial();
        Coordenada coordenadaDeCasillaConMinerales = casillaConVolcan.hallarCoordenadasAdyacentes().get(0);
        jugadorProtoss.construirEdificio(coordenadaDeCasillaConMinerales, new NexoMineral());
        for (int i = 0; i < 4; i++) {
            algoStar.pasarTurno();
        }
        /* TODO: Implementar esto
        int cantidadDeMineralesOriginalmente = jugadorProtoss.devolverCantidadMinerales();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        int cantidadDeMineralesObtenidos = jugadorProtoss.devolverCantidadMinerales() - cantidadDeMineralesOriginalmente;
        Assertions.assertEquals(10, cantidadDeMineralesObtenidos);
        */
    }
        
    public void verificarQueZergPuedaRecolectarMinerales() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Mapa mapa = algoStar.devolverMapa();
        Jugador jugadorZerg = algoStar.devolverJugadorActual();
        Casilla casillaConElCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        Coordenada coordenadaDeCasillaConMinerales = casillaConVolcan.hallarCoordenadasAdyacentes().get(0);
        /* TODO: Implementar esto
        jugadorZerg.generarUnidad(casillaConElCriadero.devolverCoordendas());
        jugadorZerg.moverUnidad(casillaConElCriadero.devolverCoordendas(), coordenadaDeCasillaConMinerales); // Mover la unidad desde el criadero hasta la casilla con minerales
        
        int cantidadDeMineralesOriginalmente = jugadorZerg.devolverCantidadMinerales();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        int cantidadDeMineralesObtenidos = jugadorZerg.devolverCantidadMinerales() - cantidadDeMineralesOriginalmente;
        Assertions.assertEquals(10, cantidadDeMineralesObtenidos);
        */
    }
}
