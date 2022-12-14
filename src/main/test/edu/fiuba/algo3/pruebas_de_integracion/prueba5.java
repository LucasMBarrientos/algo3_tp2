package edu.fiuba.algo3.pruebas_de_integracion;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.edificios.zerg.Guarida;
import edu.fiuba.algo3.modelo.edificios.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Arriba;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.geometria.direcciones.Izquierda;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.zerg.Devorador;
import edu.fiuba.algo3.modelo.unidades.zerg.Guardian;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public class prueba5 {

    @Test
    public void prueboAGenerarUnMutaliscoYEvolucionarlo() {

        Logger.setEnableLog(true);
        AlgoStar a = new AlgoStar();
        a.agregarJugador(new JugadorProtoss("Protoss", "#0000ff"));
        a.agregarJugador(new JugadorZerg("Zerggg", "#ff0000"));
        a.empezarJuego();

        // Se pasa el turno al jugador zerg
        a.pasarTurno();

        // El jugador zerg mueve el zangano inicial hasta el mineral mas cercano
        a.hallarJugadorActual().moverUnidad(new Coordenada(98, 48), new Izquierda());
        a.hallarJugadorActual().moverUnidad(new Coordenada(97, 48), new Izquierda());
        a.hallarJugadorActual().moverUnidad(new Coordenada(96, 48), new Izquierda());
        a.hallarJugadorActual().moverUnidad(new Coordenada(95, 48), new Arriba());
        a.hallarJugadorActual().moverUnidad(new Coordenada(95, 47), new Arriba());
        
        // Paso varios turnos recolectando minerales para el jugador zerg
        for (int i = 0; i < 180; i++) {
            a.pasarTurno();
        }

        // El jugador zerg mueve el zangano a un terreno diferente y construye varios criaderos (Para tener suministros suficientes para los 2 mutaliscos)
        a.hallarJugadorActual().moverUnidad(new Coordenada(95,46), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(96,46), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(97,46), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(98,46), new Abajo());
        a.hallarJugadorActual().moverUnidad(new Coordenada(98,47), new Abajo());
        a.hallarJugadorActual().construirEdificio(new Coordenada(98, 48), new Criadero());
        for (int i = 0; i < 4; i++) { // Termino de construir el criadero
            a.pasarTurno();
        }
        a.hallarJugadorActual().generarUnidad(new Coordenada(98, 48), new Zangano());
        a.pasarTurno();
        a.pasarTurno();
        for (int y = 47; y > 40; y--) {
            a.hallarJugadorActual().moverUnidad(new Coordenada(98, y), new Arriba());
        }
        a.hallarJugadorActual().construirEdificio(new Coordenada(98, 40), new Criadero());
        for (int i = 0; i < 4; i++) { // Termino de construir el criadero
            a.pasarTurno();
        }
        a.hallarJugadorActual().generarUnidad(new Coordenada(98, 40), new Zangano());
        a.pasarTurno();
        a.pasarTurno();
        a.hallarJugadorActual().construirEdificio(new Coordenada(98, 39), new Criadero());
        for (int i = 0; i < 4; i++) { // Termino de construir el criadero
            a.pasarTurno();
        }

        // El jugador zerg genera varios zanganos en su criadero
        a.hallarJugadorActual().generarUnidad(new Coordenada(98, 48), new Zangano());
        a.hallarJugadorActual().generarUnidad(new Coordenada(98, 48), new Zangano());
        for (int i = 0; i < 2; i++) { // Termino de construir los zanganos
            a.pasarTurno();
        }

        // El jugador zerg manda uno de sus zanganos a construir un extractor
        a.hallarJugadorActual().moverUnidad(new Coordenada(98, 47), new Izquierda());
        a.hallarJugadorActual().moverUnidad(new Coordenada(97, 47), new Izquierda());
        a.hallarJugadorActual().moverUnidad(new Coordenada(96, 47), new Izquierda());
        a.hallarJugadorActual().moverUnidad(new Coordenada(95, 47), new Arriba());
        a.hallarJugadorActual().moverUnidad(new Coordenada(95, 46), new Arriba());
        a.hallarJugadorActual().construirEdificio(new Coordenada(95, 45), new Extractor());
        for (int i = 0; i < 6; i++) { // Termino de construir el extractor
            a.pasarTurno();
        }

        // El jugador zerg manda 3 zanganos a trabajar en el extractor
        a.hallarJugadorActual().ingresarUnidadAUnEdificio(new Coordenada(95, 45), new Coordenada(97, 48));
        a.hallarJugadorActual().generarUnidad(new Coordenada(98, 48), new Zangano());
        a.hallarJugadorActual().generarUnidad(new Coordenada(98, 48), new Zangano());
        for (int i = 0; i < 2; i++) {
            a.pasarTurno();
        }
        a.hallarJugadorActual().ingresarUnidadAUnEdificio(new Coordenada(95, 45), new Coordenada(98, 47));
        a.hallarJugadorActual().ingresarUnidadAUnEdificio(new Coordenada(95, 45), new Coordenada(97, 48));

        // Paso varios turnos recolectando recursos para el jugador zerg
        for (int i = 0; i < 20; i++) {
            a.pasarTurno();
        }

        // El jugador zerg construye una reserva de reproduccion
        a.hallarJugadorActual().generarUnidad(new Coordenada(98, 48), new Zangano());
        for (int i = 0; i < 2; i++) {
            a.pasarTurno();
        }
        a.hallarJugadorActual().moverUnidad(new Coordenada(98, 47), new Arriba());
        a.hallarJugadorActual().construirEdificio(new Coordenada(98, 46), new ReservaDeReproduccion());
        for (int i = 0; i < 12; i++) { // Termino de construir el edificio
            a.pasarTurno();
        }

        // El jugador zerg construye una guarida
        a.hallarJugadorActual().generarUnidad(new Coordenada(98, 48), new Zangano());
        for (int i = 0; i < 2; i++) {
            a.pasarTurno();
        }
        a.hallarJugadorActual().moverUnidad(new Coordenada(98, 47), new Izquierda());
        a.hallarJugadorActual().moverUnidad(new Coordenada(97, 47), new Izquierda());
        a.hallarJugadorActual().moverUnidad(new Coordenada(96, 47), new Abajo());
        a.hallarJugadorActual().construirEdificio(new Coordenada(96, 48), new Guarida());
        for (int i = 0; i < 12; i++) { // Termino de construir el edificio
            a.pasarTurno();
        }

        // El jugador zerg construye una espiral
        a.hallarJugadorActual().generarUnidad(new Coordenada(98, 48), new Zangano());
        for (int i = 0; i < 2; i++) {
            a.pasarTurno();
        }
        a.hallarJugadorActual().moverUnidad(new Coordenada(98, 47), new Izquierda());
        a.hallarJugadorActual().moverUnidad(new Coordenada(97, 47), new Izquierda());
        a.hallarJugadorActual().moverUnidad(new Coordenada(96, 47), new Arriba());
        a.hallarJugadorActual().construirEdificio(new Coordenada(96, 46), new Espiral());
        for (int i = 0; i < 10; i++) { // Termino de construir el edificio
            a.pasarTurno();
        }

        // Genero 2 mutaliscos
        a.hallarJugadorActual().generarUnidad(new Coordenada(96, 46), new Mutalisco());
        a.hallarJugadorActual().generarUnidad(new Coordenada(96, 46), new Mutalisco());
        for (int i = 0; i < 8; i++) { // Termino de construir la unidad
            a.pasarTurno();
        }

        // Evoluciono los mutaliscos
        a.hallarJugadorActual().evolucionar(new Coordenada(97, 46), new Devorador());
        a.hallarJugadorActual().evolucionar(new Coordenada(96, 47), new Guardian());

    }
}
