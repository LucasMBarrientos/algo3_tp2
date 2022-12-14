package edu.fiuba.algo3.modelo.unidades.estados;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.UnidadNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.List;

public class UnidadEnConstruccion implements EstadoUnidad {

    private Unidad unidad;
    
    public void moverse(Direccion direccion, Coordenada coordenada) {
        throw new UnidadNoTerminoDeConstruirse();
    }

    @Override
    public void atacar(Coordenada objetivo) {
      throw new UnidadNoTerminoDeConstruirse();
    }

    public void recibirDanio(Danio danioTerrestre, Danio danioAereo) {
      this.unidad.ejecutarDanio(danioTerrestre, danioAereo);
    }

    @Override
    public void actualizar(Inventario inventario) {
        if (unidad.reducirTiempoConstruccion(1)) {
            unidad.agregarSuministro(inventario);
            terminarConstruccion();
        }
    }

    @Override
    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;      
    }

    @Override
    public void terminarConstruccion() {
        unidad.establecerEstado(new UnidadOperativa());      
    }

    @Override
    public void deshacerConstruccion() {
      
    }


    public ObjectNode toData() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("estado", "unidadEnConstruccion");
        return nodo;
    }
}
