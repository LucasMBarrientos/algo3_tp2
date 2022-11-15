package edu.fiuba.algo3.modelo.edificios.protoss.acceso;

import edu.fiuba.algo3.modelo.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class AccesoEnConstruccion implements EstadoAcceso{
    private Acceso acceso;

    public Unidad generarUnidad(Unidad unidad) throws EdificioNoTerminoDeConstruirse{
        throw new EdificioNoTerminoDeConstruirse();
    }

    @Override
    public Acceso terminarConstruccion() {
      acceso.setState(new AccesoOperativo());
      return acceso;
    }

    @Override
    public Acceso deshacerConstruccion() {
      return acceso;
    }

    @Override
    public void setAcceso(Acceso acceso) {
      this.acceso = acceso;
    }

    @Override
    public void actualizar() {
      if(this.acceso.reducirTiempoConstruccion(1)){
        this.terminarConstruccion();
      }
    }
}
