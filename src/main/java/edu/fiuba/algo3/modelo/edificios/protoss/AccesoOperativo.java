package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.NoHayLarvasDisponibles;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class AccesoOperativo implements EstadoAcceso{

    public Unidad generarUnidad(Unidad unidad) {
        //verificar que haya recursos para la unidad y quizas el tipo de unidad(?
        return unidad;
    }
}
