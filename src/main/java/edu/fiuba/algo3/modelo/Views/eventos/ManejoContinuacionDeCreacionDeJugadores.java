package edu.fiuba.algo3.modelo.Views.eventos;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.excepciones.ColorDeJugadorInvalido;
import edu.fiuba.algo3.modelo.excepciones.NombreDeJugadorInvalido;
import edu.fiuba.algo3.modelo.jugadores.Jugador;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ManejoContinuacionDeCreacionDeJugadores implements EventHandler<ActionEvent> {

    private AlgoStar algoStar;
    private AlgoStarView algoStarView;
    private TextField casillaDeTextoParaNombre;
    private ChoiceBox<String> controlParaElegirColor = new ChoiceBox<String>();
    private ChoiceBox<String> controlParaElegirRaza = new ChoiceBox<String>();
    private Stage pantalla;
    private Scene SiguienteEscena;

    public ManejoContinuacionDeCreacionDeJugadores(Stage pantalla, Scene SiguienteEscena, AlgoStar algoStar, AlgoStarView algoStarView , TextField casillaDeTextoParaNombre, ChoiceBox<String> controlParaElegirColor, ChoiceBox<String> controlParaElegirRaza){
        this.pantalla = pantalla;
        this.SiguienteEscena = SiguienteEscena;
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        this.casillaDeTextoParaNombre = casillaDeTextoParaNombre;
        this.controlParaElegirColor = controlParaElegirColor;
        this.controlParaElegirRaza = controlParaElegirRaza;
    }

    @Override
    public void handle(ActionEvent event) {
        Jugador nuevoJugador;
        String nombreElegido = casillaDeTextoParaNombre.getText();
        String razaElegida = controlParaElegirRaza.getSelectionModel().getSelectedItem();
        String colorElegido = controlParaElegirColor.getSelectionModel().getSelectedItem();
        try {
            if (razaElegida == "Zerg") {
                nuevoJugador = new JugadorZerg(nombreElegido, colorElegido);
            } else {
                nuevoJugador = new JugadorProtoss(nombreElegido, colorElegido);
            }
            try {
                algoStar.agregarJugador(nuevoJugador);
                this.pasarALaSiguienteEscena();
            } catch (ColorDeJugadorInvalido e ) {
                // TODO: Color repetido
            }
        } catch(NombreDeJugadorInvalido e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Nombre de jugador invalido");
            alert.setHeaderText("El nombre \"" + nombreElegido + "\" es invalido.\nRecuerde que los nombres de los jugadores deben tener seis letras");
            String mensaje = "Nombre de jugador Inválido, vuelva a intentarlo";
            alert.setContentText(mensaje);
            alert.show();
        }
    }

    private void pasarALaSiguienteEscena() {
        pantalla.setFullScreen(true);
        pantalla.setScene(SiguienteEscena);
        pantalla.setFullScreen(true);
    }
    
}
