package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.protoss.asimilador.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.extractor.Extractor;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoBase;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;

public class CasoDeUso3 {
    @Test
    public void extractorNoPuedeConstruirseSobreUnTerrenoNoVolcan() {
      Terreno terreno = new TerrenoBase(new Coordenada( 1,1));
      Extractor extractor = new Extractor();

      Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
        extractor.ocupar(terreno);
      });
    }

    @Test
    public void asimilidarNoPuedeConstruirseSobreUnTerrenoNoVolcan() {
      Terreno terreno = new TerrenoBase(new Coordenada( 1,1));
      Asimilador asimilador = new Asimilador();

      Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
        asimilador.ocupar(terreno);
      });
    }

    @Test
    public void criaderoNoSePuedeConstruirSobreTerrenoVolcan() {
      Terreno terrenoVolcan = new TerrenoVolcan(new Coordenada( 1,1));
      Criadero criadero = new Criadero();

      Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
        criadero.ocupar(terrenoVolcan);
      });
    }

    @Test
    public void pilonNoSePuedeConstruirSobreTerrenoVolcan() {
      Terreno terrenoVolcan = new TerrenoVolcan(new Coordenada( 1,1));
      Pilon pilon = new Pilon();

      Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
        pilon.ocupar(terrenoVolcan);
      });
    }
    
}
