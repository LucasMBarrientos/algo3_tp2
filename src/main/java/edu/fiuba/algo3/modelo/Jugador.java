package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.TieneRecursos;
import edu.fiuba.algo3.modelo.recursos.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Jugador {

    protected Mapa mapa;

    public Inventario inventario;

    public abstract void construirEdificio(Coordenada coord, Edificio edificio);



/*
    protected Mapa mapa;

    protected Inventario inventario = new Inventario();


    protected List<Unidad> unidadesDisponibles = new ArrayList<Unidad>();

    public void establecerMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public Unidad buscarUnidadDisponible(int id) {
        return this.unidadesDisponibles.get(id);
    }

    public void moverUnidad(Unidad unidad, Casilla nuevaCasilla) {
        if (this.mapa.validarMovimiento(unidad, nuevaCasilla)) {
            unidad.intentarMoverse(nuevaCasilla);
        }
    }

    public abstract Casilla generarUnidad(Casilla casilla);



    public abstract void construirEdificio(int x, int y, Edificio edificio); // eliminar esto
    
    public int devolverCantidadGas(){
        return inventario.devolverCantidadGas();
    }

    public int devolverCantidadMinerales(){
        return inventario.devolverCantidadMinerales();
    }


    public void recogerRecursosDeEdificios() {
    }

    public abstract void recogerRecursos();
*/
}
