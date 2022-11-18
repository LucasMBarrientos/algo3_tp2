package edu.fiuba.algo3.modelo.unidades.edificios.protoss.asimilador;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public interface EstadoAsimilador {

    public void recolectarRecursos(Terreno terreno, Inventario inventario);

    Asimilador terminarConstruccion();
  
    Asimilador deshacerConstruccion();
  
    void setAsimilador(Asimilador asimilador);
  
    void actualizar();

}
