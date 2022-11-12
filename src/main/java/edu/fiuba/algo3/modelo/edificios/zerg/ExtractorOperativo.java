package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.Zangano;

import java.util.ArrayList;
import java.util.List;

public class ExtractorOperativo implements EstadoExtractor {

    private List<Zangano> zanganosTrabajando = new ArrayList<Zangano>();

    public void ingresarUnidad(Zangano zangano) {
        if(zanganosTrabajando.size() < 3){
            zanganosTrabajando.add(zangano);
        }
    }

    public void actualizar(){
        //hacer algo como regenerar vida
    }
}
