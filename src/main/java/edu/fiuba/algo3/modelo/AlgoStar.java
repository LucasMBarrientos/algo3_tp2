package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class AlgoStar {

    public List<Jugador> jugadores = new ArrayList<Jugador>();
    private int idJugadorActual;

    private int turnoActual;
    private int rondaActual;

    private Mapa mapa;

    public void empezarJuego() {
        this.mapa = new Mapa(10,10);
        this.jugadores.add(new JugadorZerg(mapa));
        this.jugadores.add(new JugadorProtoss(mapa));
        this.idJugadorActual = 0;
        this.turnoActual = 0;
        this.rondaActual = 0;
    }

    public Jugador devolverJugadorActual() {
        return jugadores.get(idJugadorActual);
    }

    public void pasarTurno() {
        idJugadorActual++;
        turnoActual++;
        if (turnoActual % jugadores.size() == 0) {
            idJugadorActual = 0;
            rondaActual++;
        }
        mapa.actualizar();
    }

    public Casilla seleccionarCasilla(int x, int y) {
        return mapa.buscarCasilla(x,y);
    }

    public Casilla generarUnidad(Casilla casilla) {
        Casilla c = new Casilla(0,0);
        if (this.mapa.validarCasillaDeUnGenerador(casilla)) {
            c = devolverJugadorActual().generarUnidad(casilla);
        }
        return c;
    }

    public void construirEdificio(int x, int y, Edificio edificio) {
        devolverJugadorActual().construirEdificio(x, y, edificio);
    }

}
