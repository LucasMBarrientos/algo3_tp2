package edu.fiuba.algo3.modelo;

public abstract class Unidad implements Ocupante {

    Casilla casilla;

    public void establecerCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    public Casilla devolverCasilla() {
        return this.casilla;
    }

    public abstract void actualizar();

}