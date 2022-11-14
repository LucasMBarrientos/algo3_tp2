package edu.fiuba.algo3.modelo;

public abstract class Unidad { // seguramente deba ser abstracta

    protected int requerimientosMinerales = 0;
    protected int requerimientosGas = 0;
    protected int tiempoConstruccion = 1;
    protected int danioAereo = 0;
    protected int danioTerrestre = 0;
    protected int rango = 0;
    protected int vida = 1;
    protected boolean aerea = false;

    public int devolverRequerimientosDeGas() {
        return requerimientosGas;
    }

    public int devolverRequerimientosMinerales() {
        return requerimientosMinerales;
    }

    public int devolverTiempoConstruccion() {
        return tiempoConstruccion;
    }

    public int devolverDanio() {
        return requerimientosMinerales;
    }

    public int devolverVida() {
        return vida;
    }

    public int devolverRango() {
        return rango;
    }

    public boolean esAerea() {
        return aerea;
    }

/*
    protected boolean disponible = true;

    public boolean devolverDisponibilidad() {
        return disponible;
    }

    public boolean intentarMoverse(Casilla nuevaCasilla) {
        if (this.disponible) {
            this.disponible = false;
            return true;
        }
        return false;
    }

    protected void actualizarDisponibilidad() {
        this.disponible = true;
    }

    public int emitirDanio() {
        this.disponible = false;
        return 100;
    }

    public abstract void actualizar();
*/
}