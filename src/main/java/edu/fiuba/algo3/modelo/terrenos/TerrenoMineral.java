package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;

public class TerrenoMineral extends Terreno {

    public void ocuparPorEdificio(NexoMineral nexoMineral, Casilla casilla){
        casilla.establecerEdificio(nexoMineral);
    }

    public void ocuparPorEdificio(Pilon pilon, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(Acceso acceso, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(Asimilador asimilador, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(PuertoEstelar puertoEstelar, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    @Override
    public void ocuparPorEdificio(Criadero criadero, Casilla casilla) {
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    @Override
    public void ocuparPorEdificio(Espiral espiral, Casilla casilla) {
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    @Override
    public void ocuparPorEdificio(Extractor extractor, Casilla casilla) {
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    @Override
    public void ocuparPorEdificio(Guarida guarida, Casilla casilla) {
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    @Override
    public void ocuparPorEdificio(ReservaDeReproduccion reservaDeReproduccion, Casilla casilla) {
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }
    public boolean esReemplazable(){
        return false;
    }

    public boolean validarTransitable(Unidad unidad) {
        return true;
    }
}
