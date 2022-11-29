package edu.fiuba.algo3.modelo.edificios;

import java.util.List;

import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public class EdificioEnConstruccion implements EstadoEdificio {
  private Edificio edificio;

  @Override
  public void recibirDanio(Danio danio) throws EdificioNoTerminoDeConstruirse {
    throw new EdificioNoTerminoDeConstruirse();
  }

  public Unidad generarUnidad(Unidad unidad,Inventario inventario) throws EdificioNoTerminoDeConstruirse {
    throw new EdificioNoTerminoDeConstruirse();
  }

  @Override
  public void actualizar(Inventario inventario) {
    if(this.edificio.reducirTiempoConstruccion(1)){
      this.edificio.agregarSuministro(inventario);
      this.terminarConstruccion();
    }
  }

  @Override
  public void terminarConstruccion() {
    edificio.establecerEstado(this.edificio.estadoOperativo);
  }

  @Override
  public void setEdificio(Edificio edificio) {
    this.edificio = edificio;
  }

  @Override
  public void deshacerConstruccion() {}



  public void actualizarListasDeCoordenadas(List<Coordenada> coordenadasConCriaderos, List<Coordenada> coordenadasConPilones) {
      return;
  }

  @Override
  public void ingresarUnidad(Zangano zangano) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public boolean consumirLarva(int larvas) {
    return false;
  }
  
}
