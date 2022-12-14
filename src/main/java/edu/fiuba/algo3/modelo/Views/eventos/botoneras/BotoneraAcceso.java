package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonGenerarDragonHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonGenerarZealotHandler;
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

public class BotoneraAcceso extends HBox {
    public BotoneraAcceso(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada, Stage pantalla){
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
        
        Button generarDragon = new Button();
        generarDragon.setText("generar Dragon");
        generarDragon.getStyleClass().add("btn-botonera-accion");
        Label costoGasDragon = new Label("COSTO GAS: 50");
        costoGasDragon.getStyleClass().add("label-botonera");
        Label costoMineralDragon  = new Label("COSTO MINERAL: 125");
        costoMineralDragon.getStyleClass().add("label-botonera");
        Label costoSuministroDragon  = new Label("COSTO Suministro: 3");
        costoSuministroDragon.getStyleClass().add("label-botonera");
        VBox generarDragonbox = new VBox(costoGasDragon,costoMineralDragon,costoSuministroDragon,generarDragon);

        Button generarZealot = new Button();
        generarZealot.setText("generar Zealot");
        generarZealot.getStyleClass().add("btn-botonera-accion");
        Label costoGasZealot = new Label("COSTO GAS: 0");
        costoGasZealot.getStyleClass().add("label-botonera");
        Label costoMineralZealot  = new Label("COSTO MINERAL: 100");
        costoMineralZealot.getStyleClass().add("label-botonera");
        Label costoSuministroZealot  = new Label("COSTO Suministro: 2");
        costoSuministroZealot.getStyleClass().add("label-botonera");
        VBox generarZealotbox = new VBox(costoGasZealot,costoMineralZealot,costoSuministroZealot,generarZealot);


        BotonGenerarZealotHandler botonGenerarZealotHandler = new BotonGenerarZealotHandler(algoStar, algoStarView, coordenada);
        generarZealot.setOnAction(botonGenerarZealotHandler);
        BotonGenerarDragonHandler botonGenerarDragonHandler = new BotonGenerarDragonHandler(algoStar, algoStarView, coordenada);
        generarDragon.setOnAction(botonGenerarDragonHandler);

        List<VBox> botones = new ArrayList<>();
        botones.add(generarDragonbox);
        botones.add(generarZealotbox);

        return botones;
    }
}
