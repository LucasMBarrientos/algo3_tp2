package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMineral;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
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
        /*
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
        /*
        jugadorZerg.generarUnidad(casillaConElCriadero.devolverCoordendas());
        jugadorZerg.moverUnidad(casillaConElCriadero.devolverCoordendas(), coordenadaDeCasillaConMinerales); // Mover la unidad desde el criadero hasta la casilla con minerales
        
        int cantidadDeMineralesOriginalmente = jugadorZerg.devolverCantidadMinerales();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        int cantidadDeMineralesObtenidos = jugadorZerg.devolverCantidadMinerales() - cantidadDeMineralesOriginalmente;
        Assertions.assertEquals(10, cantidadDeMineralesObtenidos);
        */
    }



/*

    @Test
    public void verificarQueProtossPuedaRecolectarMinerales() {
      AlgoStar algoStar = new AlgoStar();
      algoStar.empezarJuego();

      algoStar.pasarTurno();

      algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoMineral());
      algoStar.construirEdificio(2, 1, new NexoMineral());

      algoStar.pasarTurno();
      algoStar.pasarTurno();

      Assertions.assertEquals(150, algoStar.devolverCantidadMinerales());

      algoStar.pasarTurno();
      algoStar.pasarTurno();

      Assertions.assertEquals(160, algoStar.devolverCantidadMinerales());
    }
    
    @Test
    public void verificarQueZergPuedaRecolectarMinerales() {
      AlgoStar algoStar = new AlgoStar();
      algoStar.empezarJuego();
      algoStar.generarUnidad(1, 1);
      algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoMineral());
      algoStar.moverDerecha(1, 1);
      algoStar.pasarTurno();
      // Turno de los protoss
      algoStar.pasarTurno();
      // Turno de los zerg

      // PONER A TRABAJAR UN ZANGANO SOBRE UN MINERAL?

      Assertions.assertEquals(210,algoStar.devolverCantidadMinerales());
      algoStar.pasarTurno();
      algoStar.pasarTurno();
      Assertions.assertEquals(220,algoStar.devolverCantidadMinerales());
    }*/
}
