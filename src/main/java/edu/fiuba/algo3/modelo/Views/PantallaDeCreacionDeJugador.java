package edu.fiuba.algo3.modelo.Views;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.eventos.ManejoContinuacionDeCreacionDeJugadores;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
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
                this.getChildren().add(imageView);
        */

        Image imgFondo = new Image("/fondo1.jpg");
        //BackgroundImage fondo = new BackgroundImage(iconoZerg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
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
    
}
