package edu.fiuba.algo3.modelo.unidades.edificios.protoss.puertoEstelar;

import edu.fiuba.algo3.modelo.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class PuertoEstelarEnConstruccion implements EstadoPuertoEstelar{
    private PuertoEstelar puertoEstelar;
    public Unidad generarUnidad(Unidad unidad) throws EdificioNoTerminoDeConstruirse {
        throw new EdificioNoTerminoDeConstruirse();
    }

    @Override
    public PuertoEstelar terminarConstruccion() {
      puertoEstelar.setState(new PuertoEstelarOperativo());
      return puertoEstelar;
    }

    @Override
    public PuertoEstelar deshacerConstruccion() {
      return puertoEstelar;
    }

    @Override
    public void setPuertoEstelar(PuertoEstelar puertoEstelar) {
      this.puertoEstelar = puertoEstelar;
    }

    @Override
    public void actualizar() {
      if(this.puertoEstelar.reducirTiempoConstruccion(1)){
        this.terminarConstruccion();
      }
    }
}
