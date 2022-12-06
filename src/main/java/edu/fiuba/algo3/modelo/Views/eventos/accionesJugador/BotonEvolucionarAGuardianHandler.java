package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.zerg.Guardian;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonEvolucionarAGuardianHandler implements EventHandler<ActionEvent>  {

    AlgoStar algoStar;
    AlgoStarView algoStarView;

    Coordenada coordenadaDeLaUnidad;

    public BotonEvolucionarAGuardianHandler(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        coordenadaDeLaUnidad = coordenada;
    }

    @Override
    public void handle(ActionEvent evento) {
        try {
            algoStar.devolverJugadorActual().evolucionar(coordenadaDeLaUnidad, new Guardian());

        } catch (RecursosInsuficientes e) {
            //avisar al jugador con una ventanita linda

        }

        algoStarView.actualizarMapa();
    }
}
