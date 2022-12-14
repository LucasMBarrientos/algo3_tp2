package edu.fiuba.algo3.modelo.Views.eventos.botoneras.unidades;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonMoverAbajoHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonMoverArribaHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonMoverDerechaHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonMoverIzquierdaHandler;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BotoneraAmoSupremo extends HBox {
    public BotoneraAmoSupremo(AlgoStar algoStar, AlgoStarView algoView, Coordenada coordenada, Stage pantalla){
        HBox contenedorHorizontal = new HBox();  
        List<Button> buttons = crearBotones(algoStar, algoView, coordenada);
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

    private List<Button> crearBotones(AlgoStar algoStar, AlgoStarView algoView, Coordenada coordenada){

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

        BotonMoverAbajoHandler botonMoverAbajoHandler = new BotonMoverAbajoHandler(algoStar, algoView, coordenada);
        moverAbajo.setOnAction(botonMoverAbajoHandler);

        BotonMoverArribaHandler botonMoverArribaHandler = new BotonMoverArribaHandler(algoStar, algoView, coordenada);
        moverArriba.setOnAction(botonMoverArribaHandler);

        BotonMoverIzquierdaHandler botonMoverIzquierdaHandler = new BotonMoverIzquierdaHandler(algoStar, algoView, coordenada);
        moverIzquierda.setOnAction(botonMoverIzquierdaHandler);

        BotonMoverDerechaHandler botonMoverDerechaHandler = new BotonMoverDerechaHandler(algoStar, algoView, coordenada);
        moverDerecha.setOnAction(botonMoverDerechaHandler);


        List<Button> botones = new ArrayList<>();
        botones.add(moverAbajo);
        botones.add(moverArriba);
        botones.add(moverIzquierda);
        botones.add(moverDerecha);

        return botones;
    }
}
