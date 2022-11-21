package edu.fiuba.algo3.modelo.edificios.protoss.acceso;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;

public interface EstadoAcceso {

    public Unidad generarUnidad(Zealot unidad);
    public Unidad generarUnidad(Dragon unidad);

    Acceso terminarConstruccion();
  
    Acceso deshacerConstruccion();
  
    void setAcceso(Acceso acceso);
  
    void actualizar();

}
