package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.Unidad;

public class TerrenoEnergizado implements Terreno {
    @Override
    public boolean validarEdificio(Edificio edificio) {
        return edificio instanceof Pilon;
    }

    @Override
    public boolean validarTransitable(Unidad unidad) {
        if (unidad == null){
            return true;
        }
        return true;
    }
}