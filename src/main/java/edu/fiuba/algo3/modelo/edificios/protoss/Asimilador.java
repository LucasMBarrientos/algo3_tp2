package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.Edificio;

public class Asimilador extends Edificio {

    public Asimilador() {
        this.tiempoConstruccion = 6;
        this.requerimientosGas = 0;
        this.requerimientosMinerales = 100;
    }
    @Override
    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return false;
    }

    @Override
    public void actualizar() {

    }
}