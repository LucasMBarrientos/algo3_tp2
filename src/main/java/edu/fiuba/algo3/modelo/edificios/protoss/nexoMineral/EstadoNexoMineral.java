package edu.fiuba.algo3.modelo.edificios.protoss.nexoMineral;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public interface EstadoNexoMineral {

    public abstract void recolectarRecursos(Terreno terreno, Inventario inventario );

    NexoMineral terminarConstruccion();
  
    NexoMineral deshacerConstruccion();
  
    void setNexoMineral(NexoMineral nexoMineral);
  
    void actualizar();

}
