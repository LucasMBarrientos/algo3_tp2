package edu.fiuba.algo3.modelo.edificios.protoss.acceso;

import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public interface EstadoAcceso {
    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Minerales minerales, Coordenada coordenada);

    Acceso terminarConstruccion();
  
    Acceso deshacerConstruccion();
  
    void setAcceso(Acceso acceso);
  
    void actualizar();
}
