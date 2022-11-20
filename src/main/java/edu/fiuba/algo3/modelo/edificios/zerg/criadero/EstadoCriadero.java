package edu.fiuba.algo3.modelo.edificios.zerg.criadero;

import java.util.List;

import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public interface EstadoCriadero {
    
    public Unidad generarUnidad(Zangano unidad);

    Criadero terminarConstruccion();
  
    Criadero deshacerConstruccion();
  
    void setCriadero(Criadero criadero);
  
    void actualizar();

    int contarLarvas();

    void consumirLarva();

    void actualizarListaDeCoordenadasConCriaderosOperativos(Coordenada coordenada, List<Coordenada> coordenadasConCriaderos);

}
