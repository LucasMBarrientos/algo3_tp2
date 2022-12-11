package edu.fiuba.algo3.modelo.Views;


import com.fasterxml.jackson.databind.JsonNode;
import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonAtacarHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonIngresarUnidadHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonPasarTurnoHandler;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.*;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.unidades.BotoneraAmoSupremo;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.unidades.BotoneraMutalisco;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.unidades.BotoneraUnidadNormal;
import edu.fiuba.algo3.modelo.Views.eventos.botoneras.unidades.BotoneraZangano;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Arriba;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.geometria.direcciones.Izquierda;
import edu.fiuba.algo3.modelo.jugadores.Jugador;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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

    public void setPantallaDeStatsJugador() {
        ImageView view = new ImageView(pasarTurnoImagen);

        Button pasarTurno = new Button();
        BotonPasarTurnoHandler pasarTurnoHandler = new BotonPasarTurnoHandler(algoStar,this,stage);
        pasarTurno.setOnAction(pasarTurnoHandler);
        pasarTurno.setGraphic(view);

        JsonNode jugadorNode = algoStar.devolverJugadorActual().toData();

        Label jugadorActualLabel = new Label("Turno de " + jugadorNode.get("nombre").asText());

        Label gasDisponible = new Label("Gas Vespeno: " + jugadorNode.get("inventario").get("cantidadGasVespeno").get("gasVespeno").asText());
        Label mineralDisponible = new Label("Mineral: " + jugadorNode.get("inventario").get("cantidadMineral").get("mineral").asText());
        Label suministrosDisponibles = new Label("Suministros: " + jugadorNode.get("inventario").get("suministroActual").get("suministro").asText());

        Label edificiosDisponibles = new Label("Edificios restantes: " + jugadorNode.get("inventario").get("edificios").asText());
        Label unidadesDisponibles = new Label("Unidades restantes: " + jugadorNode.get("inventario").get("unidades").asText());

        VBox contenedorHorizontal = new VBox(pasarTurno, jugadorActualLabel,gasDisponible,mineralDisponible,suministrosDisponibles,edificiosDisponibles,unidadesDisponibles); // <- recibe las cosas como parámetro
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
        Label escudo = new Label();
        if(Objects.equals(node.get("Ocupante").get("raza").asText(), "protoss")){
            escudo = new Label("Escudo: " + node.get("Ocupante").get("escudo").asText());
        }

        // handler del boton construir
        VBox contenedorHorizontal = new VBox(danioAereoYTerrestre,vida,escudo); // <- recibe las cosas como parámetro
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(10));

        this.setLeft(contenedorHorizontal);
    }
    public void setPantallDeStatsEdificio(JsonNode node) {
        //Aca iría las cosas de la pantalla de stats
        Label vida = new Label("Vida: " + node.get("Ocupante").get("vida").asText());
        Label estadoConstruccion = new Label("Estado de Construcción: " + node.get("Ocupante").get("estado").asText());
        Label escudo = new Label();
        if(Objects.equals(node.get("Ocupante").get("raza").asText(), "protoss")){
             escudo = new Label("Escudo: " + node.get("Ocupante").get("escudo").asText());
        }

        // handler del boton construir
        VBox contenedorHorizontal = new VBox(estadoConstruccion,vida,escudo); // <- recibe las cosas como parámetro
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

    public HBox crearBotoneraVacia(Coordenada coordenada) {
        HBox contenedorHorizontal = new HBox();
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(25));
        Label coordenadaX = new Label("CORDENADA X: " + coordenada.toData().get("x"));
        Label coordenadaY  = new Label("CORDENADA Y: "  + coordenada.toData().get("y"));
        VBox coordenadaBox = new VBox(coordenadaX,coordenadaY);
        contenedorHorizontal.getChildren().clear();
        contenedorHorizontal.getChildren().add(coordenadaBox);

        return contenedorHorizontal;
    }

    
    public void crearBotoneraAmoSupremo(Coordenada coordenada) {
      if("zerg"== algoStar.devolverJugadorActual().toData().get("raza").asText()){
        new BotoneraAmoSupremo(algoStar, this, coordenada);
      }else{
        this.setBottom(crearBotoneraVacia(coordenada));
      }
    }
    public void crearBotoneraMutalisco(Coordenada coordenada) {
      if("zerg"== algoStar.devolverJugadorActual().toData().get("raza").asText()){
        new BotoneraMutalisco(algoStar, this, coordenada);
      }else{
        this.setBottom(crearBotoneraVacia(coordenada));
      } 
    }
    public void crearBotoneraUnidadNormal(Coordenada coordenada) {
      new BotoneraUnidadNormal(algoStar, this, coordenada);
    }
    public void crearBotoneraZangano(Coordenada coordenada) {
      if("zerg"== algoStar.devolverJugadorActual().toData().get("raza").asText()){
        new BotoneraZangano(algoStar, this,coordenada);
      }else{
        this.setBottom(crearBotoneraVacia(coordenada));
      } 
    }
    public void crearBotoneraAcceso(Coordenada coordenada) {
      if("protoss"== algoStar.devolverJugadorActual().toData().get("raza").asText()){
        new BotoneraAcceso(algoStar, this,coordenada);
      } else {
        this.setBottom(crearBotoneraVacia(coordenada));
      }
    }
    /*
    public void crearBotoneraAtaque(Coordenada coordenada) {
        new BotoneraAtaque(algoStar, this, coordenada);
    }*/

    public void crearBotoneraCriadero(Coordenada coordenada) {
        if ("zerg"== algoStar.devolverJugadorActual().toData().get("raza").asText()) {
            new BotoneraCriadero(algoStar, this,coordenada);
        } else {
           this.setBottom(crearBotoneraVacia(coordenada));
        }
    }
    public void crearBotoneraEnergizado(Coordenada coordenada) {
      if("protoss"== algoStar.devolverJugadorActual().toData().get("raza").asText()){
        new BotoneraEnergizadoProtoss(algoStar, this,coordenada);
      }else{
        this.setBottom(crearBotoneraVacia(coordenada));
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
        this.setBottom(crearBotoneraVacia(coordenada));
      }
    }
    public void crearBotoneraMineral(Coordenada coordenada) {
      if("protoss"== algoStar.devolverJugadorActual().toData().get("raza").asText()){
        new BotoneraMineralProtoss(algoStar, this,coordenada);
      }else{
        this.setBottom(crearBotoneraVacia(coordenada));
      }
    }
    public void crearBotoneraPuertoEstelar(Coordenada coordenada) {
      if("protoss"== algoStar.devolverJugadorActual().toData().get("raza").asText()){
        new BotoneraPuertoEstelar(algoStar, this,coordenada);
      }else{
        this.setBottom(crearBotoneraVacia(coordenada));
      }
    }
    public void crearBotoneraReservaDeReproduccion(Coordenada coordenada) {
      if("zerg"== algoStar.devolverJugadorActual().toData().get("raza").asText()){
        new BotoneraReservaDeReproduccion(algoStar, this,coordenada);
      }else{
        this.setBottom(crearBotoneraVacia(coordenada));
      }
    }
    public void crearBotoneraTerrenoVacio(Coordenada coordenada) {
      if("protoss"== algoStar.devolverJugadorActual().toData().get("raza").asText()){
        new BotoneraVaciaProtoss(algoStar, this,coordenada);
      }else{
        this.setBottom(crearBotoneraVacia(coordenada));
      }
    }

    public void ataque(Coordenada coordenadaUnidad){
        this.contenedorCentral.setContent(mapaView.dibujar(true, coordenadaUnidad, false));
    }

    public void realizarAtaque(Coordenada coordenadaUnidad, Coordenada coordenadaObjetivo){
      System.out.println("Jugador en: ");
      System.out.println("x: " + coordenadaUnidad.devolverX());
      System.out.println("y: " + coordenadaUnidad.devolverY());
      System.out.println("ataca a: ");
      System.out.println("x: " + coordenadaObjetivo.devolverX());
      System.out.println("y: " + coordenadaObjetivo.devolverY());
      BotonAtacarHandler ataque = new BotonAtacarHandler(algoStar, this, coordenadaUnidad, coordenadaObjetivo);
      ataque.handle();
      this.contenedorCentral.setContent(mapaView.dibujar());
    }

    public void ingreso(Coordenada coordenadaUnidad){
        this.contenedorCentral.setContent(mapaView.dibujar(false, coordenadaUnidad, true));
    }

    public void ingresarUnidad(Coordenada coordenadaUnidad, Coordenada coordenadaEdificio){
        BotonIngresarUnidadHandler ingreso = new BotonIngresarUnidadHandler(algoStar, this, coordenadaUnidad, coordenadaEdificio);
        ingreso.handle();
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
                        Jugador j1 = algoStar.jugadores.get(0);
                        Jugador j2 = algoStar.jugadores.get(1);


                        j2.construirEdificio(new Coordenada(96, 45), new NexoMineral());
                        j2.construirEdificio(new Coordenada(95, 46), new NexoMineral());
                        for (int i = 0; i < 50; i++) { // Termino de construir los nexos minerales
                            algoStar.pasarTurno();
                        }
                        j2.construirEdificio(new Coordenada(95, 45), new Asimilador());
                        j2.construirEdificio(new Coordenada(8, 1), new Pilon());
                        for (int i = 0; i < 6; i++) { // Termino de construir el pilon y el asimilador
                            algoStar.pasarTurno();
                        }
                        for (int i = 0; i < 100; i++) { // Recolecto suficientes minerales
                            algoStar.pasarTurno();
                        }
                        j2.construirEdificio(new Coordenada(6, 1), new Acceso());
                        j2.construirEdificio(new Coordenada(10, 1), new PuertoEstelar());

                        j1.moverUnidad(new Coordenada(1, 1), new Derecha());
                        j1.moverUnidad(new Coordenada(2, 1), new Derecha());
                        j1.moverUnidad(new Coordenada(3, 1), new Derecha());
                        j1.moverUnidad(new Coordenada(4, 1), new Abajo());
                        j1.moverUnidad(new Coordenada(4, 2), new Abajo());
                        for (int i = 0; i < 100; i++) { // Recolecto suficientes minerales
                            algoStar.pasarTurno();
                        }
                        j1.moverUnidad(new Coordenada(4,3), new Izquierda());
                        j1.moverUnidad(new Coordenada(3,3), new Arriba());
                        j1.construirEdificio(new Coordenada(3, 2), new Criadero());
                        for (int i = 0; i < 4; i++) { // Termino de construir el criadero
                            algoStar.pasarTurno();
                        }
                        j1.generarUnidad(new Coordenada(3, 2), new Zangano());
                        j1.generarUnidad(new Coordenada(3, 2), new Zangano());
                        j1.generarUnidad(new Coordenada(3, 2), new Zangano());
                        algoStar.pasarTurno();
                        algoStar.pasarTurno();

                        j1.moverUnidad(new Coordenada(3, 1), new Izquierda());
                        j1.moverUnidad(new Coordenada(2, 1), new Izquierda());

                        j1.moverUnidad(new Coordenada(2, 2), new Izquierda());
                        j1.moverUnidad(new Coordenada(1, 2), new Abajo());

                        j1.moverUnidad(new Coordenada(4, 2), new Abajo());
                        j1.moverUnidad(new Coordenada(4, 3), new Abajo());

                        j1.construirEdificio(new Coordenada(4, 4), new Extractor());
                        for (int i = 0; i < 6; i++) { // Termino de construir el extractor
                            algoStar.pasarTurno();
                        }

                        j1.generarUnidad(new Coordenada(3, 2), new Zangano());
                        j1.generarUnidad(new Coordenada(3, 2), new Zangano());
                        j1.generarUnidad(new Coordenada(3, 2), new Zangano());
                        algoStar.pasarTurno();
                        algoStar.pasarTurno();
                        j1.ingresarUnidadAUnEdificio(new Coordenada(4, 4), new Coordenada(3,1));
                        j1.ingresarUnidadAUnEdificio(new Coordenada(4, 4), new Coordenada(2,2));
                        j1.ingresarUnidadAUnEdificio(new Coordenada(4, 4), new Coordenada(4,2));
                        for (int i = 0; i < 100; i++) { // Recolecto suficientes recursos
                            algoStar.pasarTurno();
                        }
                        j1.generarUnidad(new Coordenada(3, 2), new Zangano());
                        algoStar.pasarTurno();
                        algoStar.pasarTurno();
                        j1.moverUnidad(new Coordenada(3, 1), new Derecha());
                        j1.construirEdificio(new Coordenada(1, 1), new ReservaDeReproduccion());
                        j1.construirEdificio(new Coordenada(1, 3), new Guarida());
                        j1.construirEdificio(new Coordenada(4, 1), new Espiral());

                        for (int i = 0; i < 20; i++) { // Construyo los edificios
                            algoStar.pasarTurno();
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
