package edu.fiuba.algo3.modelo.direcciones;

import edu.fiuba.algo3.modelo.Coordenada;

public interface Direccion {

    Coordenada siguiente(Coordenada posicion);
}
