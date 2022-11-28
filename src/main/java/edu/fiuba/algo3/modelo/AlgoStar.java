package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoAlcanzado;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedenAgregarMasJugadores;
import edu.fiuba.algo3.modelo.excepciones.NombreDeJugadorInvalido;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Jugador;

public class AlgoStar {

    public List<Jugador> jugadores = new ArrayList<Jugador>();
    private int idJugadorActual;

    private int turnoActual;
    private int rondaActual;

    private Mapa mapa;

    public AlgoStar() {
        this.mapa = new Mapa(new Coordenada(100,20));
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

    public void empezarJuego() {
        for (Jugador jugador : jugadores) {
          jugador.establecerMapa(mapa);
        }
        mapa.actualizar(turnoActual);
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
        mapa.actualizar(turnoActual);
        boolean finDelJuegoAlcanzado = false;
        for (Jugador jugador : jugadores) {
            jugador.actualizar();
            try {
                jugador.fueDerrotado();
            } catch (FinDelJuegoAlcanzado e) {
                // TODO: Realizar lo que suceda con el fin del juego
                throw e;
            }
        }
    }

    


    public Jugador devolverJugadorActual() {
        return jugadores.get(idJugadorActual);
    }







    // Metodos DEBUG_ unicamente para probar el funcionamiento el programa

    public Mapa DEBUG_DEVOLVERMAPA() {
        return mapa;
    }

}
