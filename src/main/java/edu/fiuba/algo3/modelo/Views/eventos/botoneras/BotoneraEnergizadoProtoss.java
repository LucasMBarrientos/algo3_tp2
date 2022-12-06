package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonConstruirAccesoHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonConstruirPilonHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonConstruirPuertoEstelarHandler;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BotoneraEnergizadoProtoss extends HBox {

    public BotoneraEnergizadoProtoss(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){
      HBox contenedorHorizontal = new HBox();  
      List<VBox> buttons = crearBotones(algoStar, algoStarView, coordenada);
      
      Label coordenadaX = new Label("CORDENADA X: " + coordenada.toData().get("x"));
      Label coordenadaY  = new Label("CORDENADA Y: "  + coordenada.toData().get("y"));
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
        Label costoGasPilon = new Label("COSTO GAS: 0");
        Label costoMineralPilon = new Label("COSTO MINERAL: 100");
        VBox generarPilonbox = new VBox(costoGasPilon,costoMineralPilon,construirPilon);

        Button construirAcceso = new Button();
        construirAcceso.setText("construir Acceso");
        Label costoGasAcceso = new Label("COSTO GAS: 0");
        Label costoMineralAcceso  = new Label("COSTO MINERAL: 150");
        VBox generarAccesobox = new VBox(costoGasAcceso,costoMineralAcceso,construirAcceso);

        Button construirPuertoEstelar = new Button();
        construirPuertoEstelar.setText("construir Puerto Estelar");
        Label costoGasPuertoEstelar = new Label("COSTO GAS: 150");
        Label costoMineralPuertoEstelar  = new Label("COSTO MINERAL: 150");
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
