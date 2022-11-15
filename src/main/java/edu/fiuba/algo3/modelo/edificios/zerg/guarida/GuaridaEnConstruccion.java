package edu.fiuba.algo3.modelo.edificios.zerg.guarida;

import edu.fiuba.algo3.modelo.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class GuaridaEnConstruccion implements EstadoGuarida {
    private Guarida guarida;

    @Override
    public Unidad generarUnidad(Criadero criadero) throws EdificioNoTerminoDeConstruirse{
        throw new EdificioNoTerminoDeConstruirse();
    }

    @Override
    public Guarida terminarConstruccion() {
      guarida.setState(new GuaridaOperativa());
      return guarida;
    }

    @Override
    public Guarida deshacerConstruccion() {
      return guarida;
    }

    @Override
    public void setGuarida(Guarida guarida) {
      this.guarida = guarida;
    }

    @Override
    public void actualizar() {
      if(this.guarida.reducirTiempoConstruccion(1)){
        this.terminarConstruccion();
      }
    }
}
