package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.Actualizable;
import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
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

    public void ocuparPorEdificio(Criadero criadero, Casilla casilla){
        casilla.establecerEdificio(criadero);
    }

    public void ocuparPorEdificio(ReservaDeReproduccion reserva, Casilla casilla){
        casilla.establecerEdificio(reserva);
    }

    public void ocuparPorEdificio(Guarida guarida, Casilla casilla){
        casilla.establecerEdificio(guarida);
    }

    public void ocuparPorEdificio(Espiral espiral, Casilla casilla){
        casilla.establecerEdificio(espiral);
    }

    public void ocuparPorEdificio(Extractor extractor, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(EdificioProtoss edificioProtoss, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }







    public void actualizarListaDeCoordenadasConMoho(List<Coordenada> cooordenadasDeCasillasConMoho) {
        List<Coordenada> coordenadasAdyacentes = coordenada.devolverCoordenadasAdyacentes();
        for (Coordenada coordenada : coordenadasAdyacentes) {
            cooordenadasDeCasillasConMoho.add(coordenada);
        }
    }


    public void actualizar() {

    }

}