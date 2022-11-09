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

    public void DEBUGspawnearOcupante(int x, int y, Ocupante ocupante) { // Eliminar previamente a la entrega
        this.seleccionarCasilla(x, y).establecerOcupante(ocupante);
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
        mapa.actualizar();
    }

    public Casilla seleccionarCasilla(int x, int y) {
        return mapa.buscarCasilla(x,y);
    }

    public Unidad seleccionarUnidadDisponible(int id) {
        return hallarJugadorActual().buscarUnidadDisponible(id);
    }

    public void generarUnidad(int x, int y) {
        if (this.mapa.buscarCasilla(x, y).devolverOcupante() instanceof GeneradorDeUnidades) {
            Casilla casilla = this.mapa.buscarCasilla(x, y);
            hallarJugadorActual().generarUnidad(casilla);
        }
    }

    public void generarUnidad(Casilla casilla) {
        if (casilla.devolverOcupante() instanceof GeneradorDeUnidades) {
            hallarJugadorActual().generarUnidad(casilla);
        }
    }

    public void construirEdificio(int x, int y, Edificio edificio) {
        hallarJugadorActual().construirEdificio(x, y, edificio);
    }

    public void construirEdificio(Unidad unidad, Edificio edificio) {
        hallarJugadorActual().construirEdificio(unidad, edificio);
    }


}
