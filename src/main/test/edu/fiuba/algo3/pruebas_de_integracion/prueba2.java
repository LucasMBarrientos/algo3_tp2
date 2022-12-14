package edu.fiuba.algo3.pruebas_de_integracion;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoAlcanzado;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.geometria.direcciones.Izquierda;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

import org.junit.jupiter.api.Test;

public class prueba2 {

    @Test
    public void prueboPartidaConZergGanador() {

        Logger.setEnableLog(true);
        AlgoStar a = new AlgoStar();
        a.agregarJugador(new JugadorZerg("Zerggg","#ff0000"));
        a.agregarJugador(new JugadorProtoss("Protoss","#0000ff"));
        a.empezarJuego();

        //jugador zerg mueve el zangano inicial hasta el mineral
        a.hallarJugadorActual().moverUnidad(new Coordenada(1,1), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(2,1), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(3,1), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(4,1), new Abajo());
        a.hallarJugadorActual().moverUnidad(new Coordenada(4,2), new Abajo());
        
        //pasan varios turnos para recolectar recursos
        for (int i = 0; i < 40; i++) {
            a.pasarTurno();
        }

        a.pasarTurno();

        //jugador protoss construye un pilon
        a.hallarJugadorActual().construirEdificio(new Coordenada(12,4),new Pilon());

        a.pasarTurno();

        //jugador zerg construye un criadero
        a.hallarJugadorActual().moverUnidad(new Coordenada(4,3), new Izquierda());
        a.hallarJugadorActual().construirEdificio(new Coordenada(3,3),new Criadero());

        for (int i = 0; i < 8; i++) {
            a.pasarTurno();
        }

        //jugador zerg genera 3 zanganos
        for (int i = 0; i < 3; i++) {
          a.hallarJugadorActual().generarUnidad(new Coordenada(3,3), new Zangano());
        }
        
        a.pasarTurno();
        a.pasarTurno();
        //jugador zerg mueve un zangano y construye una reserva de reproduccion
        a.hallarJugadorActual().moverUnidad(new Coordenada(4,3), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(5,3), new Derecha());
        a.hallarJugadorActual().construirEdificio(new Coordenada(6,3), new ReservaDeReproduccion());

        //pasan los turnos para que la reserva termine de construirse
        for (int i = 0; i < 12; i++) {
          a.pasarTurno();
        }

        a.hallarJugadorActual().generarUnidad(new Coordenada(6,3), new Zerling());

        //pasan los turnos para que el zerling termine de construirse
        for (int i = 0; i < 4; i++) {
          a.pasarTurno();
        }
      
        a.hallarJugadorActual().moverUnidad(new Coordenada(6,2), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(7,2), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(8,2), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(9,2), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(10,2), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(11,2), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(12,2), new Abajo());

        for (int i = 0; i < 149; i++) {
          a.hallarJugadorActual().atacar(new Coordenada(12, 3), new Coordenada(12,4));
        }

        try {
          a.hallarJugadorActual().atacar(new Coordenada(12, 3), new Coordenada(12,4));
        } catch(EdificioEstaDestruido e) {
            System.out.println("Se destruyo el Pilon Protoss");
        }

        try {
          a.pasarTurno();
        }catch(FinDelJuegoAlcanzado e){
            System.out.println("Juego ganado por la raza " + a.devolverJugadorGanador().toData().get("raza"));
        }

    }

}

