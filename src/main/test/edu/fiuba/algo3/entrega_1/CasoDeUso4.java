package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.protoss.Asimilador;
import edu.fiuba.algo3.modelo.edificios.zerg.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.excepciones.NoHayEspacioDisponible;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso4 {

    @Test
    public void extractorCon0ZanganoGenera0UnidadesDeGas() {
      Terreno terrenoVolcan = new TerrenoVolcan(new Coordenada( 1,2));
      Extractor extractor = new Extractor();
      Inventario inv = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));

      int tiempoDeConstruccion = 6;
      extractor.ocupar(terrenoVolcan);

      for (int i = 0; i < tiempoDeConstruccion; i++) {
          extractor.actualizar(inv);
      }
      
      extractor.extraerRecursos(inv);

      Assertions.assertThrows(RecursosInsuficientes.class, ()->{
          inv.consumirGasVespeno(new GasVespeno(1));
      });
    }

    @Test
    public void extractorCon1ZanganoGenera10UnidadesDeGas() {
      Terreno terrenoVolcan = new TerrenoVolcan(new Coordenada( 1,2));
      Extractor extractor = new Extractor();
      Inventario inv = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));

      int tiempoDeConstruccion = 6;
      extractor.ocupar(terrenoVolcan);

      for (int i = 0; i < tiempoDeConstruccion; i++) {
          extractor.actualizar(inv);
      }

      extractor.ingresarUnidad(new Zangano());
      
      extractor.extraerRecursos(inv);

      inv.consumirGasVespeno(new GasVespeno(10));

      Assertions.assertThrows(RecursosInsuficientes.class, ()->{
          inv.consumirGasVespeno(new GasVespeno(1));
      });
    }

    @Test
    public void extractorCon2ZanganoGenera20UnidadesDeGas() {
      Terreno terrenoVolcan = new TerrenoVolcan(new Coordenada( 1,2));
      Extractor extractor = new Extractor();
      Inventario inv = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));

      int tiempoDeConstruccion = 6;
      extractor.ocupar(terrenoVolcan);

      for (int i = 0; i < tiempoDeConstruccion; i++) {
          extractor.actualizar(inv);
      }

      extractor.ingresarUnidad(new Zangano());
      extractor.ingresarUnidad(new Zangano());

      extractor.extraerRecursos(inv);

      inv.consumirGasVespeno(new GasVespeno(20));

      Assertions.assertThrows(RecursosInsuficientes.class, ()->{
          inv.consumirGasVespeno(new GasVespeno(1));
      });
    }

    @Test
    public void extractorCon3ZanganoGenera30UnidadesDeGas() {
      Terreno terrenoVolcan = new TerrenoVolcan(new Coordenada( 1,2));
      Extractor extractor = new Extractor();
      Inventario inv = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));

      int tiempoDeConstruccion = 6;
      extractor.ocupar(terrenoVolcan);

      for (int i = 0; i < tiempoDeConstruccion; i++) {
          extractor.actualizar(inv);
      }

      extractor.ingresarUnidad(new Zangano());
      extractor.ingresarUnidad(new Zangano());
      extractor.ingresarUnidad(new Zangano());

      extractor.extraerRecursos(inv);

      inv.consumirGasVespeno(new GasVespeno(30));

      Assertions.assertThrows(RecursosInsuficientes.class, ()->{
          inv.consumirGasVespeno(new GasVespeno(1));
      });
    }
    @Test
    public void extractorNopuedeTener4Zanganos() {
        Terreno terrenoVolcan = new TerrenoVolcan(new Coordenada( 1,2));
        Extractor extractor = new Extractor();
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));

        int tiempoDeConstruccion = 6;
        extractor.ocupar(terrenoVolcan);

        for (int i = 0; i < tiempoDeConstruccion; i++) {
            extractor.actualizar(inv);
        }

        extractor.ingresarUnidad(new Zangano());
        extractor.ingresarUnidad(new Zangano());
        extractor.ingresarUnidad(new Zangano());


        Assertions.assertThrows(NoHayEspacioDisponible.class, ()->{
            extractor.ingresarUnidad(new Zangano());
        });
    }
    @Test
    public void asimiladorGenera20UnidadesDeGas() {
      Terreno terrenoVolcan = new TerrenoVolcan(new Coordenada( 1,2));
      Asimilador asimilador = new Asimilador();
      Inventario inv = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));

      int tiempoDeConstruccion = 6;
      asimilador.ocupar(terrenoVolcan);

      for (int i = 0; i < tiempoDeConstruccion; i++) {
        asimilador.actualizar(inv);
      }

      asimilador.extraerRecursos(inv);

      inv.consumirGasVespeno(new GasVespeno(20));

      Assertions.assertThrows(RecursosInsuficientes.class, ()->{
          inv.consumirGasVespeno(new GasVespeno(1));
      });
    }
}
