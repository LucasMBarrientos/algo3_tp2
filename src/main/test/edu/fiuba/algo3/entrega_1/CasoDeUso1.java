package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso1 {
    @Test
    public void criaderoSeGeneraCorrectamente(){
        AlgoStar a = new AlgoStar();
        a.empezarJuego();
        Ocupante o = a.seleccionarCasillero(a.devolverCasilla(1,2));

        Assertions.assertTrue(o instanceof Criadero);

    }


    @Test
    public void zanganoSeGeneraCorrectamente(){
        AlgoStar a = new AlgoStar();
        a.empezarJuego();
        a.generarUnidad(a.devolverCasilla(1,2));
        Ocupante o = a.seleccionarCasillero(a.devolverCasilla(1,3));

        Assertions.assertTrue(o instanceof Zangano);

    }


    @Test
    public void sePasaUnTurnoYSeAgregaUnaLarva(){
        AlgoStar a = new AlgoStar();
        a.empezarJuego();
        a.generarUnidad(a.devolverCasilla(1,1));
        a.pasarTurno();
        //a.seleccionarCasillero(a.devolverCasilla(1,1)).larvasDisponibles();


    }

    @Test
    public void criaderoRegeneraLarvasCorrectamente1(){

    }
}
