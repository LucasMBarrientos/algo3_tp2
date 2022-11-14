package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public interface EstadoNexoMineral {

    public abstract void recolectarRecursos(Terreno terreno, Inventario inventario );
}
