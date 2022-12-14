package edu.fiuba.algo3.modelo.unidades.estados;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.List;

public class UnidadDestruida implements EstadoUnidad {

    private Unidad unidad;

    @Override
    public void actualizar(Inventario inventario) {
        unidad.destruirse(inventario);
    }

    @Override
    public void moverse(Direccion direccion, Coordenada coordenada) throws UnidadEstaDestruida {
        throw new UnidadEstaDestruida();
    }

    @Override
    public void atacar(Coordenada objetivo) throws UnidadEstaDestruida {
        throw new UnidadEstaDestruida();
    }

    @Override
    public void recibirDanio(Danio danioTerrestre, Danio danioAereo) throws UnidadEstaDestruida {
        throw new UnidadEstaDestruida();
    }

    @Override
    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }


    @Override
    public void terminarConstruccion() {
        return;
    }

    @Override
    public void deshacerConstruccion() {
        return;
    }

    public ObjectNode toData() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("estado", "unidadDestruida");
        return nodo;
    }
}
