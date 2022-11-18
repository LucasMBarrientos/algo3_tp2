package edu.fiuba.algo3.modelo.unidades.edificios.zerg.guarida;

import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.unidades.edificios.Edificio;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class GuaridaEnConstruccion implements EstadoGuarida {
    private Guarida guarida;

    @Override
    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Minerales minerales, Coordenada coordenada) throws EdificioNoTerminoDeConstruirse{
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
