package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonAtacarHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonIngresarUnidadHandler;
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

        this.getChildren().clear();
        this.getChildren().addAll(textField1,textField2);
        this.getChildren().addAll(buttons);
        this.setSpacing(10);
        this.setPadding(new Insets(25));

    }

    private TextField crearTextField1(){
        return new TextField();
    }

    private TextField crearTextField2(){
        return new TextField();
    }

    private Button crearBoton(AlgoStar algoStar, AlgoStarView algoView, Coordenada coordenada, TextField textFields1, TextField textField2){
        Button ingresar = new Button();
        ingresar.setText("Ingresar");


        BotonIngresarUnidadHandler botonAtacarHandler = new BotonIngresarUnidadHandler(algoStar, algoView, coordenada,textFields1,textField2);
        ingresar.setOnAction(botonAtacarHandler);
        return ingresar;
    }

}
