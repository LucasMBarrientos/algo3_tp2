package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.Zangano;

public interface EstadoCriadero {

    public abstract Zangano generarZangano();

    public abstract Unidad generarUnidad(Unidad unidad);

    public abstract void actualizar();

}
