package edu.fiuba.algo3.pruebas_de_integracion;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.edificios.protoss.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.protoss.PuertoEstelar;
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
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.AmoSupremo;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

public class prueba4 {

    @Test
    public void prueboAConstruirTodosLasUnidadesDisponiblesEnElJuego() {

        Logger.setEnableLog(true);
        AlgoStar a = new AlgoStar();
        a.agregarJugador(new JugadorProtoss("Protoss", "#0000ff"));
        a.agregarJugador(new JugadorZerg("Zerggg", "#ff0000"));
        a.empezarJuego();

        // El jugador protoss construye 2 nexos minerales y un asimilador
        a.hallarJugadorActual().construirEdificio(new Coordenada(4, 4), new Asimilador());
        a.hallarJugadorActual().construirEdificio(new Coordenada(3, 4), new NexoMineral());
        a.hallarJugadorActual().construirEdificio(new Coordenada(4, 3), new NexoMineral());
        for (int i = 0; i < 6; i++) { // Termino de construir los edificios
            a.pasarTurno();
        }

        // Paso varios turnos recolectando recursos para el jugador protoss
        for (int i = 0; i < 100; i++) {
            a.pasarTurno();
        }

        // El jugador protoss construye varios pilones (Para tener suministros suficientes para todas las unidades)
        a.hallarJugadorActual().construirEdificio(new Coordenada(1, 1), new Pilon());
        a.hallarJugadorActual().construirEdificio(new Coordenada(10, 1), new Pilon());
        a.hallarJugadorActual().construirEdificio(new Coordenada(11, 1), new Pilon());
        a.hallarJugadorActual().construirEdificio(new Coordenada(12, 1), new Pilon());
        a.hallarJugadorActual().construirEdificio(new Coordenada(1, 10), new Pilon());
        a.hallarJugadorActual().construirEdificio(new Coordenada(1, 11), new Pilon());
        a.hallarJugadorActual().construirEdificio(new Coordenada(1, 12), new Pilon());
        for (int i = 0; i < 6; i++) { // Termino de construir los pilones
            a.pasarTurno();
        }

        // El jugador protoss construye un acceso en el rango del pilon previamente construido
        a.hallarJugadorActual().construirEdificio(new Coordenada(3, 1), new Acceso());
        for (int i = 0; i < 8; i++) { // Termino de construir el acceso
            a.pasarTurno();
        }

        // El jugador protoss construye un puerto estelar en el rango del pilon previamente construido
        a.hallarJugadorActual().construirEdificio(new Coordenada(1, 3), new PuertoEstelar());
        for (int i = 0; i < 10; i++) { // Termino de construir el puerto estelar
            a.pasarTurno();
        }

        // Se pasa el turno al jugador zerg
        a.pasarTurno();

        // El jugador zerg mueve el zangano inicial hasta el mineral mas cercano
        a.hallarJugadorActual().moverUnidad(new Coordenada(98, 48), new Izquierda());
        a.hallarJugadorActual().moverUnidad(new Coordenada(97, 48), new Izquierda());
        a.hallarJugadorActual().moverUnidad(new Coordenada(96, 48), new Izquierda());
        a.hallarJugadorActual().moverUnidad(new Coordenada(95, 48), new Arriba());
        a.hallarJugadorActual().moverUnidad(new Coordenada(95, 47), new Arriba());
        
        // Paso varios turnos recolectando minerales para el jugador zerg
        for (int i = 0; i < 200; i++) {
            a.pasarTurno();
        }

        // El jugador zerg mueve el zangano a un terreno diferente y construye varios criaderos (Para tener suministros suficientes para todas las unidades)
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
        for (int y = 40; y > 38; y--) {
            a.hallarJugadorActual().generarUnidad(new Coordenada(98, y), new Zangano());
            a.pasarTurno();
            a.pasarTurno();
            a.hallarJugadorActual().construirEdificio(new Coordenada(98, y-1), new Criadero());
            for (int i = 0; i < 4; i++) { // Termino de construir el criadero
                a.pasarTurno();
            }
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
        for (int i = 0; i < 100; i++) {
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

        // Le paso el turno al jugador protoss
        a.pasarTurno();

        // Empiezo a generar todas las unidades posibles para el jugador protoss

        a.hallarJugadorActual().generarUnidad(new Coordenada(3, 1), new Zealot()); // Coordenada que posee un acceso
        a.hallarJugadorActual().generarUnidad(new Coordenada(3, 1), new Dragon()); // Coordenada que posee un acceso
        a.hallarJugadorActual().generarUnidad(new Coordenada(1, 3), new Scout()); // Coordenada que posee un puerto estelar

        // Le paso el turno al jugador zerg
        a.pasarTurno();

        // Empiezo a generar todas las unidades posibles para el jugador zerg

        a.hallarJugadorActual().generarUnidad(new Coordenada(98, 48), new AmoSupremo()); // Coordenada que posee un criadero
        a.hallarJugadorActual().generarUnidad(new Coordenada(98, 48), new Zangano()); // Coordenada que posee un criadero
        a.hallarJugadorActual().generarUnidad(new Coordenada(98, 46), new Zerling()); // Coordenada que posee una reserva de reproduccion
        a.hallarJugadorActual().generarUnidad(new Coordenada(96, 48), new Hidralisco()); // Coordenada que posee un guarida
        a.hallarJugadorActual().generarUnidad(new Coordenada(96, 46), new Mutalisco()); // Coordenada que posee una espiral

    }


}
