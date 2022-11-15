package edu.fiuba.algo3.modelo.edificios.protoss.acceso;

import edu.fiuba.algo3.modelo.unidades.Unidad;

public class AccesoOperativo implements EstadoAcceso{
    private Acceso acceso;

    public Unidad generarUnidad(Unidad unidad) {
        //verificar que haya recursos para la unidad y quizas el tipo de unidad(?
        return unidad;
    }

    @Override
    public Acceso terminarConstruccion() {
      return acceso;
    }

    @Override
    public Acceso deshacerConstruccion() {
      acceso.setState(new AccesoEnConstruccion());
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
