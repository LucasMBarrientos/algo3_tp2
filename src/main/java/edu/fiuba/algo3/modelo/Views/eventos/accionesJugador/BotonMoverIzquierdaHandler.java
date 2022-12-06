package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.excepciones.CoordenadaFueraDelMapa;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaTalUnidad;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Arriba;
import edu.fiuba.algo3.modelo.geometria.direcciones.Izquierda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMoverIzquierdaHandler implements EventHandler<ActionEvent> {
    AlgoStar algoStar;
    AlgoStarView algoStarView;

    Coordenada coordenadaActual;

    public BotonMoverIzquierdaHandler(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        coordenadaActual = coordenada;
    }

    @Override
    public void handle(ActionEvent evento) {
        try {
            algoStar.devolverJugadorActual().moverUnidad(coordenadaActual, new Izquierda());
        } catch (CoordenadaFueraDelMapa | TerrenoNoAptoParaTalUnidad exeption) {
        }

        algoStarView.actualizarMapa();
    }
}
