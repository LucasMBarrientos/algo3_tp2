package edu.fiuba.algo3.modelo.unidades.edificios.protoss.acceso;

import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.unidades.edificios.Edificio;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class AccesoOperativo implements EstadoAcceso{
    private Acceso acceso;

    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Minerales minerales, Coordenada coordenada) {
        //verificar que haya recursos para la unidad y quizas el tipo de unidad(?
        return null;
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
