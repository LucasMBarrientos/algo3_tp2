package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.Casilla;

public class Guarida extends EdificioZerg {

    public Guarida() {
        this.tiempoConstruccion = 12;
        this.requerimientosGas = 100;
        this.requerimientosMinerales = 200;
    }

    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return true;
    }

    public void actualizar() {
        regenerarVida();
    }
}
