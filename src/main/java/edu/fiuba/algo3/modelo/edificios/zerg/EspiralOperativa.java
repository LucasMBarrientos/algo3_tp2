package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;

public class EspiralOperativa implements EstadoEspiral{


    public Unidad generarUnidad(Criadero criadero) {
        return criadero.generarUnidad(new Mutalisco());
    }

    public void actualizar(){
        //hacer algo como regenerar vida
    }
}
