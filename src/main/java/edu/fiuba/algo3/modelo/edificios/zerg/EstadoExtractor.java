package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.Zangano;

public interface EstadoExtractor {

    public abstract void ingresarUnidad(Zangano zangano);

    public abstract void actualizar();
}
