package edu.fiuba.algo3.modelo.Views;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.Mapa;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
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
        dibujarOcupantes();
    }

    private void dibujarOcupantes()  {
        List<String> infoMapa = new ArrayList<>();
        List<ObjectNode> node = null;
        try {
            node = mapa.toJsonOcupantes();
            //infoMapa = Json.JsonArrayToList(node);

        }catch (JsonProcessingException e){
            System.out.println("Error al mostrar Ocupantes");
        }

        int sizeX = 10;
        int sizeY = 10;
        int posX = 2 ;
        int posY = 2 ;
        int separacion = 40;

        for (JsonNode ocupante : node) {
            JsonNode a = ocupante.get("Ocupante");
            switch (ocupante.get("Ocupante").asText()){
                case "Desocupado":{
                    canvas.getGraphicsContext2D().setFill(Color.DARKBLUE);
                    canvas.getGraphicsContext2D().fillRect(posX*separacion,posY*separacion,sizeX,sizeY);
                    break;
                }
                case "Vacio":{
                    canvas.getGraphicsContext2D().setFill(Color.WHITE);
                    canvas.getGraphicsContext2D().fillRect(posX*separacion,posY*separacion,sizeX,sizeY);
                    break;
                }
                case "Mineral":{
                    canvas.getGraphicsContext2D().setFill(Color.GOLD);
                    canvas.getGraphicsContext2D().fillRect(posX*separacion,posY*separacion,sizeX,sizeY);
                    break;
                }
                case "Moho":{
                    canvas.getGraphicsContext2D().setFill(Color.GREENYELLOW);
                    canvas.getGraphicsContext2D().fillRect(posX*separacion,posY*separacion,sizeX,sizeY);
                    break;
                }
                case "Volcan":{
                    canvas.getGraphicsContext2D().setFill(Color.RED);
                    canvas.getGraphicsContext2D().fillRect(posX*separacion,posY*separacion,sizeX,sizeY);
                    break;
                }
                case "Energizado":{
                    canvas.getGraphicsContext2D().setFill(Color.BLUE);
                    canvas.getGraphicsContext2D().fillRect(posX*separacion,posY*separacion,sizeX,2);
                    break;
                }
                case "cambioDeLinea":{
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

    private void dibujarTerrenos(){
        List<String> infoMapa = new ArrayList<String>();

        Group layout = new Group();
        try {
            JsonNode node = mapa.toJsonTerrenos().get("terrenos");
            infoMapa = Json.JsonArrayToList(node);

        }catch (JsonProcessingException e){
             System.out.println("Error al mostrar terrenos");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //Aca se dibujarian los terrenos
        int sizeX = 35;
        int sizeY = 35;
        int posX = 2 ;
        int posY = 2 ;
        int separacion = 40;

        for (String terreno : infoMapa) {
            switch (terreno){
                case "Aereo":{
                    canvas.getGraphicsContext2D().setFill(Color.DARKBLUE);
                    canvas.getGraphicsContext2D().fillRect(posX*separacion,posY*separacion,sizeX,sizeY);
                    break;
                }
                case "Vacio":{
                    canvas.getGraphicsContext2D().setFill(Color.WHITE);
                    canvas.getGraphicsContext2D().fillRect(posX*separacion,posY*separacion,sizeX,sizeY);
                    break;
                }
                case "Mineral":{
                    canvas.getGraphicsContext2D().setFill(Color.GOLD);
                    canvas.getGraphicsContext2D().fillRect(posX*separacion,posY*separacion,sizeX,sizeY);
                    break;
                }
                case "Moho":{
                    canvas.getGraphicsContext2D().setFill(Color.GREENYELLOW);
                    canvas.getGraphicsContext2D().fillRect(posX*separacion,posY*separacion,sizeX,sizeY);
                    break;
                }
                case "Volcan":{
                    canvas.getGraphicsContext2D().setFill(Color.RED);
                    canvas.getGraphicsContext2D().fillRect(posX*separacion,posY*separacion,sizeX,sizeY);
                    break;
                }
                case "Energizado":{
                    canvas.getGraphicsContext2D().setFill(Color.BLUE);
                    canvas.getGraphicsContext2D().fillRect(posX*separacion,posY*separacion,sizeX,2);
                    break;
                }
                case "cambioDeLinea":{
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
