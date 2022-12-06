package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonConstruirNexoMineralHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonConstruirPilonHandler;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BotoneraMineralProtoss extends HBox {

    public BotoneraMineralProtoss(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){
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

        Button construirNexo = new Button();
        construirNexo.setText("construir Nexo Mineral");
        Label costoGas = new Label("COSTO GAS: 0");
        Label costoMineral = new Label("COSTO MINERAL: 50");
        VBox construirNexobox = new VBox(costoGas,costoMineral,construirNexo);
        
        BotonConstruirNexoMineralHandler botonConstruirNexoMineralHandler = new BotonConstruirNexoMineralHandler(algoStar, algoStarView, coordenada);
        construirNexo.setOnAction(botonConstruirNexoMineralHandler);


        List<VBox> botones = new ArrayList<>();
        botones.add(construirNexobox);

        return botones;
    }
}
