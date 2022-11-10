package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.Casilla;

public class Acceso extends Edificio {

    public int tiempoConstruccion;

    public Acceso() {
        tiempoConstruccion = 8;
        this.requerimientosGas = 0;
        this.requerimientosMinerales = 150;
    }

    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return true;
    }

    public int devolverTiempoConstruccion() {
        return this.tiempoConstruccion;
    }

    public void actualizar() {

    }

}
