package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.Casilla;

public class Guarida extends Edificio {

    public int tiempoConstruccion;

    public Guarida() {
        tiempoConstruccion = 12;
        this.requerimientosGas = 100;
        this.requerimientosMinerales = 200;
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
