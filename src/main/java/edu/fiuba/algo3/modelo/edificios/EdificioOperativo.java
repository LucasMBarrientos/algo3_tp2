package edu.fiuba.algo3.modelo.edificios;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadProtoss;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public class EdificioOperativo implements EstadoEdificio {
  protected Edificio edificio;

  public void recibirDanio(Danio danio) {
    this.edificio.ejecutarDanio(danio);
  }

  @Override
  public void actualizar(Inventario inventario) {
    edificio.actualizarEdificio(inventario);
  }

  @Override
  public void ingresarUnidad(Unidad unidad) {
    this.edificio.ingresarUnidadTrabajadora(unidad);
  }
  
  @Override
  public void terminarConstruccion() {}

  @Override
  public void setEdificio(Edificio edificio) {
    this.edificio = edificio;
  }

  @Override
  public void deshacerConstruccion() {
    edificio.establecerEstado(this.edificio.estadoConstruccion);
  }

    public void actualizarListasDeCoordenadas(List<Coordenada> coordenadasConCriaderos, List<Coordenada> coordenadasConPilones) {
        edificio.actualizarListasDeCoordenadasSegunEdificio(coordenadasConCriaderos, coordenadasConPilones);
    }
  
  public Unidad generarUnidad(Unidad unidad,Inventario inventario)  {
    unidad.consumirRecursosParaGenerarse(inventario);
    return unidad;
  }

  @Override
  public boolean consumirLarva(int larvas) {
    if (larvas <= 0) {
      return false;
    }else{
      return true;
    }
  }

  public ObjectNode toData() {
    ObjectNode node = Json.createObjectNode();
    node.put("estado", "edificioOperativo");
    return node;
  }

}
