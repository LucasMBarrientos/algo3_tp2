package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.geometria.Coordenada;

public class BotonConstruirExtractorHandler extends BotonConstruirEdificioHandler {

    public BotonConstruirExtractorHandler(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        this.coordenada = coordenada;
    }

    public void construirEdificio() {
        algoStar.devolverJugadorActual().construirEdificio(coordenada, new Extractor());
    }

}
