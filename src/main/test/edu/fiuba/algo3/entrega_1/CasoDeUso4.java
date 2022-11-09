package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

public class CasoDeUso4 {

    @Test
    public void verificarQueZanganosPuedanEntrarEnExtractor(){
        AlgoStar algoStar = new AlgoStar();
        Casilla casillaDelZangano;
        algoStar.empezarJuego();
        algoStar.generarUnidad(1,1);
        Unidad zanganoDisponible = algoStar.seleccionarUnidadDisponible(0);
        casillaDelZangano = zanganoDisponible.devolverCasilla();
        casillaDelZangano.establecerTerreno(new Volcan()); //para debuggear
        algoStar.construirEdificio(zanganoDisponible, new Extractor());

        algoStar.generarUnidad(1,1);
        algoStar.seleccionarUnidadDisponible(0);

    }
}
