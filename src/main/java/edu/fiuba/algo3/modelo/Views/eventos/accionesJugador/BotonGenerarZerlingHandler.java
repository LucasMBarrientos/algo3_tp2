package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.zerg.AmoSupremo;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonGenerarZerlingHandler implements EventHandler<ActionEvent> {

    AlgoStar algoStar;
    AlgoStarView algoStarView;

    Coordenada coordenadaDelEdificio;

    public BotonGenerarZerlingHandler(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        coordenadaDelEdificio = coordenada;
    }

    @Override
    public void handle(ActionEvent evento) {
        try {
            algoStar.devolverJugadorActual().generarUnidad(coordenadaDelEdificio, new Zerling());
            algoStarView.setPantallaDeStatsJugador();
        } catch (RecursosInsuficientes e) {
            //avisar al jugador con una ventanita linda

        }

        algoStarView.actualizarMapa();
    }
}
