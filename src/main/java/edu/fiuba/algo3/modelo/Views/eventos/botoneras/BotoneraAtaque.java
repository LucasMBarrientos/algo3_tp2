package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonAtacarHandler;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class BotoneraAtaque extends HBox{

    public BotoneraAtaque(AlgoStar algoStar, AlgoStarView algoView, Coordenada coordenada){
        List<TextField> textFields = crearTextField();
        Button buttons = crearBoton(algoStar, algoView, coordenada, textFields);
        HBox contenedorHorizontal = new HBox((Node) textFields,buttons);
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(25));
    }

    private List<TextField> crearTextField(){
        TextField coord1 = new TextField();
        TextField coord2 = new TextField();

        List<TextField> textFields = new ArrayList<>();
        textFields.add(coord1);
        textFields.add(coord2);
        return  textFields;
    }

    private Button crearBoton(AlgoStar algoStar, AlgoStarView algoView, Coordenada coordenada, List<TextField> textFields){
        Button atacar = new Button();
        atacar.setText("ATACAR!!!");

        BotonAtacarHandler botonAtacarHandler = new BotonAtacarHandler(algoStar, algoView, coordenada, textFields);
        atacar.setOnAction(botonAtacarHandler);
        return atacar;
    }

}
