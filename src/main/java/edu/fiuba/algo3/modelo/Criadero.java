package edu.fiuba.algo3.modelo;

public class Criadero extends Edificio implements GeneraUnidades {

    private int larvas;

    public Criadero() {
        larvas = 0;
    }

    public void actualizar() {
        if (larvas < 3) {
            this.larvas++;
        }
    }

    public int devolverCantidadDeLarvas() {
        return larvas;
    }

    public void generarUnidad(Casilla casilla) {
        if (larvas > 0) {
            this.larvas--;
            casilla.establecerOcupante(new Zangano());
        }
    }

    public int larvasDisponibles() {
        return larvas;
    }
}
