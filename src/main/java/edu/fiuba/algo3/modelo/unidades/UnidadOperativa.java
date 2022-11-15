package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.direcciones.Direccion;
import edu.fiuba.algo3.modelo.estadisticas.Danio;

public class UnidadOperativa implements EstadoUnidad{

    protected Danio danioAereo;
    protected Danio danioTerrestre;
    protected int rango;

    public UnidadOperativa(Danio danioAereo, Danio danioTerrestre, int rango){
        this.danioAereo= danioAereo;
        this.danioTerrestre = danioTerrestre;
        this.rango = rango;
    }

    public void moverse(Direccion direccion, Mapa mapa, Coordenada coordenada, Unidad unidad){
        Coordenada nuevaPosicion = direccion.siguiente(coordenada);
        Casilla nuevaCasilla =  mapa.buscarCasilla(nuevaPosicion);
        Casilla casillaActual = mapa.buscarCasilla(coordenada);
        if(nuevaCasilla.devolverUnidad() == null) { //
            nuevaCasilla.establecerUnidad(unidad);
            casillaActual.establecerUnidad(null);
        }
    }

    public void atacar (Direccion direccion, Mapa mapa, Coordenada coordenada){
        Coordenada coordenadaDelObjetivo= direccion.siguiente(coordenada);

        for (int i = 0; i < rango; i++) {
            coordenadaDelObjetivo = direccion.siguiente(coordenadaDelObjetivo);
        }

        Casilla casillaDelObjetivo = mapa.buscarCasilla(coordenadaDelObjetivo);
        casillaDelObjetivo.devolverEdificio().recibirGolpe(danioTerrestre);
        //implementar el recibir daño a una unidad
    }



}
