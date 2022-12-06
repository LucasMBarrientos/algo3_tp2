package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonGenerarHidraliscoHandler;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BotoneraGuarida extends HBox {

    public BotoneraGuarida(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){
      List<VBox> buttons = crearBotones(algoStar, algoStarView, coordenada);

      HBox contenedorHorizontal = new HBox();
      contenedorHorizontal.getChildren().clear();
      contenedorHorizontal.getChildren().addAll(buttons);
      contenedorHorizontal.setSpacing(10);
      contenedorHorizontal.setPadding(new Insets(25));
      algoStarView.setBottom(contenedorHorizontal);
    }

    private List<VBox> crearBotones(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){

        Button generarHidralisco = new Button();
        generarHidralisco.setText("generar Hidralisco");
        Label costoGasHidralisco = new Label("COSTO GAS: 25");
        Label costoMineralHidralisco  = new Label("COSTO MINERAL: 75");
        Label costoSuministroHidralisco  = new Label("COSTO Suministro: 2");
        VBox generarHidraliscobox = new VBox(costoGasHidralisco,costoMineralHidralisco,costoSuministroHidralisco,generarHidralisco);

      
        BotonGenerarHidraliscoHandler botonGenerarHidraliscoHandler = new BotonGenerarHidraliscoHandler(algoStar, algoStarView, coordenada);
        generarHidralisco.setOnAction(botonGenerarHidraliscoHandler);


        List<VBox> botones = new ArrayList<>();
        botones.add(generarHidraliscobox);

        return botones;
    }
}
