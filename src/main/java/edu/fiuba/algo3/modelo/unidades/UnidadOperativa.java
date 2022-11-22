package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;

public class UnidadOperativa implements EstadoUnidad {

    protected Danio danioAereo;
    protected Danio danioTerrestre;
    protected int rango;
    protected Coordenada coordenada;

    public UnidadOperativa(Danio danioAereo, Danio danioTerrestre, int rango, Coordenada coordenada) {
        this.danioAereo= danioAereo;
        this.danioTerrestre = danioTerrestre;
        this.rango = rango;
        this.coordenada = coordenada;
    }

    public void moverse(Direccion direccion, Mapa mapa, Coordenada coordenada, Unidad unidad) {

       //Coordenada coordenadaNueva = direccion.hallarCoordenadaSiguiente(coordenada);
        mapa.establecerUnidad(direccion.hallarCoordenadaSiguiente(coordenada),unidad);
       // mapa.establecerUnidadDelMapa(coordenadaNueva,unidad);
    }

    public void atacar(Coordenada objetivo, Mapa mapa) {
        if(this.coordenada.seEncuentraACiertoRangoDeOtraCoordenada(objetivo, rango)){
            mapa.buscarTerreno(objetivo).recibirGolpe(danioTerrestre,danioAereo); //la logica seria pasarle ambos daños, q despues la unidad objetivo se encargue de ver cual
        }
    }

}
