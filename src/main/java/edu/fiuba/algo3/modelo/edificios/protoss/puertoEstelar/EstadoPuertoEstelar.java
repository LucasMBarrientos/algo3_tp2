package edu.fiuba.algo3.modelo.edificios.protoss.puertoEstelar;

import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;

public interface EstadoPuertoEstelar {

    public Unidad generarUnidad(Scout unidad);

    PuertoEstelar terminarConstruccion();
  
    PuertoEstelar deshacerConstruccion();
  
    void setPuertoEstelar(PuertoEstelar puertoEstelar);
  
    void actualizar();
}
