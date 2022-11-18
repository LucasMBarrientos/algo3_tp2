package edu.fiuba.algo3.modelo.unidades.edificios.protoss.puertoEstelar;

import edu.fiuba.algo3.modelo.unidades.Unidad;

public interface EstadoPuertoEstelar {

    public Unidad generarUnidad(Unidad unidad);

    PuertoEstelar terminarConstruccion();
  
    PuertoEstelar deshacerConstruccion();
  
    void setPuertoEstelar(PuertoEstelar puertoEstelar);
  
    void actualizar();
}
