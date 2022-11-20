package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;

public class UnidadOperativa implements EstadoUnidad {

    protected Danio danioAereo;
    protected Danio danioTerrestre;
    protected int rango;

    public UnidadOperativa(Danio danioAereo, Danio danioTerrestre, int rango) {
        this.danioAereo= danioAereo;
        this.danioTerrestre = danioTerrestre;
        this.rango = rango;
    }

    public void moverse(Direccion direccion, Mapa mapa, Coordenada coordenada, Unidad unidad) {
        Coordenada nuevaPosicion = direccion.hallarCoordenadaSiguiente(coordenada);
        Casilla nuevaCasilla =  mapa.buscarCasilla(nuevaPosicion);
        Casilla casillaActual = mapa.buscarCasilla(coordenada);
        if(nuevaCasilla.devolverUnidad() == null) { //
            nuevaCasilla.establecerUnidad(unidad);
            casillaActual.establecerUnidad(null);
        }
    }

    public void atacar(Coordenada objetivo, Mapa mapa) {
        if(this.coordenada.seEncuentraACiertoRangoDeOtraCoordenada(objetivo, rango)){
            mapa.buscarTerreno(objetivo).recibirGolpe(danioTerrestre,danioAereo); //la logica seria pasarle ambos daños, q despues la unidad objetivo se encargue de ver cual
        }
    }

}
