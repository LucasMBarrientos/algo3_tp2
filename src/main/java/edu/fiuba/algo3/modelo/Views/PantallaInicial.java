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
import javafx.scene.image.ImageView;
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
        BackgroundImage fondo = new BackgroundImage(imgFondo, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(stage.getOutputScaleX(),stage.getMaxWidth(),true,true,true,true));

        this.setBackground(new Background(fondo));
       // this.setStyle("-fx-background: #7d7d7d; -fx-border-color: #7d7d7d;");
       // this.getStylesheets().addAll(this.getClass().getResource("descarga.png").toExternalForm());
       // contenedorCentral.setPadding(new Insets(5));

        Button botonIniciarJuego = new Button();
        botonIniciarJuego.setText("Iniciar Partida!!!");

        final String[] colores = new String[]{"Naranja","Violeta","Rojo","Azul"};

        ChoiceBox<String> cb = new ChoiceBox<String>();
        cb.getItems().addAll(colores);
        cb.setValue("Elegir  un color");
        cb.setOnAction(this::getColorOne);

        TextField nombreJugador1 = new TextField();
        


        BotonEntrarEventHandler botonEntrarEventHandler = new BotonEntrarEventHandler(stage,escenaJuego,algoStar, nombreJugador1,cb.getSelectionModel().getSelectedItem());
        botonIniciarJuego.setOnAction(botonEntrarEventHandler);
        //this.getChildren().add(imgView);
    //    boolean add = this.getChildren().add(imgView);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(nombreJugador1,cb,botonIniciarJuego);
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
