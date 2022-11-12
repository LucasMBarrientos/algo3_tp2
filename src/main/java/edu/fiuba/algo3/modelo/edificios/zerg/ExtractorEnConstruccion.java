package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.Zangano;

public class ExtractorEnConstruccion  implements EstadoExtractor{

    public void ingresarUnidad(Zangano zangano) {
        throw new EdificioNoTerminoDeConstruirse();
    }

    public void actualizar(){
        //hacer algo como regenerar vida
    }
}
