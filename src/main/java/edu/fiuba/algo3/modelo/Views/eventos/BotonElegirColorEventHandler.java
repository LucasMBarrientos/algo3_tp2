package edu.fiuba.algo3.modelo.Views.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonElegirColorEventHandler implements EventHandler<ActionEvent> {

    String color;

    public BotonElegirColorEventHandler(String color){
        this.color = color;
    }


    @Override
    public void handle(ActionEvent event) {

    }
}
