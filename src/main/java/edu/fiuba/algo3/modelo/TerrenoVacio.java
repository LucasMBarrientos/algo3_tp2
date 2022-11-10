package edu.fiuba.algo3.modelo;

public class TerrenoVacio implements Terreno {

    public boolean validarEdificio(Edificio edificio){
        return false;
    };

    public boolean validarTransitable(Unidad unidad){
        return true;
    }

}
