package edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion;

import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public interface EstadoReserva {
    public Unidad generarUnidad(Criadero criadero);

    ReservaDeReproduccion terminarConstruccion();
  
    ReservaDeReproduccion deshacerConstruccion();
  
    void setReserva(ReservaDeReproduccion reserva);
  
    void actualizar();
}
