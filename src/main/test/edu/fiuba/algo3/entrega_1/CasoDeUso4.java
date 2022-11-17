package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.direcciones.Derecha;
import edu.fiuba.algo3.modelo.edificios.zerg.espiral.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.extractor.Extractor;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.recursos.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso4 {

    @Test
    public void extractorCon0ZanganoGenera0UnidadesDeGas() {
        Extractor extractor = new Extractor(); // Aca podría faltar el terreno
        //Zangano zangano = new Zangano();

        //extractor.ingresarUnidad(zangano);

        GasVespeno gas = extractor.extraerRecursos();

        Assertions.assertThrows(RecursosInsuficientes.class,()->{
            gas.gastar(new GasVespeno(10));
        });

    }

    @Test
    public void extractorCon1ZanganoGenera10UnidadesDeGas() {
        Extractor extractor = new Extractor(); // Aca podría faltar el terreno
        Zangano zangano = new Zangano();

        extractor.ingresarUnidad(zangano);

        GasVespeno gas = extractor.extraerRecursos();

        Assertions.assertThrows(RecursosInsuficientes.class,()->{
            gas.gastar(new GasVespeno(20));
        });
    }

    @Test
    public void extractorCon2ZanganoGenera20UnidadesDeGas() {
        Extractor extractor = new Extractor(); // Aca podría faltar el terreno
        Zangano zangano = new Zangano();
        Zangano zangano2 = new Zangano();

        extractor.ingresarUnidad(zangano);
        extractor.ingresarUnidad(zangano2);

        GasVespeno gas = extractor.extraerRecursos();

        Assertions.assertThrows(RecursosInsuficientes.class,()->{
            gas.gastar(new GasVespeno(30));
        });
    }

    @Test
    public void extractorCon3ZanganoGenera30UnidadesDeGas() {
        Extractor extractor = new Extractor(); // Aca podría faltar el terreno
        Zangano zangano = new Zangano();
        Zangano zangano2 = new Zangano();
        Zangano zangano3 = new Zangano();

        extractor.ingresarUnidad(zangano);
        extractor.ingresarUnidad(zangano2);
        extractor.ingresarUnidad(zangano3);

        GasVespeno gas = extractor.extraerRecursos();

        Assertions.assertThrows(RecursosInsuficientes.class,()->{
            gas.gastar(new GasVespeno(40));
        });
    }

}
