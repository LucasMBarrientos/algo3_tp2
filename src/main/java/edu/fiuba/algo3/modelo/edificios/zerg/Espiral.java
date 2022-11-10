package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.Casilla;

public class Espiral extends EdificioZerg {

    public int tiempoConstruccion;

    public Espiral() {
        tiempoConstruccion = 10;
        this.requerimientosGas = 100;
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
