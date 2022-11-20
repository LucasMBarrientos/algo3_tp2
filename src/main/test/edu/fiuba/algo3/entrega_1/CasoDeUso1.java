package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.geometria.direcciones.*;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.excepciones.NoHayLarvasSuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso1 {
    
    @Test
    public void criaderoGeneraTresZanganosYNoPuedeGenerarMasEnEseTurno() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo",50); // El jugador zerg empieza con 250 unidades de minerales y 50 unidades de gas
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Casilla casillaConCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        jugadorZerg.generarUnidad(casillaConCriadero);
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(casillaConCriadero, new Arriba());
        jugadorZerg.generarUnidad(casillaConCriadero);
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(casillaConCriadero, new Derecha());
        jugadorZerg.generarUnidad(casillaConCriadero);
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(casillaConCriadero, new Abajo());
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        Mapa mapa = algoStar.DEBUG_DEVOLVERMAPA();
        mapa.DEBUG_MOSTRARMAPATERRENO();
        mapa.DEBUG_MOSTRARMAPAUNIDADES();

        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            jugadorZerg.generarUnidad(casillaConCriadero);
        });

    }






    /*
	@Test
    public void criaderoGeneraTresZanganosYNoPuedeGenerarMasEnEseTurno() {
        Criadero criadero = new Criadero();
        for (int i = 0; i < 4; i++) { // Se finaliza la construccion del criadero
            criadero.actualizar();
        }
        criadero.generarUnidad(new Zangano());
        criadero.generarUnidad(new Zangano());
        criadero.generarUnidad(new Zangano());
        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            criadero.generarUnidad(new Zangano());
        });
    }
	@Test
    public void criaderoGeneraTresZanganosYTrasUnTurnoDeberiaPoderGenerarHastaUnZanganoMas() {
        Criadero criadero = new Criadero();
        for (int i = 0; i < 4; i++) { // Se finaliza la construccion del criadero
            criadero.actualizar();
        }
        criadero.generarUnidad(new Zangano());
        criadero.generarUnidad(new Zangano());
        criadero.generarUnidad(new Zangano());
        criadero.actualizar(); // Criadero regenera 1 larva mas
        criadero.generarUnidad(new Zangano());
        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            criadero.generarUnidad(new Zangano());
        });
    }
	@Test
    public void unCriaderoNuncaVaATenerMasDe3LarvasALaVez() {
        Criadero criadero = new Criadero();
        for (int i = 0; i < 10; i++) { // Se finaliza la construccion del criadero y se pasan varios turnos intentando generar mas zanganos
            criadero.actualizar();
        }
        criadero.generarUnidad(new Zangano());
        criadero.generarUnidad(new Zangano());
        criadero.generarUnidad(new Zangano());
        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            criadero.generarUnidad(new Zangano());
        });
    }
    */
}
