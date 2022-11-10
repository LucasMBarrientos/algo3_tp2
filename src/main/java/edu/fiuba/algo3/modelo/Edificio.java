package edu.fiuba.algo3.modelo;

public abstract class Edificio implements Actualizable{

    public int tiempoConstruccion;

    public abstract boolean validarRequerimientosDelCasillero(Casilla casilla);

    public int devolverTiempoConstruccion() {
        return this.tiempoConstruccion;
    }

    public abstract void actualizar();




}
