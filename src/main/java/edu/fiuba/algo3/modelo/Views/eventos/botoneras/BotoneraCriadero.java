package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonGenerarAmoSupremoHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonGenerarZanganoHandler;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class BotoneraCriadero extends HBox {
    public BotoneraCriadero(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){
        List<Button> buttons = crearBotones(algoStar, algoStarView, coordenada);
        HBox contenedorHorizontal = new HBox((Node) buttons);
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(25));
    }

    private List<Button> crearBotones(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){

        Button generarZangano = new Button();
        Button generarAmoSupremo = new Button();

        BotonGenerarZanganoHandler botonGenerarZanganoHandler = new BotonGenerarZanganoHandler(algoStar, algoStarView, coordenada);
        generarZangano.setOnAction(botonGenerarZanganoHandler);

        BotonGenerarAmoSupremoHandler botonGenerarAmoSupremoHandler = new BotonGenerarAmoSupremoHandler(algoStar, algoStarView, coordenada);
        generarAmoSupremo.setOnAction(botonGenerarAmoSupremoHandler);

        List<Button> botones = new ArrayList<>();
        botones.add(generarZangano);
        botones.add(generarAmoSupremo);

        return botones;
    }
}
