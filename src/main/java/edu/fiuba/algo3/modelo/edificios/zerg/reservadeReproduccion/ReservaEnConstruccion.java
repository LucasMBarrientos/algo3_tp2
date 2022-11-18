package edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion;

import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class ReservaEnConstruccion implements  EstadoReserva {

    private ReservaDeReproduccion reservaDeReproduccion;

    @Override
    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Minerales minerales, Coordenada coordenada) throws EdificioNoTerminoDeConstruirse{
        throw new EdificioNoTerminoDeConstruirse();
    }

    @Override
    public ReservaDeReproduccion terminarConstruccion() {
        reservaDeReproduccion.setState(new ReservaOperativa());
        return reservaDeReproduccion;
    }

    @Override
    public ReservaDeReproduccion deshacerConstruccion() {
      return reservaDeReproduccion;
    }

    @Override
    public void setReserva(ReservaDeReproduccion reservaDeReproduccion) {
        this.reservaDeReproduccion = reservaDeReproduccion;
    }

    @Override
    public void actualizar() {
      if(this.reservaDeReproduccion.reducirTiempoConstruccion(1)){
        this.terminarConstruccion();
      }
    }
}
