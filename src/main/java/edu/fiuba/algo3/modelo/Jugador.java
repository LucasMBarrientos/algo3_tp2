package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.direcciones.Direccion;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.TieneRecursos;
import edu.fiuba.algo3.modelo.excepciones.UnidadInexistente;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.ArrayList;
import java.util.List;

public abstract class Jugador {

    protected int id;
    protected Mapa mapa;
    public Inventario inventario;
    protected String nombre;
    protected String color;

    public void construirEdificio(Coordenada coordenada, Edificio edificio) {
        this.construirEdificio(mapa.buscarCasilla(coordenada), edificio);
    }

    public void construirEdificio(Casilla casilla, Edificio edificio) {
        casilla.ponerEdificio(edificio.construir(inventario));
    }

    protected void establecerAtributosBasicos(String nombre, String color, int gasInicial, int mineralesIniciales) {
        this.nombre = nombre;
        this.color = color;
        this.inventario = new Inventario(new GasVespeno(gasInicial), new Minerales(mineralesIniciales));
    }

    public Casilla hallarCasillaConVolcanInicial() {
        return mapa.hallarVolcanInicialDelJugador(id);
    }

    public List<Casilla> hallarCasillasConMineralesIniciales() {
        return mapa.hallarMineralesInicialesDelJugador(id);
    }

    public Casilla hallarCasillaConEdificioInicial() {
        return mapa.hallarCasillaConEdificioInicialDelJugador(id);
    }

    public void establecerMapa(Mapa mapa) {
        this.mapa = mapa;
        iniciarseEnMapa();
    }

    public abstract void generarUnidad(Coordenada coordenada);

    protected abstract void iniciarseEnMapa();

    public void establecerId(int id) {
        this.id = id;
    }

    public void moverUnidad(Casilla casillaUnidad, Direccion direccion){
        Unidad unidad = casillaUnidad.devolverUnidad();
        if(unidad == null) {
            throw new UnidadInexistente();
        }
        unidad.moverse(direccion, mapa);
    }

    public void moverUnidad(Coordenada coordenadaUnidad, Direccion direccion){
        Casilla casillaUnidad = mapa.buscarCasilla(coordenadaUnidad);
        moverUnidad(casillaUnidad, direccion);
    }
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
