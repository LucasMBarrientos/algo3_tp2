package edu.fiuba.algo3.modelo.edificios.protoss.nexoMineral;

import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public class NexoMineralOperativo implements EstadoNexoMineral{
  private NexoMineral nexoMineral;
  

  @Override
  public NexoMineral terminarConstruccion() {return nexoMineral;}

  @Override
  public NexoMineral deshacerConstruccion() {
    nexoMineral.establecerEstado(new NexoMineralEnConstruccion());
    return nexoMineral;
  }

  @Override
  public void setNexoMineral(NexoMineral nexoMineral) {
    this.nexoMineral = nexoMineral;
  }

  @Override
  public void actualizar() {
    this.nexoMineral.escudo.regenerar();

    // recolectar recursos
    
  }

  @Override
  public void recolectarRecursos(Terreno terreno, Inventario inventario){ 
    terreno.extraerMinerales(new Mineral(10));
    inventario.agregarMinerales(new Mineral(10));
  }
}
