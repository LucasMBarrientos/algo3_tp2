package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonAtacarHandler;
import edu.fiuba.algo3.modelo.geometria.Coordenada;

public class BotoneraAtaque extends HBox {

    public BotoneraAtaque(AlgoStar algoStar, AlgoStarView algoView, Coordenada coordenada) {
        List<TextField> casillasDeTexto = crearCasillasDeTexto();
        Button buttons = crearBoton(algoStar, algoView, coordenada, casillasDeTexto);
        this.getChildren().clear();
        this.getChildren().addAll(casillasDeTexto);
        this.getChildren().addAll(buttons);
        this.setSpacing(10);
        this.setPadding(new Insets(25));
    }

    private List<TextField> crearCasillasDeTexto() {
        List<TextField> casillasDeTexto = new ArrayList<TextField>();
        casillasDeTexto.add(new TextField());
        casillasDeTexto.add(new TextField());
        return casillasDeTexto;
    }

    private Button crearBoton(AlgoStar algoStar, AlgoStarView algoView, Coordenada coordenada,  List<TextField> casillasDeTexto) {
        Button atacar = new Button();
        atacar.setText("ATACAR!!!");
        BotonAtacarHandler botonAtacarHandler = new BotonAtacarHandler(algoStar, algoView, coordenada,  casillasDeTexto);
        atacar.setOnAction(botonAtacarHandler);
        return atacar;
    }

}
