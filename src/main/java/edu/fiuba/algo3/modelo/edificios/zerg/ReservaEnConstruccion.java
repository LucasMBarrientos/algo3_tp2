package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class ReservaEnConstruccion implements  EstadoReserva{


    public Unidad generarUnidad(Criadero criadero) throws EdificioNoTerminoDeConstruirse{
        throw new EdificioNoTerminoDeConstruirse();
    }

    public void actualizar() { }
}
