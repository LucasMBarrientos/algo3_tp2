package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoAlcanzado;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedenAgregarMasJugadores;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Jugador;

import java.util.ArrayList;
import java.util.List;

public class AlgoStar {

    private List<Jugador> jugadores = new ArrayList<Jugador>();
    private int idJugadorActual;
    private int turnoActual;
    private int rondaActual;

    private Jugador jugadorGanador;

    public AlgoStar() {
        Mapa.devolverInstancia().establecerDimension(new Coordenada(100,50));
    }

    public void agregarJugador(Jugador jugador) {
        Logger.log("Se agrego al jugador " + jugador.devolverNombre());
        if (jugadores.size() > 1) {
            throw new NoSePuedenAgregarMasJugadores();
        }
        jugador.compararAtributosBasicoConOtrosJugadores(jugadores);
        jugador.establecerId(jugadores.size());
        jugadores.add(jugador);
    }

    public void empezarJuego() {
        Logger.log("Comienza el juego");
        for (Jugador jugador : jugadores) {
            jugador.iniciarseEnMapa();
        }

        this.idJugadorActual = 0;
        this.turnoActual = 0;
    }
    public Jugador hallarJugadorActual() {
        return jugadores.get(this.idJugadorActual);
    }

    public void pasarTurno(){
        idJugadorActual++;
        turnoActual++;
        if (turnoActual % jugadores.size() == 0) {
            idJugadorActual = 0;
            rondaActual++;
        }
        Logger.log("Se paso el turno a el jugador " + this.hallarJugadorActual().devolverNombre());
        List<Jugador> jugadoresQueNoPerdieron = new ArrayList<Jugador>();
        for (int i=0; i < jugadores.size(); i++) {
            jugadores.get(i).actualizar();
            jugadores.get(i).aniadirseAListaSiNoFueDerrotado(jugadoresQueNoPerdieron);
        }
        if (jugadoresQueNoPerdieron.size() == 1) {
            jugadorGanador = jugadoresQueNoPerdieron.get(0);
            throw new FinDelJuegoAlcanzado();
        }
    }

    public Jugador devolverJugadorGanador() {
        return jugadorGanador;
    }

}
