package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;

public interface EstadoUnidad {

    public void moverse(Direccion direccion, Mapa mapa, Coordenada coordenada, Unidad unidad);

    public void atacar(Coordenada objetivo, Mapa mapa);

    public void recibirDanio(Danio danioTerrestre, Danio danioAereo, Unidad unidad);

}
