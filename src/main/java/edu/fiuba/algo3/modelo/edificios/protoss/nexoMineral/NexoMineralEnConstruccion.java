package edu.fiuba.algo3.modelo.edificios.protoss.nexoMineral;

import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public class NexoMineralEnConstruccion implements EstadoNexoMineral {
    private NexoMineral nexoMineral;
    public void recolectarRecursos(Terreno terreno, Inventario inventario){ }

    @Override
    public NexoMineral terminarConstruccion() {
      nexoMineral.setState(new NexoMineralOperativo());
      return nexoMineral;
    }

    @Override
    public NexoMineral deshacerConstruccion() {
      return nexoMineral;
    }

    @Override
    public void setNexoMineral(NexoMineral nexoMineral) {
      this.nexoMineral = nexoMineral;
    }

    @Override
    public void actualizar() {
      if(this.nexoMineral.reducirTiempoConstruccion(1)){
        this.terminarConstruccion();
      }
    }
}
