package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class AlgoStar {

    public List<Jugador> jugadores = new ArrayList<Jugador>();
    private Jugador jugadorActual;

    private int turno = 0;

    private Mapa mapa;


    public void empezarJuego() {
        this.mapa = new Mapa(10,10);
        this.jugadores.add(new JugadorZerg(mapa));
        this.jugadores.add(new JugadorProtoss());
        this.jugadorActual = jugadores.get(turno);
        this.seleccionarCasillero(1,2).establecerOcupante(new Criadero());

    }

    public void pasarTurno(){
        if(turno == 1){
            jugadorActual = jugadores.get(0);
        } else {
            jugadorActual = jugadores.get(1);
        }
        mapa.actualizar();
    }

    public Casilla seleccionarCasillero(int x, int y) {
        return mapa.buscarCasilla(x,y);
    }

    public void generarUnidad(Casilla c){
        jugadorActual.generarUnidad(c);
    }

    public void construirCriadero(){
        //jugador.construirCriadero
    }


}
