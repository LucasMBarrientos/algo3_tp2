package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonConstruirAsimiladorHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonConstruirNexoMineralHandler;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BotoneralVolcanProtoss extends HBox {

    public BotoneralVolcanProtoss(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){
      List<VBox> buttons = crearBotones(algoStar, algoStarView, coordenada);

        HBox contenedorHorizontal = new HBox();
        contenedorHorizontal.getChildren().clear();
        contenedorHorizontal.getChildren().addAll(buttons);
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(25));
        algoStarView.setBottom(contenedorHorizontal);        
    }

    private List<VBox> crearBotones(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){

        Button construirAsimilador = new Button();
        construirAsimilador.setText("construir Asimilador");
        Label costoGasAsimilador = new Label("COSTO GAS: 0");
        Label costoMineralAsimilador  = new Label("COSTO MINERAL: 100");
        VBox generarAsimiladorbox = new VBox(costoGasAsimilador,costoMineralAsimilador,construirAsimilador);

        BotonConstruirAsimiladorHandler botonConstruirAsimiladorHandler = new BotonConstruirAsimiladorHandler(algoStar, algoStarView, coordenada);
        construirAsimilador.setOnAction(botonConstruirAsimiladorHandler);


        List<VBox> botones = new ArrayList<>();
        botones.add(generarAsimiladorbox);

        return botones;
    }
}
