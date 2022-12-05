package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.MapaView;
import edu.fiuba.algo3.modelo.Views.eventos.BotonEntrarEventHandler;
import javafx.event.Event;
import javafx.event.EventHandler;

public class BotonPasarTurnoHandler implements EventHandler {
    AlgoStar algostar;
    AlgoStarView algoView;

    public BotonPasarTurnoHandler(AlgoStar algostar, AlgoStarView algoView){
        this.algostar = algostar;
        this.algoView = algoView;
    }


    @Override
    public void handle(Event event) {
        algostar.pasarTurno();
        algoView.actualizarMapa();
    }
}
