package edu.fiuba.algo3.modelo.Views.eventos.topMenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class OpcionZergTutoEventHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Los Zerg");
        alert.setHeaderText("Toda la info sobre los Zerg");
        String mensaje = "asdasd";
        alert.setContentText(mensaje);
        alert.show();
    }
}
