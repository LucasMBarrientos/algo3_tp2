package edu.fiuba.algo3.modelo.edificios;

import java.util.List;

import edu.fiuba.algo3.modelo.Actualizable;
import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.Coordenada;


public abstract class Edificio implements Actualizable {

    public boolean generaTerrenoEnergizado() {
        return false;
    }


    public abstract void construirse(Casilla casilla, Inventario inventario);

    protected abstract void consumirRecursosParaConstruccion(Inventario inventario);

    //public abstract void recibirGolpe(int danio);

    
/*
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

    public void consumirRecursos(Recursos recursos){

    }


    public abstract boolean recibirDanio(int unidades);

    public void reducirVida(int unidades) {
        this.vida -= unidades;
    }

    public int devolverVida(){
        return vida;
    }*/
}
