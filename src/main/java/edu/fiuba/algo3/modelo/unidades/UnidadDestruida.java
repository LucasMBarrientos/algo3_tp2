package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;

public class UnidadDestruida implements EstadoUnidad{

  @Override
  public void moverse(Direccion direccion, Mapa mapa, Coordenada coordenada, Unidad unidad) throws UnidadEstaDestruida {
    throw new UnidadEstaDestruida();
  }

  @Override
  public void atacar(Coordenada objetivo, Mapa mapa) throws UnidadEstaDestruida {
    throw new UnidadEstaDestruida();
  }

  @Override
  public void recibirDanio(Danio danioTerrestre, Danio danioAereo, Unidad unidad) throws UnidadEstaDestruida {
    throw new UnidadEstaDestruida();
  }

}
