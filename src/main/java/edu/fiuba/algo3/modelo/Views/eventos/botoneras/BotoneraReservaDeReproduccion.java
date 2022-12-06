package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonGenerarZerlingHandler;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class BotoneraReservaDeReproduccion extends HBox {

    public BotoneraReservaDeReproduccion(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){
      List<Button> buttons = crearBotones(algoStar, algoStarView, coordenada);

      HBox contenedorHorizontal = new HBox();
      contenedorHorizontal.getChildren().clear();
      contenedorHorizontal.getChildren().addAll(buttons);
      contenedorHorizontal.setSpacing(10);
      contenedorHorizontal.setPadding(new Insets(25));
      algoStarView.setBottom(contenedorHorizontal);
    }

    private List<Button> crearBotones(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){

        Button generarZerling = new Button();
        generarZerling.setText("generar Zerling");

        BotonGenerarZerlingHandler botonGenerarZerlingHandler = new BotonGenerarZerlingHandler(algoStar, algoStarView, coordenada);
        generarZerling.setOnAction(botonGenerarZerlingHandler);


        List<Button> botones = new ArrayList<>();
        botones.add(generarZerling);

        return botones;
    }
}
