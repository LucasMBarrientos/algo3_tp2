package edu.fiuba.algo3.modelo.edificios.protoss.puertoEstelar;

import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;

public class PuertoEstelarOperativo implements EstadoPuertoEstelar{
    private PuertoEstelar puertoEstelar;

    
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


  public Unidad generarUnidad(Scout unidad)  { return unidad; }
}
