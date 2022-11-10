package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.Asimilador;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.*;

public class TerrenoVolcan implements Terreno {

    public boolean validarEdificio(Edificio edificio){
        return (edificio instanceof Extractor || edificio instanceof Asimilador || edificio == null); //distinto de extractor y protoss
    };

    public boolean validarTransitable(Unidad unidad){
        if (unidad == null || unidad instanceof ConstruccionProtoss) {
            return true;
        }
        return  (unidad instanceof Zangano);
    }

}
