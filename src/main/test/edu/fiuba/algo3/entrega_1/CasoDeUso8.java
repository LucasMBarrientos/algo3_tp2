package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.recursos.RecursosInsuficientes;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.terrenos.*;

public class CasoDeUso8 {
/*
  @Test
  public void protossSoloPuedeConstruirNexoMineralSiTieneMasDe50Minerales() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();
    Assertions.assertEquals(200, algoStar.devolverCantidadMinerales());

    algoStar.pasarTurno(); // Ahora es el turno de los protoss
    
    algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoMineral());
    algoStar.seleccionarCasilla(1, 2).establecerTerreno(new TerrenoMineral());
    algoStar.seleccionarCasilla(2, 2).establecerTerreno(new TerrenoMineral());

    algoStar.construirEdificio(2, 1, new NexoMineral());
    Assertions.assertEquals(150, algoStar.devolverCantidadMinerales());

    algoStar.construirEdificio(1, 2, new NexoMineral());
    Assertions.assertEquals(100, algoStar.devolverCantidadMinerales());
    algoStar.construirEdificio(2, 1, new NexoMineral());
    
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    Assertions.assertTrue(algoStar.seleccionarCasilla(2, 1).devolverEdificio() instanceof NexoMineral);
    Assertions.assertTrue(algoStar.seleccionarCasilla(1, 2).devolverEdificio() instanceof NexoMineral);
    Assertions.assertFalse(algoStar.seleccionarCasilla(2, 2).devolverEdificio() instanceof NexoMineral);
  }
*/
    @Test
    public void jugadorProtossSoloPuedeConstruirPilonSiTieneMasDe100Minerales() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Mapa mapa = algoStar.devolverMapa();
        algoStar.pasarTurno();
        Jugador jugadorProtoss = algoStar.devolverJugadorActual();
        Casilla casillaConVolcan = jugadorProtoss.hallarVolcanInicialDelJugador();
        Casilla casillaConPilon = mapa.hallarCasillaADistanciaRelativa(casillaConVolcan,-2,-2);

        List<Casilla> casillasConTerrenosEnergizados = mapa.buscarCasillasAdyacentes(casillaConPilon);

        jugadorProtoss.construirEdificio(casillasConTerrenosEnergizados.get(0).devolverCoordendas(), new Pilon());
        jugadorProtoss.construirEdificio(casillasConTerrenosEnergizados.get(1).devolverCoordendas(), new Pilon());
        
        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            jugadorProtoss.construirEdificio(casillasConTerrenosEnergizados.get(2).devolverCoordendas(), new Pilon());
        });
    }

/*
  @Test
  public void protossSoloPuedeConstruirAsimiladorSiTieneMasDe100Minerales() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();
    Assertions.assertEquals(200, algoStar.devolverCantidadMinerales());

    algoStar.pasarTurno();

    algoStar.seleccionarCasilla(9,8).establecerTerreno(new TerrenoVolcan());
    algoStar.construirEdificio(9, 8, new Asimilador());
    Assertions.assertEquals(100, algoStar.devolverCantidadMinerales());

    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();

    Assertions.assertTrue(algoStar.seleccionarCasilla(9, 8).devolverEdificio() instanceof Asimilador);
  }

  @Test
  public void protossSoloPuedeConstruirAccesoSiTieneMasDe150Minerales() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();

    algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoMineral());

    algoStar.pasarTurno();

    Assertions.assertEquals(200, algoStar.devolverCantidadMinerales());
    
    algoStar.construirEdificio(2, 1, new NexoMineral());

    Assertions.assertEquals(150, algoStar.devolverCantidadMinerales());

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

    Assertions.assertEquals(210, algoStar.devolverCantidadMinerales());
    algoStar.construirEdificio(9, 8, new Acceso());
    Assertions.assertEquals(60, algoStar.devolverCantidadMinerales());
    algoStar.construirEdificio(8, 9, new Acceso());

    for (int i = 0; i < 10; i++) {
      algoStar.pasarTurno();
    }

    Assertions.assertTrue(algoStar.seleccionarCasilla(9, 8).devolverEdificio() instanceof Acceso);
    Assertions.assertFalse(algoStar.seleccionarCasilla(8, 9).devolverEdificio() instanceof Acceso);
  }/*

  @Test
  public void protossSoloPuedeConstruirPuertoEstelarSiTieneMasDe150MineralesY150Gas() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();

    algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoMineral());
    algoStar.seleccionarCasilla(1, 2).establecerTerreno(new TerrenoVolcan());

    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 200);
    
    algoStar.construirEdificio(2, 1, new NexoMineral());
    
    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 150);

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

    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 200);
    
    algoStar.construirEdificio(1, 2, new Asimilador());

    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 100);

    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales

    Assertions.assertTrue(algoStar.seleccionarCasilla(1, 2).devolverEdificio() instanceof Asimilador);
    
    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 160);
    Assertions.assertTrue(algoStar.devolverCantidadGas() == 200);

    algoStar.pasarTurno(); //+10 Minerales y +20 gas
    algoStar.pasarTurno(); //+10 Minerales y +20 gas
    algoStar.pasarTurno(); //+10 Minerales y +20 gas
    algoStar.pasarTurno(); //+10 Minerales y +20 gas
    algoStar.pasarTurno(); //+10 Minerales y +20 gas
    algoStar.pasarTurno(); //+10 Minerales y +20 gas
    algoStar.pasarTurno(); //+10 Minerales y +20 gas
    algoStar.pasarTurno(); //+10 Minerales y +20 gas
    algoStar.pasarTurno(); //+10 Minerales y +20 gas

    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 250);
    Assertions.assertTrue(algoStar.devolverCantidadGas() == 380);

    algoStar.construirEdificio(2, 2, new PuertoEstelar());

    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 100);
    Assertions.assertTrue(algoStar.devolverCantidadGas() == 230);

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
    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 200);

    algoStar.generarUnidad(1,1);
    algoStar.moverDerecha(1,1);
    algoStar.construirEdificio(2,1, new Criadero());

    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 150);

    algoStar.generarUnidad(1,1);
    algoStar.moverArriba(1,1);
    algoStar.construirEdificio(1,2, new Criadero());
    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 100);

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

    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 200);

    algoStar.generarUnidad(1, 1);
    algoStar.moverDerecha(1, 1);

    // PONER A TRABAJAR UN ZANGANO SOBRE UN MINERAL?

    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales
    algoStar.pasarTurno(); //+10 Minerales

    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 150);

    algoStar.generarUnidad(1,1);
    algoStar.moverArriba(1,1);
    algoStar.construirEdificio(1,2, new ReservaDeReproduccion());
    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 100);

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

    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 200);

    algoStar.generarUnidad(1, 1);
    algoStar.moverDerecha(1, 1);
    algoStar.construirEdificio(2,1, new Extractor());

    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 100);

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

    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 200);
    Assertions.assertTrue(algoStar.devolverCantidadGas() == 200);

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

    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 300);
    Assertions.assertTrue(algoStar.devolverCantidadGas() == 200);

    algoStar.generarUnidad(1,1);
    algoStar.moverIzquierda(1,1);
    algoStar.construirEdificio(0,1, new Guarida());

    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 100);
    Assertions.assertTrue(algoStar.devolverCantidadGas() == 100);

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

    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 200);
    Assertions.assertTrue(algoStar.devolverCantidadGas() == 200);

    algoStar.generarUnidad(1, 1);
    algoStar.moverDerecha(1, 1);

    // PONER A TRABAJAR UN ZANGANO SOBRE UN MINERAL?

    algoStar.generarUnidad(1, 1);
    algoStar.moverArriba(1, 1);

    // PONER A TRABAJAR UN ZANGANO SOBRE UN MINERAL?

    algoStar.pasarTurno(); //+20 Minerales
    algoStar.pasarTurno(); //+20 Minerales
    algoStar.pasarTurno(); //+20 Minerales

    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 260);
    Assertions.assertTrue(algoStar.devolverCantidadGas() == 200);

    algoStar.generarUnidad(1,1);
    algoStar.moverIzquierda(1,1);
    algoStar.construirEdificio(0,1, new Espiral());

    Assertions.assertTrue(algoStar.devolverCantidadMinerales() == 110);
    Assertions.assertTrue(algoStar.devolverCantidadGas() == 100);

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
