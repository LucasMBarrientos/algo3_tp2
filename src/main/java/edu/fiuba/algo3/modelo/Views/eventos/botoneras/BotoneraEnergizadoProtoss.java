package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonConstruirAccesoHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonConstruirPilonHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonConstruirPuertoEstelarHandler;
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

public class BotoneraEnergizadoProtoss extends HBox {

    public BotoneraEnergizadoProtoss(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada, Stage pantalla){
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

        Button construirPilon = new Button();
        construirPilon.setText("construir Pilon");
        construirPilon.getStyleClass().add("btn-botonera-accion");
        Label costoGasPilon = new Label("COSTO GAS: 0");
        costoGasPilon.getStyleClass().add("label-botonera");
        Label costoMineralPilon = new Label("COSTO MINERAL: 100");
        costoMineralPilon.getStyleClass().add("label-botonera");
        VBox generarPilonbox = new VBox(costoGasPilon,costoMineralPilon,construirPilon);

        Button construirAcceso = new Button();
        construirAcceso.setText("construir Acceso");
        construirAcceso.getStyleClass().add("btn-botonera-accion");
        Label costoGasAcceso = new Label("COSTO GAS: 0");
        costoGasAcceso.getStyleClass().add("label-botonera");
        Label costoMineralAcceso  = new Label("COSTO MINERAL: 150");
        costoMineralAcceso.getStyleClass().add("label-botonera");
        VBox generarAccesobox = new VBox(costoGasAcceso,costoMineralAcceso,construirAcceso);

        Button construirPuertoEstelar = new Button();
        construirPuertoEstelar.setText("construir Puerto Estelar");
        construirPuertoEstelar.getStyleClass().add("btn-botonera-accion");
        Label costoGasPuertoEstelar = new Label("COSTO GAS: 150");
        costoGasPuertoEstelar.getStyleClass().add("label-botonera");
        Label costoMineralPuertoEstelar  = new Label("COSTO MINERAL: 150");
        costoMineralPuertoEstelar.getStyleClass().add("label-botonera");
        VBox generarPuertoEstelarbox = new VBox(costoGasPuertoEstelar,costoMineralPuertoEstelar,construirPuertoEstelar);

        BotonConstruirPilonHandler botonConstruirPilonHandler = new BotonConstruirPilonHandler(algoStar, algoStarView, coordenada);
        construirPilon.setOnAction(botonConstruirPilonHandler);

        BotonConstruirAccesoHandler botonConstruirAccesoHandler = new BotonConstruirAccesoHandler(algoStar, algoStarView, coordenada);
        construirAcceso.setOnAction(botonConstruirAccesoHandler);

        BotonConstruirPuertoEstelarHandler botonConstruirPuertoEstelarHandler = new BotonConstruirPuertoEstelarHandler(algoStar, algoStarView, coordenada);
        construirPuertoEstelar.setOnAction(botonConstruirPuertoEstelarHandler);

        List<VBox> botones = new ArrayList<>();
        botones.add(generarPilonbox);
        botones.add(generarAccesobox);
        botones.add(generarPuertoEstelarbox);

        return botones;
    }
    
}
