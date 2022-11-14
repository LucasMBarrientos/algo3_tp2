package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.unidades.Unidad;

public interface EstadoEspiral {

    public abstract Unidad generarUnidad(Criadero criadero);

    public abstract void actualizar();
}
