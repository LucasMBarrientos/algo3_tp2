package edu.fiuba.algo3.modelo;

public class Volcan implements Terreno {

    public boolean validarOcupante(Ocupante ocupante) {
        return (ocupante instanceof Extractor || ocupante instanceof Asimilador);
    }

}
