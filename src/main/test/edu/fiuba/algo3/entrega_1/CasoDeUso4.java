package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso4 {

    @Test
    public void ExtractorSinZanganoNoGeneraGas() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(1, 1);
        Unidad zanganoDisponible = algoStar.seleccionarCasilla(1, 1).devolverUnidad();

        algoStar.moverDerecha(1, 1);
        algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoVolcan());
        algoStar.construirEdificio(2, 1, new Extractor());

        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        // JUGADOR CON EXTRACTOR SIN ZANGANO NO PRODUCE GAS
        Assertions.assertEquals(100, algoStar.devolverCantidadGas());
    }

    @Test
    public void ZanganoPuedeIngresarAExtractor(){
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(1, 1);
        Unidad zanganoDisponible = algoStar.seleccionarCasilla(1, 1).devolverUnidad();

        algoStar.moverDerecha(1, 1);
        algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoVolcan());
        algoStar.construirEdificio(2, 1, new Extractor());

        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        algoStar.generarUnidad(1, 1);
        algoStar.moverDerecha(1, 1);
        algoStar.ingresarUnidad(2,1);

        Assertions.assertNull(algoStar.seleccionarCasilla(2, 1).devolverUnidad());
    }



    @Test
    public void ExtractorCon1ZanganoGenera10Gas() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(1, 1);
        Unidad zanganoDisponible = algoStar.seleccionarCasilla(1, 1).devolverUnidad();

        algoStar.moverDerecha(1, 1);
        algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoVolcan());
        algoStar.construirEdificio(2, 1, new Extractor());

        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        algoStar.generarUnidad(1, 1);
        algoStar.moverDerecha(1, 1);
        algoStar.ingresarUnidad(2,1);

        algoStar.pasarTurno();
        algoStar.pasarTurno();


        Assertions.assertEquals(110, algoStar.devolverCantidadGas());
    }
/*
    @Test
    public void ExtractorCon2ZanganosGenera20Gas() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(1, 1);
        Ocupante zangano = algoStar.seleccionarCasilla(1, 1).devolverUnidad();

        // FALTA MOVER ZANGANO A UN VOLCAN
        Casilla casillaDelZangano = zangano.devolverCasilla();

        // CONTRUYE UN EXTRACTOR EN UN VOLCAN Y ESPERA 6 TURNOS
        algoStar.construirEdificio(casillaDelZangano, new Extractor());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        Assertions.assertFalse(casillaDelZangano.devolverEdificio() instanceof Extractor);

        // CREAR Y MOVER 2 ZANGANOS Al EXTRACTOR
        algoStar.generarUnidad(1, 1);
        Ocupante zangano1 = algoStar.seleccionarCasilla(1, 1).devolverUnidad();
        algoStar.generarUnidad(1, 1);
        Ocupante zangano2 = algoStar.seleccionarCasilla(1, 1).devolverUnidad();

        algoStar.pasarTurno();


        // JUGADOR CON EXTRACTOR CON 2 ZANGANO GENERA 20 DE GAS
        Assertions.assertTrue(algoStar.cantidadGas() == 20);
    }

    @Test
    public void ExtractorCon3ZanganosGenera30Gas() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(1, 1);
        Ocupante zangano = algoStar.seleccionarCasilla(1, 1).devolverUnidad();

        // FALTA MOVER ZANGANO A UN VOLCAN
        Casilla casillaDelZangano = zangano.devolverCasilla();

        // CONTRUYE UN EXTRACTOR EN UN VOLCAN Y ESPERA 6 TURNOS
        algoStar.construirEdificio(casillaDelZangano, new Extractor());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        Assertions.assertFalse(casillaDelZangano.devolverEdificio() instanceof Extractor);

        // CREAR Y MOVER 3 ZANGANOS Al EXTRACTOR
        algoStar.generarUnidad(1, 1);
        Ocupante zangano1 = algoStar.seleccionarCasilla(1, 1).devolverUnidad();
        // FALTA MOVER ZANGANO A UN EXTRACTOR
        algoStar.generarUnidad(1, 1);
        Ocupante zangano2 = algoStar.seleccionarCasilla(1, 1).devolverUnidad();
        // FALTA MOVER ZANGANO A UN EXTRACTOR
        algoStar.generarUnidad(1, 1);
        Ocupante zangano3 = algoStar.seleccionarCasilla(1, 1).devolverUnidad();
        // FALTA MOVER ZANGANO A UN EXTRACTOR
        algoStar.pasarTurno();


        // JUGADOR CON EXTRACTOR CON 3 ZANGANO GENERA 30 DE GAS
        Assertions.assertTrue(algoStar.cantidadGas() == 30);
    }

    @Test
    public void ExtractorCon3ZanganosNoPuedeAgregarOtro() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(1, 1);
        Ocupante zangano = algoStar.seleccionarCasilla(1, 1).devolverUnidad();

        // FALTA MOVER ZANGANO A UN VOLCAN
        Casilla casillaDelZangano = zangano.devolverCasilla();

        // CONTRUYE UN EXTRACTOR EN UN VOLCAN Y ESPERA 6 TURNOS
        algoStar.construirEdificio(casillaDelZangano, new Extractor());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        Assertions.assertFalse(casillaDelZangano.devolverEdificio() instanceof Extractor);

        // CREAR Y MOVER 4 ZANGANOS Al EXTRACTOR
        algoStar.generarUnidad(1, 1);
        Ocupante zangano1 = algoStar.seleccionarCasilla(1, 1).devolverUnidad();
        // FALTA MOVER ZANGANO A UN EXTRACTOR
        algoStar.generarUnidad(1, 1);
        Ocupante zangano2 = algoStar.seleccionarCasilla(1, 1).devolverUnidad();
        // FALTA MOVER ZANGANO A UN EXTRACTOR
        algoStar.generarUnidad(1, 1);
        Ocupante zangano3 = algoStar.seleccionarCasilla(1, 1).devolverUnidad();
        // FALTA MOVER ZANGANO A UN EXTRACTOR
        algoStar.generarUnidad(1, 1);
        Ocupante zangano4 = algoStar.seleccionarCasilla(1, 1).devolverUnidad();

        //DEBERIA DAR ERROR AL MOVER EL 4 ZANGANO
    }

    @Test
    public void asimiladorGeneraGasUnaVezConstruido() {
        // CUAL ES LA LOGICA PARA CREAR PROTOSS Y SUS EDIFICIOS?
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();

        // CONTRUYE UN ASIMILADOR EN UN VOLCAN Y ESPERA 6 TURNOS
        algoStar.construirEdificio(casillaAConstruir, new Asimilador());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        // ASIMILADOR NO TERMINO CONSTRUCCION, JUGADOR NO TIENE GAS
        Assertions.assertTrue(algoStar.cantidadGas() == 0);

        algoStar.pasarTurno();

        // ASIMILADOR TERMINO SU CONSTRUCCION, JUGADOR AUN NO TIENE GAS
        Assertions.assertFalse(casillaAConstruir.devolverEdificio() instanceof Asimilador);
        Assertions.assertTrue(algoStar.cantidadGas() == 0);

        algoStar.pasarTurno();
        // AL PASAR UN TURNO CON ASIMILADOR CONSTRUIDO, JUGADOR TIENE 20 DE GAS
        Assertions.assertTrue(algoStar.cantidadGas() == 20);
    }*/
}
