package edu.fiuba.algo3.pruebas_de_integracion;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.edificios.protoss.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.edificios.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoAlcanzado;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.geometria.direcciones.Izquierda;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.zerg.AmoSupremo;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class prueba2 {

    @Test
    public void prueboPartidaConZergGanador() { //TODO: Cambiar todo esto para que gane el jugador zerg

        AlgoStar a = new AlgoStar();

        Logger.setEnableLog(true);

        a.agregarJugador(new JugadorZerg("Zerggg","#ff0000"));

        a.agregarJugador(new JugadorProtoss("Protoss","#0000ff"));

        a.empezarJuego();

        //jugador zerg mueve el zangano inicial hasta el mineral
        a.hallarJugadorActual().moverUnidad(new Coordenada(1,1), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(2,1), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(3,1), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(4,1), new Abajo());
        a.hallarJugadorActual().moverUnidad(new Coordenada(4,2), new Abajo());

        a.pasarTurno();

        //jugador protoss construye nexo mineral y un asimilador
        a.hallarJugadorActual().construirEdificio(new Coordenada(95 ,46), new NexoMineral());
        a.hallarJugadorActual().construirEdificio(new Coordenada(95 ,44), new NexoMineral());
        a.hallarJugadorActual().construirEdificio(new Coordenada(95,45), new Asimilador());

        //ambos jugadores pasan varios turnos para recolectar recursos
        for (int i = 0; i < 40; i++) {
            a.pasarTurno();
        }

        //jugador protoss construye un pilon
        a.hallarJugadorActual().construirEdificio(new Coordenada(12,4),new Pilon());

        a.pasarTurno();

        //jugador zerg construye un criadero
        a.hallarJugadorActual().moverUnidad(new Coordenada(4,3), new Izquierda());
        a.hallarJugadorActual().construirEdificio(new Coordenada(3,3),new Criadero());

        for (int i = 0; i < 7; i++) {
            a.pasarTurno();
        }

        //jugador protoss construye un Acceso
        a.hallarJugadorActual().construirEdificio(new Coordenada(11,3), new Acceso());

        a.pasarTurno();

        //jugador zerg genera 3 zanganos
        a.hallarJugadorActual().generarUnidad(new Coordenada(3,3), new Zangano());
        a.hallarJugadorActual().generarUnidad(new Coordenada(3,3), new Zangano());
        a.hallarJugadorActual().generarUnidad(new Coordenada(3,3), new Zangano());

        a.pasarTurno();
        a.pasarTurno();

        //jugador zerg mueve un zangano y construye un Extractor
        a.hallarJugadorActual().moverUnidad(new Coordenada(2,3), new Abajo());
        a.hallarJugadorActual().moverUnidad(new Coordenada(2,4), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(3,4), new Derecha());
        a.hallarJugadorActual().construirEdificio(new Coordenada(4,4), new Extractor());

        a.pasarTurno();
        a.pasarTurno();
        a.pasarTurno();
        a.pasarTurno();
        a.pasarTurno();

        //jugador protoss genera un dragon y este aparece en la coordenada (11, 2)
        a.hallarJugadorActual().generarUnidad(new Coordenada(11,3), new Dragon());

        for (int i = 0; i < 6; i++) {
            a.pasarTurno();
        }

        //jugador protoss mueve el dragon y ataca al criadero
        a.hallarJugadorActual().moverUnidad(new Coordenada(11,2), new Izquierda());
        a.hallarJugadorActual().moverUnidad(new Coordenada(10,2), new Izquierda());
        a.hallarJugadorActual().moverUnidad(new Coordenada(9,2), new Izquierda());
        a.hallarJugadorActual().moverUnidad(new Coordenada(8,2), new Izquierda());
        a.hallarJugadorActual().moverUnidad(new Coordenada(7,2), new Izquierda());
        a.hallarJugadorActual().moverUnidad(new Coordenada(6,2), new Izquierda());

        a.pasarTurno();

        //jugador zerg genera un amo supremo e ingresa un zangano al extractor
        a.hallarJugadorActual().generarUnidad(new Coordenada(3 ,3), new AmoSupremo());
        a.devolverJugadorActual().ingresarUnidadAUnEdificio(new Coordenada(4,4), new Coordenada(3,2));

        a.pasarTurno();

        //jugador protoss ataca al extractor hasta destruirlo
        for (int i = 0; i < 37; i++) {
            a.hallarJugadorActual().atacar(new Coordenada(5,2), new Coordenada(4,4));
        }

        try {
            a.hallarJugadorActual().atacar(new Coordenada(5,2), new Coordenada(4,4));
        }catch(EdificioEstaDestruido e){
            System.out.println("Se destruyo el extractor");
        }

        a.pasarTurno();

        //jugador zerg mueve un zangano y construye una reserva de reproduccion
        a.hallarJugadorActual().moverUnidad(new Coordenada(4,3), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(5,3), new Derecha());
        a.hallarJugadorActual().construirEdificio(new Coordenada(6,3), new ReservaDeReproduccion());

        a.pasarTurno();

        //jugador protoss ataca el criadro hasta destruirlo
        for (int i = 0; i < 24; i++) {
            a.hallarJugadorActual().atacar(new Coordenada(5,2), new Coordenada(3,3));
        }

        try {
            a.hallarJugadorActual().atacar(new Coordenada(5,2), new Coordenada(3,3));
        }catch(EdificioEstaDestruido e){
            System.out.println("Se destruyo el criadero, el jugador zerg no puede generar unidades sin larvas!");
        }

        //pasan los turnos para que la reserva termine de construirse
        for (int i = 0; i < 12; i++) {
            a.pasarTurno();
        }

        //jugador protoss ataca la reserva hasta destruirla y gana la partida cuando termina su turno
        for (int i = 0; i < 49; i++) {
            a.hallarJugadorActual().atacar(new Coordenada(5,2), new Coordenada(6,3));
        }

        try {
            a.hallarJugadorActual().atacar(new Coordenada(5,2), new Coordenada(6,3));
        }catch(EdificioEstaDestruido e){
            System.out.println("Se destruyo el el ultimo edificio de los zerg");
        }

        Assertions.assertThrows(FinDelJuegoAlcanzado.class, ()->{
            a.pasarTurno();
        });

    }

}

