package edu.fiuba.algo3.modelo.Views;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.List;


public class MapaView {

    AlgoStarView algoStarView;
    Group info = new Group();
    GridPane pruebaGrid = new GridPane();
    Coordenada unidadAtacante;
    private Group terrenoGroup = new Group();
    private Group ocupanteGroup = new Group();
    boolean atacando = false;

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
//#endregion

    double opacityVisible = 1;
    double opacityInvisible = 0.5;

    public MapaView(AlgoStarView algoStarView) {
        this.algoStarView = algoStarView;
    }

    /*public Group dibujar() {
      info.getChildren().clear();
      dibujarTerrenos();
      dibujarOcupantes();
      return info;
    }*/

    public GridPane dibujar() {
      atacando = false;
      pruebaGrid.getChildren().clear();
      dibujarTerrenos();
      dibujarOcupantes();
      return pruebaGrid;
    }

    public GridPane dibujar(boolean atacando, Coordenada unidadAtacante) {
      this.atacando = true;
      this.unidadAtacante = unidadAtacante;
      pruebaGrid.getChildren().clear();
      dibujarTerrenos();
      dibujarOcupantes();
      return pruebaGrid;
    }


    private void dibujarOcupantes()  {
        List<ObjectNode> nodos = null;
        try {
            nodos = Mapa.devolverInstancia().toJsonOcupantes();

        }catch (JsonProcessingException e){
            System.out.println("Error al mostrar Ocupantes");
        }

        int sizeX = 10;
        int sizeY = 10;
        int posX = 1 ;
        int posY = 1 ;
        //ocupanteGroup.getChildren().clear();
        
        for (JsonNode nodo : nodos) {
            switch (nodo.get("Ocupante").get("nombre").asText()){
                case "AmoSupremo":{
                  ImageView imageAmoSupremoSprite= new ImageView(imagenAmoSupremo);
                  BorderPane imageAmoSupremoWrapper = new BorderPane(imageAmoSupremoSprite);
                  imageAmoSupremoWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  imageAmoSupremoWrapper.setLayoutX(posX);
                  imageAmoSupremoWrapper.setLayoutY(posY);
                  imageAmoSupremoSprite.setOnMouseClicked(event ->  {
                    if(atacando){
                      algoStarView.realizarAtaque(unidadAtacante, crearCoordenada(nodo));
                      setStatsUnidad(nodo);
                    }else{
                      algoStarView.crearBotoneraAmoSupremo(crearCoordenada(nodo));
                      setStatsUnidad(nodo);
                    }
                  });
                  
                  imageAmoSupremoWrapper.setOnMouseEntered(event ->  {
                    imageAmoSupremoWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                  });
                  
                  imageAmoSupremoWrapper.setOnMouseExited(e -> {
                    imageAmoSupremoWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  });
                  //ocupanteGroup.getChildren().add(imageAmoSupremoSprite);
                  pruebaGrid.add(imageAmoSupremoWrapper, posX, posY);
                  break;
                }
                case "Zangano":{
                  ImageView imageZanganoSprite= new ImageView(imagenZangano);
                  BorderPane imageZanganoWrapper = new BorderPane(imageZanganoSprite);
                  imageZanganoWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  imageZanganoWrapper.setLayoutX(posX);
                  imageZanganoWrapper.setLayoutY(posY);
                  imageZanganoWrapper.setOnMouseClicked(event ->  {
                    if(atacando){
                        algoStarView.realizarAtaque(unidadAtacante, crearCoordenada(nodo));
                    }else{
                        algoStarView.crearBotoneraZangano(crearCoordenada(nodo));
                    }
                      setStatsUnidad(nodo);
                  });
                  imageZanganoWrapper.setOnMouseEntered(event ->  {
                    imageZanganoWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                  });
                  
                  imageZanganoWrapper.setOnMouseExited(e -> {
                    imageZanganoWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  });
                  //ocupanteGroup.getChildren().add(imageZanganoSprite);
                  pruebaGrid.add(imageZanganoWrapper, posX, posY);
                  break;
                }
                case "Zerling":{
                  ImageView imageZerlingSprite= new ImageView(imagenZerling);
                  BorderPane imageZerlingWrapper = new BorderPane(imageZerlingSprite);
                  imageZerlingWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  imageZerlingWrapper.setLayoutX(posX);
                  imageZerlingWrapper.setLayoutY(posY);
                  imageZerlingWrapper.setOnMouseClicked(event ->  {
                      if(atacando){
                          algoStarView.realizarAtaque(unidadAtacante, crearCoordenada(nodo));
                      }else{
                          algoStarView.crearBotoneraUnidadNormal(crearCoordenada(nodo));
                      }
                      setStatsUnidad(nodo);
                  });
                  imageZerlingWrapper.setOnMouseEntered(event ->  {
                    imageZerlingWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                  });
                  
                  imageZerlingWrapper.setOnMouseExited(e -> {
                    imageZerlingWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  });
                  //ocupanteGroup.getChildren().add(imageZerlingSprite);
                  pruebaGrid.add(imageZerlingWrapper, posX, posY);
                  break;
                }
                case "Hidralisco":{
                    ImageView imageHidraliscoSprite= new ImageView(imagenHidralisco);
                    BorderPane imageHidraliscoWrapper = new BorderPane(imageHidraliscoSprite);
                    imageHidraliscoWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                    imageHidraliscoWrapper.setLayoutX(posX);
                    imageHidraliscoWrapper.setLayoutY(posY);
                    imageHidraliscoWrapper.setOnMouseClicked(event ->  {
                        if(atacando){
                            algoStarView.realizarAtaque(unidadAtacante, crearCoordenada(nodo));
                        }else{
                            algoStarView.crearBotoneraUnidadNormal(crearCoordenada(nodo));
                        }
                        setStatsUnidad(nodo);
                    });
                    
                    imageHidraliscoWrapper.setOnMouseEntered(event ->  {
                      imageHidraliscoWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                    });
                    
                    imageHidraliscoWrapper.setOnMouseExited(e -> {
                      imageHidraliscoWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                    });
                    //ocupanteGroup.getChildren().add(imageHidraliscoSprite);
                    pruebaGrid.add(imageHidraliscoWrapper, posX, posY);
                    break;
                }
                case "Mutalisco":{
                  ImageView imageMutaliscoSprite= new ImageView(imagenMutalisco);
                  BorderPane imageMutaliscoWrapper = new BorderPane(imageMutaliscoSprite);
                  imageMutaliscoWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  imageMutaliscoWrapper.setLayoutX(posX);
                  imageMutaliscoWrapper.setLayoutY(posY);
                  imageMutaliscoWrapper.setOnMouseClicked(event ->  {
                      if(atacando){
                          algoStarView.realizarAtaque(unidadAtacante, crearCoordenada(nodo));
                      }else{
                          algoStarView.crearBotoneraMutalisco(crearCoordenada(nodo));
                      }
                      setStatsUnidad(nodo);
                  });
                  
                  imageMutaliscoWrapper.setOnMouseEntered(event ->  {
                    imageMutaliscoWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                  });
                  
                  imageMutaliscoWrapper.setOnMouseExited(e -> {
                    imageMutaliscoWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  });
                  //ocupanteGroup.getChildren().add(imageMutaliscoSprite);
                  pruebaGrid.add(imageMutaliscoWrapper, posX, posY);
                  break;
                }
                case "Guardian":{
                  ImageView imageGuardianSprite= new ImageView(imagenGuardian);
                  BorderPane imageGuardianWrapper = new BorderPane(imageGuardianSprite);
                  imageGuardianWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  imageGuardianWrapper.setLayoutX(posX);
                  imageGuardianWrapper.setLayoutY(posY);
                  imageGuardianWrapper.setOnMouseClicked(event ->  {
                      if(atacando){
                          algoStarView.realizarAtaque(unidadAtacante, crearCoordenada(nodo));
                      }else{
                          algoStarView.crearBotoneraUnidadNormal(crearCoordenada(nodo));
                      }
                      setStatsUnidad(nodo);
                  });
                  
                  imageGuardianSprite.setOnMouseEntered(event ->  {
                    imageGuardianSprite.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                  });
                  
                  imageGuardianSprite.setOnMouseExited(e -> {
                    imageGuardianSprite.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  });
                  //ocupanteGroup.getChildren().add(imageGuardianSprite);
                  pruebaGrid.add(imageGuardianSprite, posX, posY);
                  break;
                }
                case "Devorador":{
                  ImageView imageDevoradorSprite= new ImageView(imagenDevorador);
                  BorderPane imageDevoradorWrapper = new BorderPane(imageDevoradorSprite);
                  imageDevoradorWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  imageDevoradorWrapper.setLayoutX(posX);
                  imageDevoradorWrapper.setLayoutY(posY);
                  imageDevoradorWrapper.setOnMouseClicked(event ->  {
                      if(atacando){
                          algoStarView.realizarAtaque(unidadAtacante, crearCoordenada(nodo));
                      }else{
                          algoStarView.crearBotoneraUnidadNormal(crearCoordenada(nodo));
                      }
                      setStatsUnidad(nodo);
                  });
                  
                  imageDevoradorWrapper.setOnMouseEntered(event ->  {
                    imageDevoradorWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                  });
                  
                  imageDevoradorWrapper.setOnMouseExited(e -> {
                    imageDevoradorWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  });

                  //ocupanteGroup.getChildren().add(imageDevoradorSprite);
                  pruebaGrid.add(imageDevoradorWrapper, posX, posY);                  
                  break;
                }
                case "Zealot":{
                  ImageView imageZealotSprite= new ImageView(imagenZealot);
                  if("visible" == nodo.get("Ocupante").get("visibilidad").asText()){
                    imageZealotSprite.setOpacity(opacityVisible);
                  }else{
                    imageZealotSprite.setOpacity(opacityInvisible);
                  }
                  BorderPane imageZealotWrapper = new BorderPane(imageZealotSprite);
                  imageZealotWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  imageZealotWrapper.setLayoutX(posX);
                  imageZealotWrapper.setLayoutY(posY);

                  imageZealotWrapper.setOnMouseClicked(event ->  {
                      if(atacando){
                          algoStarView.realizarAtaque(unidadAtacante, crearCoordenada(nodo));
                      }else{
                          algoStarView.crearBotoneraUnidadNormal(crearCoordenada(nodo));
                      }
                      setStatsUnidad(nodo);
                  });
                  
                  imageZealotWrapper.setOnMouseEntered(event ->  {
                    imageZealotWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                  });
                  
                  imageZealotWrapper.setOnMouseExited(e -> {
                    imageZealotWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  });
 
                  //ocupanteGroup.getChildren().add(imageZealotSprite);
                  pruebaGrid.add(imageZealotWrapper, posX, posY); 
                  break;
                }
                case "Dragon":{
                  ImageView imageDragonSprite= new ImageView(imagenDragon);
                   BorderPane imageDragonWrapper = new BorderPane(imageDragonSprite);
                   imageDragonWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                   imageDragonWrapper.setLayoutX(posX);
                   imageDragonWrapper.setLayoutY(posY);
                   imageDragonWrapper.setOnMouseClicked(event ->  {
                       if(atacando){
                           algoStarView.realizarAtaque(unidadAtacante, crearCoordenada(nodo));
                       }else{
                           algoStarView.crearBotoneraUnidadNormal(crearCoordenada(nodo));
                       }
                       setStatsUnidad(nodo);
                  });
                  
                  imageDragonWrapper.setOnMouseEntered(event ->  {
                    imageDragonWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                  });
                  
                  imageDragonWrapper.setOnMouseExited(e -> {
                    imageDragonWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  });
 
                  //ocupanteGroup.getChildren().add(imageDragonSprite);
                  pruebaGrid.add(imageDragonWrapper, posX, posY);                   
                  break;
                }
                case "Scout":{
                  ImageView imageScoutSprite= new ImageView(imagenScout);
                  BorderPane imageScoutWrapper = new BorderPane(imageScoutSprite);
                  imageScoutWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  imageScoutWrapper.setLayoutX(posX);
                  imageScoutWrapper.setLayoutY(posY);
                  imageScoutWrapper.setOnMouseClicked(event ->  {
                      if(atacando){
                          algoStarView.realizarAtaque(unidadAtacante, crearCoordenada(nodo));
                      }else{
                          algoStarView.crearBotoneraUnidadNormal(crearCoordenada(nodo));
                      }
                      setStatsUnidad(nodo);
                  });
                  
                  imageScoutWrapper.setOnMouseEntered(event ->  {
                    imageScoutWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                  });
                  
                  imageScoutWrapper.setOnMouseExited(e -> {
                    imageScoutWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  });
 
                  //ocupanteGroup.getChildren().add(imageScoutSprite);
                  pruebaGrid.add(imageScoutWrapper, posX, posY);     
                  break;
                }
                case "Criadero":{
                    ImageView imageCriaderoSprite= new ImageView(imagenCriadero);
                    BorderPane imageCriaderoWrapper = new BorderPane(imageCriaderoSprite);
                    int tiempoConstruccion = nodo.get("Ocupante").get("tiempoDeConstruccion").intValue();

                    if(tiempoConstruccion > 0){
                      imageCriaderoWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: linear-gradient(to right, blue "+75/tiempoConstruccion+"%, grey 1px);");
                    }else{
                      imageCriaderoWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                    }
                    
                    imageCriaderoWrapper.setLayoutX(posX);
                    imageCriaderoWrapper.setLayoutY(posY);
                    imageCriaderoWrapper.setOnMouseClicked(event ->  {
                        if(atacando){
                            algoStarView.realizarAtaque(unidadAtacante, crearCoordenada(nodo));
                        }else{
                            algoStarView.crearBotoneraCriadero(crearCoordenada(nodo));
                        }
                        setStatsEdificio(nodo);
                    });
                  
                    imageCriaderoWrapper.setOnMouseEntered(event ->  {
                      imageCriaderoWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                    });
                    
                    imageCriaderoWrapper.setOnMouseExited(e -> {
                      if(tiempoConstruccion > 0){
                        imageCriaderoWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: linear-gradient(to right, blue "+75/tiempoConstruccion+"%, grey 1px);");
                      }else{
                        imageCriaderoWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                      }
                    });
   
                    //ocupanteGroup.getChildren().add(imageCriaderoSprite);
                    pruebaGrid.add(imageCriaderoWrapper, posX, posY);                             
                    break;
                }
                case "ReservaDeReproduccion":{
                    ImageView imagenReservaDeReproduccionSprite= new ImageView(imagenReservaDeReproduccion);
                    BorderPane imageReservaDeReproduccionWrapper = new BorderPane(imagenReservaDeReproduccionSprite);int tiempoConstruccion = nodo.get("Ocupante").get("tiempoDeConstruccion").intValue();

                    if(tiempoConstruccion > 0){
                      imageReservaDeReproduccionWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: linear-gradient(to right, blue "+75/tiempoConstruccion+"%, grey 1px);");
                    }else{
                      imageReservaDeReproduccionWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                    }

                    imageReservaDeReproduccionWrapper.setLayoutX(posX);
                    imageReservaDeReproduccionWrapper.setLayoutY(posY);
                    imageReservaDeReproduccionWrapper.setOnMouseClicked(event ->  {
                        if(atacando){
                            algoStarView.realizarAtaque(unidadAtacante, crearCoordenada(nodo));
                        }else{
                            algoStarView.crearBotoneraReservaDeReproduccion(crearCoordenada(nodo));
                        }
                        setStatsEdificio(nodo);
                    });
                  
                    imageReservaDeReproduccionWrapper.setOnMouseEntered(event ->  {
                      imageReservaDeReproduccionWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                    });
                    
                    imageReservaDeReproduccionWrapper.setOnMouseExited(e -> {
                      if(tiempoConstruccion > 0){
                        imageReservaDeReproduccionWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: linear-gradient(to right, blue "+75/tiempoConstruccion+"%, grey 1px);");
                      }else{
                      imageReservaDeReproduccionWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                      }
                    });
   
                    //ocupanteGroup.getChildren().add(imagenReservaDeReproduccionSprite);
                    pruebaGrid.add(imageReservaDeReproduccionWrapper, posX, posY);                                    
                    break;
                }
                case "Extractor":{
                  ImageView imagenExtractorSprite= new ImageView(imagenExtractor);
                  BorderPane imageExtractorWrapper = new BorderPane(imagenExtractorSprite);
                  imageExtractorWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  imageExtractorWrapper.setLayoutX(posX);
                  imageExtractorWrapper.setLayoutY(posY);
                  imageExtractorWrapper.setOnMouseClicked(event ->  {
                      if(atacando){
                          algoStarView.realizarAtaque(unidadAtacante, crearCoordenada(nodo));
                      }else{
                          algoStarView.crearBotoneraVacia(crearCoordenada(nodo)); //TODO REVISAR SINO FALTA BOTONERA PARA ESTO
                      }
                      setStatsEdificio(nodo);
                  });
                  
                  imageExtractorWrapper.setOnMouseEntered(event ->  {
                    imageExtractorWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                  });
                  
                  imageExtractorWrapper.setOnMouseExited(e -> {
                    imageExtractorWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  });
 
                  //ocupanteGroup.getChildren().add(imagenExtractorSprite);
                  pruebaGrid.add(imageExtractorWrapper, posX, posY);                         
                  break;
                }
                case "Guarida":{
                  ImageView imagenGuaridaSprite= new ImageView(imagenGuarida);
                  BorderPane imageGuaridaWrapper = new BorderPane(imagenGuaridaSprite);
                  imageGuaridaWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  imageGuaridaWrapper.setLayoutX(posX);
                  imageGuaridaWrapper.setLayoutY(posY);
                  imageGuaridaWrapper.setOnMouseClicked(event ->  {
                      if(atacando){
                          algoStarView.realizarAtaque(unidadAtacante, crearCoordenada(nodo));
                      }else{
                          algoStarView.crearBotoneraGuarida(crearCoordenada(nodo));
                      }
                      setStatsEdificio(nodo);
                  });
                  
                  imageGuaridaWrapper.setOnMouseEntered(event ->  {
                    imageGuaridaWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                  });
                  
                  imageGuaridaWrapper.setOnMouseExited(e -> {
                    imageGuaridaWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  });
 
                  //ocupanteGroup.getChildren().add(imagenGuaridaSprite);
                  pruebaGrid.add(imageGuaridaWrapper, posX, posY); 
                  break;
                }
                case "Espiral":{
                  ImageView imagenEspiralSprite= new ImageView(imagenEspiral);
                  BorderPane imageEspiralWrapper = new BorderPane(imagenEspiralSprite);
                  imageEspiralWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  imageEspiralWrapper.setLayoutX(posX);
                  imageEspiralWrapper.setLayoutY(posY);
                  imagenEspiralSprite.setOnMouseClicked(event ->  {
                      if(atacando){
                          algoStarView.realizarAtaque(unidadAtacante, crearCoordenada(nodo));
                      }else{
                          algoStarView.crearBotoneraEspiral(crearCoordenada(nodo));
                      }
                      setStatsEdificio(nodo);
                  });
                  
                  imageEspiralWrapper.setOnMouseEntered(event ->  {
                    imageEspiralWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                  });
                  
                  imageEspiralWrapper.setOnMouseExited(e -> {
                    imageEspiralWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  });
 
                  //ocupanteGroup.getChildren().add(imagenEspiralSprite);
                  pruebaGrid.add(imageEspiralWrapper, posX, posY); 
                  break;
                }
                case "NexoMineral":{
                  ImageView imagenNexoMineralSprite= new ImageView(imagenNexoMineral);                  
                  BorderPane imageNexoMineralWrapper = new BorderPane(imagenNexoMineralSprite);
                  imageNexoMineralWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  imageNexoMineralWrapper.setLayoutX(posX);
                  imageNexoMineralWrapper.setLayoutY(posY);
                  imageNexoMineralWrapper.setOnMouseClicked(event ->  {
                      if(atacando){
                          algoStarView.realizarAtaque(unidadAtacante, crearCoordenada(nodo));
                      }else{
                          algoStarView.crearBotoneraVacia(crearCoordenada(nodo)); //TODO REVISAR
                      }
                      setStatsEdificio(nodo);
                  });
                  
                  imageNexoMineralWrapper.setOnMouseEntered(event ->  {
                    imageNexoMineralWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                  });
                  
                  imageNexoMineralWrapper.setOnMouseExited(e -> {
                    imageNexoMineralWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  });
 
                  //ocupanteGroup.getChildren().add(imagenNexoMineralSprite);
                  pruebaGrid.add(imageNexoMineralWrapper, posX, posY);                  
                  break;
                }
                case "Pilon":{
                  ImageView imagenPilonSprite= new ImageView(imagenPilon);                  
                  BorderPane imagePilonWrapper = new BorderPane(imagenPilonSprite);
                  imagePilonWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  imagePilonWrapper.setLayoutX(posX);
                  imagePilonWrapper.setLayoutY(posY);
                  imagePilonWrapper.setOnMouseClicked(event ->  {
                      if(atacando){
                          algoStarView.realizarAtaque(unidadAtacante, crearCoordenada(nodo));
                      }else{
                          algoStarView.crearBotoneraVacia(crearCoordenada(nodo));
                      }
                      setStatsEdificio(nodo);
                  });
                  
                  imagePilonWrapper.setOnMouseEntered(event ->  {
                    imagePilonWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                  });
                  
                  imagePilonWrapper.setOnMouseExited(e -> {
                    imagePilonWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  });
 
                  //ocupanteGroup.getChildren().add(imagenPilonSprite);
                  pruebaGrid.add(imagePilonWrapper, posX, posY);  
                  break;
                }
                case "Asimilador":{
                  ImageView imagenAsimiladorSprite= new ImageView(imagenAsimilador);                 
                  BorderPane imageAsimiladorWrapper = new BorderPane(imagenAsimiladorSprite);
                  imageAsimiladorWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  imageAsimiladorWrapper.setLayoutX(posX);
                  imageAsimiladorWrapper.setLayoutY(posY);
                  imageAsimiladorWrapper.setOnMouseClicked(event ->  {
                      if(atacando){
                          algoStarView.realizarAtaque(unidadAtacante, crearCoordenada(nodo));
                      }else{
                          algoStarView.crearBotoneraVacia(crearCoordenada(nodo));
                      }
                      setStatsEdificio(nodo);
                  });
                  
                  imageAsimiladorWrapper.setOnMouseEntered(event ->  {
                    imageAsimiladorWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                  });
                  
                  imageAsimiladorWrapper.setOnMouseExited(e -> {
                    imageAsimiladorWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  });
 
                  //ocupanteGroup.getChildren().add(imagenAsimiladorSprite);
                  pruebaGrid.add(imageAsimiladorWrapper, posX, posY);                    
                  break;
                }
                case "Acceso":{
                  ImageView imagenAccesoSprite= new ImageView(imagenAcceso);                 
                  BorderPane imageAccesoWrapper = new BorderPane(imagenAccesoSprite);
                  imageAccesoWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  imageAccesoWrapper.setLayoutX(posX);
                  imageAccesoWrapper.setLayoutY(posY);
                  imageAccesoWrapper.setOnMouseClicked(event ->  {
                      if(atacando){
                          algoStarView.realizarAtaque(unidadAtacante, crearCoordenada(nodo));
                      }else{
                          algoStarView.crearBotoneraAcceso(crearCoordenada(nodo));
                      }
                      setStatsEdificio(nodo);
                  });
                  
                  imageAccesoWrapper.setOnMouseEntered(event ->  {
                    imageAccesoWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                  });
                  
                  imageAccesoWrapper.setOnMouseExited(e -> {
                    imageAccesoWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  });
 
                  //ocupanteGroup.getChildren().add(imagenAccesoSprite);
                  pruebaGrid.add(imageAccesoWrapper, posX, posY);                      
                  break;
                }
                case "PuertoEstelar":{
                  ImageView imagenPuertoEstelarSprite= new ImageView(imagenPuertoEstelar);                 
                  BorderPane imagePuertoEstelarWrapper = new BorderPane(imagenPuertoEstelarSprite);
                  imagePuertoEstelarWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  imagePuertoEstelarWrapper.setLayoutX(posX);
                  imagePuertoEstelarWrapper.setLayoutY(posY);
                  imagenPuertoEstelarSprite.setOnMouseClicked(event ->  {
                      if(atacando){
                          algoStarView.realizarAtaque(unidadAtacante, crearCoordenada(nodo));
                      }else{
                          algoStarView.crearBotoneraPuertoEstelar(crearCoordenada(nodo));
                      }
                      setStatsEdificio(nodo);
                  });
                  
                  imagePuertoEstelarWrapper.setOnMouseEntered(event ->  {
                    imagePuertoEstelarWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                  });
                  
                  imagePuertoEstelarWrapper.setOnMouseExited(e -> {
                    imagePuertoEstelarWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                  });
 
                  //ocupanteGroup.getChildren().add(imagenPuertoEstelarSprite);
                  pruebaGrid.add(imagePuertoEstelarWrapper, posX, posY);                      
                  break;
                }
                case "Desocupado":{
                    break;
                }
                case "cambioDeLinea":{
                    posX = 0;
                    posY ++;
                    break;
                }
                default: {

                }
            }
            posX ++;
        }
        //info.getChildren().add(ocupanteGroup);
    }

    private Coordenada crearCoordenada(JsonNode nodo){
        int x = nodo.get("Ocupante").get("coordenada").get("x").asInt();
        int y = nodo.get("Ocupante").get("coordenada").get("y").asInt();
        Coordenada coordenada = new Coordenada(x,y);
        return coordenada;
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
            nodos = Mapa.devolverInstancia().toJsonTerrenos();
        }catch (JsonProcessingException e){
             System.out.println("Error al mostrar terrenos");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //Aca se dibujarian los terrenos
        int posX = 1 ;
        int posY = 1 ;
        //terrenoGroup.getChildren().clear();
        for (JsonNode nodo : nodos) {
            switch (nodo.get("nombre").asText()){
                case "Aereo":{
                    ImageView imageEspecialesSprite= new ImageView(imagenEspecial);
                    BorderPane imageEspecialWrapper = new BorderPane(imageEspecialesSprite);
                    imageEspecialWrapper.setLayoutX(posX);
                    imageEspecialWrapper.setLayoutY(posY);
                    imageEspecialWrapper.setOnMouseClicked(event ->  {
                      int x = nodo.get("coordenada").get("x").asInt();
                      int y = nodo.get("coordenada").get("y").asInt();
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.setBottom(algoStarView.crearBotoneraVacia(coor));
                    });

                    imageEspecialWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                    imageEspecialWrapper.setOnMouseEntered(event ->  {
                      imageEspecialWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                    });
                    
                    imageEspecialWrapper.setOnMouseExited(e -> {
                      imageEspecialWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                    });

                    //terrenoGroup.getChildren().add(imageEspecialesSprite);
                    pruebaGrid.add(imageEspecialWrapper, posX, posY);
                    break;
                }
                case "Vacio":{
                    ImageView imageVacioSprite= new ImageView(imagenVacio);
                    BorderPane imageVacioWrapper = new BorderPane(imageVacioSprite);
                   
                    imageVacioWrapper.setLayoutX(posX);
                    imageVacioWrapper.setLayoutY(posY);
                    imageVacioWrapper.setOnMouseClicked(event ->  {
                      if(atacando){
                        int x = nodo.get("coordenada").get("x").asInt();
                        int y = nodo.get("coordenada").get("y").asInt();
                        Coordenada coor = new Coordenada(x,y);
                        algoStarView.realizarAtaque(unidadAtacante,coor);
                      }else{
                        int x = nodo.get("coordenada").get("x").asInt();
                        int y = nodo.get("coordenada").get("y").asInt();
                        Coordenada coor = new Coordenada(x,y);
                        algoStarView.crearBotoneraTerrenoVacio(coor);
                      }
                    });
                    imageVacioWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                    imageVacioWrapper.setOnMouseEntered(event ->  {
                      imageVacioWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                    });
                    
                    imageVacioWrapper.setOnMouseExited(e -> {
                      imageVacioWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                    });
                    

                    //imageVacioWrapper.getStyleClass().add("terreno-vacio");
                    //terrenoGroup.getChildren().add(imageVacioWrapper);
                    pruebaGrid.add(imageVacioWrapper, posX, posY);
                    break;
                }
                case "Mineral":{
                    ImageView imageMineralSprite= new ImageView(imagenMineral);
                    BorderPane imageMineralWrapper = new BorderPane(imageMineralSprite);
                    imageMineralWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                    imageMineralWrapper.setLayoutX(posX);
                    imageMineralWrapper.setLayoutY(posY);
                    imageMineralWrapper.setOnMouseClicked(event ->  {
                      int x = nodo.get("coordenada").get("x").asInt();
                      int y = nodo.get("coordenada").get("y").asInt();
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraMineral(coor);
                    });
                    
                    imageMineralWrapper.setOnMouseEntered(event ->  {
                      imageMineralWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                    });
                    
                    imageMineralWrapper.setOnMouseExited(e -> {
                      imageMineralWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                    });
                    //terrenoGroup.getChildren().add(imageMineralSprite);
                    pruebaGrid.add(imageMineralWrapper, posX, posY);
                    break;
                }
                case "Moho":{
                    ImageView imageMohoSprite= new ImageView(imagenMoho);
                    BorderPane imageMohoWrapper = new BorderPane(imageMohoSprite);
                    imageMohoWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                    imageMohoWrapper.setLayoutX(posX);
                    imageMohoWrapper.setLayoutY(posY);
                    imageMohoWrapper.setOnMouseClicked(event ->  {
                      int x = nodo.get("coordenada").get("x").asInt();
                      int y = nodo.get("coordenada").get("y").asInt();
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.setBottom(algoStarView.crearBotoneraVacia(coor));
                    });

                    imageMohoWrapper.setOnMouseEntered(event ->  {
                      imageMohoWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                    });
                    
                    imageMohoWrapper.setOnMouseExited(e -> {
                      imageMohoWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                    });

                    //terrenoGroup.getChildren().add(imageMohoSprite);
                    pruebaGrid.add(imageMohoWrapper, posX, posY);
                    break;
                }
                case "Volcan":{
                    ImageView imageVolcanSprite= new ImageView(imagenVolcan);
                    BorderPane imageVolcanWrapper = new BorderPane(imageVolcanSprite);
                    imageVolcanWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                    imageVolcanWrapper.setLayoutX(posX);
                    imageVolcanWrapper.setLayoutY(posY);
                    imageVolcanWrapper.setOnMouseClicked(event ->  {
                      int x = nodo.get("coordenada").get("x").asInt();
                      int y = nodo.get("coordenada").get("y").asInt();
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraVolcan(coor);
                    });
                    imageVolcanWrapper.setOnMouseEntered(event ->  {
                      imageVolcanWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                    });
                    
                    imageVolcanWrapper.setOnMouseExited(e -> {
                      imageVolcanWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                    });
                    //terrenoGroup.getChildren().add(imageVolcanSprite);
                    pruebaGrid.add(imageVolcanWrapper, posX, posY);
                    break;
                }
                case "Energizado":{
                    ImageView imageEnergizadoSprite= new ImageView(imagenEnergizado);
                    BorderPane imageEnergizadoWrapper = new BorderPane(imageEnergizadoSprite);
                    imageEnergizadoWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                    imageEnergizadoWrapper.setLayoutX(posX);
                    imageEnergizadoWrapper.setLayoutY(posY);
                    imageEnergizadoWrapper.setOnMouseClicked(event ->  {
                      int x = nodo.get("coordenada").get("x").asInt();
                      int y = nodo.get("coordenada").get("y").asInt();
                      Coordenada coor = new Coordenada(x,y);
                      algoStarView.crearBotoneraEnergizado(coor);
                    });
                    imageEnergizadoWrapper.setOnMouseEntered(event ->  {
                      imageEnergizadoWrapper.setStyle("-fx-border-width: 5px;" + "-fx-border-color: blue;");
                    });
                    
                    imageEnergizadoWrapper.setOnMouseExited(e -> {
                      imageEnergizadoWrapper.setStyle("-fx-border-width: 5px;"+ "-fx-border-color: grey;");
                    });
                    //terrenoGroup.getChildren().add(imageEnergizadoSprite);
                    pruebaGrid.add(imageEnergizadoWrapper, posX, posY);
                    break;
                }
                case "cambioDeLinea":{
                    posX = 0;
                    posY ++;
                    break;
                }
                default: {

                }
            }
            posX ++;
        }
        //info.getChildren().add(terrenoGroup);
    }
}
