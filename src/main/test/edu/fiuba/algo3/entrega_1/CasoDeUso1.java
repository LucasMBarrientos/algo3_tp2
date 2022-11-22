package edu.fiuba.algo3.entrega_1;


import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.excepciones.NoHayLarvasSuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Jugador;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.excepciones.NoHayLarvasSuficientes;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso1 {


	@Test
    public void criaderoGeneraTresZanganosYNoPuedeGenerarMasEnEseTurno() {
/* 
        AlgoStar algoStar = new AlgoStar();
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        algoStar.empezarJuego();

        Mapa mapa = algoStar.DEBUG_DEVOLVERMAPA();
        mapa.DEBUG_MOSTRARMAPATERRENO();
*/
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(100));
        
        Criadero criadero = new Criadero();
        for (int i = 0; i < 4; i++) { // Se finaliza la construccion del criadero
            criadero.actualizar(inv);
        }
        
        inv.agregarEdificio(criadero);
        
        criadero.generarUnidad(new Zangano(),inv);
        criadero.generarUnidad(new Zangano(),inv);
        criadero.generarUnidad(new Zangano(),inv);
        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            criadero.generarUnidad(new Zangano(),inv);
        });
    }
	@Test
    public void criaderoGeneraTresZanganosYTrasUnTurnoDeberiaPoderGenerarHastaUnZanganoMas() {
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(100));
        Criadero criadero = new Criadero();
        for (int i = 0; i < 4; i++) { // Se finaliza la construccion del criadero
            criadero.actualizar(inv);
        }
        inv.agregarEdificio(criadero);
        criadero.generarUnidad(new Zangano(),inv);
        criadero.generarUnidad(new Zangano(),inv);
        criadero.generarUnidad(new Zangano(),inv);
        criadero.actualizar(inv); // Criadero regenera 1 larva mas
        criadero.generarUnidad(new Zangano(),inv);
        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            criadero.generarUnidad(new Zangano(),inv);
        });
    }
	@Test
    public void unCriaderoNuncaVaATenerMasDe3LarvasALaVez() {
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(100));
        Criadero criadero = new Criadero();
        for (int i = 0; i < 10; i++) { // Se finaliza la construccion del criadero y se pasan varios turnos intentando generar mas zanganos
            criadero.actualizar(inv);
        }
        inv.agregarEdificio(criadero);
        criadero.generarUnidad(new Zangano(),inv);
        criadero.generarUnidad(new Zangano(),inv);
        criadero.generarUnidad(new Zangano(),inv);
        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            criadero.generarUnidad(new Zangano(),inv);
        });
    }
}
