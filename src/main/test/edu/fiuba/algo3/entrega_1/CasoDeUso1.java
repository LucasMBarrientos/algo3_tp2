package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso1 {
    
    @Test
    public void criaderoGeneraTresZanganosYNoPuedeGenerarMasEnEseTurno() {

        Coordenada ubicacion = new Coordenada(2 , 2);
        Criadero criadero = new Criadero(ubicacion);
        for(int i=0; i<5; i++){ criadero.actualizar(); } //paso los turnos para que se termine de construir

        criadero.generarZangano();
        criadero.generarZangano();
        criadero.generarZangano();

        Assertions.assertThrows(NoHayLarvasDisponibles.class, ()->{
            criadero.generarZangano();
        });
    }

    @Test
    public void criaderoGeneraDosZanganosYPuedeGenerarUnoMasEnEseTurno() {
        boolean expected = true;
        Coordenada ubicacion = new Coordenada(2 , 2);
        Criadero criadero = new Criadero(ubicacion);
        for(int i=0; i<5; i++){ criadero.actualizar();
        }

        criadero.generarZangano();
        criadero.generarZangano();

        try{
            criadero.generarZangano();
        } catch (NoHayLarvasDisponibles e){
            expected = false;
        }
        Assertions.assertTrue(expected); //buscar forma mas elegante para hacer esto
    }

    @Test
    public void criaderoGeneraTresZanganosYAlOtroTurnoPuedeGenerarUnoMas() {
        boolean expected = true;
        Coordenada ubicacion = new Coordenada(2 , 2);
        Criadero criadero = new Criadero(ubicacion);
        for(int i=0; i<5; i++){ criadero.actualizar(); }

        criadero.generarZangano();
        criadero.generarZangano();
        criadero.generarZangano();

        criadero.actualizar();

        try{
            criadero.generarZangano();
        } catch (NoHayLarvasDisponibles e){
            expected = false;
        }
        Assertions.assertTrue(expected);
    }

    @Test
    public void criaderoGeneraTresZanganosYEnDosTurnosPuedeGenerarDosMas() {
        boolean expected = true;
        Coordenada ubicacion = new Coordenada(2 , 2);
        Criadero criadero = new Criadero(ubicacion);
        for(int i=0; i<5; i++){ criadero.actualizar(); }

        criadero.generarZangano();
        criadero.generarZangano();
        criadero.generarZangano();

        criadero.actualizar();
        criadero.actualizar();

        try{
            criadero.generarZangano();
            criadero.generarZangano();
        } catch (NoHayLarvasDisponibles e){
            expected = false;
        }
        Assertions.assertTrue(expected);
    }

    @Test
    public void criaderoNoPuedeTenerMasDeTresLarvasQueGenerenZanganos() {
        Coordenada ubicacion = new Coordenada(2 , 2);
        Criadero criadero = new Criadero(ubicacion);
        for(int i=0; i<5; i++){ criadero.actualizar(); }

        criadero.generarZangano();
        criadero.generarZangano();
        criadero.generarZangano();

        for(int i=0; i<10; i++){ //paso varios turnos
            criadero.actualizar();
        }

        Assertions.assertThrows(NoHayLarvasDisponibles.class, ()->{
            for(int i=0; i<4; i++){criadero.generarZangano();} //trato de generar mas de 3 zanganos
        });
    }
/*
    @Test
    public void zanganoSeGeneraCorrectamente() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(1,1);
        Unidad zanganoGenerado = algoStar.seleccionarCasilla(1,1).devolverUnidad();
        Assertions.assertTrue(zanganoGenerado instanceof Zangano);
    }

    @Test
    public void sePasaUnTurnoYSeAgregaUnaLarva() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(1,1);
        int cantidadDeLarvas = ((Criadero) algoStar.seleccionarCasilla(1,1).devolverEdificio()).devolverCantidadDeLarvas();
        Assertions.assertTrue(cantidadDeLarvas == 2);
        algoStar.pasarTurno();
        cantidadDeLarvas = ((Criadero) algoStar.seleccionarCasilla(1,1).devolverEdificio()).devolverCantidadDeLarvas();
        Assertions.assertTrue(cantidadDeLarvas == 3);
    }

    @Test
    public void criaderoRegeneraLarvasCorrectamente() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(1,1);
        algoStar.generarUnidad(1,1);
        algoStar.generarUnidad(1,1);   
        int cantidadDeLarvas = ((Criadero) algoStar.seleccionarCasilla(1,1).devolverEdificio()).devolverCantidadDeLarvas();
        Assertions.assertTrue(cantidadDeLarvas == 0);
        algoStar.pasarTurno();
        cantidadDeLarvas = ((Criadero) algoStar.seleccionarCasilla(1,1).devolverEdificio()).devolverCantidadDeLarvas();
        Assertions.assertTrue(cantidadDeLarvas == 1);
        algoStar.pasarTurno();        
        cantidadDeLarvas = ((Criadero) algoStar.seleccionarCasilla(1,1).devolverEdificio()).devolverCantidadDeLarvas();
        Assertions.assertTrue(cantidadDeLarvas == 2);
        algoStar.pasarTurno();
        cantidadDeLarvas = ((Criadero) algoStar.seleccionarCasilla(1,1).devolverEdificio()).devolverCantidadDeLarvas();
        Assertions.assertTrue(cantidadDeLarvas == 3);
        algoStar.pasarTurno();
        cantidadDeLarvas = ((Criadero) algoStar.seleccionarCasilla(1,1).devolverEdificio()).devolverCantidadDeLarvas();
        Assertions.assertTrue(cantidadDeLarvas == 3);
    }
*/
}
