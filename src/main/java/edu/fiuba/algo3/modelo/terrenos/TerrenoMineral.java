package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.NexoMineral;

public class TerrenoMineral implements Terreno{
    @Override
    public boolean validarEdificio(Edificio edificio) {
        return (edificio instanceof NexoMineral || edificio == null);
    }

    @Override
    public boolean validarTransitable(Unidad unidad) {
        return true;
    }
}
