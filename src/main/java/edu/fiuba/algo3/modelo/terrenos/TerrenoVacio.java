package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;

public class TerrenoVacio extends Terreno {

    public void ocuparPorEdificio(Pilon pilon, Casilla casilla){
        casilla.establecerEdificio(pilon);
    }

    public boolean esReemplazable(){
        return true;
    }
    
    protected boolean validarEdificio(Edificio edificio){
        return false;
    };

    protected boolean validarTransitable(Unidad unidad){
        return true;
    }

}
