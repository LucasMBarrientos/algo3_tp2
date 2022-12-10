package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoAlcanzado;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedenAgregarMasJugadores;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Jugador;

import java.util.ArrayList;
import java.util.List;

public class AlgoStar {

    public List<Jugador> jugadores = new ArrayList<Jugador>();
    private int idJugadorActual;

    private int turnoActual;
    private int rondaActual;

    private Jugador jugadorGanador;

    public AlgoStar() {
       Mapa.devolverInstancia().establecerDimension(new Coordenada(100,
        this.mapa = new Mapa(new Coordenada(100,50));
    }

    public void agregarJugador(Jugador jugador) {
        if (jugadores.size() > 1) {
            throw new NoSePuedenAgregarMasJugadores();
        }
        jugador.compararAtributosBasicoConOtrosJugadores(jugadores);
        jugador.establecerId(jugadores.size());
        jugadores.add(jugador);
    }

    public void empezarJuego() {
        for (Jugador jugador : jugadores) {
            jugador.iniciarseEnMapa();
        }
        //Mapa.devolverInstancia().actualizar(turnoActual);
        this.idJugadorActual = 0;
        this.turnoActual = 0;
        this.rondaActual = 0;
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
        //Mapa.devolverInstancia().actualizar(turnoActual);
        for (Jugador jugador : jugadores) {
            jugador.actualizar();
            try {
                jugador.fueDerrotado();
            } catch (FinDelJuegoAlcanzado e) {
                jugadorGanador = jugador;
                throw e;
            }
        }
    }

    public Jugador devolverJugadorGanador() {
        return jugadorGanador;
    }
    
    public Jugador devolverJugadorActual() {
        return jugadores.get(idJugadorActual);
    }

}
