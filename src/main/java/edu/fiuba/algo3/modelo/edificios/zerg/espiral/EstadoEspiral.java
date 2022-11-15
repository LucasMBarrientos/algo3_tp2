package edu.fiuba.algo3.modelo.edificios.zerg.espiral;

import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public interface EstadoEspiral {

    public Unidad generarUnidad(Criadero criadero);

    Espiral terminarConstruccion();
  
    Espiral deshacerConstruccion();
  
    void setEspiral(Espiral espiral);
  
    void actualizar();
}
