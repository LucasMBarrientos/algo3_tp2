package edu.fiuba.algo3.modelo.Views.eventos.botoneras.unidades;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.*;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class BotoneraZangano extends HBox {
    public BotoneraZangano(AlgoStar algoStar, AlgoStarView algoView, Coordenada coordenada, Stage pantalla){
        HBox contenedorHorizontal = new HBox();  
        List<VBox> buttons = crearBotones(algoStar, algoView, coordenada);
        Image imgFondo = new Image("/abajo.jpg");
        BackgroundImage fondo = new BackgroundImage(imgFondo, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(pantalla.getOutputScaleX(),pantalla.getMaxWidth(),true,true,true,true));
        contenedorHorizontal.setBackground(new Background(fondo));
        contenedorHorizontal.setPadding(new Insets(25));

        Label coordenadaX = new Label("CORDENADA X: " + coordenada.toData().get("x"));
        coordenadaX.getStyleClass().add("label-botonera");
        Label coordenadaY  = new Label("CORDENADA Y: "  + coordenada.toData().get("y"));
        coordenadaY.getStyleClass().add("label-botonera");
        VBox coordenadaBox = new VBox(coordenadaX,coordenadaY);
        
        contenedorHorizontal.getChildren().clear();
        contenedorHorizontal.getChildren().add(coordenadaBox);
        contenedorHorizontal.getChildren().addAll(buttons);
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(25));
        algoView.setBottom(contenedorHorizontal);
    }

    private List<VBox> crearBotones(AlgoStar algoStar, AlgoStarView algoView, Coordenada coordenada){

        Button construirCriadero = new Button();
        construirCriadero.getStyleClass().add("btn-botonera-accion");
        construirCriadero.setText("construir Criadero");
        Label costoGasCriadero = new Label("COSTO GAS: 0");
        costoGasCriadero.getStyleClass().add("label-botonera");
        Label costoMineralCriadero  = new Label("COSTO MINERAL: 200");
        costoMineralCriadero.getStyleClass().add("label-botonera");
        VBox generarCriaderobox = new VBox(costoGasCriadero,costoMineralCriadero,construirCriadero);
        
        Button construirEspiral = new Button();
        construirEspiral.setText("construir Espiral");
        construirEspiral.getStyleClass().add("btn-botonera-accion");
        Label costoGasEspiral = new Label("COSTO GAS: 100");
        costoGasEspiral.getStyleClass().add("label-botonera");
        Label costoMineralEspiral  = new Label("COSTO MINERAL: 150");
        costoMineralEspiral.getStyleClass().add("label-botonera");
        VBox generarEspiralbox = new VBox(costoGasEspiral,costoMineralEspiral,construirEspiral);

        Button construirExtractor = new Button();
        construirExtractor.setText("construir Extractor");
        construirExtractor.getStyleClass().add("btn-botonera-accion");
        Label costoGasExtractor = new Label("COSTO GAS: 0");
        costoGasExtractor.getStyleClass().add("label-botonera");
        Label costoMineralExtractor  = new Label("COSTO MINERAL: 100");
        costoMineralExtractor.getStyleClass().add("label-botonera");
        VBox generarExtractorbox = new VBox(costoGasExtractor,costoMineralExtractor,construirExtractor);

        Button construirGuarida = new Button();
        construirGuarida.setText("construir Guarida");
        construirGuarida.getStyleClass().add("btn-botonera-accion");
        Label costoGasGuarida = new Label("COSTO GAS: 100");
        costoGasGuarida.getStyleClass().add("label-botonera");
        Label costoMineralGuarida  = new Label("COSTO MINERAL: 200");
        costoMineralGuarida.getStyleClass().add("label-botonera");
        VBox generarGuaridabox = new VBox(costoGasGuarida,costoMineralGuarida,construirGuarida);

        Button construirReservaDeReproduccion = new Button();
        construirReservaDeReproduccion.setText("construir Reserva De Reproduccion");
        construirReservaDeReproduccion.getStyleClass().add("btn-botonera-accion");
        Label costoGasReservaDeReproduccion = new Label("COSTO GAS: 0");
        costoGasReservaDeReproduccion.getStyleClass().add("label-botonera");
        Label costoMineralReservaDeReproduccion  = new Label("COSTO MINERAL: 150");
        costoMineralReservaDeReproduccion.getStyleClass().add("label-botonera");
        VBox generarReservaDeReproduccionbox = new VBox(costoGasReservaDeReproduccion,costoMineralReservaDeReproduccion,construirReservaDeReproduccion);

        Image arriba = new Image("flecha-arriba.png" ,35, 35, false, false);
        Image abajo = new Image("flecha-abajo.png",35, 35, false, false);
        Image derecha = new Image("flecha-derecha.png",35, 35, false, false);
        Image izquierda = new Image("flecha-izquierda.png",35, 35, false, false);

        Button moverAbajo = new Button();
        moverAbajo.setGraphic(new ImageView(abajo));
        moverAbajo.getStyleClass().add("btn-botonera-direcciones");
        Button moverArriba = new Button();
        moverArriba.setGraphic(new ImageView(arriba));
        moverArriba.getStyleClass().add("btn-botonera-direcciones");
        Button moverIzquierda = new Button();
        moverIzquierda.setGraphic(new ImageView(izquierda));
        moverIzquierda.getStyleClass().add("btn-botonera-direcciones");
        Button moverDerecha = new Button();
        moverDerecha.setGraphic(new ImageView(derecha));
        moverDerecha.getStyleClass().add("btn-botonera-direcciones");

        VBox generarAbajobox = new VBox(moverAbajo);
        VBox generarArribabox = new VBox(moverArriba);
        VBox generarIzquierdabox = new VBox(moverIzquierda);
        VBox generarDerechabox = new VBox(moverDerecha);

        Button ingresar = new Button();
        ingresar.setText("ingresar");
        ingresar.getStyleClass().add("btn-botonera-accion");
        VBox generaringresarbox = new VBox(ingresar);

       /* ingresar.setOnAction(event ->  {
            algoView.ingreso(coordenada);
        });*/


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
        /*
        ingresar.setOnAction(event ->  {
            algoView.ingreso(coordenada);
        });*/

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
