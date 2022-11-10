package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.edificios.Edificio;

public class Zangano extends Unidad implements Actualizable, Constructor {

    Construccion construccion;

    public void actualizar() {
        this.actualizarDisponibilidad();
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
