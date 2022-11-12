package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.Zangano;
import edu.fiuba.algo3.modelo.Zerling;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;

public interface EstadoReserva {

    public abstract Unidad generarUnidad(Criadero criadero);

    public abstract void actualizar();
}
