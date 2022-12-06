package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.edificios.zerg.Guarida;
import edu.fiuba.algo3.modelo.edificios.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;


import java.util.List;

import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.protoss.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Jugador;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.AlgoStar;

public class CasoDeUso8 {

  @Test
  public void noSePuedeConstruirNexoMineralconMenosDe50Minerales() {
    Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(49), new Suministro(200));
    NexoMineral nexoMineral = new NexoMineral();

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      nexoMineral.consumirRecursosParaConstruccion(inventario);
    });
  }

  @Test
  public void sePuedeConstruirNexoMineralcon50Minerales() {
    Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(50), new Suministro(200));
    NexoMineral nexoMineral = new NexoMineral();
    nexoMineral.consumirRecursosParaConstruccion(inventario);

    for(int i=0; i< 4; i++ ){
      nexoMineral.actualizar(inventario); //paso los turnos para terminar de construir el nexo
    }

    NexoMineral nexoMineral2 = new NexoMineral();

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      nexoMineral2.consumirRecursosParaConstruccion(inventario);
    });
  }
  @Test
  public void noSePuedeConstruirPilonconMenosDe100Minerales() {
    Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(99), new Suministro(200));
    Edificio edificio = new Pilon();

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      edificio.consumirRecursosParaConstruccion(inventario);
    });
  }

  @Test
  public void sePuedeConstruirPiloncon100Minerales() {
    Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(100), new Suministro(200));
    Edificio edificio = new Pilon();
    edificio.consumirRecursosParaConstruccion(inventario);

    for(int i=0; i< 4; i++ ){
      edificio.actualizar(inventario); //paso los turnos para terminar de construir el nexo
    }

    Edificio edificioNuevo = new Pilon();

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      edificioNuevo.consumirRecursosParaConstruccion(inventario);
    });
  }
  @Test
  public void noSePuedeConstruirAsimiladorconMenosDe100Minerales() {
    Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(99), new Suministro(200));
    Edificio edificio = new Asimilador();

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      edificio.consumirRecursosParaConstruccion(inventario);
    });
  }

  @Test
  public void sePuedeConstruirAsimiladorcon100Minerales() {
    Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(100), new Suministro(200));
    Edificio edificio = new Asimilador();
    edificio.consumirRecursosParaConstruccion(inventario);

    for(int i=0; i< 4; i++ ){
      edificio.actualizar(inventario); //paso los turnos para terminar de construir el nexo
    }

    Edificio edificioNuevo = new Asimilador();

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      edificioNuevo.consumirRecursosParaConstruccion(inventario);
    });
  }
  @Test
  public void noSePuedeConstruirAccesoconMenosDe150Minerales() {
    Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(149), new Suministro(200));
    Edificio edificio = new Acceso();

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      edificio.consumirRecursosParaConstruccion(inventario);
    });
  }

  @Test
  public void sePuedeConstruirAccesocon150Minerales() {
    Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(150), new Suministro(200));
    Edificio edificio = new Acceso();
    edificio.consumirRecursosParaConstruccion(inventario);

    for(int i=0; i< 4; i++ ){
      edificio.actualizar(inventario); //paso los turnos para terminar de construir el nexo
    }

    Edificio edificioNuevo = new Acceso();

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      edificioNuevo.consumirRecursosParaConstruccion(inventario);
    });
  }
  @Test
  public void noSePuedeConstruirGuaridaconMenosDe150MineralesY150GasVespeno() {
    Inventario inventario = new Inventario(new GasVespeno(100), new Mineral(149), new Suministro(200));
    Edificio edificio = new PuertoEstelar();

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      edificio.consumirRecursosParaConstruccion(inventario);
    });
  }

  @Test
  public void sePuedeConstruirGuaridacon150MineralesY150GasVespeno() {
    Inventario inventario = new Inventario(new GasVespeno(150), new Mineral(150), new Suministro(200));
    Edificio edificio = new PuertoEstelar();
    edificio.consumirRecursosParaConstruccion(inventario);

    for (int i = 0; i < 4; i++) {
      edificio.actualizar(inventario); //paso los turnos para terminar de construir el nexo
    }

    Edificio edificioNuevo = new PuertoEstelar();

    Assertions.assertThrows(RecursosInsuficientes.class, () -> {
      edificioNuevo.consumirRecursosParaConstruccion(inventario);
    });
  }
  @Test
  public void noSePuedeConstruirCriaderoconMenosDe200Minerales() {
    Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(199), new Suministro(200));
    Edificio edificio = new Criadero();

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      edificio.consumirRecursosParaConstruccion(inventario);
    });
  }

  @Test
  public void sePuedeConstruirCriaderocon200Minerales() {
    Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(200), new Suministro(200));
    Edificio edificio = new Criadero();
    edificio.consumirRecursosParaConstruccion(inventario);

    for(int i=0; i< 4; i++ ){
      edificio.actualizar(inventario); //paso los turnos para terminar de construir el nexo
    }

    Edificio edificioNuevo = new Criadero();

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      edificioNuevo.consumirRecursosParaConstruccion(inventario);
    });
  }
  @Test
  public void noSePuedeConstruirExtractorconMenosDe100Minerales() {
    Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(99), new Suministro(200));
    Edificio edificio = new Extractor();

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      edificio.consumirRecursosParaConstruccion(inventario);
    });
  }

  @Test
  public void sePuedeConstruirExtractorcon100Minerales() {
    Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(100), new Suministro(200));
    Edificio edificio = new Extractor();
    edificio.consumirRecursosParaConstruccion(inventario);

    for(int i=0; i< 4; i++ ){
      edificio.actualizar(inventario); //paso los turnos para terminar de construir el nexo
    }

    Edificio edificioNuevo = new Extractor();

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      edificioNuevo.consumirRecursosParaConstruccion(inventario);
    });
  }
  @Test
  public void noSePuedeConstruirReservaDeReproduccionconMenosDe150Minerales() {
    Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(149), new Suministro(200));
    Edificio edificio = new ReservaDeReproduccion();

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      edificio.consumirRecursosParaConstruccion(inventario);
    });
  }

  @Test
  public void sePuedeConstruirReservaDeReproduccioncon150Minerales() {
    Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(150), new Suministro(200));
    Edificio edificio = new ReservaDeReproduccion();
    edificio.consumirRecursosParaConstruccion(inventario);

    for(int i=0; i< 4; i++ ){
      edificio.actualizar(inventario); //paso los turnos para terminar de construir el nexo
    }

    Edificio edificioNuevo = new ReservaDeReproduccion();

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      edificioNuevo.consumirRecursosParaConstruccion(inventario);
    });
  }
  @Test
  public void noSePuedeConstruirEspiralconMenosDe150MineralesY100GasVespeno() {
    Inventario inventario = new Inventario(new GasVespeno(100), new Mineral(149), new Suministro(200));
    Edificio edificio = new Espiral();

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      edificio.consumirRecursosParaConstruccion(inventario);
    });
  }

  @Test
  public void sePuedeConstruirEspiralcon150MineralesY100GasVespeno() {
    Inventario inventario = new Inventario(new GasVespeno(100), new Mineral(150), new Suministro(200));
    Edificio edificio = new Espiral();
    edificio.consumirRecursosParaConstruccion(inventario);

    for(int i=0; i< 4; i++ ){
      edificio.actualizar(inventario); //paso los turnos para terminar de construir el nexo
    }

    Edificio edificioNuevo = new Espiral();

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      edificioNuevo.consumirRecursosParaConstruccion(inventario);
    });
  }

  @Test
  public void noSePuedeConstruirGuaridaconMenosDe150MineralesY100GasVespeno() {
    Inventario inventario = new Inventario(new GasVespeno(100), new Mineral(199), new Suministro(200));
    Edificio edificio = new Guarida();

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      edificio.consumirRecursosParaConstruccion(inventario);
    });
  }

  @Test
  public void sePuedeConstruirGuaridacon150MineralesY100GasVespeno() {
    Inventario inventario = new Inventario(new GasVespeno(100), new Mineral(200), new Suministro(200));
    Edificio edificio = new Guarida();
    edificio.consumirRecursosParaConstruccion(inventario);

    for(int i=0; i< 4; i++ ){
      edificio.actualizar(inventario); //paso los turnos para terminar de construir el nexo
    }

    Edificio edificioNuevo = new Guarida();

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      edificioNuevo.consumirRecursosParaConstruccion(inventario);
    });
  }




}

