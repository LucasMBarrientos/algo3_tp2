package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.protoss.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.edificios.zerg.Guarida;
import edu.fiuba.algo3.modelo.edificios.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;

public class CasoDeUso8 {
  /*
  @Test
  public void protossSoloPuedeConstruirNexoMineralSiTieneMasDe50Minerales() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();
    Assertions.assertTrue(algoStar.cantidadMinerales() == 100);
    
    algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoMineral());
    algoStar.seleccionarCasilla(1, 2).establecerTerreno(new TerrenoMineral());
    algoStar.seleccionarCasilla(2, 2).establecerTerreno(new TerrenoMineral());

    algoStar.construirEdificio(2, 1, new NexoMineral());
    Assertions.assertTrue(algoStar.cantidadMinerales() == 50);

    algoStar.construirEdificio(1, 2, new NexoMineral());
    Assertions.assertTrue(algoStar.cantidadMinerales() == 0);
    algoStar.construirEdificio(2, 1, new NexoMineral());
    
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    Assertions.assertTrue(algoStar.seleccionarCasilla(2, 1).devolverEdificio() instanceof NexoMineral);
    Assertions.assertTrue(algoStar.seleccionarCasilla(1, 2).devolverEdificio() instanceof NexoMineral);
    Assertions.assertFalse(algoStar.seleccionarCasilla(2, 2).devolverEdificio() instanceof NexoMineral);
  }

  @Test
  public void protossSoloPuedeConstruirPilonSiTieneMasDe100Minerales() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();
    Assertions.assertTrue(algoStar.cantidadMinerales() == 100);
    
    algoStar.construirEdificio(2, 1, new Pilon());
    Assertions.assertTrue(algoStar.cantidadMinerales() == 0);

    algoStar.construirEdificio(1, 2, new Pilon());
    
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();

    Assertions.assertTrue(algoStar.seleccionarCasilla(2, 1).devolverEdificio() instanceof Pilon);
    Assertions.assertFalse(algoStar.seleccionarCasilla(1, 2).devolverEdificio() instanceof Pilon);
  }

  @Test
  public void protossSoloPuedeConstruirAsimiladorSiTieneMasDe100Minerales() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();

    algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoVolcan());
    algoStar.seleccionarCasilla(1, 2).establecerTerreno(new TerrenoVolcan());
    
    Assertions.assertTrue(algoStar.cantidadMinerales() == 100);
    
    algoStar.construirEdificio(2, 1, new Asimilador());
    
    Assertions.assertTrue(algoStar.cantidadMinerales() == 0);

    algoStar.construirEdificio(1, 2, new Asimilador());
    
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();

    Assertions.assertTrue(algoStar.seleccionarCasilla(2, 1).devolverEdificio() instanceof Asimilador);
    Assertions.assertFalse(algoStar.seleccionarCasilla(1, 2).devolverEdificio() instanceof Asimilador);
  }

  @Test
  public void protossSoloPuedeConstruirAccesoSiTieneMasDe150Minerales() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();

    algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoMineral());
    
    Assertions.assertTrue(algoStar.cantidadMinerales() == 100);
    
    algoStar.construirEdificio(2, 1, new NexoMineral());
    
    Assertions.assertTrue(algoStar.cantidadMinerales() == 50);

    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();

    Assertions.assertTrue(algoStar.seleccionarCasilla(2, 1).devolverEdificio() instanceof NexoMineral);

    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales

    Assertions.assertTrue(algoStar.cantidadMinerales() == 150);
    algoStar.construirEdificio(1, 2, new Acceso());
    Assertions.assertTrue(algoStar.cantidadMinerales() == 0);
    algoStar.construirEdificio(2, 2, new Acceso());
    
    Assertions.assertTrue(algoStar.seleccionarCasilla(1, 2).devolverEdificio() instanceof Acceso);
    Assertions.assertFalse(algoStar.seleccionarCasilla(2, 2).devolverEdificio() instanceof Acceso);
  }

  @Test
  public void protossSoloPuedeConstruirPuertoEstelarSiTieneMasDe150MineralesY150Gas() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();

    algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoMineral());
    algoStar.seleccionarCasilla(1, 2).establecerTerreno(new TerrenoVolcan());

    Assertions.assertTrue(algoStar.cantidadMinerales() == 100);
    
    algoStar.construirEdificio(2, 1, new NexoMineral());
    
    Assertions.assertTrue(algoStar.cantidadMinerales() == 50);

    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();

    Assertions.assertTrue(algoStar.seleccionarCasilla(2, 1).devolverEdificio() instanceof NexoMineral);

    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales

    Assertions.assertTrue(algoStar.cantidadMinerales() == 100);
    
    algoStar.construirEdificio(1, 2, new Asimilador());

    Assertions.assertTrue(algoStar.cantidadMinerales() == 0);

    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales

    Assertions.assertTrue(algoStar.seleccionarCasilla(1, 2).devolverEdificio() instanceof Asimilador);
    
    Assertions.assertTrue(algoStar.cantidadMinerales() == 60);
    Assertions.assertTrue(algoStar.cantidadGas() == 100);

    algoStar.pasarTurno(); //+10 Minerales y +20 gas
    algoStar.pasarTurno(); //+10 Minerales y +20 gas
    algoStar.pasarTurno(); //+10 Minerales y +20 gas
    algoStar.pasarTurno(); //+10 Minerales y +20 gas
    algoStar.pasarTurno(); //+10 Minerales y +20 gas
    algoStar.pasarTurno(); //+10 Minerales y +20 gas
    algoStar.pasarTurno(); //+10 Minerales y +20 gas
    algoStar.pasarTurno(); //+10 Minerales y +20 gas
    algoStar.pasarTurno(); //+10 Minerales y +20 gas

    Assertions.assertTrue(algoStar.cantidadMinerales() == 150);
    Assertions.assertTrue(algoStar.cantidadGas() == 280);

    algoStar.construirEdificio(2, 2, new PuertoEstelar());

    Assertions.assertTrue(algoStar.cantidadMinerales() == 0);
    Assertions.assertTrue(algoStar.cantidadGas() == 130);

    algoStar.construirEdificio(2, 3, new PuertoEstelar());

    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();

    Assertions.assertTrue(algoStar.seleccionarCasilla(2, 2).devolverEdificio() instanceof PuertoEstelar);
    Assertions.assertFalse(algoStar.seleccionarCasilla(2, 3).devolverEdificio() instanceof PuertoEstelar);
  }

  @Test
  public void zergSoloPuedeConstruirCriaderoSiTieneMasDe50Minerales() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();
    Assertions.assertTrue(algoStar.cantidadMinerales() == 100);

    algoStar.generarUnidad(1,1);
    algoStar.moverDerecha(1,1);
    algoStar.construirEdificio(2,1, new Criadero());

    Assertions.assertTrue(algoStar.cantidadMinerales() == 50);

    algoStar.generarUnidad(1,1);
    algoStar.moverArriba(1,1);
    algoStar.construirEdificio(1,2, new Criadero());
    Assertions.assertTrue(algoStar.cantidadMinerales() == 0);

    algoStar.generarUnidad(1,1);
    algoStar.moverIzquierda(1,1);
    algoStar.construirEdificio(0,1, new Criadero());
    
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();

    Assertions.assertTrue(algoStar.seleccionarCasilla(2, 1).devolverEdificio() instanceof Criadero);
    Assertions.assertTrue(algoStar.seleccionarCasilla(1, 2).devolverEdificio() instanceof Criadero);
    Assertions.assertFalse(algoStar.seleccionarCasilla(0, 1).devolverEdificio() instanceof Criadero);
  }

  @Test
  public void zergSoloPuedeConstruirReservadeReproduccionSiTieneMasDe150Minerales() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();
    algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoMineral());

    Assertions.assertTrue(algoStar.cantidadMinerales() == 100);

    algoStar.generarUnidad(1, 1);
    algoStar.moverDerecha(1, 1);

    // PONER A TRABAJAR UN ZANGANO SOBRE UN MINERAL?

    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales

    Assertions.assertTrue(algoStar.cantidadMinerales() == 150);

    algoStar.generarUnidad(1,1);
    algoStar.moverArriba(1,1);
    algoStar.construirEdificio(1,2, new ReservaDeReproduccion());
    Assertions.assertTrue(algoStar.cantidadMinerales() == 0);

    algoStar.generarUnidad(1,1);
    algoStar.moverIzquierda(1,1);
    algoStar.construirEdificio(0,1, new ReservaDeReproduccion());
    
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    
    Assertions.assertTrue(algoStar.seleccionarCasilla(1, 2).devolverEdificio() instanceof ReservaDeReproduccion);
    Assertions.assertFalse(algoStar.seleccionarCasilla(0, 1).devolverEdificio() instanceof ReservaDeReproduccion);
  }

  @Test
  public void zergSoloPuedeConstruirConstruirExtractorSiTieneMasDe100Minerales() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();
    algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoVolcan());
    algoStar.seleccionarCasilla(1, 2).establecerTerreno(new TerrenoVolcan());

    Assertions.assertTrue(algoStar.cantidadMinerales() == 100);

    algoStar.generarUnidad(1, 1);
    algoStar.moverDerecha(1, 1);
    algoStar.construirEdificio(2,1, new Extractor());

    Assertions.assertTrue(algoStar.cantidadMinerales() == 0);

    algoStar.generarUnidad(1,1);
    algoStar.moverArriba(1,1);
    algoStar.construirEdificio(1,2, new Extractor());

    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();

    Assertions.assertTrue(algoStar.seleccionarCasilla(2, 1).devolverEdificio() instanceof Extractor);
    Assertions.assertFalse(algoStar.seleccionarCasilla(1, 2).devolverEdificio() instanceof Extractor);
  }

  @Test
  public void zergSoloPuedeConstruirGuaridaSiTieneMasDe200MineralY100Gas() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();
    algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoMineral());
    algoStar.seleccionarCasilla(1, 2).establecerTerreno(new TerrenoMineral());

    Assertions.assertTrue(algoStar.cantidadMinerales() == 100);
    Assertions.assertTrue(algoStar.cantidadGas() == 100);

    algoStar.generarUnidad(1, 1);
    algoStar.moverDerecha(1, 1);

    // PONER A TRABAJAR UN ZANGANO SOBRE UN MINERAL?

    algoStar.generarUnidad(1, 1);
    algoStar.moverArriba(1, 1);

    // PONER A TRABAJAR UN ZANGANO SOBRE UN MINERAL?

    algoStar.pasarTurno(); //+20 Minerales
    algoStar.pasarTurno(); //+20 Minerales
    algoStar.pasarTurno(); //+20 Minerales
    algoStar.pasarTurno(); //+20 Minerales
    algoStar.pasarTurno(); //+20 Minerales

    Assertions.assertTrue(algoStar.cantidadMinerales() == 200);
    Assertions.assertTrue(algoStar.cantidadGas() == 100);

    algoStar.generarUnidad(1,1);
    algoStar.moverIzquierda(1,1);
    algoStar.construirEdificio(0,1, new Guarida());

    Assertions.assertTrue(algoStar.cantidadMinerales() == 0);
    Assertions.assertTrue(algoStar.cantidadGas() == 0);

    algoStar.generarUnidad(1,1);
    algoStar.moverAbajo(1,1);
    algoStar.construirEdificio(1,0, new Guarida());
    
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    
    Assertions.assertTrue(algoStar.seleccionarCasilla(0, 1).devolverEdificio() instanceof Guarida);
    Assertions.assertFalse(algoStar.seleccionarCasilla(1, 0).devolverEdificio() instanceof Guarida);
  }

  @Test
  public void zergSoloPuedeConstruirEspiralSiTieneMasDe150MineralY100Gas() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();
    algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoMineral());
    algoStar.seleccionarCasilla(1, 2).establecerTerreno(new TerrenoMineral());

    Assertions.assertTrue(algoStar.cantidadMinerales() == 100);
    Assertions.assertTrue(algoStar.cantidadGas() == 100);

    algoStar.generarUnidad(1, 1);
    algoStar.moverDerecha(1, 1);

    // PONER A TRABAJAR UN ZANGANO SOBRE UN MINERAL?

    algoStar.generarUnidad(1, 1);
    algoStar.moverArriba(1, 1);

    // PONER A TRABAJAR UN ZANGANO SOBRE UN MINERAL?

    algoStar.pasarTurno(); //+20 Minerales
    algoStar.pasarTurno(); //+20 Minerales
    algoStar.pasarTurno(); //+20 Minerales

    Assertions.assertTrue(algoStar.cantidadMinerales() == 160);
    Assertions.assertTrue(algoStar.cantidadGas() == 100);

    algoStar.generarUnidad(1,1);
    algoStar.moverIzquierda(1,1);
    algoStar.construirEdificio(0,1, new Espiral());

    Assertions.assertTrue(algoStar.cantidadMinerales() == 10);
    Assertions.assertTrue(algoStar.cantidadGas() == 0);

    algoStar.generarUnidad(1,1);
    algoStar.moverAbajo(1,1);
    algoStar.construirEdificio(1,0, new Espiral());
    
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    
    Assertions.assertTrue(algoStar.seleccionarCasilla(0, 1).devolverEdificio() instanceof Espiral);
    Assertions.assertFalse(algoStar.seleccionarCasilla(1, 0).devolverEdificio() instanceof Espiral);
  }*/
}
