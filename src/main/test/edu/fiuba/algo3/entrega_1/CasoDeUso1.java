package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso1 {
    
    @Test
    public void criaderoSeGeneraCorrectamente() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Edificio edificioEnCasilla = algoStar.seleccionarCasilla(1,1).devolverEdificio();
        Assertions.assertTrue(edificioEnCasilla instanceof Criadero);
    }

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

}
