package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioDestruido;
import edu.fiuba.algo3.modelo.edificios.protoss.acceso.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.protoss.puertoEstelar.PuertoEstelar;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.espiral.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.guarida.Guarida;
import edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.*;
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

    @Test
    public void unMutalizcoPuedeEvolucionarEnUnDevoradorSiHaySuficientesRecursosYLuegoPuedeAtacarAUnEnemigoA5CoordenadasDeDistancia() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 1200, 1200,200); // TODO: Marcar los recursos estrictamente necesarios para lograr pasar esta prueba
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff",1200, 1200,200);
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        jugadorZerg.construirEdificio(new Coordenada(1, 1), new Criadero());
        algoStar.pasarTurno();
        jugadorProtoss.construirEdificio(new Coordenada(30,2), new Pilon());
        for (int i = 0; i < 7; i++) {
            algoStar.pasarTurno();
        }

        // Construir una reserva de reproduccion
        jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.construirEdificio(new Coordenada(2, 1), new ReservaDeReproduccion());
        for (int i = 0; i < 12; i++) {
            algoStar.pasarTurno();
        }

        // construir una guarida
        jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(new Coordenada(1,2), new Abajo());
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
        jugadorProtoss.construirEdificio(new Coordenada(31,2), new Acceso());
        for (int i = 0; i <14; i++) {
            algoStar.pasarTurno();
        }

        jugadorProtoss.construirEdificio(new Coordenada(31,1), new PuertoEstelar());
        for (int i = 0; i <14; i++) {
            algoStar.pasarTurno();
        }

        // Genero un scout en el puerto estelar
        jugadorProtoss.generarUnidad(new Coordenada(31,1),new Scout());
        for (int i = 0; i < 18; i++) {
            algoStar.pasarTurno();
        }

        // Acercar el scout al devorador
        for (int x = 31; x > 6; x--) {
            jugadorProtoss.moverUnidad(new Coordenada(x,0), new Izquierda());
            algoStar.pasarTurno();
            algoStar.pasarTurno();
        }
        algoStar.pasarTurno();

        for (int i=0; i < 48; i++) {
            jugadorZerg.atacar(new Coordenada(3,1), new Coordenada(6,0));
            algoStar.pasarTurno();
            algoStar.pasarTurno();
        }

        // Se intenta atacar una unidad que esta a 5 de rango
        Assertions.assertThrows(UnidadEstaDestruida.class, ()->{
            jugadorZerg.atacar(new Coordenada(3,1), new Coordenada(6,0));
        });
    }
}
