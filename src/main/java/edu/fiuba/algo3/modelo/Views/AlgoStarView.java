package edu.fiuba.algo3.modelo.Views;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class AlgoStarView extends BorderPane {

    BarraDelMenu menuBar;

    Stage stage;
    AlgoStar algoStar;

    Group layout;

    Coordenada limite;

    Mapa mapa;

    public AlgoStarView(Stage stage, AlgoStar algostar) {
        this.algoStar = algostar;
        setMenu(stage);
        pantallaJuego();
        setBotonera();
        this.stage = stage;
        limite = new Coordenada(100,20);
        mapa = algoStar.empezarJuego();
    }

    private void setBotonera() {
        //Aca iría las cosas de la botonera

        Button botonConstruir = new Button();
        botonConstruir.setText("Construir");
        // handler del boton construir


        HBox contenedorHorizontal = new HBox(botonConstruir); // <- recibe los botones como parametro
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(25));

        this.setBottom(contenedorHorizontal);
    }

    private void setMenu(Stage stage){
        this.menuBar = new BarraDelMenu(stage);
        this.setTop(menuBar);
    }

    private void pantallaJuego(){
        Canvas escenaCentral = new Canvas(1620,780);

        MapaView mapaView = new MapaView(escenaCentral, algoStar);
        mapaView.dibujar();

        VBox contenedorCentral = new VBox(escenaCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));


        this.setCenter(contenedorCentral);
    }

    private void dibujarMapa(){
        //TODO: todo lo pertinente a mapa
        //layout.getChildren().add(mapa);
    }
}
