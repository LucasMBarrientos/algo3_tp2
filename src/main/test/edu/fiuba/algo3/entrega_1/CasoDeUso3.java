package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.edificios.zerg.Guarida;
import edu.fiuba.algo3.modelo.edificios.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.protoss.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
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
    public void ReservaDeReproduccionNoSePuedeConstruirSobreTerrenoVolcan() {
        Terreno terrenoVolcan = new TerrenoVolcan(new Coordenada( 1,1));
        Edificio edificio = new ReservaDeReproduccion();

        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            edificio.ocupar(terrenoVolcan);
        });
    }
    @Test
    public void GuaridaNoSePuedeConstruirSobreTerrenoVolcan() {
        Terreno terrenoVolcan = new TerrenoVolcan(new Coordenada( 1,1));
        Edificio edificio = new Guarida();

        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            edificio.ocupar(terrenoVolcan);
        });
    }

    @Test
    public void EspiralNoSePuedeConstruirSobreTerrenoVolcan() {
        Terreno terrenoVolcan = new TerrenoVolcan(new Coordenada( 1,1));
        Edificio edificio = new Espiral();

        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            edificio.ocupar(terrenoVolcan);
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
    @Test
    public void NexoMineralNoSePuedeConstruirSobreTerrenoVolcan() {
        Terreno terrenoVolcan = new TerrenoVolcan(new Coordenada( 1,1));
        Edificio edificio = new NexoMineral();

        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            edificio.ocupar(terrenoVolcan);
        });
    }
    @Test
    public void AccesoNoSePuedeConstruirSobreTerrenoVolcan() {
        Terreno terrenoVolcan = new TerrenoVolcan(new Coordenada( 1,1));
        Edificio edificio = new Acceso();

        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            edificio.ocupar(terrenoVolcan);
        });
    }
    @Test
    public void PuertoEstelarNoSePuedeConstruirSobreTerrenoVolcan() {
        Terreno terrenoVolcan = new TerrenoVolcan(new Coordenada( 1,1));
        Edificio edificio = new PuertoEstelar();

        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            edificio.ocupar(terrenoVolcan);
        });
    }
}
