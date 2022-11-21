package edu.fiuba.algo3.modelo.edificios.protoss.puertoEstelar;

import edu.fiuba.algo3.modelo.excepciones.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;

public class PuertoEstelarEnConstruccion implements EstadoPuertoEstelar {

    private PuertoEstelar puertoEstelar;

    public Unidad generarUnidad(Scout unidad) throws EdificioNoTerminoDeConstruirse {
        throw new EdificioNoTerminoDeConstruirse();
    }

    @Override
    public PuertoEstelar terminarConstruccion() {
      puertoEstelar.establecerEstado(new PuertoEstelarOperativo());
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
