package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;

public class TerrenoVacio extends Terreno {
    //TODO Leti YO xd: codigo repetido x1000, hace un refactor a esto  plis. Nuevas interfaces o excepciones mas especificas?
    public void ocuparPorEdificio(Edificio edificio, Casilla casilla, Terreno terreno){
        terreno.ocuparPorEdificio(edificio, casilla, this);
    }

    public void ocuparPorEdificio(Criadero criadero, Casilla casilla, TerrenoVacio terreno){
        casilla.establecerEdificio(criadero);
    }

    public void ocuparPorEdificio(Pilon pilon, Casilla casilla, TerrenoVacio terreno){
        casilla.establecerEdificio(pilon);
    }

    public void ocuparPorEdificio(Extractor extractor, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(ReservaDeReproduccion reserva, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(Guarida guarida, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(Espiral espiral, Casilla casilla){
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

    public void ocuparPorEdificio(NexoMineral nexoMineral, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }


    public boolean esReemplazable(){
        return true;
    }


    protected boolean validarTransitable(Unidad unidad){
        return true;
    }

}
