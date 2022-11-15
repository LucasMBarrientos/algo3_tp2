package edu.fiuba.algo3.modelo.edificios.zerg.espiral;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public interface EstadoEspiral {

    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Minerales minerales);

    Espiral terminarConstruccion();
  
    Espiral deshacerConstruccion();
  
    void setEspiral(Espiral espiral);
  
    void actualizar();
}
