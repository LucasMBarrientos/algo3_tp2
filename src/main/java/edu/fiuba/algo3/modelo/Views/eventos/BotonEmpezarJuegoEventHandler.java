package edu.fiuba.algo3.modelo.Views.eventos;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.excepciones.NombreDeJugadorInvalido;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonEmpezarJuegoEventHandler implements EventHandler<ActionEvent> {

    private final AlgoStar algoStar;
    private final AlgoStarView algoView;
    private final TextField nombre1;

    String color;

    BotonElegirColorEventHandler botonColor;
    Stage stage;
    Scene proximaEscena;

    public BotonEmpezarJuegoEventHandler(Stage stage, Scene proximaEscena, AlgoStar algoStar, AlgoStarView algoView , TextField nombreJugador1,String cb){
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.algoStar = algoStar;
        this.algoView = algoView;
        this.nombre1 = nombreJugador1;
        this.color = cb;
    }



    @Override
    public void handle(ActionEvent event) {
        try {
            if(algoStar.jugadores.size()==0){

                JugadorZerg jugadorZerg = new JugadorZerg(nombre1.getText(),color);
                algoStar.agregarJugador(jugadorZerg);

            }
            else{
                JugadorProtoss jugadorProtoss = new JugadorProtoss(nombre1.getText(), color);
                algoStar.agregarJugador(jugadorProtoss);
            }


            if(algoStar.jugadores.size()==2){
                algoStar.empezarJuego();
                algoView.actualizarMapa();
            }
            stage.setFullScreen(true);
            stage.setScene(proximaEscena);
            stage.setFullScreen(true);
        } catch (NombreDeJugadorInvalido e ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Nombre de Jugador Inválido");
            alert.setHeaderText("Recuerde que los nombres de los jugadores deben tener seis letras");
            String mensaje = "Nombre de jugador Inválido, vuelva a intentarlo";
            alert.setContentText(mensaje);
            alert.show();
        }

    }




}
