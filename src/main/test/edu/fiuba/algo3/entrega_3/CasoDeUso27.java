package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.edificios.protoss.acceso.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.protoss.puertoEstelar.PuertoEstelar;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.espiral.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.guarida.Guarida;
import edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.UnidadDestruida;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.zerg.Devorador;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CasoDeUso27 {

/*

    @Test
    public void unMutalizcoPuedeEvolucionarEnUnDevoradorSiHaySuficientesRecursosYLuegoPuedeAtacarAUnEnemigoA5CoordenadasDeDistancia() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 1200, 1200); // TODO: Marcar los recursos estrictamente necesarios para lograr pasar esta prueba
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff",1200, 1200);
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        jugadorZerg.construirEdificio(new Coordenada(1, 1), new Criadero());
        algoStar.pasarTurno();
        jugadorProtoss.construirEdificio(new Coordenada(8,3), new Pilon());
        for (int i = 0; i < 7; i++) {
            algoStar.pasarTurno();
        }

        // Construir una reserva de reproduccion
        jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.construirEdificio(new Coordenada(2, 1), new ReservaDeReproduccion()); // TODO: Suponiendo que el zangano de antes se genere en la coordenada (2,1)
        for (int i = 0; i < 12; i++) {
            algoStar.pasarTurno();
        }

        // construir una guarida
        jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(new Coordenada(1,2), new Abajo()); // TODO: Suponiendo que el zangano de antes se genere en la coordenada (1,2)
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.construirEdificio(new Coordenada(1, 3), new Guarida());
        for (int i = 0; i < 12; i++) {
            algoStar.pasarTurno();
        }

        // construir una espiral
        jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(new Coordenada(1,2), new Derecha());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(new Coordenada(2,2), new Derecha());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.construirEdificio(new Coordenada(3, 2), new Espiral());
        for (int i = 0; i < 10; i++) {
            algoStar.pasarTurno();
        }

        // generar un mutalisco
        jugadorZerg.generarUnidad(new Coordenada(3,2), new Mutalisco());
        for (int i = 0; i < 14; i++) {
            algoStar.pasarTurno();
        }

        // Evolucionar el mutalisco en un devorador
        jugadorZerg.evolucionar(new Coordenada(3,1), new Devorador());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }


        algoStar.pasarTurno();
        jugadorProtoss.construirEdificio(new Coordenada(8,4), new Acceso());
        for (int i = 0; i <14; i++) {
            algoStar.pasarTurno();
        }

        jugadorProtoss.construirEdificio(new Coordenada(8,2), new PuertoEstelar());
        for (int i = 0; i <14; i++) {
            algoStar.pasarTurno();
        }
        jugadorProtoss.generarUnidad(new Coordenada(8,2),new Scout());
        for (int i = 0; i <14; i++) {
            algoStar.pasarTurno();
        }
        // TODO: jugadorProtoss debe construir una unidad en la coordenada (8,1)


        jugadorZerg.atacar(new Coordenada(3,1), new Coordenada(8,1));

        // Se intenta atacar una unidad que esta a 5 de rango
        Assertions.assertThrows(EdificioEstaDestruido.class, ()->{
            jugadorZerg.atacar(new Coordenada(3,1), new Coordenada(8,1));
        });
    }*/
}
