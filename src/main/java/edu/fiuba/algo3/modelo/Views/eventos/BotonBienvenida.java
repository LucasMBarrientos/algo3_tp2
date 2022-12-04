package edu.fiuba.algo3.modelo.Views.eventos;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.excepciones.NombreDeJugadorInvalido;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonBienvenida  implements EventHandler<ActionEvent> {

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

  /*      try {
            stage.setFullScreen(true);
            stage.setScene(proximaEscena);
            stage.setFullScreen(true);
        } catch (NombreDeJugadorInvalido e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Nombre de Jugador Inválido");
            alert.setHeaderText("Recuerde que los nombres de los jugadores deben tener seis letras");
            String mensaje = "Nombre de jugador Inválido, vuelva a intentarlo";
            alert.setContentText(mensaje);
            alert.show();
        }*/

    }
}
