package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.Casilla;

public class ReservaDeReproduccion extends EdificioZerg {

    public int tiempoConstruccion;

    public ReservaDeReproduccion() {
        tiempoConstruccion = 12;
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
        regenerarVida();
    }

}
