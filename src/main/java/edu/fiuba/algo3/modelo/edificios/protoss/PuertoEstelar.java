package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.Casilla;

public class PuertoEstelar extends EdificioProtoss {

    public int tiempoConstruccion;

    public PuertoEstelar() {
        tiempoConstruccion = 10;
        this.requerimientosGas = 150;
        this.requerimientosMinerales = 150;
    }

    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return true;
    }

    public int devolverTiempoConstruccion() {
        return this.tiempoConstruccion;
    }

    public void actualizar() {
        regenerarEscudo();
    }
    
}
