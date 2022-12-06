package edu.fiuba.algo3.modelo.Views.eventos.botoneras.unidades;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonMoverAbajoHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonMoverArribaHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonMoverDerechaHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonMoverIzquierdaHandler;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class BotoneraAmoSupremo extends HBox {
    public BotoneraAmoSupremo(AlgoStar algoStar, AlgoStarView algoView, Coordenada coordenada){
        List<Button> buttons = crearBotones(algoStar, algoView, coordenada);
        HBox contenedorHorizontal = new HBox((Node) buttons);
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(25));
    }

    private List<Button> crearBotones(AlgoStar algoStar, AlgoStarView algoView, Coordenada coordenada){

        Button moverAbajo = new Button();
        Button moverArriba = new Button();
        Button moverIzquierda = new Button();
        Button moverDerecha = new Button();


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
