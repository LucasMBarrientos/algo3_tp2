package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.NoHayLarvasDisponibles;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

public class ReservaOperativa implements EstadoReserva {

    public Unidad generarUnidad(Criadero criadero) {
        return criadero.generarUnidad(new Zerling());
    }

    public void actualizar(){
        //hacer algo como regenerar vida
    }
}
