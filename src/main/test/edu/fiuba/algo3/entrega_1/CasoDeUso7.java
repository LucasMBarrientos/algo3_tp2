package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMineral;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.recursos.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.terrenos.TerrenoNoAptoParaConstruirEsteEdificio;

public class CasoDeUso7 {

    @Test
    public void verificarQueElNexoMineralSeaConstruibleSobreUnMineral() {
        AlgoStar algoStar = new AlgoStar();
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
        algoStar.agregarJugador(jugadorZerg);
        algoStar.empezarJuego();

        Casilla casillaConVolcan = jugadorProtoss.hallarCasillaConVolcanInicial();
        Coordenada coordenadaConTerrenosMinerales = casillaConVolcan.hallarCoordenadasAdyacentes().get(0);

        boolean intentoFueExitoso = true;
        try {
            jugadorProtoss.construirEdificio(coordenadaConTerrenosMinerales, new NexoMineral());
        } catch (TerrenoNoAptoParaConstruirEsteEdificio e) {
            intentoFueExitoso = false;
        }
        Assertions.assertTrue(intentoFueExitoso);
    }

    @Test
    public void verificarQueProtossRecolecteMineralesPorRonda() {
        AlgoStar algoStar = new AlgoStar();
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
        algoStar.agregarJugador(jugadorZerg);
        algoStar.empezarJuego();

        Casilla casillaConVolcan = jugadorProtoss.hallarCasillaConVolcanInicial();
        Coordenada coordenadaConTerrenosMinerales = casillaConVolcan.hallarCoordenadasAdyacentes().get(0);
        jugadorProtoss.construirEdificio(coordenadaConTerrenosMinerales, new NexoMineral());
        for(int i = 0; i < 4; i++) { // Se finaliza la construccion del nexo mineral
            algoStar.pasarTurno();
        }
        for(int i = 0; i < 10; i++) { // Despues de 5 turnos del jugador protoss (10 turnos totales), el jugador deberia tener 200 minerales
            algoStar.pasarTurno();
        }

        Casilla casillaConPilon = jugadorProtoss.hallarCasillaConEdificioInicial();
        List<Coordenada> coordenadasConTerrenosEnergizados = casillaConPilon.hallarCoordenadasAdyacentes();
        jugadorProtoss.construirEdificio(coordenadasConTerrenosEnergizados.get(0), new Pilon());
        boolean intentoExitoso = true;
        try {
            jugadorProtoss.construirEdificio(coordenadasConTerrenosEnergizados.get(1), new Pilon());
        } catch (RecursosInsuficientes e){
            intentoExitoso = false;
        }
        Assertions.assertTrue(intentoExitoso);
    }
        
    public void verificarQueZergPuedaRecolectarMinerales() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();
        
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        Coordenada coordenadaConTerrenosMinerales = casillaConVolcan.hallarCoordenadasAdyacentes().get(0);
        Casilla casillaConCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        /* TODO: Implementar esto
        jugadorZerg.generarUnidad(casillaConCriadero);
        jugadorZerg.moverUnidad(casillaConCriadero, coordenadaConTerrenosMinerales);
        */
        for(int i = 0; i < 10; i++) { // Despues de 5 turnos del jugador zerg (10 turnos totales), el jugador deberia tener 300 minerales
            algoStar.pasarTurno();
        }

        List<Coordenada> coordenadasConMoho = casillaConVolcan.hallarCoordenadasAdyacentes();
        jugadorZerg.construirEdificio(coordenadasConMoho.get(0), new ReservaDeReproduccion());
        boolean intentoExitoso = true;
        try {
            jugadorZerg.construirEdificio(coordenadasConMoho.get(1), new ReservaDeReproduccion());
        } catch (RecursosInsuficientes e){
            intentoExitoso = false;
        }
        Assertions.assertTrue(intentoExitoso);
    }
}
