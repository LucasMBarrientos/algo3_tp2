package edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion;

import edu.fiuba.algo3.modelo.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class ReservaEnConstruccion implements  EstadoReserva{
    private ReservaDeReproduccion reserva;

    @Override
    public Unidad generarUnidad(Edificio edificioConLarvas) throws EdificioNoTerminoDeConstruirse{
        throw new EdificioNoTerminoDeConstruirse();
    }

    @Override
    public ReservaDeReproduccion terminarConstruccion() {
      reserva.setState(new ReservaOperativa());
      return reserva;
    }

    @Override
    public ReservaDeReproduccion deshacerConstruccion() {
      return reserva;
    }

    @Override
    public void setReserva(ReservaDeReproduccion reserva) {
      this.reserva = reserva;
    }

    @Override
    public void actualizar() {
      if(this.reserva.reducirTiempoConstruccion(1)){
        this.terminarConstruccion();
      }
    }
}
