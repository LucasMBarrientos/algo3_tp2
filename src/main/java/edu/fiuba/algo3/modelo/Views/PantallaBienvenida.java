package edu.fiuba.algo3.modelo.Views;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.eventos.BotonBienvenida;
import edu.fiuba.algo3.modelo.Views.eventos.topMenu.OpcionSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PantallaBienvenida extends VBox {

    Stage stage;
    ChoiceBox<String> cb = new ChoiceBox<String>();
    ChoiceBox<String> cb2 = new ChoiceBox<String>();

    String colorOne;
    String colorTwo;

    public PantallaBienvenida(Stage stage, Scene escenaJuego, AlgoStar algoStar) {

        super();

        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Image imgFondo = new Image("/fondo1.jpg");

        BackgroundImage fondo = new BackgroundImage(imgFondo, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(stage.getOutputScaleX(),stage.getMaxWidth(),true,true,true,true));
        //BackgroundImage fondo2 = new BackgroundImage(imgFondo, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.AUTO(this.getBaselineOffset()));
        this.setBackground(new Background(fondo));

        Button boton = new Button();
        boton.setText("Comenzar Partida");
        BotonBienvenida botonBienvenida = new BotonBienvenida(stage,escenaJuego,algoStar);
        boton.setOnAction(botonBienvenida);
        Button botonParaSalir = new Button("Salir del juego");

        OpcionSalirEventHandler opcionSalirEventHandler = new OpcionSalirEventHandler();
        botonParaSalir.setOnAction(opcionSalirEventHandler);

        //this.getChildren().add(imgView);
        //    boolean add = this.getChildren().add(imgView);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(boton, botonParaSalir);
    }

}
