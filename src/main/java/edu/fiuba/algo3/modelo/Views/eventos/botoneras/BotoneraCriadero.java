package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonGenerarAmoSupremoHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonGenerarZanganoHandler;
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

public class BotoneraCriadero extends HBox {
    public BotoneraCriadero(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada, Stage pantalla){
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
        
        Button generarZangano = new Button();
        generarZangano.setText("generar Zangano");
        generarZangano.getStyleClass().add("btn-botonera-accion");
        Label costoGasZangano = new Label("COSTO GAS: 0");
        costoGasZangano.getStyleClass().add("label-botonera");
        Label costoMineralZangano = new Label("COSTO MINERAL: 25");
        costoMineralZangano.getStyleClass().add("label-botonera");
        Label costoSuministroZangano  = new Label("COSTO Suministro: 1");
        costoSuministroZangano.getStyleClass().add("label-botonera");
        VBox generarZanganobox = new VBox(costoGasZangano,costoMineralZangano,costoSuministroZangano,generarZangano);

        Button generarAmoSupremo = new Button();
        generarAmoSupremo.setText("generar Amo Supremo");
        generarAmoSupremo.getStyleClass().add("btn-botonera-accion");
        Label costoGasAmoSupremo = new Label("COSTO GAS: 0");
        costoGasAmoSupremo.getStyleClass().add("label-botonera");
        Label costoMineralAmoSupremo  = new Label("COSTO MINERAL: 100");
        costoMineralAmoSupremo.getStyleClass().add("label-botonera");
        Label costoSuministroAmoSupremo  = new Label("COSTO Suministro: 0");
        costoSuministroAmoSupremo.getStyleClass().add("label-botonera");
        VBox generarAmoSupremobox = new VBox(costoGasAmoSupremo,costoMineralAmoSupremo,costoSuministroAmoSupremo,generarAmoSupremo);


        BotonGenerarZanganoHandler botonGenerarZanganoHandler = new BotonGenerarZanganoHandler(algoStar, algoStarView, coordenada);
        generarZangano.setOnAction(botonGenerarZanganoHandler);

        BotonGenerarAmoSupremoHandler botonGenerarAmoSupremoHandler = new BotonGenerarAmoSupremoHandler(algoStar, algoStarView, coordenada);
        generarAmoSupremo.setOnAction(botonGenerarAmoSupremoHandler);

        List<VBox> botones = new ArrayList<>();
        botones.add(generarZanganobox);
        botones.add(generarAmoSupremobox);

        return botones;
    }
}
