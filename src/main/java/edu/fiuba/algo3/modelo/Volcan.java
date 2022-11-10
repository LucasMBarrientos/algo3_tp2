package edu.fiuba.algo3.modelo;

public class Volcan implements Terreno {

    public boolean validarEdificio(Edificio edificio){
        return (edificio instanceof Extractor || edificio instanceof Asimilador); //distinto de extractor y protoss
    };

    public boolean validarTransitable(Unidad unidad){
        return  (unidad instanceof Zangano);
    }

}
