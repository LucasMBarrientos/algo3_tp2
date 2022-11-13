package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.edificios.protoss.*;

public class TerrenoMineral extends Terreno {

    public void ocuparPorEdificio(Edificio edificio, Casilla casilla, Terreno terreno){
        terreno.ocuparPorEdificio(edificio, casilla, this);
    }
    public void ocuparPorEdificio(Edificio edificio, Casilla casilla, TerrenoMineral terreno){
        terreno.ocuparPorEdificio(edificio, casilla, this);
    }

    public void ocuparPorEdificio(NexoMineral nexoMineral, Casilla casilla){
        casilla.establecerEdificio(nexoMineral);
    }

    public void ocuparPorEdificio(Pilon pilon, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(Acceso acceso, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(PuertoEstelar puertoEstelar, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(Asimilador asimilador, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(EdificioZerg edificioZerg, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }




    public boolean validarTransitable(Unidad unidad) {
        return true;
    }
}
