package edu.fiuba.algo3.modelo;

public class Volcan {
    public boolean puedeOcuparse(Ocupante ocupante){
        return ocupante instanceof Extractor || ocupante instanceof Asimilador;
    }
}
