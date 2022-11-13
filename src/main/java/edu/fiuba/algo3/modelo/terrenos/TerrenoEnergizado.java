package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.edificios.zerg.*;

public class TerrenoEnergizado extends Terreno {

    public void ocuparPorEdificio(Pilon pilon, Casilla casilla){
        casilla.establecerEdificio(pilon);
    }

    public void ocuparPorEdificio(Acceso acceso, Casilla casilla){
        casilla.establecerEdificio(acceso);
    }

    public void ocuparPorEdificio(PuertoEstelar puertoEstelar, Casilla casilla){
        casilla.establecerEdificio(puertoEstelar);
    }

    public void ocuparPorEdificio(NexoMineral nexoMineral, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(Asimilador asimilador, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(EdificioZerg edificioZerg, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public boolean esTerrenoEnergizado() {
        return true;
    }

    public boolean esReemplazable(){
        return true;
    }

}
