package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Jugador;

public class AlgoStar {

    public List<Jugador> jugadores = new ArrayList<Jugador>();
    private int idJugadorActual;

    private int turnoActual;
    private int rondaActual;

    private Mapa mapa;

    public void agregarJugador(Jugador jugador) {
        if (jugadores.size() < 2) {
            jugador.establecerId(jugadores.size());
            jugadores.add(jugador);
        } else {
            // TODO: Lanzar excepcion "SeEstaTratandoDePonerMasDe2Jugadores"
        }
    }

    public void empezarJuego() {
        this.mapa = new Mapa(new Coordenada(100,20));
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
    }


    public Jugador devolverJugadorActual() {
        return jugadores.get(idJugadorActual);
    }






    
    // Metodos DEBUG_ unicamente para probar el funcionamiento el programa

    public Mapa DEBUG_DEVOLVERMAPA() {
        return mapa;
    }

}
