package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonConstruirAsimiladorHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonConstruirNexoMineralHandler;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class BotoneralVolcanProtoss extends HBox {

    public BotoneralVolcanProtoss(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){
        List<Button> buttons = crearBotones(algoStar, algoStarView, coordenada);

        HBox contenedorHorizontal = new HBox();
        contenedorHorizontal.getChildren().clear();
        contenedorHorizontal.getChildren().addAll(buttons);
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(25));
        algoStarView.setBottom(contenedorHorizontal);        
    }

    private List<Button> crearBotones(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){

        Button construirPilon = new Button();
        construirPilon.setText("construir Volcan");
        
        BotonConstruirAsimiladorHandler botonConstruirAsimiladorHandler = new BotonConstruirAsimiladorHandler(algoStar, algoStarView, coordenada);
        construirPilon.setOnAction(botonConstruirAsimiladorHandler);


        List<Button> botones = new ArrayList<>();
        botones.add(construirPilon);

        return botones;
    }
}
