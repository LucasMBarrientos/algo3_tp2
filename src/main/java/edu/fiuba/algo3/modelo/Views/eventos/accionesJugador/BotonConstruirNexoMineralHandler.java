package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.edificios.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonConstruirNexoMineralHandler implements EventHandler<ActionEvent> {
    AlgoStar algoStar;
    AlgoStarView algoStarView;

    Coordenada coordenada;

    public BotonConstruirNexoMineralHandler(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        this.coordenada = coordenada;
    }

    @Override
    public void handle(ActionEvent evento) {
        try {
            algoStar.devolverJugadorActual().construirEdificio(coordenada, new NexoMineral());

        } catch (RecursosInsuficientes e) {
            //avisar al jugador con una ventanita linda
        }

        algoStarView.actualizarMapa();
    }
}