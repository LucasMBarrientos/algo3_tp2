package edu.fiuba.algo3.modelo;

public class Edificio {

    public Casilla ubicacion;

    public boolean esLaMismaCasilla(Casilla c){
        return ubicacion.equals(c);

    }
}
