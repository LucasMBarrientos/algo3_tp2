package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.protoss.acceso.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso6 {

    @Test
    public void elRadioDelMohoDelCriaderoEsIgualA5cuandoSeTerminaDeConstruir() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 0, 500,200);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff",0,250,200);
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        // Se construye un criadero a partir de 4 pasarTurno
        // El moho Se expande de 1,1 a 6,1 y de crea a apartir del 5 pasarTurno()

        jugadorZerg.construirEdificio(new Coordenada(1,1), new Criadero());
        jugadorProtoss.construirEdificio(new Coordenada(6,2), new Pilon());
        for (int i = 0; i < 5; i++) {
            algoStar.pasarTurno();
        }
        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            jugadorProtoss.construirEdificio(new Coordenada(6,1), new Acceso());
        });
    }

    @Test
    public void elRadioDelMohoDelCriaderoInicialNoEsMayorA5EnElPrimerTurno() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 0, 500,200);
        algoStar.agregarJugador(jugadorZerg);
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff",0,250,200);
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();
        
        Criadero criadero = new Criadero();
        Zangano zangano = new Zangano();

        jugadorZerg.construirEdificio(new Coordenada(1,1), criadero);

        criadero.terminarConstruccion();
        jugadorZerg.generarUnidad(new Coordenada(1,1), zangano);

        zangano.actualizar(inventario);
        zangano.actualizar(inventario);

        jugadorZerg.moverUnidad(new Coordenada(2,1),new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(3,1),new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(4,1),new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(5,1),new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(6,1),new Abajo());

        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            jugadorZerg.construirEdificio(new Coordenada(6,2), new ReservaDeReproduccion());
        });
    }

    @Test
    public void mohoSeExpande1CasillaCada2Turnos() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 0, 500,200);
        algoStar.agregarJugador(jugadorZerg);
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff",0,250,200);
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Criadero criadero = new Criadero();
        Zangano zangano = new Zangano();

        jugadorZerg.construirEdificio(new Coordenada(1,1), criadero);

        criadero.terminarConstruccion();
        jugadorZerg.generarUnidad(new Coordenada(1,1), zangano);

        zangano.actualizar(inventario);
        zangano.actualizar(inventario);

        jugadorZerg.moverUnidad(new Coordenada(2,1),new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(3,1),new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(4,1),new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(5,1),new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(6,1),new Abajo());

        algoStar.pasarTurno();
        algoStar.pasarTurno();

        algoStar.pasarTurno();
        algoStar.pasarTurno();

        jugadorZerg.construirEdificio(new Coordenada(6,2), new ReservaDeReproduccion());

    }


}
