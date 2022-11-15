package edu.fiuba.algo3.modelo.direcciones;

import edu.fiuba.algo3.modelo.Coordenada;

public class Izquierda implements Direccion{

    public Coordenada siguiente(Coordenada posicion){

        return posicion.devolverCoordenadaRelativa(-1,0);
    }
}
