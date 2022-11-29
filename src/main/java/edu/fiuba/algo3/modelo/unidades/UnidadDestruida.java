package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;
import edu.fiuba.algo3.modelo.jugadores.Inventario;

public class UnidadDestruida implements EstadoUnidad{
  protected Unidad unidad;

  @Override
  public void actualizar(Inventario inventario) {
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
  public void terminarConstruccion() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void deshacerConstruccion() {
    // TODO Auto-generated method stub
    
  }

 

}