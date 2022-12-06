package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.MapaView;
import edu.fiuba.algo3.modelo.Views.PantallaFinDelJuego;
import edu.fiuba.algo3.modelo.Views.eventos.BotonEntrarEventHandler;
import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoAlcanzado;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonPasarTurnoHandler implements EventHandler<ActionEvent> {

    AlgoStar algoStar;
    AlgoStarView algoStarView;
    Stage pantalla;

    public BotonPasarTurnoHandler(AlgoStar algoStar, AlgoStarView algoStarView, Stage pantalla) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        this.pantalla = pantalla;
    }

    @Override
    public void handle(ActionEvent evento) {
        try {
            algoStar.pasarTurno();
        } catch (FinDelJuegoAlcanzado excepcion) {
            PantallaFinDelJuego pantallaFinDelJuego = new PantallaFinDelJuego(algoStar.devolverJugadorGanador());
            Scene escenarioFinDelJuego = new Scene(pantallaFinDelJuego,1620,780);
            pantalla.setScene(escenarioFinDelJuego);
        }
        algoStarView.actualizarMapa();
    }
}
