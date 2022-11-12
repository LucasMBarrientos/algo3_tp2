package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.NoHayLarvasDisponibles;
import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.Zerling;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;

public class ReservaOperativa implements EstadoReserva {

    public Unidad generarUnidad(Criadero criadero) {
        return criadero.generarUnidad(new Zerling());
    }

    public void actualizar(){
        //hacer algo como regenerar vida
    }
}
