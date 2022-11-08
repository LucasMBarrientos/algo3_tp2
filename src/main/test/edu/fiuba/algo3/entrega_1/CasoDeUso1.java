package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso1 {

    @Test
    public void criaderoSeGeneraCorrectamente() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Ocupante ocupanteDelCasilla = algoStar.seleccionarCasilla(1,2).devolverOcupante();
        Assertions.assertTrue(ocupanteDelCasilla instanceof Criadero);
    }

    @Test
    public void zanganoSeGeneraCorrectamente() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(algoStar.seleccionarCasilla(1,2));
        Ocupante ocupanteDelCasilla = algoStar.seleccionarCasilla(1,3).devolverOcupante();
        Assertions.assertTrue(ocupanteDelCasilla instanceof Zangano);
    }

    @Test
    public void sePasaUnTurnoYSeAgregaUnaLarva() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(algoStar.seleccionarCasilla(1,1));
        int cantidadDeLarvas = ((Criadero) algoStar.seleccionarCasilla(1,1).devolverOcupante()).devolverCantidadDeLarvas();
        Assertions.assertTrue(cantidadDeLarvas == 2);
        algoStar.pasarTurno();
        cantidadDeLarvas = ((Criadero) algoStar.seleccionarCasilla(1,1).devolverOcupante()).devolverCantidadDeLarvas();
        Assertions.assertTrue(cantidadDeLarvas == 3);
    }

    @Test
    public void criaderoRegeneraLarvasCorrectamente() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(algoStar.seleccionarCasilla(1,1));
        algoStar.generarUnidad(algoStar.seleccionarCasilla(1,1));
        algoStar.generarUnidad(algoStar.seleccionarCasilla(1,1));
        int cantidadDeLarvas = ((Criadero) algoStar.seleccionarCasilla(1,1).devolverOcupante()).devolverCantidadDeLarvas();
        Assertions.assertTrue(cantidadDeLarvas == 0);
        algoStar.pasarTurno();
        cantidadDeLarvas = ((Criadero) algoStar.seleccionarCasilla(1,1).devolverOcupante()).devolverCantidadDeLarvas();
        Assertions.assertTrue(cantidadDeLarvas == 1);
        algoStar.pasarTurno();
        cantidadDeLarvas = ((Criadero) algoStar.seleccionarCasilla(1,1).devolverOcupante()).devolverCantidadDeLarvas();
        Assertions.assertTrue(cantidadDeLarvas == 2);
        algoStar.pasarTurno();
        cantidadDeLarvas = ((Criadero) algoStar.seleccionarCasilla(1,1).devolverOcupante()).devolverCantidadDeLarvas();
        Assertions.assertTrue(cantidadDeLarvas == 3);
        algoStar.pasarTurno();
        cantidadDeLarvas = ((Criadero) algoStar.seleccionarCasilla(1,1).devolverOcupante()).devolverCantidadDeLarvas();
        Assertions.assertTrue(cantidadDeLarvas == 3);

    }

}
