package edu.fiuba.algo3.modelo.unidades.edificios;

import java.util.List;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.terrenos.EstadoTerreno;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;


public abstract class Edificio  {

    public boolean generaTerrenoEnergizado() {
        return false;
    }

    public abstract Edificio construir(Inventario inventario);
    
    public abstract List<EstadoTerreno> posiblesEstados();

    protected abstract void consumirRecursosParaConstruccion(Inventario inventario);

    public abstract boolean validarCorrelativas(Inventario inventario);

    public abstract void ocupar(Casilla casilla, Terreno terreno);

    public abstract void establecerTerreno(Terreno terreno);
    
    //public abstract void recibirGolpe(int danio);

    public abstract void actualizar();

    public abstract boolean compararCon(Edificio edificoAComparar);

    public abstract String devolverNombre();

    public abstract Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespenoDelJugador, Minerales mineralesDelJugador, Coordenada coordenada);

    public Unidad consumirLarvasYGenerarUnidad(Unidad unidad) {
        return null;
    }

    public abstract void recibirGolpe(Danio danio);

    public int contarLarvas() {
        return 0;
    }

    public void consumirLarva() {
        return;
    }

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

    public abstract void ocupar(Casilla casilla, Terreno terreno);


    public abstract boolean recibirDanio(int unidades);

    public void reducirVida(int unidades) {
        this.vida -= unidades;
    }

    public int devolverVida(){
        return vida;
    }*/
}
