package edu.fiuba.algo3.modelo.edificios.protoss.acceso;

import edu.fiuba.algo3.modelo.unidades.Unidad;

public interface EstadoAcceso {
    public Unidad generarUnidad(Unidad unidad);

    Acceso terminarConstruccion();
  
    Acceso deshacerConstruccion();
  
    void setAcceso(Acceso acceso);
  
    void actualizar();
}
