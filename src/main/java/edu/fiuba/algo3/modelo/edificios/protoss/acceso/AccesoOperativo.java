package edu.fiuba.algo3.modelo.edificios.protoss.acceso;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;

public class AccesoOperativo implements EstadoAcceso{
    private Acceso acceso;
    public Unidad generarUnidad(Zealot unidad)  {
        return unidad;
    }
    public Unidad generarUnidad(Dragon unidad){
        return unidad;
    }

    @Override
    public Acceso terminarConstruccion() {
      return acceso;
    }

    @Override
    public Acceso deshacerConstruccion() {
      acceso.establecerEstado(new AccesoEnConstruccion());
      return acceso;
    }

    @Override
    public void setAcceso(Acceso acceso) {
      this.acceso = acceso;
    }

    @Override
    public void actualizar() {
      this.acceso.escudo.regenerar();      
    }
}
