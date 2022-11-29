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
import javafx.scene.control.TextInputControl;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {

    private final AlgoStar algoStar;
    private final TextField nombre1;
    private final TextField nombre2;
    Stage stage;
    Scene proximaEscena;

    public BotonEntrarEventHandler(Stage stage, Scene proximaEscena, AlgoStar algoStar , TextField nombreJugador1, TextField nombreJugador2){
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.algoStar = algoStar;
        this.nombre1 = nombreJugador1;
        this.nombre2 = nombreJugador2;
    }

    @Override
    public void handle(ActionEvent event) {
        try{
            JugadorZerg jugadorZerg = new JugadorZerg(nombre1.getText(), "#0000ff");
            algoStar.agregarJugador(jugadorZerg);
            JugadorProtoss jugadorProtoss = new JugadorProtoss(nombre2.getText(), "#ff0000");
            algoStar.agregarJugador(jugadorProtoss);

            stage.setScene(proximaEscena);

        }catch(NombreDeJugadorInvalido e ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Nombre de Jugador Inválido");
            alert.setHeaderText("Recuerde que los nombres de los jugadores deben tener seis letras");
            String mensaje = "Nombre de jugador Inválido, vuelva a intentarlo";
            alert.setContentText(mensaje);
            alert.show();
        }





    }
}
