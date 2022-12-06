package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.BotoneraAtaque;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.BotoneraIngresarAExtractor;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

public class BotonEmpezarIngresoHandler implements EventHandler<ActionEvent> {

    AlgoStar algoStar;
    AlgoStarView algoStarView;

    Coordenada coordenadaUnidad;
    public BotonEmpezarIngresoHandler(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenadaUnidad) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        this.coordenadaUnidad = coordenadaUnidad;
    }

    @Override
    public void handle(ActionEvent evento) {
        BotoneraIngresarAExtractor contenedorHorizontal = new BotoneraIngresarAExtractor(algoStar,algoStarView,coordenadaUnidad); // <- Recibe los botones como parametro
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(25));
        algoStarView.setBottom(contenedorHorizontal);
    }
}
