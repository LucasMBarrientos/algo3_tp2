package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.Zangano;

public class CriaderoEnConstruccion implements EstadoCriadero {

    public Zangano generarZangano() throws EdificioNoTerminoDeConstruirse {
        throw new EdificioNoTerminoDeConstruirse();
    }

    public Unidad generarUnidad(Unidad unidad) throws EdificioNoTerminoDeConstruirse{
        throw new EdificioNoTerminoDeConstruirse();
    }

    public void actualizar() { }//estaria bueno que esto reste el tiempo de construccion
}
