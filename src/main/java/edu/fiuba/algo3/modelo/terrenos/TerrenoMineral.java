package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.NexoMineral;

public class TerrenoMineral extends Terreno {

    public boolean validarEdificio(Edificio edificio) {
        return true ; //(edificio instanceof NexoMineral || edificio == null);
    }

    public boolean validarTransitable(Unidad unidad) {
        return true;
    }
}
