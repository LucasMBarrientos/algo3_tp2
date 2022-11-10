package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Actualizable;
import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.recursos.*;

public abstract class Edificio implements Actualizable {

    public int tiempoConstruccion;
    public int requerimientosGas;
    public int requerimientosMinerales;

    public abstract boolean validarRequerimientosDelCasillero(Casilla casilla);

    public int devolverTiempoConstruccion() {
        return this.tiempoConstruccion;
    }

    public int devolverRequerimientosDeMinerales() {
        return requerimientosMinerales;
    }

    public int devolverRequerimientosDeGas() {
        return requerimientosGas;
    }

    public abstract void actualizar();




}
