package edu.fiuba.algo3.modelo;

public abstract class Edificio implements Ocupante {

    public int tiempoConstruccion;

    public abstract boolean validarRequerimientosDelCasillero(Casilla casilla);

    public int devolverTiempoConstruccion() {
        return this.tiempoConstruccion;
    }

}
