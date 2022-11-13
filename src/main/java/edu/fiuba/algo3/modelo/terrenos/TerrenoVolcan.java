package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.*;

public class TerrenoVolcan extends Terreno {

    public void ocuparPorEdificio(Edificio edificio, Casilla casilla, Terreno terreno){
        terreno.ocuparPorEdificio(edificio, casilla, this);
    }
    public void ocuparPorEdificio(Edificio edificio, Casilla casilla, TerrenoVolcan terreno){
        terreno.ocuparPorEdificio(edificio, casilla, this);
    }

    public void ocuparPorEdificio(Asimilador asimilador, Casilla casilla, TerrenoVolcan terreno){
        casilla.establecerEdificio(asimilador);
    }

    public void ocuparPorEdificio(Extractor extractor, Casilla casilla){
        casilla.establecerEdificio(extractor);
    }

    public void ocuparPorEdificio(Criadero criadero, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(Pilon pilon, Casilla casilla){
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

    public void ocuparPorEdificio(NexoMineral nexoMineral, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }


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
