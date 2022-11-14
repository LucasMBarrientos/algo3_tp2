package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.TieneRecursos;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Recursos;

public class TerrenoVolcan extends Terreno implements TieneRecursos {

    public GasVespeno gasVespeno = new GasVespeno(5000);

    public Recursos obtenerRecursos(){
        return gasVespeno;
    }

    public void ocuparPorEdificio(Asimilador asimilador, Casilla casilla){
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

    public boolean esReemplazable(){
        return false;
    }

}
