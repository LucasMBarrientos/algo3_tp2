package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonConstruirAccesoHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonConstruirPilonHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonConstruirPuertoEstelarHandler;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class BotoneraEnergizadoProtoss extends HBox {

    public BotoneraEnergizadoProtoss(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){
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
        construirPilon.setText("construir Pilon");
        Button construirAcceso = new Button();
        construirAcceso.setText("construir Acceso");
        Button construirPuertoEstelar = new Button();
        construirPuertoEstelar.setText("construir Puerto Estelar");

        BotonConstruirPilonHandler botonConstruirPilonHandler = new BotonConstruirPilonHandler(algoStar, algoStarView, coordenada);
        construirPilon.setOnAction(botonConstruirPilonHandler);

        BotonConstruirAccesoHandler botonConstruirAccesoHandler = new BotonConstruirAccesoHandler(algoStar, algoStarView, coordenada);
        construirAcceso.setOnAction(botonConstruirAccesoHandler);

        BotonConstruirPuertoEstelarHandler botonConstruirPuertoEstelarHandler = new BotonConstruirPuertoEstelarHandler(algoStar, algoStarView, coordenada);
        construirPuertoEstelar.setOnAction(botonConstruirPuertoEstelarHandler);


        List<Button> botones = new ArrayList<>();
        botones.add(construirPilon);
        botones.add(construirAcceso);
        botones.add(construirPuertoEstelar);

        return botones;
    }
}
