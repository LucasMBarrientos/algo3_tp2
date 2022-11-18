package edu.fiuba.algo3.modelo.edificios.zerg.espiral;

import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class EspiralEnConstruccion implements EstadoEspiral {
    private Espiral espiral;


    @Override
    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Minerales minerales, Coordenada coordenada) {
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
