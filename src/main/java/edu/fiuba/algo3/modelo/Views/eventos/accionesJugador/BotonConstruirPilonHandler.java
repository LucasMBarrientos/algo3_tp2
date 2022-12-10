package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.geometria.Coordenada;

public class BotonConstruirPilonHandler extends BotonConstruirEdificioHandler {

    public BotonConstruirPilonHandler(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        this.coordenada = coordenada;
    }
    
    public void construirEdificio() {
        algoStar.devolverJugadorActual().construirEdificio(coordenada, new Pilon());
    }

}
