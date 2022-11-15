package edu.fiuba.algo3.modelo.edificios.zerg.criadero;

import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public interface EstadoCriadero {

    public Zangano generarZangano();
    
    public Unidad generarUnidad(Unidad unidad);

    Criadero terminarConstruccion();
  
    Criadero deshacerConstruccion();
  
    void setCriadero(Criadero criadero);
  
    void actualizar();

    int contarLarvas();

    void consumirLarva();
}
