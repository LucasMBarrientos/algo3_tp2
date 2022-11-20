package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.protoss.acceso.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.asimilador.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.nexoMineral.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.protoss.puertoEstelar.PuertoEstelar;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Jugador;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.AlgoStar;

public class CasoDeUso8 {

    /*

  @Test
  public void protossSoloPuedeConstruirNexoMineralSiTieneMasDe50Minerales() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();
    Mapa mapa = algoStar.devolverMapa();

    algoStar.pasarTurno();// Ahora es el turno de los protoss
    Jugador jugadorProtoss = algoStar.devolverJugadorActual();

    Casilla casillaConVolcan = jugadorProtoss.hallarCasillaConVolcanInicial();
    Casilla casillaConPilon = mapa.hallarCasillaADistanciaRelativa(casillaConVolcan,2,2);
    List<Casilla> casillasConTerrenosEnergizados = mapa.buscarCasillasAdyacentes(casillaConPilon);
    jugadorProtoss.construirEdificio(casillasConTerrenosEnergizados.get(0).devolverCoordendas(), new Pilon());

    List<Casilla> casillasMinerales = jugadorProtoss.hallarCasillasConMineralesIniciales();
    jugadorProtoss.construirEdificio(casillasMinerales.get(0).devolverCoordendas(), new NexoMineral());
    jugadorProtoss.construirEdificio(casillasMinerales.get(1).devolverCoordendas(), new NexoMineral());
    
    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      jugadorProtoss.construirEdificio(casillasMinerales.get(2).devolverCoordendas(), new NexoMineral());
    });
  }

    @Test
    public void jugadorProtossSoloPuedeConstruirPilonSiTieneMasDe100Minerales() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Casilla casillaConPilon = jugadorProtoss.hallarCasillaConEdificioInicial();
        List<Coordenada> coordenadasConTerrenosEnergizados = casillaConPilon.hallarCoordenadasAdyacentes();
        // El jugador protoss deberia tener 200 minerales

        jugadorProtoss.construirEdificio(coordenadasConTerrenosEnergizados.get(0), new Pilon());
        jugadorProtoss.construirEdificio(coordenadasConTerrenosEnergizados.get(1), new Pilon());
        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
             // El jugador no deberia ser capaz de construir un tercer pilon
            jugadorProtoss.construirEdificio(coordenadasConTerrenosEnergizados.get(2), new Pilon());
        });
    }

  /*@Test
  public void jugadorProtossSoloPuedeConstruirPilonSiTieneMasDe100Minerales() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();
    Mapa mapa = algoStar.devolverMapa();
    algoStar.pasarTurno();
    Jugador jugadorProtoss = algoStar.devolverJugadorActual();
    Casilla casillaConVolcan = jugadorProtoss.hallarCasillaConVolcanInicial();
    Casilla casillaConPilon = mapa.hallarCasillaADistanciaRelativa(casillaConVolcan,2,2);
    List<Casilla> casillasConTerrenosEnergizados = mapa.buscarCasillasAdyacentes(casillaConPilon);
    jugadorProtoss.construirEdificio(casillasConTerrenosEnergizados.get(0).devolverCoordendas(), new Pilon());
    jugadorProtoss.construirEdificio(casillasConTerrenosEnergizados.get(1).devolverCoordendas(), new Pilon());
    
    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      jugadorProtoss.construirEdificio(casillasConTerrenosEnergizados.get(2).devolverCoordendas(), new Pilon());
    });
  }

  @Test
  public void protossPuedeConstruirAsimiladorSiTieneMasDe100Minerales() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();
    Mapa mapa = algoStar.devolverMapa();
    algoStar.pasarTurno();
    Jugador jugadorProtoss = algoStar.devolverJugadorActual();
    Casilla casillaConVolcan = jugadorProtoss.hallarCasillaConVolcanInicial();
    Casilla casillaConPilon = mapa.hallarCasillaADistanciaRelativa(casillaConVolcan,2,2);
    List<Casilla> casillasConTerrenosEnergizados = mapa.buscarCasillasAdyacentes(casillaConPilon);
    jugadorProtoss.construirEdificio(casillasConTerrenosEnergizados.get(0).devolverCoordendas(), new Pilon());
    
    jugadorProtoss.construirEdificio(casillaConVolcan.devolverCoordendas(), new Asimilador());
    /*Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      jugadorProtoss.construirEdificio(casillaConVolcan.devolverCoordendas(), new Pilon());
    });
  }

  @Test
  public void protossNoPuedeConstruirAsimiladorSiNoTienesuficientesMinerales() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();
    Mapa mapa = algoStar.devolverMapa();
    algoStar.pasarTurno();
    Jugador jugadorProtoss = algoStar.devolverJugadorActual();
    Casilla casillaConVolcan = jugadorProtoss.hallarCasillaConVolcanInicial();
    Casilla casillaConPilon = mapa.hallarCasillaADistanciaRelativa(casillaConVolcan,2,2);
    List<Casilla> casillasConTerrenosEnergizados = mapa.buscarCasillasAdyacentes(casillaConPilon);
    jugadorProtoss.construirEdificio(casillasConTerrenosEnergizados.get(0).devolverCoordendas(), new Pilon());
    jugadorProtoss.construirEdificio(casillasConTerrenosEnergizados.get(1).devolverCoordendas(), new Pilon());

    
    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      jugadorProtoss.construirEdificio(casillaConVolcan.devolverCoordendas(), new Asimilador());
    });
  }

  @Test
  public void protossSoloPuedeConstruirAccesoSiTieneMasDe150Minerales() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();
    Mapa mapa = algoStar.devolverMapa();
    algoStar.pasarTurno();
    Jugador jugadorProtoss = algoStar.devolverJugadorActual();
    Casilla casillaConVolcan = jugadorProtoss.hallarCasillaConVolcanInicial();
    Casilla casillaConPilon = mapa.hallarCasillaADistanciaRelativa(casillaConVolcan,2,2);
    List<Casilla> casillasConTerrenosEnergizados = mapa.buscarCasillasAdyacentes(casillaConPilon);
    jugadorProtoss.construirEdificio(casillasConTerrenosEnergizados.get(0).devolverCoordendas(), new Acceso());

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      jugadorProtoss.construirEdificio(casillasConTerrenosEnergizados.get(1).devolverCoordendas(), new Acceso());
    });
  }

  @Test
  public void protossSoloPuedeConstruirPuertoEstelarSiTieneMasDe150MineralesY150Gas() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();
    Mapa mapa = algoStar.devolverMapa();
    algoStar.pasarTurno();
    Jugador jugadorProtoss = algoStar.devolverJugadorActual();
    Casilla casillaConVolcan = jugadorProtoss.hallarCasillaConVolcanInicial();
    Casilla casillaConPilon = mapa.hallarCasillaADistanciaRelativa(casillaConVolcan,2,2);
    List<Casilla> casillasConTerrenosEnergizados = mapa.buscarCasillasAdyacentes(casillaConPilon);
    jugadorProtoss.construirEdificio(casillasConTerrenosEnergizados.get(1).devolverCoordendas(), new PuertoEstelar());
    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      jugadorProtoss.construirEdificio(casillasConTerrenosEnergizados.get(1).devolverCoordendas(), new PuertoEstelar());
    });
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
