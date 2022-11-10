package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Actualizable;
import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.Inventario;

public abstract class Edificio implements Actualizable {

    public int tiempoConstruccion;
    public int requerimientosGas;
    public int requerimientosMinerales;
    public int vidaMax;
    public int vida;

    public abstract boolean validarRequerimientosDelCasillero(Casilla casilla);

    public int devolverTiempoConstruccion() {
        return this.tiempoConstruccion;
    }

    public boolean validarRequirimientos(Inventario inventario) {
        boolean requerimientosDeGasAlcanzados = inventario.devolverCantidadGas() >= requerimientosGas;
        boolean requerimientosDeMineralesAlcanzados = inventario.devolverCantidadMinerales() >= requerimientosMinerales;
        return requerimientosDeGasAlcanzados && requerimientosDeMineralesAlcanzados;
    }

    public void consumirRecursosDelJugador(Inventario inventario) {
        inventario.restarGas(requerimientosGas);
        inventario.restarMinerales(requerimientosMinerales);
    }

    public int devolverRequerimientosDeMinerales() {
        return requerimientosMinerales;
    }

    public int devolverRequerimientosDeGas() {
        return requerimientosGas;
    }

    public abstract void actualizar();


    public abstract boolean recibirDanio(int unidades);

    public void reducirVida(int unidades) {
        this.vida -= unidades;
    }

}
