package edu.fiuba.algo3.modelo.unidades;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;
import edu.fiuba.algo3.modelo.jugadores.Inventario;

import java.util.List;

public class UnidadDestruida implements EstadoUnidad{
  protected Unidad unidad;

  @Override
  public void actualizar(Inventario inventario) {
      unidad.destruirse(inventario);
  }

  @Override
  public void moverse(Direccion direccion, Mapa mapa, Coordenada coordenada) throws UnidadEstaDestruida {
    throw new UnidadEstaDestruida();
  }

  @Override
  public void atacar(Coordenada objetivo, Mapa mapa) throws UnidadEstaDestruida {
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
  public void actualizarListaDeCoordenadasVisibles(List<Coordenada> coordenadasAVisibilizar){}

  @Override
  public void terminarConstruccion() {}

  @Override
  public void deshacerConstruccion() { }

  public ObjectNode toData() {
    ObjectNode nodo = Json.createObjectNode();
    nodo.put("estado", "unidadDestruida");
    return nodo;
  }

 

}
