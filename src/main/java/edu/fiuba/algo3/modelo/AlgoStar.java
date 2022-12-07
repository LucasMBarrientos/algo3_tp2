package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoAlcanzado;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedenAgregarMasJugadores;
import edu.fiuba.algo3.modelo.excepciones.NombreDeJugadorInvalido;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Jugador;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;

public class AlgoStar {

    public List<Jugador> jugadores = new ArrayList<Jugador>();
    private int idJugadorActual;

    private int turnoActual;
    private int rondaActual;

    private Jugador jugadorGanador;

    private Mapa mapa;

    public AlgoStar() {
        this.mapa = new Mapa(new Coordenada(50,50));
    }

    public AlgoStar(Mapa mapaPersonalizado) {
        this.mapa = mapaPersonalizado;
    }

    public void agregarJugador(Jugador jugador) {
        if (jugadores.size() > 1) {
            throw new NoSePuedenAgregarMasJugadores();
        }
        jugador.compararAtributosBasicoConOtrosJugadores(jugadores);
        jugador.establecerId(jugadores.size());
        jugadores.add(jugador);
    }

    public Mapa empezarJuego() {
        for (Jugador jugador : jugadores) {
          jugador.establecerMapa(mapa);
        }
        mapa.actualizar(turnoActual);
        this.idJugadorActual = 0;
        this.turnoActual = 0;
        this.rondaActual = 0;
        return mapa;
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
        mapa.actualizar(turnoActual);
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
