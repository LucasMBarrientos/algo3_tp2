package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonGenerarZerlingHandler;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BotoneraReservaDeReproduccion extends HBox {

    public BotoneraReservaDeReproduccion(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){
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

        Button generarZerling = new Button();
        generarZerling.setText("generar Zerling");
        Label costoGasZerling = new Label("COSTO GAS: 0");
        Label costoMineralZerling  = new Label("COSTO MINERAL: 25");
        Label costoSuministroZerling  = new Label("COSTO Suministro: 1");
        VBox generarZerlingbox = new VBox(costoGasZerling,costoMineralZerling,costoSuministroZerling,generarZerling);


        BotonGenerarZerlingHandler botonGenerarZerlingHandler = new BotonGenerarZerlingHandler(algoStar, algoStarView, coordenada);
        generarZerling.setOnAction(botonGenerarZerlingHandler);


        List<VBox> botones = new ArrayList<>();
        botones.add(generarZerlingbox);;

        return botones;
    }
}
