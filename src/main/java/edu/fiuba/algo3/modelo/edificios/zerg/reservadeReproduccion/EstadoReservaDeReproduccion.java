package edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

public interface EstadoReservaDeReproduccion {
    
    public Unidad generarUnidad(Zerling unidad);

    ReservaDeReproduccion terminarConstruccion();
  
    ReservaDeReproduccion deshacerConstruccion();
  
    void establecerReservaDeReproduccion(ReservaDeReproduccion reservaDeReproduccion);
  
    void actualizar();
}
