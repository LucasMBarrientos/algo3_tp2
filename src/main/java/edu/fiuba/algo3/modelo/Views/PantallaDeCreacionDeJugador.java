package edu.fiuba.algo3.modelo.Views;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.eventos.ManejoContinuacionDeCreacionDeJugadores;
import edu.fiuba.algo3.modelo.Views.eventos.topMenu.OpcionSalirEventHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PantallaDeCreacionDeJugador extends VBox {

    private Stage pantalla;
    private AlgoStar algoStar;
    private AlgoStarView algoStarView;
    private ChoiceBox<String> controlParaElegirColor = new ChoiceBox<String>();
    private ChoiceBox<String> controlParaElegirRaza = new ChoiceBox<String>();
    private TextField casillaDeTextoParaNombre = new TextField();
    private Button botonParaContinuar;
    private GridPane formUsuario = new GridPane();
    private List<Integer> coloresRemovidos;
    private List<Integer> razasRemovidas;
    private HBox contenedorBotones = new HBox(20);

    public PantallaDeCreacionDeJugador(Stage pantalla, Scene proximaEscena, AlgoStar algoStar, AlgoStarView algoView, List<Integer> coloresRemovidos, List<Integer> razasRemovidas) {
        super();
        this.pantalla = pantalla;
        this.algoStar = algoStar;
        this.algoStarView = algoView;
        this.setAlignment(Pos.CENTER);
        this.contenedorBotones.setAlignment(Pos.CENTER);
        this.formUsuario = new GridPane();
        this.formUsuario.setAlignment(Pos.CENTER);
        this.formUsuario.setHgap(20); //horizontal gap in pixels => that's what you are asking for
        this.formUsuario.setVgap(20);
        this.setSpacing(40);
        this.setPadding(new Insets(25));
        this.establecerFondo();
        this.agregarControlParaSeleccionarColor();
        this.agregarCasillaDeTextoParaNombre();
        this.coloresRemovidos = coloresRemovidos;
        this.razasRemovidas = razasRemovidas;
        this.formUsuario.getStyleClass().add("form-grid");
        this.controlParaElegirColor.getStyleClass().add("choice-box");
        this.controlParaElegirRaza.getStyleClass().add("choice-box");
        this.agregarControlParaSeleccionarRaza();
        this.getChildren().add(this.formUsuario);
        this.agregarBotonParaContinuar(proximaEscena, coloresRemovidos, razasRemovidas);
        this.agregarBotonParaSalir();
        this.getChildren().add(this.contenedorBotones);
    }


    private void agregarCasillaDeTextoParaNombre() {
        Label nombre = new Label();
        nombre.setPrefHeight(40);
        nombre.setText ("Insertar un nombre:");
        nombre.getStyleClass().add("form-label");

        addTextLimiter(casillaDeTextoParaNombre,15);
        casillaDeTextoParaNombre.setPromptText("Ejemplo:Chaqueño");
        casillaDeTextoParaNombre.getStyleClass().add("nombre-input");
        casillaDeTextoParaNombre.setPrefHeight(40);
        nombre.setLayoutX(1);
        nombre.setLayoutY(1);
        casillaDeTextoParaNombre.setLayoutX(2);
        casillaDeTextoParaNombre.setLayoutY(1);

        Image infoImage = new Image("/info.png",40,40,false,false);
        ImageView view = new ImageView(infoImage);
        
        Tooltip tt = new Tooltip("MINIMO 6 Caracteres\nMAXIMO 15 Caracteres");
        tt.setPrefWidth(400);
        tt.getStyleClass().add("tooltip");
        Tooltip.install(view, tt);
        this.formUsuario.add(nombre, 0,1);
        this.formUsuario.add(casillaDeTextoParaNombre, 1,1);
        this.formUsuario.add(view, 2,1);

    }

    private void agregarControlParaSeleccionarColor() {
        Label nombre = new Label();
       
        nombre.setText ("Elegir tu color:");
        nombre.getStyleClass().add("form-label");
        nombre.setPrefHeight(40);
        List<String> colores = new ArrayList<String>();
        colores.add("Naranja");
        colores.add("Violeta");
        colores.add("Rojo");
        colores.add("Azul");

        controlParaElegirColor.getItems().addAll(colores);
        controlParaElegirColor.setValue("Elegir un color");
        controlParaElegirColor.setOnMouseClicked(this::seleccionarColor);
        controlParaElegirColor.setPrefHeight(40);

        this.formUsuario.add(nombre, 0,2);
        this.formUsuario.add(controlParaElegirColor, 1,2);
    }

    private void agregarControlParaSeleccionarRaza() {
        Label nombre = new Label();

        nombre.setText ("Elegir tu raza:");
        nombre.getStyleClass().add("form-label");
        nombre.setPrefHeight(40);
        controlParaElegirRaza.getItems().add("Zerg");
        controlParaElegirRaza.getItems().add("Protoss");
        controlParaElegirRaza.setValue("Elegir una raza");
        controlParaElegirRaza.setOnMouseClicked(this::seleccionarRaza);
        controlParaElegirRaza.setPrefHeight(40);

        this.formUsuario.add(nombre, 0,3);
        this.formUsuario.add(controlParaElegirRaza, 1,3);
    }

    private void agregarBotonParaContinuar(Scene proximaEscena, List<Integer> coloresRemovidos, List<Integer> razasRemovidas) {
        this.botonParaContinuar = new Button();
        botonParaContinuar.getStyleClass().add("btn-comenzar");
        if (razasRemovidas.size() == 1) {
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
            coloresRemovidos,
            razasRemovidas
        );

        botonParaContinuar.setOnAction(manejoCotinuacionDeCreacionDeJugadores);
        this.contenedorBotones.getChildren().add(botonParaContinuar);

    }

    private void agregarBotonParaSalir() {
      Button botonParaSalir = new Button("Salir del juego");
      botonParaSalir.getStyleClass().add("btn-salir");
      OpcionSalirEventHandler opcionSalirEventHandler = new OpcionSalirEventHandler();
      botonParaSalir.setOnAction(opcionSalirEventHandler);
    
      this.contenedorBotones.getChildren().add(botonParaSalir);
  }

    private void establecerFondo() {
        Image imgFondo = new Image("/fondo1.jpg");
        BackgroundImage fondo = new BackgroundImage(imgFondo, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(pantalla.getOutputScaleX(),pantalla.getMaxWidth(),true,true,true,true));
        this.setBackground(new Background(fondo));
    }

    public void seleccionarColor(MouseEvent e) {
        if (coloresRemovidos.size() > 0) {
            int indiceRemovido = coloresRemovidos.get(coloresRemovidos.size()-1);
            this.controlParaElegirColor.getItems().remove(indiceRemovido);
        }
    }

    public void seleccionarRaza(MouseEvent e) {
        if (razasRemovidas.size() > 0) {
            int indiceRemovido = razasRemovidas.get(razasRemovidas.size()-1);
            this.controlParaElegirRaza.getItems().remove(indiceRemovido);
        }
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


