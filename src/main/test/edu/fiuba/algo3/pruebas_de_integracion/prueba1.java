package edu.fiuba.algo3.pruebas_de_integracion;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.edificios.protoss.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import org.junit.jupiter.api.Test;

public class prueba1 {

    @Test
    public void prueboPartidaConZergGanador() {

        AlgoStar a = new AlgoStar();


        Logger.log("El Jugador 1 Elige raza Zerg, nombre Zerggg y color #ff0000");
        a.agregarJugador(new JugadorZerg("Zerggg","#ff0000"));

        Logger.log("El Jugador 1 Elige raza Protoss, nombre Protoss y color #0000ff");
        a.agregarJugador(new JugadorProtoss("Protoss","#0000ff"));

        Logger.log("Inicia el Juego, Empieza la Ronda 1");
        a.empezarJuego();

        Logger.log("El jugador 1 mueve su zangano incial hacia la coordenada (4,3), donde se encuentra un Mineral.");
        a.hallarJugadorActual().moverUnidad(new Coordenada(1,1), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(2,1), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(3,1), new Derecha());
        a.hallarJugadorActual().moverUnidad(new Coordenada(4,1), new Abajo());
        a.hallarJugadorActual().moverUnidad(new Coordenada(4,2), new Abajo());

        Logger.log("El jugador 1 pasa el turno");
        a.pasarTurno();

        Logger.log("Inicia el turno del Jugador Protoss");
        Logger.log("El jugador Protoss construye un nexo mineral en la coordenada (45,46)");
        a.hallarJugadorActual().construirEdificio(new Coordenada(45,46), new NexoMineral());
        Logger.log("El jugador Protoss construye un asimilador en la coordenada (45,45)");
        a.hallarJugadorActual().construirEdificio(new Coordenada(45,45), new Asimilador());

        Logger.log("El jugador 2 pasa el turno");
        Logger.log("Inicia el Juego, Empieza la Ronda 2");
        a.pasarTurno();
        Logger.log("El jugador 1 pasa el turno");
        a.pasarTurno();
        Logger.log("El jugador 2 pasa el turno");
        Logger.log("Inicia el Juego, Empieza la Ronda 3");
        a.pasarTurno();
        Logger.log("El jugador 1 pasa el turno");
        a.pasarTurno();
        Logger.log("El jugador 2 pasa el turno");
        Logger.log("Inicia el Juego, Empieza la Ronda 4");
        a.pasarTurno();
        Logger.log("El jugador 1 pasa el turno");
        a.pasarTurno();

        //Logger.log("El jugador Protoss construye un pilon en la coordenada (6,6)");
       // a.hallarJugadorActual().construirEdificio(new Coordenada(6,6),new Pilon());




    }

}
