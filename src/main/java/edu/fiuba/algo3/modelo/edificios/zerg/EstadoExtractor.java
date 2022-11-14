package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public interface EstadoExtractor {

    public abstract void ingresarUnidad(Zangano zangano);

    public abstract void recolectarRecursos(Terreno terreno, Inventario inventario );
}
