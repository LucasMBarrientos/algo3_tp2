package edu.fiuba.algo3.modelo;

public class Criadero extends Edificio implements GeneradorDeUnidades, Actualizable {

    private int larvas;

    public Criadero() {
        this.larvas = 3;
        this.tiempoConstruccion = 4;
    }

    public void actualizar() {
        if (larvas < 3) {
            this.larvas++;
        }
    }

    public int devolverCantidadDeLarvas() {
        return this.larvas;
    }

    public Unidad generarUnidad(Casilla casilla) {
        Unidad unidadGenerada = null;
        if (larvas > 0) {
            unidadGenerada = new Zangano();
            this.larvas--;
            casilla.establecerOcupante(unidadGenerada);
        }
        return unidadGenerada;
    }
    
}
