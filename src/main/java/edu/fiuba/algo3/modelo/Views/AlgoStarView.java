package edu.fiuba.algo3.modelo.Views;

import com.fasterxml.jackson.databind.JsonNode;
import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonAtacarHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonPasarTurnoHandler;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.*;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.unidades.BotoneraAmoSupremo;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.unidades.BotoneraMutalisco;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.unidades.BotoneraUnidadNormal;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.unidades.BotoneraZangano;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.geometria.direcciones.Izquierda;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.zerg.AmoSupremo;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Objects;

public class AlgoStarView extends BorderPane {

    BarraDelMenu menuBar;

    Stage stage;
    AlgoStar algoStar;
    ScrollPane contenedorCentral;
    Group layout;

    Coordenada limite;

    MapaView mapaView;

    Image pasarTurnoImagen = new Image("/Sprite-0001-export.png", 100, 100, false, false);

    public AlgoStarView(Stage stage, AlgoStar algostar) {
        this.stage = stage;
        this.algoStar = algostar;
        this.contenedorCentral = new ScrollPane();
        algoStar.empezarJuego();
        
        agregarBarraDelMenu(stage);
        pantallaJuego();
        setPantallDeStats();
    }

    public String colorJugadorActual() {
      String colorJugadorActual = "";
      try {
        switch (this.algoStar.hallarJugadorActual().toData().get("color").asText()){
          case "Naranja":{
            colorJugadorActual= "orange";
            break;
          }
          case "Violeta":{
            colorJugadorActual= "violet";
            break;
          }
          case "Rojo":{
            colorJugadorActual= "red";
            break;
          }
          case "Azul":{
            colorJugadorActual = "blue";
            break;
          }
        }
      } catch (RuntimeException e) {}
      return colorJugadorActual;
    }

    public void setPantallaDeStatsJugador() {
        ImageView view = new ImageView(pasarTurnoImagen);

        Button pasarTurno = new Button();
        BotonPasarTurnoHandler pasarTurnoHandler = new BotonPasarTurnoHandler(algoStar,this,stage);
        pasarTurno.setOnAction(pasarTurnoHandler);
        //pasarTurno.setBackground(new Background("-fx-background-color: transparent"));
        pasarTurno.setStyle(" -fx-background-color: transparent; -fx-border-color: #7d7d7d;");
        pasarTurno.setGraphic(view);

        JsonNode jugadorNode = algoStar.hallarJugadorActual().toData();

        Label jugadorActualnombre = new Label(jugadorNode.get("nombre").asText());
        jugadorActualnombre.setFont (Font.font("Tahoma", FontWeight.BOLD, 15));
        jugadorActualnombre.setTextFill(Color.web(this.colorJugadorActual()));
        Label jugadorActualLabelInicio = new Label("Turno de " );
        jugadorActualLabelInicio.getStyleClass().add("label-lateral-derecho");
        HBox jugadorActualLabel = new HBox(jugadorActualLabelInicio,jugadorActualnombre); 

        Label gasDisponible = new Label("Gas Vespeno: " + jugadorNode.get("inventario").get("cantidadGasVespeno").get("gasVespeno").asText());
        gasDisponible.getStyleClass().add("label-lateral-derecho");
        Label mineralDisponible = new Label("Mineral: " + jugadorNode.get("inventario").get("cantidadMineral").get("mineral").asText());
        mineralDisponible.getStyleClass().add("label-lateral-derecho");
        Label suministrosDisponibles = new Label("Suministros: " + jugadorNode.get("inventario").get("suministroActual").get("suministro").asText());
        suministrosDisponibles.getStyleClass().add("label-lateral-derecho");

        Label edificiosDisponibles = new Label("Edificios restantes: " + jugadorNode.get("inventario").get("edificios").asText());
        edificiosDisponibles.getStyleClass().add("label-lateral-derecho");
        Label unidadesDisponibles = new Label("Unidades restantes: " + jugadorNode.get("inventario").get("unidades").asText());
        unidadesDisponibles.getStyleClass().add("label-lateral-derecho");

        VBox contenedorHorizontal = new VBox(pasarTurno, jugadorActualLabel,gasDisponible,mineralDisponible,suministrosDisponibles,edificiosDisponibles,unidadesDisponibles); // <- recibe las cosas como parámetro
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(10));

        contenedorHorizontal.setMinWidth(140);

        //contenedorHorizontal.setMaxWidth(140);
        Image imgFondo = new Image("/derecha.jpg");
        BackgroundImage fondo = new BackgroundImage(imgFondo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(stage.getOutputScaleX(),stage.getMaxWidth(),true,true,true,true));
        contenedorHorizontal.setBackground(new Background(fondo));
        this.setRight(contenedorHorizontal);
    }

    private void setPantallDeStats() {
        //Aca iría las cosas de la pantalla de stats


        // handler del boton construir
        VBox contenedorHorizontal = new VBox(); // <- recibe las cosas como parámetro
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(10));

        this.setLeft(contenedorHorizontal);
    }

    public void setPantallDeStatsTerreno(JsonNode node) {
      //Aca iría las cosas de la pantalla de stats
      Label terreno = new Label("Tipo de Terreno: " + node.get("nombre").asText());
      terreno.getStyleClass().add("label-lateral-izquierdo");
      

      // handler del boton construir
      VBox contenedorHorizontal = new VBox(terreno); // <- recibe las cosas como parámetro
      contenedorHorizontal.setSpacing(10);
      contenedorHorizontal.setPadding(new Insets(10));

      contenedorHorizontal.setMinWidth(140);

      Image imgFondo = new Image("/izquierda.jpg");
      BackgroundImage fondo = new BackgroundImage(imgFondo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(stage.getOutputScaleX(),stage.getMaxWidth(),true,true,true,true));
      contenedorHorizontal.setBackground(new Background(fondo));

      this.setLeft(contenedorHorizontal);
  }

    public void setPantallDeStatsUnidad(JsonNode node) {
        //Aca iría las cosas de la pantalla de stats
        Label nombre = new Label("Unidad de Tipo: " + node.get("Ocupante").get("nombre").asText());
        nombre.getStyleClass().add("label-lateral-izquierdo");
        Label vida = new Label("Vida: " + node.get("Ocupante").get("vida").asText());
        vida.getStyleClass().add("label-lateral-izquierdo");
        Label danioAereoYTerrestre = new Label("Daño Terrestre: " + node.get("Ocupante").get("danioTerrestre").asText() + "\nDaño Aereo: " + node.get("Ocupante").get("danioAereo").asText());
        danioAereoYTerrestre.getStyleClass().add("label-lateral-izquierdo");
        Label escudo = new Label();
            

        if(Objects.equals(node.get("Ocupante").get("raza").asText(), "protoss")){
            escudo = new Label("Escudo: " + node.get("Ocupante").get("escudo").asText());
        }
        escudo.getStyleClass().add("label-lateral-izquierdo");


        // handler del boton construir
        VBox contenedorHorizontal = new VBox(nombre,danioAereoYTerrestre,vida,escudo); // <- recibe las cosas como parámetro
        /*contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setMinWidth(260);
        contenedorHorizontal.setPadding(new Insets(10));*/
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(10));

        contenedorHorizontal.setMinWidth(140);

        Image imgFondo = new Image("/izquierda.jpg");
        BackgroundImage fondo = new BackgroundImage(imgFondo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(stage.getOutputScaleX(),stage.getMaxWidth(),true,true,true,true));
        contenedorHorizontal.setBackground(new Background(fondo));

        this.setLeft(contenedorHorizontal);
    }
    public void setPantallDeStatsEdificio(JsonNode node) {
        //Aca iría las cosas de la pantalla de stats
        Label nombre = new Label("Edicifio: " + node.get("Ocupante").get("nombre").asText());
        nombre.getStyleClass().add("label-lateral-izquierdo");
        Label vida = new Label("Vida: " + node.get("Ocupante").get("vida").asText());
        vida.getStyleClass().add("label-lateral-izquierdo");
        Label estadoConstruccion = new Label("Estado de Construcción: " + node.get("Ocupante").get("estado").asText());
        estadoConstruccion.getStyleClass().add("label-lateral-izquierdo");
        Label escudo = new Label();
        

        if(Objects.equals(node.get("Ocupante").get("raza").asText(), "protoss")){
             escudo = new Label("Escudo: " + node.get("Ocupante").get("escudo").asText());
        }
        escudo.getStyleClass().add("label-lateral-izquierdo");
        // handler del boton construir
        VBox contenedorHorizontal = new VBox(nombre,estadoConstruccion,vida,escudo); // <- recibe las cosas como parámetro
        //contenedorHorizontal.setStyle("-fx-background-image: url('/texturaStats.png');" +
         //       "-fx-background-repeat: repeat;");
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setMinWidth(260);
        contenedorHorizontal.setPadding(new Insets(10));
        Image imgFondo = new Image("/izquierda.jpg");
        BackgroundImage fondo = new BackgroundImage(imgFondo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(stage.getOutputScaleX(),stage.getMaxWidth(),true,true,true,true));
        contenedorHorizontal.setBackground(new Background(fondo));
        this.setLeft(contenedorHorizontal);
    }

    public HBox crearBotoneraVacia() {
      HBox contenedorHorizontal = new HBox();
      contenedorHorizontal.setSpacing(10);

      contenedorHorizontal.setPadding(new Insets(25));
      contenedorHorizontal.setMinHeight(110);
      contenedorHorizontal.setMinWidth(1920);

      Image imgFondo = new Image("/abajo.jpg");
      BackgroundImage fondo = new BackgroundImage(imgFondo, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(stage.getOutputScaleX(),stage.getMaxWidth(),true,true,true,true));
      contenedorHorizontal.setBackground(new Background(fondo));

      return contenedorHorizontal;
    }

    public HBox crearBotoneraVacia(Coordenada coordenada) {
        HBox contenedorHorizontal = new HBox();
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setMinHeight(110);
        contenedorHorizontal.setMinWidth(1920);
        contenedorHorizontal.setMaxHeight(110);
        contenedorHorizontal.setMaxWidth(1920);
        Image imgFondo = new Image("/abajo.jpg");
        BackgroundImage fondo = new BackgroundImage(imgFondo, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(stage.getOutputScaleX(),stage.getMaxWidth(),true,true,true,true));
        contenedorHorizontal.setBackground(new Background(fondo));
        contenedorHorizontal.setPadding(new Insets(25));

        Label coordenadaX = crearMensaje("CORDENADA X: " + coordenada.toData().get("x"));
        Label coordenadaY = crearMensaje("CORDENADA Y: "  + coordenada.toData().get("y"));

        VBox coordenadaBox = new VBox(coordenadaX,coordenadaY);
        contenedorHorizontal.getChildren().clear();
        contenedorHorizontal.getChildren().add(coordenadaBox);


        return contenedorHorizontal;
    }

    private static Label crearMensaje(String string) {
        Label mensaje  = new Label(string);

        mensaje.setFont (Font.font("Tahoma", FontWeight.BOLD, 15));
        mensaje.setTextFill(Color.web("#000000"));
        return mensaje;
    }


    public void crearBotoneraAmoSupremo(Coordenada coordenada) {
      if("zerg"== algoStar.hallarJugadorActual().toData().get("raza").asText()){
        new BotoneraAmoSupremo(algoStar, this, coordenada, stage);
      }else{
        this.setBottom(crearBotoneraVacia(coordenada));
      }
    }
    public void crearBotoneraMutalisco(Coordenada coordenada) {
      if("zerg"== algoStar.hallarJugadorActual().toData().get("raza").asText()){
        new BotoneraMutalisco(algoStar, this, coordenada, stage);
      }else{
        this.setBottom(crearBotoneraVacia(coordenada));
      } 
    }
    public void crearBotoneraUnidadNormal(Coordenada coordenada) {
      new BotoneraUnidadNormal(algoStar, this, coordenada, stage);
    }
    public void crearBotoneraZangano(Coordenada coordenada) {
      if("zerg"== algoStar.hallarJugadorActual().toData().get("raza").asText()){
        new BotoneraZangano(algoStar, this, coordenada, stage);
      }else{
        this.setBottom(crearBotoneraVacia(coordenada));
      } 
    }
    public void crearBotoneraAcceso(Coordenada coordenada) {
      if("protoss"== algoStar.hallarJugadorActual().toData().get("raza").asText()){
        new BotoneraAcceso(algoStar, this,coordenada, stage);
      } else {
        this.setBottom(crearBotoneraVacia(coordenada));
      }
    }
    /*
    public void crearBotoneraAtaque(Coordenada coordenada) {
        new BotoneraAtaque(algoStar, this, coordenada);
    }*/

    public void crearBotoneraCriadero(Coordenada coordenada) {
        if ("zerg"== algoStar.hallarJugadorActual().toData().get("raza").asText()) {
            new BotoneraCriadero(algoStar, this,coordenada, stage);
        } else {
           this.setBottom(crearBotoneraVacia(coordenada));
        }
    }
    public void crearBotoneraEnergizado(Coordenada coordenada) {
      if("protoss"== algoStar.hallarJugadorActual().toData().get("raza").asText()){
        new BotoneraEnergizadoProtoss(algoStar, this,coordenada, stage);
      }else{
        this.setBottom(crearBotoneraVacia(coordenada));
      }
    }
    public void crearBotoneraEspiral(Coordenada coordenada) {
      new BotoneraEspiral(algoStar, this,coordenada, stage);
    }
    public void crearBotoneraGuarida(Coordenada coordenada) {
      new BotoneraGuarida(algoStar, this,coordenada, stage);
    }
    public void crearBotoneraVolcan(Coordenada coordenada) {
      if("protoss"== algoStar.hallarJugadorActual().toData().get("raza").asText()){
        new BotoneralVolcanProtoss(algoStar, this,coordenada, stage);
      }else{
        this.setBottom(crearBotoneraVacia(coordenada));
      }
    }
    public void crearBotoneraMineral(Coordenada coordenada) {
      if("protoss"== algoStar.hallarJugadorActual().toData().get("raza").asText()){
        new BotoneraMineralProtoss(algoStar, this,coordenada, stage);
      }else{
        this.setBottom(crearBotoneraVacia(coordenada));
      }
    }
    public void crearBotoneraPuertoEstelar(Coordenada coordenada) {
        if ("protoss"== algoStar.hallarJugadorActual().toData().get("raza").asText()) {
            new BotoneraPuertoEstelar(algoStar, this,coordenada, stage);
        } else {
            this.setBottom(crearBotoneraVacia(coordenada));
        }
    }
    public void crearBotoneraReservaDeReproduccion(Coordenada coordenada) {
        if ("zerg"== algoStar.hallarJugadorActual().toData().get("raza").asText()) {
            new BotoneraReservaDeReproduccion(algoStar, this,coordenada, stage);
        } else {
            this.setBottom(crearBotoneraVacia(coordenada));
        }
    }
    public void crearBotoneraTerrenoVacio(Coordenada coordenada) {
        if ("protoss"== algoStar.hallarJugadorActual().toData().get("raza").asText()) {
            new BotoneraVaciaProtoss(algoStar, this,coordenada, stage);
        } else {
            this.setBottom(crearBotoneraVacia(coordenada));
        }
    }

    public void ataque(Coordenada coordenadaUnidad){
        this.contenedorCentral.setContent(mapaView.dibujar(true, coordenadaUnidad, false));
    }

    public void realizarAtaque(Coordenada coordenadaUnidad, Coordenada coordenadaObjetivo){
      BotonAtacarHandler ataque = new BotonAtacarHandler(algoStar, this, coordenadaUnidad, coordenadaObjetivo);
      ataque.handle();
      this.contenedorCentral.setContent(mapaView.dibujar());
    }

    private void agregarBarraDelMenu(Stage stage){
        this.menuBar = new BarraDelMenu(stage);
        this.setTop(menuBar);
    }

    private void pantallaJuego(){
        limite = new Coordenada(100,20);

        this.mapaView = new MapaView(this);
        contenedorCentral.setContent(mapaView.dibujar());        
      
        contenedorCentral.setStyle("-fx-background: #7d7d7d; -fx-border-color: #7d7d7d;");
        contenedorCentral.setPadding(new Insets(5));

        contenedorCentral.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        contenedorCentral.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case W: contenedorCentral.setVvalue(contenedorCentral.getVvalue() - (contenedorCentral.getHeight() * 0.00002));
                        break;
                    case S: contenedorCentral.setVvalue(contenedorCentral.getVvalue() + (contenedorCentral.getHeight() * 0.00002));
                        break;
                    case A: contenedorCentral.setHvalue(contenedorCentral.getHvalue() - (contenedorCentral.getWidth() * 0.00002));
                        break;
                    case D: contenedorCentral.setHvalue(contenedorCentral.getHvalue() + (contenedorCentral.getWidth() * 0.00002));
                        break;
                    // Start DEBUG_ code for debug purposes only
                    case G:
                        ReproductorDeSonidos r = new ReproductorDeSonidos();
                        r.reproducirSonido("/boom.mp3", false);
                        break;
                    case P:
                        AlgoStar a = algoStar;

                        //jugador zerg mueve el zangano inicial hasta el mineral
                        a.hallarJugadorActual().moverUnidad(new Coordenada(1,1), new Derecha());
                        a.hallarJugadorActual().moverUnidad(new Coordenada(2,1), new Derecha());
                        a.hallarJugadorActual().moverUnidad(new Coordenada(3,1), new Derecha());
                        a.hallarJugadorActual().moverUnidad(new Coordenada(4,1), new Abajo());
                        a.hallarJugadorActual().moverUnidad(new Coordenada(4,2), new Abajo());

                        a.pasarTurno();

                        //jugador protoss construye nexo mineral y un asimilador
                        a.hallarJugadorActual().construirEdificio(new Coordenada(95 ,46), new NexoMineral());
                        a.hallarJugadorActual().construirEdificio(new Coordenada(95 ,44), new NexoMineral());
                        a.hallarJugadorActual().construirEdificio(new Coordenada(95,45), new Asimilador());

                        //ambos jugadores pasan varios turnos para recolectar recursos
                        for (int i = 0; i < 40; i++) {
                            a.pasarTurno();
                        }

                        //jugador protoss construye un pilon
                        a.hallarJugadorActual().construirEdificio(new Coordenada(12,4),new Pilon());

                        a.pasarTurno();

                        //jugador zerg construye un criadero
                        a.hallarJugadorActual().moverUnidad(new Coordenada(4,3), new Izquierda());
                        a.hallarJugadorActual().construirEdificio(new Coordenada(3,3),new Criadero());

                        for (int i = 0; i < 7; i++) {
                            a.pasarTurno();
                        }

                        //jugador protoss construye un Acceso
                        a.hallarJugadorActual().construirEdificio(new Coordenada(11,3), new Acceso());

                        a.pasarTurno();

                        //jugador zerg genera 3 zanganos
                        a.hallarJugadorActual().generarUnidad(new Coordenada(3,3), new Zangano());
                        a.hallarJugadorActual().generarUnidad(new Coordenada(3,3), new Zangano());
                        a.hallarJugadorActual().generarUnidad(new Coordenada(3,3), new Zangano());

                        a.pasarTurno();
                        a.pasarTurno();

                        //jugador zerg mueve un zangano y construye un Extractor
                        a.hallarJugadorActual().moverUnidad(new Coordenada(2,3), new Abajo());
                        a.hallarJugadorActual().moverUnidad(new Coordenada(2,4), new Derecha());
                        a.hallarJugadorActual().moverUnidad(new Coordenada(3,4), new Derecha());
                        a.hallarJugadorActual().construirEdificio(new Coordenada(4,4), new Extractor());

                        a.pasarTurno();
                        a.pasarTurno();
                        a.pasarTurno();
                        a.pasarTurno();
                        a.pasarTurno();

                        //jugador protoss genera un dragon y este aparece en la coordenada (11, 2)
                        a.hallarJugadorActual().generarUnidad(new Coordenada(11,3), new Dragon());

                        for (int i = 0; i < 6; i++) {
                            a.pasarTurno();
                        }

                        //jugador protoss mueve el dragon y ataca al criadero
                        a.hallarJugadorActual().moverUnidad(new Coordenada(11,2), new Izquierda());
                        a.hallarJugadorActual().moverUnidad(new Coordenada(10,2), new Izquierda());
                        a.hallarJugadorActual().moverUnidad(new Coordenada(9,2), new Izquierda());
                        a.hallarJugadorActual().moverUnidad(new Coordenada(8,2), new Izquierda());
                        a.hallarJugadorActual().moverUnidad(new Coordenada(7,2), new Izquierda());
                        a.hallarJugadorActual().moverUnidad(new Coordenada(6,2), new Izquierda());

                        a.pasarTurno();

                        //jugador zerg genera un amo supremo e ingresa un zangano al extractor
                        a.hallarJugadorActual().generarUnidad(new Coordenada(3 ,3), new AmoSupremo());
                        a.hallarJugadorActual().ingresarUnidadAUnEdificio(new Coordenada(4,4), new Coordenada(3,2));

                        a.pasarTurno();

                        //jugador protoss ataca al extractor hasta destruirlo
                        for (int i = 0; i < 37; i++) {
                            a.hallarJugadorActual().atacar(new Coordenada(5,2), new Coordenada(4,4));
                        }

                        try {
                            a.hallarJugadorActual().atacar(new Coordenada(5,2), new Coordenada(4,4));
                        }catch(EdificioEstaDestruido e){
                            System.out.println("Se destruyo el extractor");
                        }

                        a.pasarTurno();

                        //jugador zerg mueve un zangano y construye una reserva de reproduccion
                        a.hallarJugadorActual().moverUnidad(new Coordenada(4,3), new Derecha());
                        a.hallarJugadorActual().moverUnidad(new Coordenada(5,3), new Derecha());
                        a.hallarJugadorActual().construirEdificio(new Coordenada(6,3), new ReservaDeReproduccion());

                        a.pasarTurno();

                        //jugador protoss ataca el criadro hasta destruirlo
                        for (int i = 0; i < 24; i++) {
                            a.hallarJugadorActual().atacar(new Coordenada(5,2), new Coordenada(3,3));
                        }

                        try {
                            a.hallarJugadorActual().atacar(new Coordenada(5,2), new Coordenada(3,3));
                        }catch(EdificioEstaDestruido e){
                            System.out.println("Se destruyo el criadero, el jugador zerg no puede generar unidades sin larvas!");
                        }

                        //pasan los turnos para que la reserva termine de construirse
                        for (int i = 0; i < 12; i++) {
                            a.pasarTurno();
                        }

                        //jugador protoss ataca la reserva hasta destruirla y gana la partida cuando termina su turno
                        for (int i = 0; i < 49; i++) {
                            a.hallarJugadorActual().atacar(new Coordenada(5,2), new Coordenada(6,3));
                        }

                        break;
                    // End DEBUG_ code for debug purposes only
                }
            }
        });

        
        this.setCenter(contenedorCentral);
    }

    public void actualizarMapa(){
      this.contenedorCentral.setContent(mapaView.dibujar());
    }

    public void mostrarMensajeDeAccionProhibida(Text mensaje){
        HBox contenedor = new HBox(mensaje);
        contenedor.setAlignment(Pos.CENTER);

        Scene scene = new Scene(contenedor, 500,90);
        scene.setFill(Color.DARKGRAY); //no funca :(

        Stage notificacion = new Stage();
        notificacion.setTitle("Accion no permitida");
        notificacion.setScene(scene);
        notificacion.setOpacity(0.90);
        notificacion.initOwner(stage);

        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished(e -> notificacion.hide());

        notificacion.show();
        delay.play();
    }
  }
