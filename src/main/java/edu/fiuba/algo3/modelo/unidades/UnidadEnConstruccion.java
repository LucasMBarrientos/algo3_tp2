package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.direcciones.Direccion;
import edu.fiuba.algo3.modelo.estadisticas.Danio;

public class UnidadEnConstruccion implements EstadoUnidad{

    public void moverse(Direccion direccion, Mapa mapa, Coordenada coordenada, Unidad unidad){
        throw new UnidadNoTerminoDeConstruirse();
    }

    public void atacar(Direccion direccion, Mapa mapa, Coordenada coordenada){
        throw new UnidadNoTerminoDeConstruirse();
    }
}


