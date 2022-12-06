package edu.fiuba.algo3.modelo.Views.eventos.botoneras.unidades;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.*;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class BotoneraZangano extends HBox {
    public BotoneraZangano(AlgoStar algoStar, AlgoStarView algoView, Coordenada coordenada){
        List<Button> buttons = crearBotones(algoStar, algoView, coordenada);
        HBox contenedorHorizontal = new HBox((Node) buttons);
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(25));
    }

    private List<Button> crearBotones(AlgoStar algoStar, AlgoStarView algoView, Coordenada coordenada){

        Button construirCriadero = new Button();
        Button construirEspiral = new Button();
        Button construirExtractor = new Button();
        Button construirGuarida = new Button();
        Button construirReservaDeReproduccion = new Button();
        Button moverAbajo = new Button();
        Button moverArriba = new Button();
        Button moverIzquierda = new Button();
        Button moverDerecha = new Button();
        Button ingresar = new Button();

        BotonConstruirCriaderoHandler botonConstruirCriaderoHandler = new BotonConstruirCriaderoHandler(algoStar, algoView, coordenada);
        construirCriadero.setOnAction(botonConstruirCriaderoHandler);

        BotonConstruirEspiralHandler botonConstruirEspiralHandler = new BotonConstruirEspiralHandler(algoStar, algoView, coordenada);
        construirEspiral.setOnAction(botonConstruirEspiralHandler);

        BotonConstruirExtractorHandler botonConstruirExtractorHandler = new BotonConstruirExtractorHandler(algoStar, algoView, coordenada);
        construirExtractor.setOnAction(botonConstruirExtractorHandler);

        BotonConstruirGuaridaHandler botonConstruirGuaridaHandler = new BotonConstruirGuaridaHandler(algoStar, algoView, coordenada);
        construirGuarida.setOnAction(botonConstruirGuaridaHandler);

        BotonConstruirReservaDeReproduccionHandler botonConstruirReservaDeReproduccionHandler = new BotonConstruirReservaDeReproduccionHandler(algoStar, algoView, coordenada);
        construirReservaDeReproduccion.setOnAction(botonConstruirReservaDeReproduccionHandler);

        BotonMoverAbajoHandler botonMoverAbajoHandler = new BotonMoverAbajoHandler(algoStar, algoView, coordenada);
        moverAbajo.setOnAction(botonMoverAbajoHandler);

        BotonMoverArribaHandler botonMoverArribaHandler = new BotonMoverArribaHandler(algoStar, algoView, coordenada);
        moverArriba.setOnAction(botonMoverArribaHandler);

        BotonMoverIzquierdaHandler botonMoverIzquierdaHandler = new BotonMoverIzquierdaHandler(algoStar, algoView, coordenada);
        moverIzquierda.setOnAction(botonMoverIzquierdaHandler);

        BotonMoverDerechaHandler botonMoverDerechaHandler = new BotonMoverDerechaHandler(algoStar, algoView, coordenada);
        moverDerecha.setOnAction(botonMoverDerechaHandler);

        //BotonIngresarUnidadHandler botonIngresarHandler = new BotonIngresarUnidadHandler(algoStar, algoView, coordenada);
        //ingresar.setOnAction(botonIngresarHandler);

        List<Button> botones = new ArrayList<>();
        botones.add(construirCriadero);
        botones.add(construirEspiral);
        botones.add(construirExtractor);
        botones.add(construirGuarida);
        botones.add(construirReservaDeReproduccion);
        botones.add(moverAbajo);
        botones.add(moverArriba);
        botones.add(moverIzquierda);
        botones.add(moverDerecha);
        botones.add(ingresar);

        return botones;
    }
}
