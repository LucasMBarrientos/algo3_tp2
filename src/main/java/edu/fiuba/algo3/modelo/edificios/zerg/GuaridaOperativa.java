package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.Hidralisco;
import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.Zerling;

public class GuaridaOperativa implements EstadoGuarida{

    public Unidad generarUnidad(Criadero criadero) {
        return criadero.generarUnidad(new Hidralisco());
    }

    public void actualizar(){
        //hacer algo como regenerar vida
    }
}
