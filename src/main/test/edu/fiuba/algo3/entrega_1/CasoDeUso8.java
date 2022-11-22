package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;


import java.util.List;

import edu.fiuba.algo3.modelo.recursos.Mineral;
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

  @Test
  public void noSePuedeConstruirNexoMineralconMenosDe50Minerales() {
    Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(49));
    NexoMineral nexoMineral = new NexoMineral();

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      nexoMineral.consumirRecursosParaConstruccion(inventario);
    });
  }

  @Test
  public void sePuedeConstruirNexoMineralcon50Minerales() {
    Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(60));
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
}
