package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Mapa;

import java.util.List;

public abstract class Terreno {

    public void ocuparPorEdificio(Edificio edificio, Casilla casilla){
        this.ocuparPorEdificio(edificio, casilla);
    }

    public void expandirse(Mapa mapa) {
        return;
    }

    public boolean esTerrenoMoho() {
        return false;
    }

    public boolean esTerrenoEnergizado() {
        return false;
    }


}
