package edu.fiuba.algo3.modelo.Views;


import com.fasterxml.jackson.databind.JsonNode;
import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonPasarTurnoHandler;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.BotoneraAcceso;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.BotoneraAtaque;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.BotoneraCriadero;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.BotoneraEnergizadoProtoss;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.BotoneraEspiral;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.BotoneraGuarida;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.BotoneraMineralProtoss;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.BotoneraPuertoEstelar;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.BotoneraReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.BotoneraVaciaProtoss;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.BotoneralVolcanProtoss;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.unidades.BotoneraAmoSupremo;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.unidades.BotoneraMutalisco;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.unidades.BotoneraUnidadNormal;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.unidades.BotoneraZangano;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AlgoStarView extends BorderPane {

    BarraDelMenu menuBar;

    Stage stage;
    AlgoStar algoStar;
    ScrollPane contenedorCentral;
    Group layout;

    Coordenada limite;

    Mapa mapa;

    MapaView mapaView;

    Image pasarTurnoImagen = new Image("/Sprite-0001-export.png", 100, 100, false, false);

    public AlgoStarView(Stage stage, AlgoStar algostar) {
        this.stage = stage;
        this.algoStar = algostar;
        this.contenedorCentral = new ScrollPane();
        mapa = algoStar.empezarJuego();
        
        agregarBarraDelMenu(stage);
        pantallaJuego();
        setPantallDeStats();
        crearBotoneraVacia();
    }

    public void setPantallaDeStatsJugador() {
        ImageView view = new ImageView(pasarTurnoImagen);

        Button pasarTurno = new Button();
        BotonPasarTurnoHandler pasarTurnoHandler = new BotonPasarTurnoHandler(algoStar,this,stage);
        pasarTurno.setOnAction(pasarTurnoHandler);
        pasarTurno.setGraphic(view);

        JsonNode jugadorNode = algoStar.devolverJugadorActual().toData();

        Label jugadorActualLabel = new Label("Jugador Actual: " + jugadorNode.get("nombre").asText());

        Label gasDisponible = new Label("Gas Vespeno: " + jugadorNode.get("inventario").get("cantidadGasVespeno").get("gasVespeno").asText());
        Label mineralDisponible = new Label("Mineral: " + jugadorNode.get("inventario").get("cantidadMineral").get("mineral").asText());

        VBox contenedorHorizontal = new VBox(pasarTurno, jugadorActualLabel,gasDisponible,mineralDisponible); // <- recibe las cosas como parámetro
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(10));

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

    public void setPantallDeStatsUnidad(JsonNode node) {
        //Aca iría las cosas de la pantalla de stats
        Label vida = new Label("Vida: " + node.get("Ocupante").get("vida").asText());
        Label danioAereoYTerrestre = new Label("Daño Terrestre: " + node.get("Ocupante").get("danioTerrestre").asText() + "\nDaño Aereo: " + node.get("Ocupante").get("danioAereo").asText());


        // handler del boton construir
        VBox contenedorHorizontal = new VBox(vida, danioAereoYTerrestre); // <- recibe las cosas como parámetro
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(10));

        this.setLeft(contenedorHorizontal);
    }
    public void setPantallDeStatsEdificio(JsonNode node) {
        //Aca iría las cosas de la pantalla de stats
        Label vida = new Label("Vida: " + node.get("Ocupante").get("vida").asText());
        Label estadoConstruccion = new Label("Estado de Construcción: " + node.get("Ocupante").get("estado").asText());


        // handler del boton construir
        VBox contenedorHorizontal = new VBox(vida, estadoConstruccion); // <- recibe las cosas como parámetro
        //contenedorHorizontal.setStyle("-fx-background-image: url('/texturaStats.png');" +
         //       "-fx-background-repeat: repeat;");
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(10));

        this.setLeft(contenedorHorizontal);
    }

    public HBox crearBotoneraVacia() {
        HBox contenedorHorizontal = new HBox();
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(25));

        return contenedorHorizontal;
    }
    public void crearBotoneraAmoSupremo(Coordenada coordenada) {
      new BotoneraAmoSupremo(algoStar, this, coordenada);
    }
    public void crearBotoneraMutalisco(Coordenada coordenada) {
      new BotoneraMutalisco(algoStar, this, coordenada);
    }
    public void crearBotoneraUnidadNormal(Coordenada coordenada) {
      new BotoneraUnidadNormal(algoStar, this, coordenada);
    }
    public void crearBotoneraZangano(Coordenada coordenada) {
      new BotoneraZangano(algoStar, this,coordenada);
    }
    public void crearBotoneraAcceso(Coordenada coordenada) {
      new BotoneraAcceso(algoStar, this,coordenada);
    }
    public void crearBotoneraAtaque(Coordenada coordenada) {
      new BotoneraAtaque(algoStar, this,coordenada, new TextField(), new TextField());
    }
    public void crearBotoneraCriadero(Coordenada coordenada) {
      new BotoneraCriadero(algoStar, this,coordenada);
    }
    public void crearBotoneraEnergizado(Coordenada coordenada) {
      if("protoss"== algoStar.devolverJugadorActual().toData().get("raza").asText()){
        new BotoneraEnergizadoProtoss(algoStar, this,coordenada);
      }else{
        this.setBottom(crearBotoneraVacia());
      }
    }
    public void crearBotoneraEspiral(Coordenada coordenada) {
      new BotoneraEspiral(algoStar, this,coordenada);
    }
    public void crearBotoneraGuarida(Coordenada coordenada) {
      new BotoneraGuarida(algoStar, this,coordenada);
    }
    public void crearBotoneraVolcan(Coordenada coordenada) {
      if("protoss"== algoStar.devolverJugadorActual().toData().get("raza").asText()){
        new BotoneralVolcanProtoss(algoStar, this,coordenada);
      }else{
        this.setBottom(crearBotoneraVacia());
      }
    }
    public void crearBotoneraMineral(Coordenada coordenada) {
      if("protoss"== algoStar.devolverJugadorActual().toData().get("raza").asText()){
        new BotoneraMineralProtoss(algoStar, this,coordenada);
      }else{
        this.setBottom(crearBotoneraVacia());
      }
    }
    public void crearBotoneraPuertoEstelar(Coordenada coordenada) {
      new BotoneraPuertoEstelar(algoStar, this,coordenada);
    }
    public void crearBotoneraReservaDeReproduccion(Coordenada coordenada) {
      new BotoneraReservaDeReproduccion(algoStar, this,coordenada);
    }
    public void crearBotoneraVacia(Coordenada coordenada) {
      if("protoss"== algoStar.devolverJugadorActual().toData().get("raza").asText()){
        new BotoneraVaciaProtoss(algoStar, this,coordenada);
      }else{
        this.setBottom(crearBotoneraVacia());
      }
    }
    
    

    private void agregarBarraDelMenu(Stage stage){
        this.menuBar = new BarraDelMenu(stage);
        this.setTop(menuBar);
    }

    private void pantallaJuego(){
        limite = new Coordenada(100,20);

        this.mapaView = new MapaView(mapa, this);
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
                }
            }
        });

        
        this.setCenter(contenedorCentral);
    }

    public void actualizarMapa(){
      this.contenedorCentral.setContent(mapaView.dibujar());
    }
  }
