package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class AlgoStar {

    public List<Jugador> jugadores = new ArrayList<Jugador>();
    private Jugador jugadorActual ;

    private int turno = 0;

    private Mapa mapa;


    public void empezarJuego(){

        mapa = new Mapa();
        jugadores.add(new JugadorZerg(mapa));
        jugadores.add(new JugadorProtoss());
        jugadorActual = jugadores.get(turno);
        devolverCasilla(1,2).ocupar(new Criadero());

    }

    public void pasarTurno(){
        if(turno == 1){
            jugadorActual = jugadores.get(0);
        }
        else{

            jugadorActual = jugadores.get(1);
        }
        mapa.actualizar();
    }

    public Casilla devolverCasilla(int x, int y){
        return mapa.esLaMismaCasilla(new Casilla(x,y));
    }

    public void generarUnidad(Casilla c){
        jugadorActual.generarUnidad(c);
    }

    public Ocupante seleccionarCasillero(Casilla c){
        return mapa.esLaMismaCasilla(c).devolverOcupante();

    }

    public void construirCriadero(){
        //jugador.construirCriadero
    }


}
