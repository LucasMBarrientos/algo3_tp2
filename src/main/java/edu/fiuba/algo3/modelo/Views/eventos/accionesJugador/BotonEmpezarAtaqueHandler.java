package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.BotoneraAtaque;
import edu.fiuba.algo3.modelo.geometria.Coordenada;

public class BotonEmpezarAtaqueHandler implements EventHandler<ActionEvent> {

    AlgoStar algoStar;
    AlgoStarView algoStarView;
    Coordenada coordenadaDelAtacante;

    public BotonEmpezarAtaqueHandler(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenadaDelAtacante) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        this.coordenadaDelAtacante = coordenadaDelAtacante;
    }

    @Override
    public void handle(ActionEvent evento) {
        BotoneraAtaque contenedorHorizontal = new BotoneraAtaque(algoStar, algoStarView, coordenadaDelAtacante); // <- Recibe los botones como parametro
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(25));
        algoStarView.setBottom(contenedorHorizontal);
    }
}
