package edu.fiuba.algo3.modelo.Views;

import edu.fiuba.algo3.modelo.AlgoStar;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MapaView {
    AlgoStar algoStar;
    Canvas canvas;
    public MapaView(Canvas canvas, AlgoStar algoStar) {
        this.algoStar = algoStar;
        this.canvas = canvas;

    }

    public void dibujar() {
        dibujarTerrenos();
    }

    private void dibujarTerrenos(){
        canvas.getGraphicsContext2D().setFill(Color.ORANGE);
        canvas.getGraphicsContext2D().fillRect(500,500,500,500);
        //Aca se dibujarian los terrenos
    }
}
