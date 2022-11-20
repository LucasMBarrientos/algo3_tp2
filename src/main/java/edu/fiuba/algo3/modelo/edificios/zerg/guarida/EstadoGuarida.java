package edu.fiuba.algo3.modelo.edificios.zerg.guarida;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public interface EstadoGuarida {

    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespenoDelJugador, Mineral mineralDelJugador, Coordenada coordenada);

    Guarida terminarConstruccion();
  
    Guarida deshacerConstruccion();
  
    void establecerGuarida(Guarida guarida);
  
    void actualizar();
}
