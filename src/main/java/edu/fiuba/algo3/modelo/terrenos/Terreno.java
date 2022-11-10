package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.Unidad;

public interface Terreno {

    boolean validarEdificio(Edificio edificio);

    boolean validarTransitable(Unidad unidad);

}
