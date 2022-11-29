package edu.fiuba.algo3.modelo.Views.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;

    public BotonEntrarEventHandler(Stage stage, Scene proximaEscena){
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent event) {
        stage.setScene(proximaEscena);
        //Aca pondriamos lo de fullscreen
        stage.show();
    }
}
