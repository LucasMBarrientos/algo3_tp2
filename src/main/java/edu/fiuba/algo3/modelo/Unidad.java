package edu.fiuba.algo3.modelo;

public abstract class Unidad {


    private boolean disponible = true;

    public boolean devolverDisponibilidad() {
        return disponible;
    }


    public void intentarMoverse(Casilla nuevaCasilla) {
        if (this.disponible) {
            this.disponible = false;
        }
    }

    protected void actualizarDisponibilidad() {
        this.disponible = true;
    }

    public abstract void actualizar();

}