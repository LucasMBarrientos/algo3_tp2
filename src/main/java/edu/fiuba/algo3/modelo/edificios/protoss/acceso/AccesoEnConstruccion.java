package edu.fiuba.algo3.modelo.edificios.protoss.acceso;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class AccesoEnConstruccion implements EstadoAcceso{
    private Acceso acceso;

    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Minerales minerales, Coordenada coordenada) throws EdificioNoTerminoDeConstruirse{
        throw new EdificioNoTerminoDeConstruirse();
    }

    @Override
    public Acceso terminarConstruccion() {
      acceso.establecerEstado(new AccesoOperativo());
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
