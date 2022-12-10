package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.excepciones.NoHayLarvasSuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso1 {

	@Test
    public void criaderoGeneraTresZanganosYNoPuedeGenerarMasEnEseTurno() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 0, 500,200);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        // Se construye un criadero
        jugadorZerg.construirEdificio(new Coordenada(1,1), new Criadero());
        for (int i = 0; i < 4; i++) {
            algoStar.pasarTurno();
        }
        
        jugadorZerg.generarUnidad(new Coordenada(1,1), new Zangano());
        jugadorZerg.generarUnidad(new Coordenada(1,1), new Zangano());
        jugadorZerg.generarUnidad(new Coordenada(1,1), new Zangano());

        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            jugadorZerg.generarUnidad(new Coordenada(1,1), new Zangano());
        });
    }

	@Test
    public void criaderoGeneraTresZanganosYTrasUnTurnoDeberiaPoderGenerarHastaUnZanganoMas() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 0, 500,200);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        // Se construye un criadero
        jugadorZerg.construirEdificio(new Coordenada(1,1), new Criadero());
        for (int i = 0; i < 4; i++) {
            algoStar.pasarTurno();
        }

        jugadorZerg.generarUnidad(new Coordenada(1,1), new Zangano());
        jugadorZerg.generarUnidad(new Coordenada(1,1), new Zangano());
        jugadorZerg.generarUnidad(new Coordenada(1,1), new Zangano());

        algoStar.pasarTurno();

        jugadorZerg.generarUnidad(new Coordenada(1,1), new Zangano());

        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            jugadorZerg.generarUnidad(new Coordenada(1,1), new Zangano());
        });
    }

	@Test
    public void unCriaderoNuncaVaATenerMasDe3LarvasALaVez() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 0, 500,200);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        // Se construye un criadero
        jugadorZerg.construirEdificio(new Coordenada(1,1), new Criadero());
        for (int i = 0; i < 4; i++) {
            algoStar.pasarTurno();
        }

        jugadorZerg.generarUnidad(new Coordenada(1,1), new Zangano());
        jugadorZerg.generarUnidad(new Coordenada(1,1), new Zangano());
        jugadorZerg.generarUnidad(new Coordenada(1,1), new Zangano());

        for (int i = 0; i < 20; i++) {
            algoStar.pasarTurno();
        }
        //muevo las unidades para poder seguir generando mas
        jugadorZerg.moverUnidad(new Coordenada(1,2), new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(2,2), new Abajo());

        jugadorZerg.generarUnidad(new Coordenada(1,1), new Zangano());
        jugadorZerg.generarUnidad(new Coordenada(1,1), new Zangano());
        jugadorZerg.generarUnidad(new Coordenada(1,1), new Zangano());

        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            jugadorZerg.generarUnidad(new Coordenada(1,1), new Zangano());
        });
    }
    
}
