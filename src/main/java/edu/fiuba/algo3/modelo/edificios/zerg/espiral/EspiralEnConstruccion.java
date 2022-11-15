package edu.fiuba.algo3.modelo.edificios.zerg.espiral;

import edu.fiuba.algo3.modelo.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class EspiralEnConstruccion implements EstadoEspiral {
    private Espiral espiral;

    @Override
    public Unidad generarUnidad(Criadero criadero) throws EdificioNoTerminoDeConstruirse{
        throw new EdificioNoTerminoDeConstruirse();
    }
  
    @Override
    public Espiral terminarConstruccion() {
      espiral.setState(new EspiralOperativa());
      return espiral;
    }

    @Override
    public Espiral deshacerConstruccion() {
      return espiral;
    }

    @Override
    public void setEspiral(Espiral espiral) {
      this.espiral = espiral;
    }

    @Override
    public void actualizar() {
      if(this.espiral.reducirTiempoConstruccion(1)){
        this.terminarConstruccion();
      }
    }
}
