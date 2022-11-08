package edu.fiuba.algo3.modelo;

public class Zangano extends Unidad {

    Construccion construccion;

    public void actualizar() {
        if (this.construccion != null) {
            boolean construccionTerminada = this.construccion.continuar();
            if (construccionTerminada) {
                this.construccion.finalizar();
            }
        }
    }

    public void construir(Edificio edificio, Casilla casilla) {
        this.construccion = new Construccion(edificio, casilla);
    }

}
