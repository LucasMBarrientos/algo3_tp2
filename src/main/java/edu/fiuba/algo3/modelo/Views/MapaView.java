package edu.fiuba.algo3.modelo.Views;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.Unidad;
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


    //#region Imagenes
    Image imagenVacio = new  Image("/imgVacio.jpg", 35, 35, false, false);
    Image imagenVolcan = new  Image("/imgVolcan.jpg", 35, 35, false, false);
    Image imagenMoho = new  Image("/imgMoho.jpg", 35, 35, false, false);
    Image imagenMineral = new  Image("/imgMineral.jpg", 35, 35, false, false);
    Image imagenEnergizado = new  Image("/imgEnergizado.jpg", 35, 35, false, false);
    Image imagenEspecial = new  Image("/imgEspeciales.jpg", 35, 35, false, false);

    Image imagenAmoSupremo = new Image("/AmoSupremo.png", 35, 35, false, false);
    Image imagenZangano = new Image("/Zangano.png", 35, 35, false, false);
    Image imagenZerling = new Image("/Zerling.png", 35, 35, false, false);
    Image imagenHidralisco = new Image("/Hidralisco.png", 35, 35, false, false);
    Image imagenMutalisco = new Image("/Mutalisco.png", 35, 35, false, false);
    Image imagenGuardian = new Image("/Guardian.png", 35, 35, false, false);
    Image imagenDevorador = new Image("/Devorador.png", 35, 35, false, false);
    Image imagenZealot = new Image("/Zealot.png", 35, 35, false, false);
    Image imagenDragon = new Image("/Dragon.png", 35, 35, false, false);
    Image imagenScout = new Image("/Scout.png", 35, 35, false, false);
    
    Image imagenCriadero = new Image("/Criadero.png", 35, 35, false, false);
    Image imagenReservaDeReproduccion = new Image("/ReservaDeReproduccion.png", 35, 35, false, false);
    Image imagenExtractor = new Image("/Extractor.png", 35, 35, false, false);
    Image imagenGuarida = new Image("/Guarida.png", 35, 35, false, false);
    Image imagenEspiral = new Image("/Espiral.png", 35, 35, false, false);
    Image imagenNexoMineral = new Image("/NexoMineral.png", 35, 35, false, false);
    Image imagenPilon = new Image("/Pilon.png", 35, 35, false, false);
    Image imagenAsimilador = new Image("/Asimilador.png", 35, 35, false, false);
    Image imagenAcceso = new Image("/Acceso.png", 35, 35, false, false);
    Image imagenPuertoEstelar = new Image("/PuertoEstelar.png", 35, 35, false, false);

    double opacityConstruido = 1;
    double opacityEnConstruccion = 0.5;

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
        List<ObjectNode> nodos = null;
        try {
            nodos = mapa.toJsonOcupantes();

        }catch (JsonProcessingException e){
            System.out.println("Error al mostrar Ocupantes");
        }

        int sizeX = 10;
        int sizeY = 10;
        int posX = 2 ;
        int posY = 2 ;
        int separacion = 40;
        ocupanteGroup.getChildren().clear();
        
        for (JsonNode nodo : nodos) {
            switch (nodo.get("Ocupante").get("nombre").asText()){
                case "AmoSupremo":{
                  ImageView imageAmoSupremoSprite= new ImageView(imagenAmoSupremo);
                  imageAmoSupremoSprite.setY(posY*separacion);
                  imageAmoSupremoSprite.setX(posX*separacion);
                  imageAmoSupremoSprite.setOnMouseClicked(event ->  {
                      int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
                      int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
                      setStatsUnidad(nodo);
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraAmoSupremo(coor);
                  });
                  ocupanteGroup.getChildren().add(imageAmoSupremoSprite);
                  break;
                }
                case "Zangano":{
                  ImageView imageZanganoSprite= new ImageView(imagenZangano);
                  imageZanganoSprite.setY(posY*separacion);
                  imageZanganoSprite.setX(posX*separacion);
                  imageZanganoSprite.setOnMouseClicked(event ->  {
                      int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
                      int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
                      setStatsUnidad(nodo);
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraZangano(coor);
                  });
                  ocupanteGroup.getChildren().add(imageZanganoSprite);
                  break;
                }
                case "Zerling":{
                  ImageView imageZerlingSprite= new ImageView(imagenZerling);
                  imageZerlingSprite.setY(posY*separacion);
                  imageZerlingSprite.setX(posX*separacion);
                  imageZerlingSprite.setOnMouseClicked(event ->  {
                      int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
                      int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
                      setStatsUnidad(nodo);
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraUnidadNormal(coor);
                  });
                  ocupanteGroup.getChildren().add(imageZerlingSprite);
                  break;
                }
                case "Hidralisco":{
                    ImageView imageHidraliscoSprite= new ImageView(imagenHidralisco);
                    imageHidraliscoSprite.setY(posY*separacion);
                    imageHidraliscoSprite.setX(posX*separacion);
                    imageHidraliscoSprite.setOnMouseClicked(event ->  {
                        int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
                        int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
                        setStatsUnidad(nodo);
                        Coordenada coor = new Coordenada(x,y);
                        algoStarView.crearBotoneraUnidadNormal(coor);
                    });
                    ocupanteGroup.getChildren().add(imageHidraliscoSprite);
                    break;
                }
                case "Mutalisco":{
                  ImageView imageMutaliscoSprite= new ImageView(imagenMutalisco);
                  imageMutaliscoSprite.setY(posY*separacion);
                  imageMutaliscoSprite.setX(posX*separacion);
                  imageMutaliscoSprite.setOnMouseClicked(event ->  {
                      int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
                      int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
                      setStatsUnidad(nodo);
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraMutalisco(coor);
                  });
                  ocupanteGroup.getChildren().add(imageMutaliscoSprite);
                  break;
                }
                case "Guardian":{
                  ImageView imageGuardianSprite= new ImageView(imagenGuardian);
                  imageGuardianSprite.setY(posY*separacion);
                  imageGuardianSprite.setX(posX*separacion);
                  imageGuardianSprite.setOnMouseClicked(event ->  {
                      int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
                      int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
                      setStatsUnidad(nodo);
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraUnidadNormal(coor);
                  });
                  ocupanteGroup.getChildren().add(imageGuardianSprite);
                  break;
                }
                case "Devorador":{
                  ImageView imageDevoradorSprite= new ImageView(imagenDevorador);
                  imageDevoradorSprite.setY(posY*separacion);
                  imageDevoradorSprite.setX(posX*separacion);
                  imageDevoradorSprite.setOnMouseClicked(event ->  {
                      int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
                      int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
                      setStatsUnidad(nodo);
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraUnidadNormal(coor);
                  });
                  ocupanteGroup.getChildren().add(imageDevoradorSprite);
                  break;
                }
                case "Zealot":{
                  ImageView imageZealotSprite= new ImageView(imagenZealot);
                  imageZealotSprite.setY(posY*separacion);
                  imageZealotSprite.setX(posX*separacion);
                  imageZealotSprite.setOnMouseClicked(event ->  {
                      int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
                      int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
                      setStatsUnidad(nodo);
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraUnidadNormal(coor);
                  });
                  ocupanteGroup.getChildren().add(imageZealotSprite);
                  break;
                }
                case "Dragon":{
                  ImageView imageDragonSprite= new ImageView(imagenDragon);
                  imageDragonSprite.setY(posY*separacion);
                  imageDragonSprite.setX(posX*separacion);
                  imageDragonSprite.setOnMouseClicked(event ->  {
                      int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
                      int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
                      setStatsUnidad(nodo);
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraUnidadNormal(coor);
                  });
                  ocupanteGroup.getChildren().add(imageDragonSprite);
                  break;
                }
                case "Scout":{
                  ImageView imageScoutSprite= new ImageView(imagenScout);
                  imageScoutSprite.setY(posY*separacion);
                  imageScoutSprite.setX(posX*separacion);
                  imageScoutSprite.setOnMouseClicked(event ->  {
                      int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
                      int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
                      setStatsUnidad(nodo);
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraUnidadNormal(coor);
                  });
                  ocupanteGroup.getChildren().add(imageScoutSprite);
                  break;
                }
                case "Criadero":{
                    ImageView imageCriaderoSprite= new ImageView(imagenCriadero);
                    imageCriaderoSprite.setY(posY*separacion);
                    imageCriaderoSprite.setX(posX*separacion);
                    imageCriaderoSprite.setOnMouseClicked(event ->  {
                      int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
                      int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
                      setStatsEdificio(nodo);
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraCriadero(coor);
                    });
                    ocupanteGroup.getChildren().add(imageCriaderoSprite);
                    break;
                }
                case "ReservaDeReproduccion":{
                    ImageView imagenReservaDeReproduccionSprite= new ImageView(imagenReservaDeReproduccion);
                    imagenReservaDeReproduccionSprite.setY(posY*separacion);
                    imagenReservaDeReproduccionSprite.setX(posX*separacion);
                    imagenReservaDeReproduccionSprite.setOnMouseClicked(event ->  {
                      int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
                      int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
                      setStatsEdificio(nodo);
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraReservaDeReproduccion(coor);
                    });
                    ocupanteGroup.getChildren().add(imagenReservaDeReproduccionSprite);
                    break;
                }
                case "Extractor":{
                  ImageView imagenExtractorSprite= new ImageView(imagenExtractor);
                  imagenExtractorSprite.setY(posY*separacion);
                  imagenExtractorSprite.setX(posX*separacion);
                  imagenExtractorSprite.setOnMouseClicked(event ->  {
                    int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
                    int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
                    setStatsEdificio(nodo);
                    Coordenada coor = new Coordenada(x,y);
                    algoStarView.setBottom(algoStarView.crearBotoneraVacia(coor));
                  });
                  ocupanteGroup.getChildren().add(imagenExtractorSprite);
                  break;
                }
                case "Guarida":{
                  ImageView imagenGuaridaSprite= new ImageView(imagenGuarida);
                  imagenGuaridaSprite.setY(posY*separacion);
                  imagenGuaridaSprite.setX(posX*separacion);
                  imagenGuaridaSprite.setOnMouseClicked(event ->  {
                      int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
                      int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
                      setStatsEdificio(nodo);
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraGuarida(coor);
                  });
                  ocupanteGroup.getChildren().add(imagenGuaridaSprite);
                  break;
                }
                case "Espiral":{
                  ImageView imagenEspiralSprite= new ImageView(imagenEspiral);
                  imagenEspiralSprite.setY(posY*separacion);
                  imagenEspiralSprite.setX(posX*separacion);
                  imagenEspiralSprite.setOnMouseClicked(event ->  {
                      int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
                      int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
                      setStatsEdificio(nodo);
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraEspiral(coor);
                  });
                  ocupanteGroup.getChildren().add(imagenEspiralSprite);
                  break;
                }
                case "NexoMineral":{
                  ImageView imagenNexoMineralSprite= new ImageView(imagenNexoMineral);
                  imagenNexoMineralSprite.setY(posY*separacion);
                  imagenNexoMineralSprite.setX(posX*separacion);
                  imagenNexoMineralSprite.setOnMouseClicked(event ->  {
                    int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
                    int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
                    setStatsEdificio(nodo);
                    Coordenada coor = new Coordenada(x,y);
                    algoStarView.setBottom(algoStarView.crearBotoneraVacia(coor));
                  });
                  ocupanteGroup.getChildren().add(imagenNexoMineralSprite);
                  break;
                }
                case "Pilon":{
                  ImageView imagenPilonSprite= new ImageView(imagenPilon);
                  imagenPilonSprite.setY(posY*separacion);
                  imagenPilonSprite.setX(posX*separacion);
                  imagenPilonSprite.setOnMouseClicked(event ->  {
                    int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
                    int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
                    setStatsEdificio(nodo);
                    Coordenada coor = new Coordenada(x,y);
                    algoStarView.setBottom(algoStarView.crearBotoneraVacia(coor));
                  });
                  ocupanteGroup.getChildren().add(imagenPilonSprite);
                  break;
                }
                case "Asimilador":{
                  ImageView imagenAsimiladorSprite= new ImageView(imagenAsimilador);
                  imagenAsimiladorSprite.setY(posY*separacion);
                  imagenAsimiladorSprite.setX(posX*separacion);
                  imagenAsimiladorSprite.setOnMouseClicked(event ->  {
                    int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
                    int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
                    setStatsEdificio(nodo);
                    Coordenada coor = new Coordenada(x,y);
                    algoStarView.setBottom(algoStarView.crearBotoneraVacia(coor));
                  });
                  ocupanteGroup.getChildren().add(imagenAsimiladorSprite);
                  break;
                }
                case "Acceso":{
                  ImageView imagenAccesoSprite= new ImageView(imagenAcceso);
                  imagenAccesoSprite.setY(posY*separacion);
                  imagenAccesoSprite.setX(posX*separacion);
                  imagenAccesoSprite.setOnMouseClicked(event ->  {
                      int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
                      int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
                      setStatsEdificio(nodo);
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraAcceso(coor);
                  });
                  ocupanteGroup.getChildren().add(imagenAccesoSprite);
                  break;
                }
                case "PuertoEstelar":{
                  ImageView imagenPuertoEstelarSprite= new ImageView(imagenPuertoEstelar);
                  imagenPuertoEstelarSprite.setY(posY*separacion);
                  imagenPuertoEstelarSprite.setX(posX*separacion);
                  imagenPuertoEstelarSprite.setOnMouseClicked(event ->  {
                    int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
                    int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
                    setStatsEdificio(nodo);
                    Coordenada coor = new Coordenada(x,y);
                    algoStarView.crearBotoneraPuertoEstelar(coor);
                  });
                  ocupanteGroup.getChildren().add(imagenPuertoEstelarSprite);
                  break;
                }
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

    private void setStatsUnidad(JsonNode node){
        algoStarView.setPantallDeStatsUnidad(node);
    }

    private void setStatsEdificio(JsonNode node){
        algoStarView.setPantallDeStatsEdificio(node);
    }

    private void dibujarTerrenos(){
        List<ObjectNode> nodos = null;
        try {
            nodos = mapa.toJsonTerrenos();
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
        for (JsonNode nodo : nodos) {
            switch (nodo.get("nombre").asText()){
                case "Aereo":{
                    ImageView imageEspecialesSprite= new ImageView(imagenEspecial);
                    imageEspecialesSprite.setY(posY*separacion);
                    imageEspecialesSprite.setX(posX*separacion);
                    imageEspecialesSprite.setOnMouseClicked(event ->  {
                      int x = nodo.get("coordenada").get("x").asInt();
                      int y = nodo.get("coordenada").get("y").asInt();
                      Coordenada coor = new Coordenada(x,y);
                      System.out.println(x);
                      System.out.println(y);
                      algoStarView.setBottom(algoStarView.crearBotoneraVacia(coor));
                    });
                    terrenoGroup.getChildren().add(imageEspecialesSprite);
                    break;
                }
                case "Vacio":{
                    ImageView imageVacioSprite= new ImageView(imagenVacio);
                    imageVacioSprite.setY(posY*separacion);
                    imageVacioSprite.setX(posX*separacion);
                    imageVacioSprite.setOnMouseClicked(event ->  {
                      int x = nodo.get("coordenada").get("x").asInt();
                      int y = nodo.get("coordenada").get("y").asInt();
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraTerrenoVacio(coor);
                    });
                    terrenoGroup.getChildren().add(imageVacioSprite);
                    break;
                }
                case "Mineral":{
                    ImageView imageMineralSprite= new ImageView(imagenMineral);
                    imageMineralSprite.setY(posY*separacion);
                    imageMineralSprite.setX(posX*separacion);
                    imageMineralSprite.setOnMouseClicked(event ->  {
                      int x = nodo.get("coordenada").get("x").asInt();
                      int y = nodo.get("coordenada").get("y").asInt();
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraMineral(coor);
                    });
                    terrenoGroup.getChildren().add(imageMineralSprite);
                    break;
                }
                case "Moho":{
                    ImageView imageMohoSprite= new ImageView(imagenMoho);
                    imageMohoSprite.setY(posY*separacion);
                    imageMohoSprite.setX(posX*separacion);
                    imageMohoSprite.setOnMouseClicked(event ->  {
                      int x = nodo.get("coordenada").get("x").asInt();
                      int y = nodo.get("coordenada").get("y").asInt();
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.setBottom(algoStarView.crearBotoneraVacia(coor));
                    });
                    terrenoGroup.getChildren().add(imageMohoSprite);
                    break;
                }
                case "Volcan":{
                    ImageView imageVolcanSprite= new ImageView(imagenVolcan);
                    imageVolcanSprite.setY(posY*separacion);
                    imageVolcanSprite.setX(posX*separacion);
                    imageVolcanSprite.setOnMouseClicked(event ->  {
                      int x = nodo.get("coordenada").get("x").asInt();
                      int y = nodo.get("coordenada").get("y").asInt();
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraVolcan(coor);
                    });
                    terrenoGroup.getChildren().add(imageVolcanSprite);
                    
                    break;
                }
                case "Energizado":{
                    ImageView imageEnergizadoSprite= new ImageView(imagenEnergizado);
                    imageEnergizadoSprite.setY(posY*separacion);
                    imageEnergizadoSprite.setX(posX*separacion);
                    imageEnergizadoSprite.setOnMouseClicked(event ->  {
                      int x = nodo.get("coordenada").get("x").asInt();
                      int y = nodo.get("coordenada").get("y").asInt();
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraEnergizado(coor);
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
