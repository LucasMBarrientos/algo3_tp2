package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.edificios.Edificio;

public class ConstruccionProtoss extends Unidad implements Constructor{

    private Construccion construccion;

    public ConstruccionProtoss(Edificio edificio, Casilla casilla) {
        this.construccion = new Construccion(edificio, casilla);
    }

    @Override
    public void actualizar() {
        if (this.construccion != null) {
            boolean construccionTerminada = this.construccion.continuar();
            if (construccionTerminada) {
                this.construccion.finalizar();
            }
        }
    }

    @Override
    public void construir(Edificio edificio, Casilla casilla) {}
}
