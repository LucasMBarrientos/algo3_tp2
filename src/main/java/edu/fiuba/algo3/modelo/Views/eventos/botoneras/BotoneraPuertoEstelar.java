package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonGenerarScoutHandler;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BotoneraPuertoEstelar extends HBox {

    public BotoneraPuertoEstelar(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada, Stage pantalla){
      HBox contenedorHorizontal = new HBox();  
      List<VBox> buttons = crearBotones(algoStar, algoStarView, coordenada);
      Image imgFondo = new Image("/abajo.jpg");
      BackgroundImage fondo = new BackgroundImage(imgFondo, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(pantalla.getOutputScaleX(),pantalla.getMaxWidth(),true,true,true,true));
      contenedorHorizontal.setBackground(new Background(fondo));
      contenedorHorizontal.setPadding(new Insets(25));

      Label coordenadaX = new Label("CORDENADA X: " + coordenada.toData().get("x"));
      coordenadaX.getStyleClass().add("label-botonera");
      Label coordenadaY  = new Label("CORDENADA Y: "  + coordenada.toData().get("y"));
      coordenadaY.getStyleClass().add("label-botonera");
      VBox coordenadaBox = new VBox(coordenadaX,coordenadaY);
      
      contenedorHorizontal.getChildren().clear();
      contenedorHorizontal.getChildren().add(coordenadaBox);
      contenedorHorizontal.getChildren().addAll(buttons);
      contenedorHorizontal.setSpacing(10);
      contenedorHorizontal.setPadding(new Insets(25));
      algoStarView.setBottom(contenedorHorizontal);
    }

    private List<VBox> crearBotones(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){

        Button generarScout = new Button();
        generarScout.setText("generar Scout");
        generarScout.getStyleClass().add("btn-botonera-accion");
        Label costoGasScout = new Label("COSTO GAS: 150");
        costoGasScout.getStyleClass().add("label-botonera");
        Label costoMineralScout  = new Label("COSTO MINERAL: 300");
        costoMineralScout.getStyleClass().add("label-botonera");
        Label costoSuministroScout  = new Label("COSTO Suministro: 4");
        costoSuministroScout.getStyleClass().add("label-botonera");
        VBox generarScoutbox = new VBox(costoGasScout,costoMineralScout,costoSuministroScout,generarScout);

        BotonGenerarScoutHandler botonGenerarScoutHandler = new BotonGenerarScoutHandler(algoStar, algoStarView, coordenada);
        generarScout.setOnAction(botonGenerarScoutHandler);


        List<VBox> botones = new ArrayList<>();
        botones.add(generarScoutbox);

        return botones;
    }
}
