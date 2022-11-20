package edu.fiuba.algo3.modelo.geometria.direcciones;

import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;

public class Abajo implements Direccion {

    public Coordenada hallarCoordenadaSiguiente(Coordenada posicionActual) {
        return posicionActual.devolverCoordenadaRelativa(0,1);
    }

}
