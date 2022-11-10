package edu.fiuba.algo3.modelo;

public class Moho implements Terreno, Actualizable {

    public boolean validarEdificio(Edificio edificio){
        return (edificio instanceof Criadero); //distinto de extractor y protoss
    };

    public boolean validarTransitable(Unidad unidad){
        return true;
    }
    public void actualizar() {
        // Expandir el moho a su alrededor
    }

}