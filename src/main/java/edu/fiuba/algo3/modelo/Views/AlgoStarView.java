package edu.fiuba.algo3.modelo.Views;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class AlgoStarView {

    Stage stage;
    AlgoStar algoStar;

    Group layout;

    Coordenada limite;

    Rectangle mapa;

    public AlgoStarView(Stage stage) {
        this.stage = stage;
        algoStar = new AlgoStar();
        limite = new Coordenada(100,20);
        pantallaInicial();
    }

    private void pantallaInicial(){
        //TODO: pedir datos de jugador
        pantallaJuego();
    }

    private void pantallaJuego(){
        layout = new Group();
        dibujarMapa();

        stage.setScene(new Scene(layout, 1620, 720));
        stage.show();

    }

    private void dibujarMapa(){

        layout.getChildren().add(mapa);
    }
}
