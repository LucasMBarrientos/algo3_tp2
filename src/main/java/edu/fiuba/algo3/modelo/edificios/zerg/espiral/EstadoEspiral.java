package edu.fiuba.algo3.modelo.edificios.zerg.espiral;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;

public interface EstadoEspiral {

    public Unidad generarUnidad(Mutalisco unidad);
    Espiral terminarConstruccion();
  
    Espiral deshacerConstruccion();
  
    void setEspiral(Espiral espiral);
  
    void actualizar();
}
