package edu.fiuba.algo3.modelo.unidades.estados;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaTalUnidad;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.List;

public class UnidadOperativa implements EstadoUnidad {

    private Unidad unidad;

    public void moverse(Direccion direccion, Coordenada coordenada) {
        try {
            Mapa.devolverInstancia().establecerUnidad(direccion.hallarCoordenadaSiguiente(coordenada),this.unidad);
            Mapa.devolverInstancia().eliminarUnidad(coordenada);
        } catch (TerrenoNoAptoParaTalUnidad e){
            Mapa.devolverInstancia().establecerUnidad(coordenada, this.unidad);
        }
    }

    public void atacar(Coordenada objetivo) {
        unidad.ejecutarAtaque(objetivo);
    }

    public void recibirDanio(Danio danioTerrestre, Danio danioAereo) {
        unidad.ejecutarDanio(danioTerrestre, danioAereo);
    }

    @Override
    public void actualizar(Inventario inventario) {
      unidad.actualizarUnidad(inventario);
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
        nodo.put("estado", "unidadOperativa");
        return nodo;
    }
}
