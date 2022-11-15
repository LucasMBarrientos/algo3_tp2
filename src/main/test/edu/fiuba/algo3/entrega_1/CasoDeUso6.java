package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.terrenos.TerrenoNoAptoParaConstruirEsteEdificio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso6 {

    @Test
    public void elRadioDelMohoDelCriaderoInicialEsIgualA5EnElPrimerTurno() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Mapa mapa = algoStar.devolverMapa();
        Casilla casillaConCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaConMoho = mapa.hallarCasillaADistanciaRelativa(casillaConCriadero,5,0);

        /* TODO: Implementar esto
        jugadorZerg.generarUnidad(casillaConCriadero);
        jugadorZerg.moverUnidad(casillaConCriadero, casillaConMoho);
        */
        boolean intentoExitoso = true;
        try {
            jugadorZerg.construirEdificio(casillaConMoho, new ReservaDeReproduccion());
        } catch (TerrenoNoAptoParaConstruirEsteEdificio e){
            intentoExitoso = false;
        }
        Assertions.assertTrue(intentoExitoso);
    }


    @Test
    public void elRadioDelMohoDelCriaderoInicialNoEsMayorA5EnElPrimerTurno() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Mapa mapa = algoStar.devolverMapa();
        Casilla casillaConCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaSinMoho = mapa.hallarCasillaADistanciaRelativa(casillaConCriadero,6,0);

        /* TODO: Implementar esto
        jugadorZerg.generarUnidad(casillaConCriadero);
        jugadorZerg.moverUnidad(casillaConCriadero, casillaConMoho);
        */
        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorProtoss.construirEdificio(casillaSinMoho, new ReservaDeReproduccion());
        });
    }

    @Test
    public void mohoSeExpande1CasillaCada2Turnos() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Mapa mapa = algoStar.devolverMapa();
        Casilla casillaConCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaSinMohoInicialmente = mapa.hallarCasillaADistanciaRelativa(casillaConCriadero,6,0);
        for(int i = 0; i < 4; i++) { // Despues de 2 turnos del jugador zerg (4 turnos totales), el moho se deberia expandir 1 casilla mas
            algoStar.pasarTurno();
        }

        /* TODO: Implementar esto
        jugadorZerg.generarUnidad(casillaConCriadero);
        jugadorZerg.moverUnidad(casillaConCriadero, casillaConMoho);
        */
        boolean intentoExitoso = true;
        try {
            jugadorZerg.construirEdificio(casillaSinMohoInicialmente, new ReservaDeReproduccion());
        } catch (TerrenoNoAptoParaConstruirEsteEdificio e){
            intentoExitoso = false;
        }
        Assertions.assertTrue(intentoExitoso);
    }
    
}
