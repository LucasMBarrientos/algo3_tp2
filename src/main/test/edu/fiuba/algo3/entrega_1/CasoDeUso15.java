package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.protoss.asimilador.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.nexoMineral.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.zerg.extractor.Extractor;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMineral;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CasoDeUso15 {

    @Test
    public void extractorNoPuedeSeguirExtrayendoGasVespenoUnaVezAgotado(  ) {
      TerrenoVolcan terrenoVolcan = new TerrenoVolcan();
      Extractor extratractor = new Extractor();
      Zangano zangano1 = new Zangano();
      Zangano zangano2 = new Zangano();
      Zangano zangano3 = new Zangano();

      terrenoVolcan.contruirEdificio(extractor);
      extractor.meterZangano(zangano1);
      extractor.meterZangano(zangano2);
      extractor.meterZangano(zangano3);
      
      for(int i = 0; i < 166; i++) { //166 turnos * 30 gas por turno = 4.980
        extractor.extraerRecursos();
      }

      Assertions.assertThrows(VolcanAgotado.class, ()->{
        extractor.extraerRecursos();
      });

    }

    @Test
    public void asimiladorNoPuedeSeguirExtrayendoGasVespenoUnaVezAgotado(  ) {
      TerrenoVolcan terrenoVolcan = new TerrenoVolcan();
      Asimilador asimilador = new Asimilador();

      terrenoVolcan.contruirEdificio(asimilador);
      
      for(int i = 0; i < 250; i++) { //250 turnos * 20 gas por turno = 5000
        asimilador.extraerRecursos();
      }

      Assertions.assertThrows(VolcanAgotado.class, ()->{
        asimilador.extraerRecursos();
      });
    }

    @Test
    public void zanganoNoPuedeSeguirExtrayendoMineralUnaVezAgotado(  ) {
      TerrenoMineral terrenoMineral = new TerrenoMineral();
      Zangano zangano = new Zangano();

      zangano.trabajarTerreno(terrenoMineral);
      
      for(int i = 0; i < 200; i++) { //200 turnos * ¿10 mineral por turno? = 2000
        zangano.extraerRecursos();
      }

      Assertions.assertThrows(MineralAgotado.class, ()->{
        zangano.extraerRecursos();
      });

    }

    @Test
    public void nexoMineralNoPuedeSeguirExtrayendomineralUnaVezAgotado(  ) {
      TerrenoMineral terrenoMineral = new TerrenoMineral();
      NexoMineral nexoMineral = new NexoMineral();

      TerrenoMineral.contruirEdificio(nexoMineral);
      
      for(int i = 0; i < 200; i++) { //200 turnos * ¿10 mineral por turno? = 2000
        nexoMineral.extraerRecursos();
      }

      Assertions.assertThrows(MineralAgotado.class, ()->{
        nexoMineral.extraerRecursos();
      });
    }

}
