package edu.fiuba.algo3.pruebas_de_integracion;

import edu.fiuba.algo3.modelo.geometria.direcciones.Izquierda;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.edificios.protoss.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public class prueba1 {

    @Test
    public void prueboPartidaConZergGanador() {

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
        a.hallarJugadorActual().construirEdificio(new Coordenada(95,45), new Asimilador());

        //ambos jugadores pasan varios turnos para recolectar recursos
        for (int i = 0; i < 20; i++) {
            a.pasarTurno();
        }

        //jugador protoss construye un pilon
        a.hallarJugadorActual().construirEdificio(new Coordenada(12,4),new Pilon());

        a.pasarTurno();

        //
        a.hallarJugadorActual().moverUnidad(new Coordenada(4,3), new Izquierda());
        a.hallarJugadorActual().construirEdificio(new Coordenada(5,3),new Criadero());

        for (int i = 0; i < 9; i++) {
            a.pasarTurno();
        }

        a.hallarJugadorActual().construirEdificio(new Coordenada(17,2), new Acceso());

        a.pasarTurno();

        a.hallarJugadorActual().generarUnidad(new Coordenada(5,3), new Zangano());
        a.hallarJugadorActual().generarUnidad(new Coordenada(5,3), new Zangano());
        a.hallarJugadorActual().generarUnidad(new Coordenada(5,3), new Zangano());

        a.pasarTurno();



    }

}
