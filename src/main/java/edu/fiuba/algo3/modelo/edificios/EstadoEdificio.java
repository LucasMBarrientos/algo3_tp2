package edu.fiuba.algo3.modelo.edificios;

import java.util.List;

import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public interface EstadoEdificio {
  void actualizar(Inventario inventario);

  Unidad generarUnidad(Unidad unidad, Inventario inventario);
  
  void ingresarUnidad(Zangano zangano);

  void recibirGolpe(Danio danio);

  void terminarConstruccion();

  void deshacerConstruccion();

  void setEdificio(Edificio edificio);

  boolean generaTerrenoEnergizado();
  
  void actualizarListaDeCoordenadasConPilonesOperativos(Coordenada coordenada, List<Coordenada> coordenadasConPilones);

  boolean validarLarva();  
}
