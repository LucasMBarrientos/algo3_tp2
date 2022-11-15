package edu.fiuba.algo3.modelo.edificios.zerg.espiral;

import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;

public class EspiralOperativa implements EstadoEspiral{
    private Espiral espiral;

    public Unidad generarUnidad(Criadero criadero) {
      return criadero.generarUnidad(new Mutalisco());
    }
    
    @Override
    public Espiral terminarConstruccion() {return espiral;}

    @Override
    public Espiral deshacerConstruccion() {
      espiral.setState(new EspiralEnConstruccion());
      return espiral;
    }

    @Override
    public void setEspiral(Espiral espiral) {
      this.espiral = espiral;
    }

    @Override
    public void actualizar() {
      this.espiral.vida.regenerar();
    }
}
