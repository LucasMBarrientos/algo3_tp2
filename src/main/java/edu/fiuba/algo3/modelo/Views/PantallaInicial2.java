package edu.fiuba.algo3.modelo.Views;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.eventos.BotonEmpezarJuegoEventHandler;
import edu.fiuba.algo3.modelo.Views.eventos.BotonEntrarEventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PantallaInicial2 extends VBox{

    Stage stage;
    ChoiceBox<String> cb = new ChoiceBox<String>();

    AlgoStarView algoView;

    String colorOne;

    public PantallaInicial2(Stage stage, Scene escenaJuego, AlgoStar algoStar, AlgoStarView algoView) {
        super();
        this.stage = stage;
        this.algoView = algoView;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        // imgView.setX(50);
        //imgView.setY(50);
  /*      ImageView imageView = new ImageView();
        imageView.setImage(bgImage);
        imageView.setFitHeight(780);
        imageView.setFitWidth(1620);
        this.getChildren().add(imageView);
*/
        Image imgFondo = new Image("/fondo1.jpg");
        //BackgroundImage fondo = new BackgroundImage(iconoZerg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        BackgroundImage fondo = new BackgroundImage(imgFondo, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(stage.getOutputScaleX(),stage.getMaxWidth(),true,true,true,true));

        this.setBackground(new Background(fondo));
        // this.setStyle("-fx-background: #7d7d7d; -fx-border-color: #7d7d7d;");
        // this.getStylesheets().addAll(this.getClass().getResource("descarga.png").toExternalForm());
        // contenedorCentral.setPadding(new Insets(5));

        Button botonIniciarJuego = new Button();
        botonIniciarJuego.setText("Iniciar Partida!!!");

        final String[] colores = new String[]{"Naranja","Violeta","Rojo","Azul"};

        ChoiceBox<String> cb = new ChoiceBox<String>();
        cb.getItems().addAll(colores);
        cb.setOnAction(this::getColorOne);



        TextField nombreJugador1 = new TextField();




        BotonEmpezarJuegoEventHandler botonEmpezarJuegoEventHandler = new BotonEmpezarJuegoEventHandler(stage,escenaJuego,algoStar, algoView, nombreJugador1,cb.getSelectionModel().getSelectedItem());
        botonIniciarJuego.setOnAction(botonEmpezarJuegoEventHandler);
        //this.getChildren().add(imgView);
        //    boolean add = this.getChildren().add(imgView);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(nombreJugador1,cb,botonIniciarJuego);
    }


    public void getColorOne(ActionEvent e){
        this.colorOne = cb.getSelectionModel().getSelectedItem();
        System.out.println(colorOne);
    }


}
