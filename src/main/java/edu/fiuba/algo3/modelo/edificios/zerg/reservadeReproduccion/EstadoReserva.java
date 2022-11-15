package edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public interface EstadoReserva {
    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Minerales minerales);

    ReservaDeReproduccion terminarConstruccion();
  
    ReservaDeReproduccion deshacerConstruccion();
  
    void setReserva(ReservaDeReproduccion reserva);
  
    void actualizar();
}
