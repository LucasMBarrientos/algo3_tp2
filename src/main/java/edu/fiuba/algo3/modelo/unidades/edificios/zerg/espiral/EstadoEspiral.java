package edu.fiuba.algo3.modelo.unidades.edificios.zerg.espiral;

import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.unidades.edificios.Edificio;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public interface EstadoEspiral {

    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Minerales minerales, Coordenada coordenada);

    Espiral terminarConstruccion();
  
    Espiral deshacerConstruccion();
  
    void setEspiral(Espiral espiral);
  
    void actualizar();
}
