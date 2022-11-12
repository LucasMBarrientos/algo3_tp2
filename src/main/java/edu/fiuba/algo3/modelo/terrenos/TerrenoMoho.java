package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.Actualizable;
import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.*;

import java.util.List;

public class TerrenoMoho extends Terreno {

    Coordenada coordenada;

    public TerrenoMoho(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public boolean validarEdificio(Edificio edificio){
        return true; //(edificio instanceof Criadero || edificio instanceof Espiral || edificio instanceof Guarida || edificio == null); //distinto de extractor y protoss
    };

    public boolean validarTransitable(Unidad unidad){
        return true;
    }

    public void actualizar() {

    }

    public boolean esTerrenoMoho() {
        return true;
    }

    public void expandirse(Mapa mapa) {
        List<Casilla> casillasAdyacentes = mapa.buscarCasillasAdyacentes(coordenada);
        for (Casilla casilla : casillasAdyacentes) {
            casilla.establecerTerreno(new TerrenoMoho(casilla.devolverCoordendas()));
        }
    }

}