package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMoho;
import edu.fiuba.algo3.modelo.terrenos.TerrenoNoAptoParaConstruirEsteEdificio;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVacio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso6 {

    @Test
    public void elRadioDelMohoDelCriaderoInicialEsIgualA5EnElPrimerTurno() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Mapa mapa = algoStar.devolverMapa();
        Jugador jugadorZerg = algoStar.devolverJugadorActual();
        Casilla casillaConElCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaConMoho = mapa.hallarCasillaADistanciaRelativa(casillaConElCriadero, 5, 0);

        boolean intentoExitoso = true;
        try {
            jugadorZerg.construirEdificio(casillaConMoho.devolverCoordendas(), new Criadero()); // Meter al zangano adentro extractor
        } catch (TerrenoNoAptoParaConstruirEsteEdificio e){
            intentoExitoso = false;
        }
        Assertions.assertTrue(intentoExitoso);
    }

    @Test
    public void elRadioDelMohoDelCriaderoInicialNoEsMayorA5EnElPrimerTurno() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Mapa mapa = algoStar.devolverMapa();
        Jugador jugadorZerg = algoStar.devolverJugadorActual();
        Casilla casillaConElCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaConMoho = mapa.hallarCasillaADistanciaRelativa(casillaConElCriadero, 6, 0);

        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorZerg.construirEdificio(casillaConMoho.devolverCoordendas(), new Criadero());
        });
    }

    @Test
    public void mohoSeExpande1CasillaCada2Turnos() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Mapa mapa = algoStar.devolverMapa();
        Jugador jugadorZerg = algoStar.devolverJugadorActual();
        Casilla casillaConElCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaConMoho = mapa.hallarCasillaADistanciaRelativa(casillaConElCriadero, 6, 0);
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorZerg.construirEdificio(casillaConMoho.devolverCoordendas(), new Criadero());
        });
    }
    
}
