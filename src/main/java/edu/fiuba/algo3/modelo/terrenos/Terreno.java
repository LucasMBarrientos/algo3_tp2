package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.ReservaDeReproduccion;

import java.util.List;

public abstract class Terreno {

    public abstract void ocuparPorEdificio(Edificio edificio, Casilla casilla, Terreno terreno);

    public void ocuparPorEdificio(Pilon pilon, Casilla casilla){
        casilla.establecerEdificio(pilon);
    }


    public void actualizarListaDeCoordenadasConMoho(List<Coordenada> cooordenadasDeCasillasConMoho) {
        return;
    }

    public boolean esReemplazable() {
        return false;
    }

    public boolean repeleeMoho() {
        return false;
    }


}
