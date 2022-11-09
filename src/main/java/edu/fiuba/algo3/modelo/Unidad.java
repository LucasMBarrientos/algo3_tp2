package edu.fiuba.algo3.modelo;

public abstract class Unidad implements Ocupante {

    private Casilla casilla;
    private boolean disponible = true;

    public boolean devolverDisponibilidad() {
        return disponible;
    }

    public void establecerCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    public Casilla devolverCasilla() {
        return this.casilla;
    }

    public void intentarMoverse(Casilla nuevaCasilla) {
        if (this.disponible) {
            this.casilla = nuevaCasilla;
            this.disponible = false;
        }
    }

    protected void actualizarDisponibilidad() {
        this.disponible = true;
    }

    public abstract void actualizar();

}