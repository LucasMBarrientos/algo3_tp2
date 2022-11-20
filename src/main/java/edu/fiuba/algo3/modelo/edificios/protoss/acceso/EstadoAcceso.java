package edu.fiuba.algo3.modelo.edificios.protoss.acceso;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public interface EstadoAcceso {
    
    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Mineral mineral, Coordenada coordenada);

    Acceso terminarConstruccion();
  
    Acceso deshacerConstruccion();
  
    void setAcceso(Acceso acceso);
  
    void actualizar();

}
