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

public class BotoneraIngresarAExtractor extends HBox{

    public BotoneraIngresarAExtractor(AlgoStar algoStar, AlgoStarView algoView, Coordenada coordenada){
        TextField textField1 = crearTextField1();
        TextField textField2 = crearTextField2();
        Button buttons = crearBoton(algoStar, algoView, coordenada, textField1, textField2);
        HBox contenedorHorizontal = new HBox (textField1,buttons, textField2);
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(25));
    }

    private TextField crearTextField1(){
        TextField coord1 = new TextField();
        return  coord1;
    }

    private TextField crearTextField2(){
        TextField coord2 = new TextField();

        return  coord2;
    }

    private Button crearBoton(AlgoStar algoStar, AlgoStarView algoView, Coordenada coordenada, TextField textFields1, TextField textField2){
        Button atacar = new Button();
        atacar.setText("Ingresar");

        BotonAtacarHandler botonAtacarHandler = new BotonAtacarHandler(algoStar, algoView, coordenada, textFields1, textField2);
        atacar.setOnAction(botonAtacarHandler);
        return atacar;
    }

}
