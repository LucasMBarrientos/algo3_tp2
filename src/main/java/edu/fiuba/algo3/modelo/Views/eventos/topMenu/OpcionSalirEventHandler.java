package edu.fiuba.algo3.modelo.Views.eventos.topMenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OpcionSalirEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        System.exit(0);
    }
    
}
