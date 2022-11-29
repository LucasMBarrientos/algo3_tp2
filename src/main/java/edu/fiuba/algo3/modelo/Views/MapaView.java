package edu.fiuba.algo3.modelo.Views;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Mapa;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.List;

public class MapaView {
    Mapa mapa;
    Canvas canvas;


    public MapaView(Canvas canvas, Mapa mapa) {
        this.mapa = mapa;
        this.canvas = canvas;
       // this.canvas.getGraphicsContext2D().setFill(Color.BLACK);
      //  this.canvas.getGraphicsContext2D().fillRect(-100,-100 , 100000,100000);

    }

    public void dibujar() {
        dibujarTerrenos();
    }

    private void dibujarTerrenos(){
        Group layout = new Group();
        String infoMapa = mapa.getString();
        //Aca se dibujarian los terrenos
        String[] listaDeTerrenos = infoMapa.split("");
        int sizeX = 10;
        int sizeY = 10;
        int posX = 2 ;
        int posY = 2 ;

        int separacion = 15;
        for (int i = 0; i < listaDeTerrenos.length; i++) {
            switch (listaDeTerrenos[i]){
                case "a":{
                    canvas.getGraphicsContext2D().setFill(Color.DARKBLUE);
                    canvas.getGraphicsContext2D().fillRect(posX*separacion,posY*separacion,sizeX,sizeY);
                    break;
                }
                case "i":{
                    canvas.getGraphicsContext2D().setFill(Color.WHITE);
                    canvas.getGraphicsContext2D().fillRect(posX*separacion,posY*separacion,sizeX,sizeY);
                    break;
                }
                case "m":{
                    canvas.getGraphicsContext2D().setFill(Color.GOLD);
                    canvas.getGraphicsContext2D().fillRect(posX*separacion,posY*separacion,sizeX,sizeY);
                    break;
                }
                case "h":{
                    canvas.getGraphicsContext2D().setFill(Color.GREENYELLOW);
                    canvas.getGraphicsContext2D().fillRect(posX*separacion,posY*separacion,sizeX,sizeY);
                    break;
                }
                case "v":{
                    canvas.getGraphicsContext2D().setFill(Color.RED);
                    canvas.getGraphicsContext2D().fillRect(posX*separacion,posY*separacion,sizeX,sizeY);
                    break;
                }
                case "e":{
                    canvas.getGraphicsContext2D().setFill(Color.BLUE);
                    canvas.getGraphicsContext2D().fillRect(posX*separacion,posY*separacion,sizeX,2);
                    break;
                }
                case "0":{
                    posX = 1;
                    posY ++;
                    break;
                }
                default: {

                }
            }
            posX ++;
        }
    }
}
