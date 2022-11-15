package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.extractor.Extractor;
import edu.fiuba.algo3.modelo.edificios.protoss.acceso.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.terrenos.TerrenoNoAptoParaConstruirEsteEdificio;

public class CasoDeUso5 {

    @Test
    public void seProduceUnErrorAlIntentarConstruirUnEdificioProtossLejosDeUnPilon() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Mapa mapa = algoStar.devolverMapa();
        algoStar.pasarTurno();
        Jugador jugadorProtoss = algoStar.devolverJugadorActual();
        Casilla casillaConVolcan = jugadorProtoss.hallarCasillaConVolcanInicial();
        Casilla casillaConTerenoVacio = mapa.hallarCasillaADistanciaRelativa(casillaConVolcan,-1,-1);

        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorProtoss.construirEdificio(casillaConTerenoVacio.devolverCoordendas(), new Acceso());
        });
    }

    @Test
    public void seProduceUnErrorAlIntentarConstruirUnEdificioZergEnUnTerrenoSinMoho() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Mapa mapa = algoStar.devolverMapa();
        Jugador jugadorZerg = algoStar.devolverJugadorActual();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        jugadorZerg.construirEdificio(casillaConVolcan.devolverCoordendas(), new Extractor());
        for (int i = 0; i < 6; i++) { // Se construye un extractor para obtener la cantidad de gas necesaria para construir una Guarida
            algoStar.pasarTurno();
        }
        Casilla casillaConElCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        /* TODO: Implementar esto
        jugadorZerg.generarUnidad(casillaConElCriadero.devolverCoordendas());
        jugadorZerg.moverUnidad(casillaConElCriadero.devolverCoordendas(), casillaConVolcan.devolverCoordenada()); // Mover la unidad desde el criadero hasta la casilla con el extractor
        jugadorZerg.ingresarUnidadAlEdificio(casillaConVolcan.devolverCoordenada()); // Meter al zangano adentro extractor
        for (int i=0; i < 10) { // Se obtiene la cantidad de gas necesaria para construir una Guarida
            algoStar.pasarTurno();
            algoStar.pasarTurno();
        }
        
        Casilla casillaConTerenoVacio = mapa.hallarCasillaADistanciaRelativa(casillaConVolcan,1,1);
        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorZerg.construirEdificio(casillaConTerenoVacio.devolverCoordendas(), new Guarida());
        });
        */
    }
    
}
