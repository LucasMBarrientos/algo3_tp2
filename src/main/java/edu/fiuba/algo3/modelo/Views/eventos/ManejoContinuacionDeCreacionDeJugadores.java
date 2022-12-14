package edu.fiuba.algo3.modelo.Views.eventos;

import java.util.List;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.ReproductorDeSonidos;
import edu.fiuba.algo3.modelo.excepciones.ColorDeJugadorInvalido;
import edu.fiuba.algo3.modelo.excepciones.NombreDeJugadorInvalido;
import edu.fiuba.algo3.modelo.excepciones.RazaInvalida;
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
    List<Integer> coloresRemovidos;
    List<Integer> razasRemovidas;

    public ManejoContinuacionDeCreacionDeJugadores(Stage pantalla, Scene SiguienteEscena, AlgoStar algoStar, AlgoStarView algoStarView , TextField casillaDeTextoParaNombre, ChoiceBox<String> controlParaElegirColor, ChoiceBox<String> controlParaElegirRaza, List<Integer> coloresRemovidos, List<Integer> razasRemovidas) {
        this.pantalla = pantalla;
        this.SiguienteEscena = SiguienteEscena;
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        this.casillaDeTextoParaNombre = casillaDeTextoParaNombre;
        this.controlParaElegirColor = controlParaElegirColor;
        this.controlParaElegirRaza = controlParaElegirRaza;
        this.coloresRemovidos = coloresRemovidos;
        this.razasRemovidas = razasRemovidas;
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
            } else if (razaElegida == "Protoss") {
                nuevoJugador = new JugadorProtoss(nombreElegido, colorElegido);
            } else {
                throw new RazaInvalida();
            }
            try {
                algoStar.agregarJugador(nuevoJugador);
                coloresRemovidos.add(controlParaElegirColor.getSelectionModel().getSelectedIndex());
                razasRemovidas.add(controlParaElegirRaza.getSelectionModel().getSelectedIndex());
                this.pasarALaSiguienteEscena();
            } catch (NombreDeJugadorInvalido e ) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Nombre invalido");
                alert.setHeaderText("El nombre \"" + nombreElegido + "\" es invalido.\nSeleccione un nombre que el otro jugador no haya elegido.");
                alert.setContentText("Nombre de jugador Inválido, vuelva a intentarlo");
                alert.show();
            } catch (ColorDeJugadorInvalido e ) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Color invalido");
                alert.setHeaderText("El color \"" + colorElegido + "\" es invalido.\nSeleccione un color que el otro jugador no haya elegido.");
                alert.setContentText("Color de jugador Inválido, vuelva a intentarlo");
                alert.show();
            } catch(RazaInvalida e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Raza invalida");
                alert.setHeaderText("El color \"" + razaElegida + "\" ya fue seleccionada por el otro jugador.\nSeleccione una raza que no haya sido elegida.");
                alert.setContentText("Raza invalida, vuelva a intentarlo");
                alert.show();
            }
        } catch(NombreDeJugadorInvalido e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Nombre invalido");
            alert.setHeaderText("El nombre \"" + nombreElegido + "\" es invalido.\nRecuerde que los nombres de los jugadores deben tener seis letras.");
            alert.setContentText("Nombre de jugador Inválido, vuelva a intentarlo");
            alert.initOwner(pantalla);
            alert.show();
        } catch(RazaInvalida e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Seleccionar una raza");
            alert.setHeaderText("Falta seleccionar Raza");
            alert.setContentText("Seleccionar una raza de las disponibles");
            alert.show();
        }
    }

    private void pasarALaSiguienteEscena() {
        pantalla.setFullScreen(true);
        if (razasRemovidas.size() == 2) {
            ReproductorDeSonidos.devolverInstancia().reproducirSonido("/bg.mp3", true);
            algoStarView.setPantallaDeStatsJugador();
            algoStar.empezarJuego();
            algoStarView.actualizarMapa();
        }
        pantalla.setScene(SiguienteEscena);
        pantalla.setFullScreen(true);
    }
}
