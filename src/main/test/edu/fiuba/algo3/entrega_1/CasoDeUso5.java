package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.edificios.protoss.acceso.Acceso;

public class CasoDeUso5 {

    /*

    @Test
    public void seProduceUnErrorAlIntentarConstruirUnEdificioProtossLejosDeUnPilon() {
        AlgoStar algoStar = new AlgoStar();
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
        algoStar.agregarJugador(jugadorZerg);
        algoStar.empezarJuego();

        Mapa mapa = algoStar.devolverMapa();
        Casilla casillaConVolcan = jugadorProtoss.hallarCasillaConVolcanInicial();
        Casilla casillaConTerenoVacio = mapa.hallarCasillaADistanciaRelativa(casillaConVolcan,1,1);

        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorProtoss.construirEdificio(casillaConTerenoVacio, new Acceso());
        });
    }

    @Test
    public void seProduceUnErrorAlIntentarConstruirUnEdificioZergEnUnTerrenoSinMoho() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Mapa mapa = algoStar.devolverMapa();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        Casilla casillaConTerenoVacio = mapa.hallarCasillaADistanciaRelativa(casillaConVolcan,1,1);

        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorZerg.construirEdificio(casillaConTerenoVacio, new ReservaDeReproduccion());
        });
    }

    */
    
}
