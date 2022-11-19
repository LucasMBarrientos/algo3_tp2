package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.excepciones.UnidadNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;

public class UnidadEnConstruccion implements EstadoUnidad {

    public void moverse(Direccion direccion, Mapa mapa, Coordenada coordenada, Unidad unidad) {
        throw new UnidadNoTerminoDeConstruirse();
    }

    @Override
    public void atacar(Coordenada objetivo, Mapa mapa) {

    }

}
