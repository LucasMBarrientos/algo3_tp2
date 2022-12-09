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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BotoneraMutalisco extends HBox {
    public BotoneraMutalisco(AlgoStar algoStar, AlgoStarView algoView, Coordenada coordenada){
        HBox contenedorHorizontal = new HBox();  
        List<Button> buttons = crearBotones(algoStar, algoView, coordenada);
      
        Label coordenadaX = new Label("CORDENADA X: " + coordenada.toData().get("x"));
        Label coordenadaY  = new Label("CORDENADA Y: "  + coordenada.toData().get("y"));
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
        Button moverArriba = new Button();
        moverArriba.setGraphic(new ImageView(arriba));
        Button moverIzquierda = new Button();
        moverIzquierda.setGraphic(new ImageView(izquierda));
        Button moverDerecha = new Button();
        moverDerecha.setGraphic(new ImageView(derecha));

        Button atacar = new Button();
        atacar.setText("atacar");
        Button evolucionarGuardian = new Button();
        evolucionarGuardian.setText("evolucionar Guardian");
        Button evolucionarDevorador = new Button();
        evolucionarDevorador.setText("evolucionar Devorador");


        BotonMoverAbajoHandler botonMoverAbajoHandler = new BotonMoverAbajoHandler(algoStar, algoView, coordenada);
        moverAbajo.setOnAction(botonMoverAbajoHandler);

        BotonMoverArribaHandler botonMoverArribaHandler = new BotonMoverArribaHandler(algoStar, algoView, coordenada);
        moverArriba.setOnAction(botonMoverArribaHandler);

        BotonMoverIzquierdaHandler botonMoverIzquierdaHandler = new BotonMoverIzquierdaHandler(algoStar, algoView, coordenada);
        moverIzquierda.setOnAction(botonMoverIzquierdaHandler);

        BotonMoverDerechaHandler botonMoverDerechaHandler = new BotonMoverDerechaHandler(algoStar, algoView, coordenada);
        moverDerecha.setOnAction(botonMoverDerechaHandler);

        BotonEmpezarAtaqueHandler botonAtacarHandler = new BotonEmpezarAtaqueHandler(algoStar, algoView, coordenada);
        atacar.setOnAction(botonAtacarHandler);

        BotonEvolucionarAGuardianHandler botonEvolucionarGuardianHandler = new BotonEvolucionarAGuardianHandler(algoStar, algoView, coordenada);
        evolucionarGuardian.setOnAction(botonEvolucionarGuardianHandler);

        BotonEvolucionarADevoradorHandler botonEvolucionarDevoradorHandler = new BotonEvolucionarADevoradorHandler(algoStar, algoView, coordenada);
        evolucionarDevorador.setOnAction(botonEvolucionarDevoradorHandler);

        List<Button> botones = new ArrayList<>();
        botones.add(moverAbajo);
        botones.add(moverArriba);
        botones.add(moverIzquierda);
        botones.add(moverDerecha);
        botones.add(atacar);
        botones.add(evolucionarGuardian);
        botones.add(evolucionarDevorador);

        return botones;
    }
}
