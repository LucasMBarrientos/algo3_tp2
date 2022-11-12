package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.Asimilador;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.*;

public class TerrenoVolcan extends Terreno {

    public boolean validarEdificio(Edificio edificio){
        return true; //(edificio instanceof Extractor || edificio instanceof Asimilador || edificio == null); //distinto de extractor y protoss
    };

    public boolean validarTransitable(Unidad unidad){
        return true;
        /*
        if (unidad == null || unidad instanceof ConstruccionProtoss) {
            return true;
        }
        return  (unidad instanceof Zangano);
        */

    }

}
