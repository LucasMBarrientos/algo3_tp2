package edu.fiuba.algo3.modelo.direcciones;

import edu.fiuba.algo3.modelo.Coordenada;

public class Abajo implements Direccion{

    public Abajo(){}

    public Coordenada siguiente(Coordenada posicion){

        return posicion.devolverCoordenadaRelativa(0,1);
    }
}
