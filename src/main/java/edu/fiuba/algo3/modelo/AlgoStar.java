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

    public Jugador hallarJugadorActual() {
        return jugadores.get(idJugadorActual);
    }

    public void pasarTurno() {
        idJugadorActual++;
        turnoActual++;
        if (turnoActual % jugadores.size() == 0) {
            idJugadorActual = 0;
            rondaActual++;
        }
        this.mapa.actualizar();
    }

    public Casilla seleccionarCasilla(int x, int y) {
        return mapa.buscarCasilla(x,y);
    }

    public Unidad seleccionarUnidadDisponible(int id) {
        return hallarJugadorActual().buscarUnidadDisponible(id);
    }

    public void generarUnidad(int x, int y) {
        if (this.mapa.buscarCasilla(x, y).devolverEdificio() instanceof GeneradorDeUnidades) {
            Casilla casilla = this.mapa.buscarCasilla(x, y);
            hallarJugadorActual().generarUnidad(casilla);
        }
    }

    public void generarUnidad(Casilla casilla) {
        if (casilla.devolverEdificio() instanceof GeneradorDeUnidades) {
            hallarJugadorActual().generarUnidad(casilla);
        }
    }

    public void moverUnidad(Unidad unidad, Casilla nuevaCasilla) {
        hallarJugadorActual().moverUnidad(unidad, nuevaCasilla);
    }

    public void moverUnidad(Unidad unidad, int x, int y) {
        Casilla nuevaCasilla = mapa.buscarCasilla(x, y);
        this.moverUnidad(unidad, nuevaCasilla);
    }

    public void construirEdificio(int x, int y, Edificio edificio) {
        hallarJugadorActual().construirEdificio(x, y, edificio);
    }

    public void construirEdificio(Unidad unidad, Edificio edificio) {
        hallarJugadorActual().construirEdificio(unidad, edificio);
    }


}
