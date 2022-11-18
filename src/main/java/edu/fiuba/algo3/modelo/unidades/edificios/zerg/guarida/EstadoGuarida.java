package edu.fiuba.algo3.modelo.unidades.edificios.zerg.guarida;

import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.unidades.edificios.Edificio;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public interface EstadoGuarida {

    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespenoDelJugador, Minerales mineralesDelJugador, Coordenada coordenada);

    Guarida terminarConstruccion();
  
    Guarida deshacerConstruccion();
  
    void setGuarida(Guarida guarida);
  
    void actualizar();
}
