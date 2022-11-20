package edu.fiuba.algo3.modelo.edificios.zerg.guarida;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;

public interface EstadoGuarida {

    public Unidad generarUnidad(Hidralisco unidad);
    Guarida terminarConstruccion();
  
    Guarida deshacerConstruccion();
  
    void establecerGuarida(Guarida guarida);
  
    void actualizar();
}
