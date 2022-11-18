package edu.fiuba.algo3.modelo.edificios.protoss.nexoMineral;

import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public class NexoMineralOperativo implements EstadoNexoMineral{
  private NexoMineral nexoMineral;
  public void recolectarRecursos(Terreno terreno, Inventario inventario){ }

  @Override
  public NexoMineral terminarConstruccion() {return nexoMineral;}

  @Override
  public NexoMineral deshacerConstruccion() {
    nexoMineral.setState(new NexoMineralEnConstruccion());
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


    /*public void recolectarRecursos(Terreno terreno, Inventario inventario){
        recursosAExtraer = new Minerales(10);
        Recursos gasDelVolcan = terreno.obtenerRecursos();
        gasDelVolcan.gastar(recursosAExtraer);
        inventario.actualizarMinerales(recursosAExtraer);
    }*/
}
