package edu.fiuba.algo3.modelo.Views;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.Mapa;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class MapaView {
/*
    var player = javafx.scene.media.MediaPlayer {
        repeatCount: javafx.scene.media.MediaPlayer.REPEAT_FOREVER
        media: Media { source: "{\_\_DIR\_\_}clip.wav"
        };
    };
    */
    Mapa mapa;
    AlgoStarView algoStarView;
    Group info = new Group();
    private Group terrenoGroup = new Group();
    private Group ocupanteGroup = new Group();
    Image imagenVacio = new  Image("/imgVacio.jpg", 35, 35, false, false);
    Image imagenVolcan = new  Image("/imgVolcan.jpg", 35, 35, false, false);
    Image imagenMoho = new  Image("/imgMoho.jpg", 35, 35, false, false);
    Image imagenMineral = new  Image("/imgMineral.jpg", 35, 35, false, false);
    Image imagenEnergizado = new  Image("/imgEnergizado.jpg", 35, 35, false, false);
    Image imagenEspecial = new  Image("/imgEspeciales.jpg", 35, 35, false, false);
    Image imagenZangano = new  Image("/imgEnergizado.jpg", 10, 10, false, false);
    

    public MapaView(Mapa mapa, AlgoStarView algoStarView) {
        this.mapa = mapa;
        this.algoStarView = algoStarView;
    }

    public Group dibujar() {
      info.getChildren().clear();
      dibujarTerrenos();
      dibujarOcupantes();
      return info;
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
        ocupanteGroup.getChildren().clear();
        for (JsonNode ocupante : node) {
            String a = ocupante.get("Ocupante").get("nombre").asText();
            switch (ocupante.get("Ocupante").get("nombre").asText()){
                case "Zangano":{
                    System.out.println("Zangano");
                    ImageView imageZanganoSprite= new ImageView(imagenZangano);
                    imageZanganoSprite.setY(posY*separacion + 35/2);
                    imageZanganoSprite.setX(posX*separacion + 35/2);
                    imageZanganoSprite.setOnMouseClicked(event ->  {
                      System.out.println("Zangano");
                    });
                    ocupanteGroup.getChildren().add(imageZanganoSprite);
                    //canvas.getGraphicsContext2D().setFill(Color.ORANGE);
                    //canvas.getGraphicsContext2D().fillRect(posX*separacion + 35/2,posY*separacion + 35/2 ,sizeX,sizeY);
                    break;
                }
                /*case "Vacio":{
                    canvas.getGraphicsContext2D().setFill(Color.WHITE);
                    canvas.getGraphicsContext2D().fillRect(posX*separacion,posY*separacion,sizeX,sizeY);
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
                }*/
                case "Desocupado":{
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
        info.getChildren().add(ocupanteGroup);
    }

    private void dibujarTerrenos(){
        List<String> infoMapa = new ArrayList<String>();
        
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
        terrenoGroup.getChildren().clear();
        for (String terreno : infoMapa) {
            switch (terreno){
                case "Aereo":{
                    ImageView imageEspecialesSprite= new ImageView(imagenEspecial);
                    imageEspecialesSprite.setY(posY*separacion);
                    imageEspecialesSprite.setX(posX*separacion);
                    imageEspecialesSprite.setOnMouseClicked(event ->  {
                      System.out.println("Vacio");
                    });
                    terrenoGroup.getChildren().add(imageEspecialesSprite);
                    break;
                }
                case "Vacio":{
                    ImageView imageVacioSprite= new ImageView(imagenVacio);
                    imageVacioSprite.setY(posY*separacion);
                    imageVacioSprite.setX(posX*separacion);
                    imageVacioSprite.setOnMouseClicked(event ->  {
                      System.out.println("Vacio");
                    });
                    terrenoGroup.getChildren().add(imageVacioSprite);
                    break;
                }
                case "Mineral":{
                    ImageView imageMineralSprite= new ImageView(imagenMineral);
                    imageMineralSprite.setY(posY*separacion);
                    imageMineralSprite.setX(posX*separacion);
                    imageMineralSprite.setOnMouseClicked(event ->  {
                      System.out.println("Mineral");
                    });
                    terrenoGroup.getChildren().add(imageMineralSprite);
                    break;
                }
                case "Moho":{
                    ImageView imageMohoSprite= new ImageView(imagenMoho);
                    imageMohoSprite.setY(posY*separacion);
                    imageMohoSprite.setX(posX*separacion);
                    imageMohoSprite.setOnMouseClicked(event ->  {
                      System.out.println("Moho");
                    });
                    terrenoGroup.getChildren().add(imageMohoSprite);
                    break;
                }
                case "Volcan":{
                    ImageView imageVolcanSprite= new ImageView(imagenVolcan);
                    imageVolcanSprite.setY(posY*separacion);
                    imageVolcanSprite.setX(posX*separacion);
                    imageVolcanSprite.setOnMouseClicked(event ->  {
                      System.out.println("Volcan");
                    });
                    terrenoGroup.getChildren().add(imageVolcanSprite);
                    
                    break;
                }
                case "Energizado":{
                    ImageView imageEnergizadoSprite= new ImageView(imagenEnergizado);
                    imageEnergizadoSprite.setY(posY*separacion);
                    imageEnergizadoSprite.setX(posX*separacion);
                    imageEnergizadoSprite.setOnMouseClicked(event ->  {
                      System.out.println("Energizado");
                    });
                    terrenoGroup.getChildren().add(imageEnergizadoSprite);
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
        info.getChildren().add(terrenoGroup);
    }
}
