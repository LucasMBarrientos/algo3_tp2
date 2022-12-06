package edu.fiuba.algo3.modelo.Views;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.eventos.ManejoContinuacionDeCreacionDeJugadores;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PantallaDeCreacionDeJugador extends VBox {

    Stage pantalla;
    AlgoStar algoStar;
    AlgoStarView algoStarView;
    ChoiceBox<String> controlParaElegirColor = new ChoiceBox<String>();
    ChoiceBox<String> controlParaElegirRaza = new ChoiceBox<String>();
    String colorElegido;


    String razaElegida;
    TextField casillaDeTextoParaNombre = new TextField();
    private Button botonParaContinuar;


    public PantallaDeCreacionDeJugador(Stage pantalla, Scene proximaEscena, AlgoStar algoStar, Boolean esElPrimerJugador) {
        super();
        this.pantalla = pantalla;
        this.algoStar = algoStar;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        this.establecerFondo();
        this.agregarCasillaDeTextoParaNombre();
        this.agregarControlParaSeleccionarColor();

        this.agregarControlParaSeleccionarRaza();
        this.agregarBotonParaContinuar(proximaEscena, esElPrimerJugador);
    }


    private void agregarCasillaDeTextoParaNombre() {
        Label etiqueta = new Label();
        etiqueta.setFont (Font.font("Tahoma", FontWeight.BOLD, 22));
        etiqueta.setText ("  Insertar un nombre\nMINIMO 6 Caracteres\nMAXIMO 15 Caracteres ");
        // etiqueta.setTextFill(Color.web("#6A7C5"));
        casillaDeTextoParaNombre.setMaxWidth(140);
        addTextLimiter(casillaDeTextoParaNombre,15);
        casillaDeTextoParaNombre.setPromptText("Ejemplo:Chaqueño");

        this.getChildren().add(etiqueta);
        this.getChildren().add(casillaDeTextoParaNombre);

    }

    private void agregarControlParaSeleccionarColor() {
        List<String> colores = new ArrayList<String>();
        colores.add("Naranja");
        colores.add("Violeta");
        colores.add("Rojo");
        colores.add("Azul");

        controlParaElegirColor.getItems().addAll(colores);
        controlParaElegirColor.setValue("Elegir un color");
        controlParaElegirColor.setOnAction(this::seleccionarColor);
        this.getChildren().add(controlParaElegirColor);
    }

    private void agregarControlParaSeleccionarRaza() {
        controlParaElegirRaza.getItems().add("Zerg");
        controlParaElegirRaza.getItems().add("Protoss");
        controlParaElegirRaza.setValue("Elegir una raza");
        controlParaElegirRaza.setOnAction(this::seleccionarRaza);
        this.getChildren().add(controlParaElegirRaza);
    }



    private void agregarBotonParaContinuar(Scene proximaEscena, boolean esElPrimerJugador) {
        this.botonParaContinuar = new Button();
        if (esElPrimerJugador) {
            botonParaContinuar.setText("Continuar");
        } else {
            botonParaContinuar.setText("Empezar juego!");
        }
        ManejoContinuacionDeCreacionDeJugadores manejoCotinuacionDeCreacionDeJugadores = new ManejoContinuacionDeCreacionDeJugadores (
            pantalla,
            proximaEscena,
            algoStar,
            algoStarView,
            casillaDeTextoParaNombre,
            controlParaElegirColor,
            controlParaElegirRaza,
            esElPrimerJugador
        );

        botonParaContinuar.setOnAction(manejoCotinuacionDeCreacionDeJugadores);
        this.getChildren().add(botonParaContinuar);

    }

    private void establecerFondo() {
                // imgView.setX(50);
                //imgView.setY(50);
        /*      ImageView imageView = new ImageView();
                imageView.setImage(bgImage);
                imageView.setFitHeight(780);
                imageView.setFitWidth(1620);

        */

        Image imgFondo = new Image("/fondo1.jpg");
         BackgroundImage fondo = new BackgroundImage(imgFondo, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(pantalla.getOutputScaleX(),pantalla.getMaxWidth(),true,true,true,true));

        this.setBackground(new Background(fondo));
        // this.setStyle("-fx-background: #7d7d7d; -fx-border-color: #7d7d7d;");
        // this.getStylesheets().addAll(this.getClass().getResource("descarga.png").toExternalForm());
        // contenedorCentral.setPadding(new Insets(5));
    }

    public void seleccionarColor(ActionEvent e){
        this.colorElegido = controlParaElegirColor.getSelectionModel().getSelectedItem();

    }

    public void seleccionarRaza(ActionEvent e){
        this.razaElegida = controlParaElegirColor.getSelectionModel().getSelectedItem();
    }
    public static void addTextLimiter(final TextField tf, final int maxLength) {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (tf.getText().length() > maxLength) {
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
    }

}


