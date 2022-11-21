package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.protoss.asimilador.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.nexoMineral.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.zerg.extractor.Extractor;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMineral;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CasoDeUso15 {

    @Test
    public void extractorNoPuedeSeguirExtrayendoGasVespenoUnaVezAgotado(  ) {

        Inventario inv =  new Inventario(new GasVespeno(0), new Mineral(0));
        TerrenoVolcan terrenoVolcan = new TerrenoVolcan(new Coordenada(1,1));
        Extractor extractor = new Extractor();
        Zangano zangano1 = new Zangano();
        Zangano zangano2 = new Zangano();
        Zangano zangano3 = new Zangano();

        extractor.ocupar(terrenoVolcan);

        for (int i = 0; i < 10; i++) {
            extractor.actualizar();
        }
        extractor.ingresarUnidad(zangano1);
        extractor.ingresarUnidad(zangano2);
        extractor.ingresarUnidad(zangano3);

        for(int i = 0; i < 166; i++) { //166 turnos * 30 gas por turno = 4.980
            extractor.recolectarRecursos(inv);
        }

        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            extractor.recolectarRecursos(inv);
        });
    }

    @Test
    public void asimiladorNoPuedeSeguirExtrayendoGasVespenoUnaVezAgotado(  ) {
        Inventario inv =  new Inventario(new GasVespeno(0), new Mineral(0));
        TerrenoVolcan terrenoVolcan = new TerrenoVolcan(new Coordenada(1,1));
        Asimilador asimilador = new Asimilador();
        asimilador.ocupar(terrenoVolcan);

        for (int i = 0; i < 10; i++) {
            asimilador.actualizar();
        }

        for(int i = 0; i < 250; i++) { //166 turnos * 30 gas por turno = 4.980
            asimilador.recolectarRecursos(inv);
        }

        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            asimilador.recolectarRecursos(inv);
        });
    }

    @Test
    public void zanganoNoPuedeSeguirExtrayendoMineralUnaVezAgotado(  ) {

        Inventario inv =  new Inventario(new GasVespeno(0), new Mineral(0));
        TerrenoMineral terrenoMineral = new TerrenoMineral(new Coordenada(1,1));
        Zangano zangano = new Zangano();

        zangano.ocupar(terrenoMineral);

        for(int i = 0; i < 200; i++) { //200 turnos * ¿10 mineral por turno? = 2000
            zangano.recolectarRecursos(terrenoMineral,inv);
        }

        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            zangano.recolectarRecursos(terrenoMineral,inv);
        });

    }

    @Test
    public void nexoMineralNoPuedeSeguirExtrayendomineralUnaVezAgotado(  ) {
        Inventario inv =  new Inventario(new GasVespeno(0), new Mineral(0));
        TerrenoMineral terrenoMineral = new TerrenoMineral(new Coordenada(1,1));
        NexoMineral nexoMineral = new NexoMineral();

        nexoMineral.ocupar(terrenoMineral);

        for (int i = 0; i < 10; i++) {
            nexoMineral.actualizar();
        }

        for(int i = 0; i < 200; i++) { //200 turnos * ¿10 mineral por turno? = 2000
            nexoMineral.recolectarRecursos(inv);
        }

        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            nexoMineral.recolectarRecursos(inv);
        });
    }

}
