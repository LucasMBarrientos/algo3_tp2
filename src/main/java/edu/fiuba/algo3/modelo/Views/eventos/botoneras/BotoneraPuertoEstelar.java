package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonGenerarScoutHandler;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class BotoneraPuertoEstelar extends HBox {

    public BotoneraPuertoEstelar(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){
        List<Button> buttons = crearBotones(algoStar, algoStarView, coordenada);
        HBox contenedorHorizontal = new HBox((Node) buttons);
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(25));
    }

    private List<Button> crearBotones(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){

        Button generarScout = new Button();

        BotonGenerarScoutHandler botonGenerarScoutHandler = new BotonGenerarScoutHandler(algoStar, algoStarView, coordenada);
        generarScout.setOnAction(botonGenerarScoutHandler);


        List<Button> botones = new ArrayList<>();
        botones.add(generarScout);

        return botones;
    }
}
