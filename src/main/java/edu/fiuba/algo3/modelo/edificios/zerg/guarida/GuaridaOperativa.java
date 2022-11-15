package edu.fiuba.algo3.modelo.edificios.zerg.guarida;

import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;

public class GuaridaOperativa implements EstadoGuarida{
    private Guarida guarida;

    public Unidad generarUnidad(Criadero criadero) {
      return criadero.generarUnidad(new Hidralisco());
    }
    
    @Override
    public Guarida terminarConstruccion() {return guarida;}

    @Override
    public Guarida deshacerConstruccion() {
      guarida.setState(new GuaridaEnConstruccion());
      return guarida;
    }

    @Override
    public void setGuarida(Guarida guarida) {
      this.guarida = guarida;
    }

    @Override
    public void actualizar() {
      this.guarida.vida.regenerar();
    }
}
