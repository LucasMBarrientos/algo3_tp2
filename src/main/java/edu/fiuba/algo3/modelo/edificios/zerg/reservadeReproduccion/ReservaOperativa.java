package edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion;

import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

public class ReservaOperativa implements EstadoReserva {
    private ReservaDeReproduccion reserva;

    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Minerales minerales, Coordenada coordenada) {
        return edificioConLarvas.consumirLarvasYGenerarUnidad(new Zerling(gasVespeno, minerales, coordenada));
    }
    
    @Override
    public ReservaDeReproduccion terminarConstruccion() {return reserva;}

    @Override
    public ReservaDeReproduccion deshacerConstruccion() {
      reserva.setState(new ReservaEnConstruccion());
      return reserva;
    }

    @Override
    public void setReserva(ReservaDeReproduccion reserva) {
      this.reserva = reserva;
    }

    @Override
    public void actualizar() {
      this.reserva.vida.regenerar();
    }
}
