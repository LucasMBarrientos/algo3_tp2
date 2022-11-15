package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.edificios.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.recursos.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso4 {

    @Test
    public void extractorSinZanganosNoGeneraGas() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Casilla casillaConCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        /* TODO: Implementar esto
        jugadorZerg.generarUnidad(casillaConCriadero);
        jugadorZerg.moverUnidad(casillaConCriadero, casillaConVolcan);
        */
        jugadorZerg.construirEdificio(casillaConVolcan.devolverCoordendas(), new Extractor());
        for(int i = 0; i < 6; i++) { // Se finaliza la construccion del extractor
            algoStar.pasarTurno();
        }
        for(int i = 0; i < 10; i++) { // Se da un par de turnos para intentar conseguir recursos suficientes para construir una reserva de reproduccion
            algoStar.pasarTurno();
        }

        Mapa mapa = algoStar.devolverMapa();
        Casilla casillaConMoho = mapa.hallarCasillaADistanciaRelativa(casillaConCriadero,1,0);
        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            jugadorZerg.construirEdificio(casillaConMoho, new ReservaDeReproduccion());
        });
    }

    @Test
    public void extractorCon1ZanganoGenera10UnidadesDeGas() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Casilla casillaConCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        /* TODO: Implementar esto
        jugadorZerg.generarUnidad(casillaConCriadero);
        jugadorZerg.moverUnidad(casillaConCriadero, casillaConVolcan);
        */
        jugadorZerg.construirEdificio(casillaConVolcan.devolverCoordendas(), new Extractor());
        for(int i = 0; i < 6; i++) { // Se finaliza la construccion del extractor
            algoStar.pasarTurno();
        }
        for(int i = 0; i < 10; i++) { // Se da un par de turnos para intentar conseguir recursos suficientes para construir una reserva de reproduccion
            algoStar.pasarTurno();
        }
        /* TODO: Implementar esto
        jugadorZerg.generarUnidad(casillaConCriadero.devolverCoordendas());
        jugadorZerg.moverUnidad(casillaConCriadero.devolverCoordendas(), casillaConVolcan.devolverCoordenada()); // Mover la unidad desde el criadero hasta la casilla con el extractor
        jugadorZerg.ingresarUnidadAlEdificio(casillaConVolcan.devolverCoordenada()); // Meter al zangano adentro extractor
        */
        for(int i = 0; i < 10; i++) { // Despues de 5 rondas (10 turnos), el jugador zerg deberia tener 150 minerales
            algoStar.pasarTurno();
        }

        Mapa mapa = algoStar.devolverMapa();
        Casilla casillaConMoho = mapa.hallarCasillaADistanciaRelativa(casillaConCriadero,1,0);
        boolean intentoExitoso = true;
        try {
            jugadorZerg.construirEdificio(casillaConMoho, new Criadero());
        } catch (RecursosInsuficientes e){
            intentoExitoso = false;
        }
        Assertions.assertTrue(intentoExitoso);
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
        */
        for(int i = 0; i < 3; i++) { // Despues de 3 turnos deberia tener 60 recursos
            algoStar.pasarTurno();
        }

        Mapa mapa = algoStar.devolverMapa();
        Casilla casillaConMoho = mapa.hallarCasillaADistanciaRelativa(casillaConElCriadero, 1, 0);
        boolean intentoExitoso = true;
        try {
            jugadorZerg.construirEdificio(casillaConMoho.devolverCoordendas(), new Criadero());
        } catch (RecursosInsuficientes e){
            intentoExitoso = false;
        }
        Assertions.assertTrue(intentoExitoso);
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
        */
        for(int i = 0; i < 3; i++) { // Despues de 2 turnos deberia tener 60 recursos
            algoStar.pasarTurno();
        }

        Mapa mapa = algoStar.devolverMapa();
        Casilla casillaConMoho = mapa.hallarCasillaADistanciaRelativa(casillaConElCriadero, 1, 0);
        boolean intentoExitoso = true;
        try {
            jugadorZerg.construirEdificio(casillaConMoho.devolverCoordendas(), new Criadero());
        } catch (RecursosInsuficientes e){
            intentoExitoso = false;
        }
        Assertions.assertTrue(intentoExitoso);
    }

}
