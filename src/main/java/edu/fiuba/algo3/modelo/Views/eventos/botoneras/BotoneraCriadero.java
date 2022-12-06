package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonGenerarAmoSupremoHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonGenerarZanganoHandler;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BotoneraCriadero extends HBox {
    public BotoneraCriadero(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){
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
        
        Button generarZangano = new Button();
        generarZangano.setText("generar Zangano");
        Label costoGasZangano = new Label("COSTO GAS: 0");
        Label costoMineralZangano = new Label("COSTO MINERAL: 25");
        Label costoSuministroZangano  = new Label("COSTO Suministro: 1");
        VBox generarZanganobox = new VBox(costoGasZangano,costoMineralZangano,costoSuministroZangano,generarZangano);

        Button generarAmoSupremo = new Button();
        generarAmoSupremo.setText("generar Amo Supremo");
        Label costoGasAmoSupremo = new Label("COSTO GAS: 0");
        Label costoMineralAmoSupremo  = new Label("COSTO MINERAL: 100");
        Label costoSuministroAmoSupremo  = new Label("COSTO Suministro: 0");
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
