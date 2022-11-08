package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class AlgoStar {

    public List<Jugador> jugadores;
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
        this.jugadores = new ArrayList<Jugador>();
    }

    private Jugador seleccionarJugadorActual() {
        return this.jugadores.get(idJugadorActual);
    }

    public void pasarTurno() {
        idJugadorActual++;
        turnoActual++;
        if (turnoActual % jugadores.size() == 0) {
            idJugadorActual = 0;
        }
        mapa.actualizar();
    }

    public Casilla seleccionarCasilla(int x, int y) {
        return mapa.buscarCasilla(x,y);
    }

    public void generarUnidad(Casilla casilla) {
        if (this.mapa.validarCasillaDeUnGenerador(casilla)) {
            seleccionarJugadorActual().generarUnidad(casilla);
        }
    }

    public void construirCriadero(){
        //jugador.construirCriadero
    }


}
