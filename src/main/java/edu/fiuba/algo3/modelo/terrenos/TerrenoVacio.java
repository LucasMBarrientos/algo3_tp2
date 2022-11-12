package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.Unidad;

public class TerrenoVacio extends Terreno {

    protected boolean validarEdificio(Edificio edificio){
        return false;
    };

    protected boolean validarTransitable(Unidad unidad){
        return true;
    }

}
