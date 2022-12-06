package edu.fiuba.algo3.modelo.Views.eventos.botoneras.unidades;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.*;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BotoneraZangano extends HBox {
    public BotoneraZangano(AlgoStar algoStar, AlgoStarView algoView, Coordenada coordenada){
        List<VBox> buttons = crearBotones(algoStar, algoView, coordenada);
        
        HBox contenedorHorizontal = new HBox();
        contenedorHorizontal.getChildren().clear();
        contenedorHorizontal.getChildren().addAll(buttons);
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(25));
        algoView.setBottom(contenedorHorizontal);
    }

    private List<VBox> crearBotones(AlgoStar algoStar, AlgoStarView algoView, Coordenada coordenada){

        Button construirCriadero = new Button();
        construirCriadero.setText("construir Criadero");
        Label costoGasCriadero = new Label("COSTO GAS: 0");
        Label costoMineralCriadero  = new Label("COSTO MINERAL: 200");
        VBox generarCriaderobox = new VBox(costoGasCriadero,costoMineralCriadero,construirCriadero);
        
        Button construirEspiral = new Button();
        construirEspiral.setText("construir Espiral");
        Label costoGasEspiral = new Label("COSTO GAS: 100");
        Label costoMineralEspiral  = new Label("COSTO MINERAL: 150");
        VBox generarEspiralbox = new VBox(costoGasEspiral,costoMineralEspiral,construirEspiral);

        Button construirExtractor = new Button();
        construirExtractor.setText("construir Extractor");
        Label costoGasExtractor = new Label("COSTO GAS: 0");
        Label costoMineralExtractor  = new Label("COSTO MINERAL: 100");
        VBox generarExtractorbox = new VBox(costoGasExtractor,costoMineralExtractor,construirExtractor);

        Button construirGuarida = new Button();
        construirGuarida.setText("construir Guarida");
        Label costoGasGuarida = new Label("COSTO GAS: 100");
        Label costoMineralGuarida  = new Label("COSTO MINERAL: 200");
        VBox generarGuaridabox = new VBox(costoGasGuarida,costoMineralGuarida,construirGuarida);

        Button construirReservaDeReproduccion = new Button();
        construirReservaDeReproduccion.setText("construir Reserva De Reproduccion");
        Label costoGasReservaDeReproduccion = new Label("COSTO GAS: 0");
        Label costoMineralReservaDeReproduccion  = new Label("COSTO MINERAL: 150");
        VBox generarReservaDeReproduccionbox = new VBox(costoGasReservaDeReproduccion,costoMineralReservaDeReproduccion,construirReservaDeReproduccion);

        Button moverAbajo = new Button();
        moverAbajo.setText("mover Abajo");
        VBox generarAbajobox = new VBox(moverAbajo);

        Button moverArriba = new Button();
        moverArriba.setText("mover Arriba");
        VBox generarArribabox = new VBox(moverArriba);

        Button moverIzquierda = new Button();
        moverIzquierda.setText("mover Izquierda");
        VBox generarIzquierdabox = new VBox(moverIzquierda);

        Button moverDerecha = new Button();
        moverDerecha.setText("mover Derecha");
        VBox generarDerechabox = new VBox(moverDerecha);

        Button ingresar = new Button();
        ingresar.setText("ingresar");
        VBox generaringresarbox = new VBox(ingresar);


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

        BotonEmpezarIngresoHandler botonIngresarAExtractorHandler = new BotonEmpezarIngresoHandler(algoStar, algoView, coordenada);
        ingresar.setOnAction(botonIngresarAExtractorHandler);

        List<VBox> botones = new ArrayList<>();
        botones.add(generarCriaderobox);
        botones.add(generarEspiralbox);
        botones.add(generarExtractorbox);
        botones.add(generarGuaridabox);
        botones.add(generarReservaDeReproduccionbox);
        botones.add(generarAbajobox);
        botones.add(generarArribabox);
        botones.add(generarIzquierdabox);
        botones.add(generarDerechabox);
        botones.add(generaringresarbox);

        return botones;
    }
}
