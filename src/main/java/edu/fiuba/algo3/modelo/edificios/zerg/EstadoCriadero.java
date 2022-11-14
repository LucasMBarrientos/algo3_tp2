package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public interface EstadoCriadero {

    public abstract Zangano generarZangano();

    public abstract Unidad generarUnidad(Unidad unidad);

    public abstract void actualizar();

}
