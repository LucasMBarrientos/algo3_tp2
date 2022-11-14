package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

public class GuaridaOperativa implements EstadoGuarida{

    public Unidad generarUnidad(Criadero criadero) {
        return criadero.generarUnidad(new Hidralisco());
    }

    public void actualizar(){
        //hacer algo como regenerar vida
    }
}
