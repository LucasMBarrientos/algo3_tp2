package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class AccesoEnConstruccion implements EstadoAcceso{

    public Unidad generarUnidad(Unidad unidad) throws EdificioNoTerminoDeConstruirse{
        throw new EdificioNoTerminoDeConstruirse();
    }
}
