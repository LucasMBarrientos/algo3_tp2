package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.protoss.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMineral;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;


public class CasoDeUso15 {

    @Test
    public void extractorNoPuedeSeguirExtrayendoGasVespenoUnaVezAgotado(  ) {

        Inventario inv =  new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));
        TerrenoVolcan terrenoVolcan = new TerrenoVolcan(new Coordenada(1,1));
        Extractor extractor = new Extractor();
        Zangano zangano1 = new Zangano();
        Zangano zangano2 = new Zangano();
        Zangano zangano3 = new Zangano();

        extractor.ocupar(terrenoVolcan);

        for (int i = 0; i < 10; i++) {
            extractor.actualizar(inv);
        }
        extractor.ingresarUnidad(zangano1);
        extractor.ingresarUnidad(zangano2);
        extractor.ingresarUnidad(zangano3);

        for(int i = 0; i < 166; i++) { //166 turnos * 30 gas por turno = 4.980
            extractor.extraerRecursos(inv);
        }

        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            extractor.extraerRecursos(inv);
        });
    }

    @Test
    public void asimiladorNoPuedeSeguirExtrayendoGasVespenoUnaVezAgotado(  ) {
        Inventario inv =  new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));
        TerrenoVolcan terrenoVolcan = new TerrenoVolcan(new Coordenada(1,1));
        Asimilador asimilador = new Asimilador();
        asimilador.ocupar(terrenoVolcan);

        for (int i = 0; i < 6; i++) {
            asimilador.actualizar(inv);
        }

        for(int i = 0; i < 250; i++) { //250 turnos * 20 gas por turno = 4.980
            asimilador.extraerRecursos(inv);
        }

        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            asimilador.extraerRecursos(inv);
        });
    }

    @Test
    public void zanganoNoPuedeSeguirExtrayendoMineralUnaVezAgotado(  ) {

        Inventario inv =  new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));
        TerrenoMineral terrenoMineral = new TerrenoMineral(new Coordenada(1,1));
        Zangano zangano = new Zangano();

        zangano.ocupar(terrenoMineral);

        for(int i = 0; i < 200; i++) { //200 turnos * ¿10 mineral por turno? = 2000
            zangano.extraerRecursos(inv);
        }

        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            zangano.extraerRecursos(inv);
        });

    }

    @Test
    public void nexoMineralNoPuedeSeguirExtrayendomineralUnaVezAgotado(  ) {
        Inventario inv =  new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));
        TerrenoMineral terrenoMineral = new TerrenoMineral(new Coordenada(1,1));
        NexoMineral nexoMineral = new NexoMineral();

        nexoMineral.ocupar(terrenoMineral);

        for (int i = 0; i < 4; i++) {
            nexoMineral.actualizar(inv);
        }

        for(int i = 0; i < 200; i++) { //200 turnos * ¿10 mineral por turno? = 2000
            nexoMineral.extraerRecursos(inv);
        }

        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            nexoMineral.extraerRecursos(inv);
        });
    }
}
