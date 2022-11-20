package edu.fiuba.algo3.modelo.edificios.protoss.puertoEstelar;

import edu.fiuba.algo3.modelo.unidades.Unidad;

public class PuertoEstelarOperativo implements EstadoPuertoEstelar{
    private PuertoEstelar puertoEstelar;
    public Unidad generarUnidad(Unidad unidad) {
        //verificar que haya recursos para la unidad y quizas el tipo de unidad(?
        return unidad;
    }

    
  @Override
  public PuertoEstelar terminarConstruccion() {return puertoEstelar;}

  @Override
  public PuertoEstelar deshacerConstruccion() {
    puertoEstelar.establecerEstado(new PuertoEstelarEnConstruccion());
    return puertoEstelar;
  }

  @Override
  public void setPuertoEstelar(PuertoEstelar puertoEstelar) {
    this.puertoEstelar = puertoEstelar;
  }

  @Override
  public void actualizar() {
    this.puertoEstelar.escudo.regenerar();
  }

}
