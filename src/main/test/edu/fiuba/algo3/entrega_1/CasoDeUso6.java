package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMoho;
import edu.fiuba.algo3.modelo.terrenos.TerrenoNoAptoParaConstruirEsteEdificio;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVacio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.edificios.zerg.Guarida;

public class CasoDeUso6 {

    @Test
    public void elRadioDelMohoDelCriaderoInicialEsIgualA5EnElPrimerTurno() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Mapa mapa = algoStar.devolverMapa();
        Jugador jugadorZerg = algoStar.devolverJugadorActual();
        Casilla casillaConElCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        jugadorZerg.construirEdificio(casillaConVolcan.devolverCoordendas(), new Extractor());
        for (int i = 0; i < 6; i++) { // Se construye un extractor para obtener la cantidad de gas necesaria para construir una Guarida
            algoStar.pasarTurno();
        }
        /* TODO: Implementar esto
        jugadorZerg.generarUnidad(casillaConElCriadero.devolverCoordendas());
        jugadorZerg.moverUnidad(casillaConElCriadero.devolverCoordendas(), casillaConVolcan.devolverCoordenada()); // Mover la unidad desde el criadero hasta la casilla con el extractor
        jugadorZerg.ingresarUnidadAlEdificio(casillaConVolcan.devolverCoordenada()); // Meter al zangano adentro extractor
        */
        for (int i=0; i < 10; i++) { // Se obtiene la cantidad de gas necesaria para construir una Guarida
            algoStar.pasarTurno();
            algoStar.pasarTurno();
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
            jugadorZerg.construirEdificio(casillaConMoho, new Criadero());
        });
    }

    @Test
    public void mohoSeExpande1CasillaCada2Turnos() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Mapa mapa = algoStar.devolverMapa();
        Jugador jugadorZerg = algoStar.devolverJugadorActual();
        Casilla casillaConElCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        jugadorZerg.construirEdificio(casillaConVolcan.devolverCoordendas(), new Extractor());
        for (int i = 0; i < 6; i++) { // Se construye un extractor para obtener la cantidad de gas necesaria para construir una Guarida
            algoStar.pasarTurno();
        }
        /* TODO: Implementar esto
        jugadorZerg.generarUnidad(casillaConElCriadero.devolverCoordendas());
        jugadorZerg.moverUnidad(casillaConElCriadero.devolverCoordendas(), casillaConVolcan.devolverCoordenada()); // Mover la unidad desde el criadero hasta la casilla con el extractor
        jugadorZerg.ingresarUnidadAlEdificio(casillaConVolcan.devolverCoordenada()); // Meter al zangano adentro extractor
        */
        for (int i=0; i < 10; i++) { // Se obtiene la cantidad de gas necesaria para construir una Guarida
            algoStar.pasarTurno();
            algoStar.pasarTurno();
        }

        Casilla casillaConMoho = mapa.hallarCasillaADistanciaRelativa(casillaConElCriadero, 11, 0);
        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorZerg.construirEdificio(casillaConMoho, new Guarida());
        });
    }
    
}
