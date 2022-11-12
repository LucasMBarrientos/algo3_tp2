package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Coordenada;

import java.util.List;

public abstract class Terreno {

    public void ocuparPorEdificio(Edificio edificio, Casilla casilla){
        this.ocuparPorEdificio(edificio, casilla);
    }





    public void actualizarListaDeCoordenadasConMoho(List<Coordenada> cooordenadasDeCasillasConMoho) {
        return;
    }

    public boolean esReemplazable() {
        return false;
    }


}
