package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.Hidralisco;
import edu.fiuba.algo3.modelo.Mutalisco;
import edu.fiuba.algo3.modelo.Unidad;

public class EspiralOperativa implements EstadoEspiral{


    public Unidad generarUnidad(Criadero criadero) {
        return criadero.generarUnidad(new Mutalisco());
    }

    public void actualizar(){
        //hacer algo como regenerar vida
    }
}
