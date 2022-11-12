package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.Unidad;

public abstract class Terreno {

    protected abstract boolean validarEdificio(Edificio edificio);

    protected abstract boolean validarTransitable(Unidad unidad);

}
