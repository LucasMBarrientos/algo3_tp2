package edu.fiuba.algo3.modelo.edificios.zerg.criadero;

import java.util.List;

import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.EdificioDestruido;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public class CriaderoDestruido implements EstadoCriadero {
  private Criadero criadero;

  @Override
  public Unidad generarUnidad(Zangano unidad) throws EdificioDestruido {
    throw new EdificioDestruido();
  }

  @Override
  public void terminarConstruccion() throws EdificioDestruido {
    throw new EdificioDestruido();
  }

  @Override
  public Criadero deshacerConstruccion() throws EdificioDestruido {
    throw new EdificioDestruido();
  }

  @Override
  public void setCriadero(Criadero criadero) {
    this.criadero = criadero;
}

  @Override
  public void actualizar() {}

  @Override
  public int contarLarvas() throws EdificioDestruido {
    throw new EdificioDestruido();
  }

  @Override
  public void consumirLarva() throws EdificioDestruido {
    throw new EdificioDestruido();
  }

  @Override
  public void actualizarListaDeCoordenadasConCriaderosOperativos(Coordenada coordenada,
      List<Coordenada> coordenadasConCriaderos) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void recibirGolpe(Danio danio) {
    throw new EdificioDestruido();
  }

    
}
