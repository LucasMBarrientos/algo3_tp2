package edu.fiuba.algo3.modelo.geometria.direcciones;

import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;

public class Arriba implements Direccion{

    public Coordenada hallarCoordenadaSiguiente(Coordenada posicionActual) {

        Coordenada coordenada = posicionActual.devolverCoordenadaRelativa(0, -1);
        return coordenada;
    }
    
}
