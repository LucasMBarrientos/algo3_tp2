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

    public void construir(Casilla c) {
        this.construccion = new Construccion(new Criadero(), c);
    }

}
