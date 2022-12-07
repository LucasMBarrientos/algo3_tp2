package edu.fiuba.algo3.modelo.Views.eventos;

import edu.fiuba.algo3.modelo.AlgoStar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonBienvenida implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;

    public BotonBienvenida(Stage stage, Scene proximaEscena, AlgoStar algoStar){
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent event) {
        stage.setFullScreen(true);
        stage.setScene(proximaEscena);
        stage.setFullScreen(true);
    }
}
