package edu.fiuba.algo3.modelo.edificios;

import java.util.List;

import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public class EdificioDestruido implements EstadoEdificio {
  private Edificio edificio;

  @Override
  public void recibirGolpe(Danio danio) throws EdificioEstaDestruido {
    throw new EdificioEstaDestruido();
  }

  @Override
  public void actualizar(Inventario inventario) {}

  public Unidad generarUnidad(Unidad unidad,Inventario inventario) throws EdificioEstaDestruido {
    throw new EdificioEstaDestruido();
  }

  @Override
  public void terminarConstruccion() {}

  @Override
  public void setEdificio(Edificio edificio) {
    this.edificio = edificio;
  }

  @Override
  public void deshacerConstruccion() {}

  @Override
  public boolean generaTerrenoEnergizado() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void actualizarListaDeCoordenadasConPilonesOperativos(Coordenada coordenada,
      List<Coordenada> coordenadasConPilones) {}

  @Override
  public void ingresarUnidad(Zangano zangano) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public boolean validarLarva() {
    return false;
  }
  
}
