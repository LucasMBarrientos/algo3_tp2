package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.Unidad;

public class TerrenoVacio  {

    public boolean validarEdificio(Edificio edificio){
        return false;
    };

    public boolean validarTransitable(Unidad unidad){
        return true;
    }

}
