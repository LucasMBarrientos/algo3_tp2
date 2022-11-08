package edu.fiuba.algo3.modelo;

public class Criadero extends Edificio implements GeneraUnidades{

    private int larvas = 3;

    public Criadero() {

    }

    public void actualizar() {
        if(larvas < 3){
            larvas = larvas + 1;
        }
    }

    public int getLarvas() {
        return larvas;
    }

    public void generarUnidad(Casilla casillaDelGenerador) {
        if (larvas > 0) {
            this.larvas--;
            casillaDelGenerador.establecerOcupante(new Zangano());
        }
    }

    public int larvasDisponibles() {
        return larvas;
    }
}
