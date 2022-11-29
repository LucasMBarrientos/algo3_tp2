package edu.fiuba.algo3.modelo.Views;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class AlgoStarView extends BorderPane {

    BarraDelMenu menuBar;

    Stage stage;
    AlgoStar algoStar;

    Group layout;

    Coordenada limite;

    Rectangle mapa;

    public AlgoStarView(Stage stage) {
        this.setMenu(stage);
        this.stage = stage;
        algoStar = new AlgoStar();
        limite = new Coordenada(100,20);
        pantallaJuego();
    }

    private void setMenu(Stage stage){
        this.menuBar = new BarraDelMenu(stage);
        this.setTop(menuBar);
    }

    private void pantallaJuego(){
        layout = new Group();
        layout.getChildren().add(new Rectangle(10,10,10,10));
        dibujarMapa();
    }

    private void dibujarMapa(){
        //TODO: todo lo pertinente a mapa
        //layout.getChildren().add(mapa);
    }
}
