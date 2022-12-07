package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonIngresarUnidadHandler;
import edu.fiuba.algo3.modelo.geometria.Coordenada;

public class BotoneraIngresarAExtractor extends HBox {

    public BotoneraIngresarAExtractor(AlgoStar algoStar, AlgoStarView algoView, Coordenada coordenada){
        TextField casillaDeTexto1 = crearCasillaDeTexto();
        TextField casillaDeTexto2 = crearCasillaDeTexto();
        Button buttons = crearBoton(algoStar, algoView, coordenada, casillaDeTexto1, casillaDeTexto2);
        this.getChildren().clear();
        this.getChildren().addAll(casillaDeTexto1, casillaDeTexto2);
        this.getChildren().addAll(buttons);
        this.setSpacing(10);
        this.setPadding(new Insets(25));
    }

    private TextField crearCasillaDeTexto(){
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
