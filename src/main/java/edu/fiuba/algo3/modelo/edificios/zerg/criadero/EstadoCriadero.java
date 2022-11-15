package edu.fiuba.algo3.modelo.edificios.zerg.criadero;

import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public interface EstadoCriadero {
    
    public Unidad generarUnidad(Unidad unidad);

    Criadero terminarConstruccion();
  
    Criadero deshacerConstruccion();
  
    void setCriadero(Criadero criadero);
  
    void actualizar();

    int contarLarvas();

    void consumirLarva();
}
