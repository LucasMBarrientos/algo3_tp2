package edu.fiuba.algo3.modelo.Views;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.eventos.BotonElegirColorEventHandler;
import edu.fiuba.algo3.modelo.Views.eventos.BotonEntrarEventHandler;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.*;

public class PantallaInicial extends VBox {

    Stage stage;
    ChoiceBox<String> cb = new ChoiceBox<String>();
    ChoiceBox<String> cb2 = new ChoiceBox<String>();

    String colorOne;
    String colorTwo;

    public PantallaInicial(Stage stage, Scene escenaJuego, AlgoStar algoStar) {

        super();

        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Image iconoZerg = new Image("/iconozerg.png");
        BackgroundImage fondo = new BackgroundImage(iconoZerg, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(fondo));

        Button botonIniciarJuego = new Button();
        botonIniciarJuego.setText("Iniciar Partida!!!");

        final String[] colores = new String[]{"Naranja","Violeta","Rojo","Azul"};

        ChoiceBox<String> cb = new ChoiceBox<String>();
        cb.getItems().addAll(colores);
        cb.setOnAction(this::getColorOne);

        ChoiceBox<String> cb2 = new ChoiceBox<String>();
        cb2.getItems().addAll(colores);
        cb2.setOnAction(this::getColorTwo);

        TextField nombreJugador1 = new TextField();
        nombreJugador1.setText("abcdef");

        TextField nombreJugador2 = new TextField();
        nombreJugador2.setText("ghijkl");

        BotonEntrarEventHandler botonEntrarEventHandler = new BotonEntrarEventHandler(stage,escenaJuego,algoStar, nombreJugador1, nombreJugador2);
        botonIniciarJuego.setOnAction(botonEntrarEventHandler);

        this.getChildren().addAll(nombreJugador1,cb,nombreJugador2,cb2,botonIniciarJuego );
    }


    public void getColorOne(ActionEvent e){
        this.colorOne = cb.getSelectionModel().getSelectedItem();
        System.out.println(colorOne);
    }

    public void getColorTwo(ActionEvent e2){
        this.colorTwo = cb2.getSelectionModel().getSelectedItem();
        System.out.println(colorTwo);
    }
}
