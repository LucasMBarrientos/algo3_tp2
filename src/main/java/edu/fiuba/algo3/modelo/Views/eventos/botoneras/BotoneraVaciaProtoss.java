package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonConstruirPilonHandler;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class BotoneraVaciaProtoss extends HBox {

    public BotoneraVaciaProtoss(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){
        List<Button> buttons = crearBotones(algoStar, algoStarView, coordenada);
        HBox contenedorHorizontal = new HBox((Node) buttons);
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(25));
    }

    private List<Button> crearBotones(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){

        Button construirPilon = new Button();

        BotonConstruirPilonHandler botonConstruirPilonHandler = new BotonConstruirPilonHandler(algoStar, algoStarView, coordenada);
        construirPilon.setOnAction(botonConstruirPilonHandler);


        List<Button> botones = new ArrayList<>();
        botones.add(construirPilon);

        return botones;
    }
}
