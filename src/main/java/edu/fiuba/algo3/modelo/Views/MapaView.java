package edu.fiuba.algo3.modelo.Views;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Mapa;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MapaView {
    Mapa mapa;
    Canvas canvas;


    public MapaView(Canvas canvas, Mapa mapa) {
        this.mapa = mapa;
        this.canvas = canvas;

    }

    public void dibujar() {
        dibujarTerrenos();
    }

    private void dibujarTerrenos(){
        mapa.getString();
        //Aca se dibujarian los terrenos
    }
}
