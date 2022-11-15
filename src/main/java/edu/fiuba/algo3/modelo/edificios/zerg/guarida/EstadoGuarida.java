package edu.fiuba.algo3.modelo.edificios.zerg.guarida;

import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public interface EstadoGuarida {

    public Unidad generarUnidad(Criadero criadero);

    Guarida terminarConstruccion();
  
    Guarida deshacerConstruccion();
  
    void setGuarida(Guarida guarida);
  
    void actualizar();
}
