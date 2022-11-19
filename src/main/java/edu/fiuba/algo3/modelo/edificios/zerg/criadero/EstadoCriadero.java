package edu.fiuba.algo3.modelo.edificios.zerg.criadero;

import edu.fiuba.algo3.modelo.unidades.Unidad;

public interface EstadoCriadero {
    
    public Unidad generarUnidad(Unidad unidad);

    Criadero terminarConstruccion();
  
    Criadero deshacerConstruccion();
  
    void setCriadero(Criadero criadero);
  
    void actualizar();

    int contarLarvas();

    void consumirLarva();
}
