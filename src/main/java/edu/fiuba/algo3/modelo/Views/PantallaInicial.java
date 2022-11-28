package edu.fiuba.algo3.modelo.Views;

import edu.fiuba.algo3.modelo.Views.eventos.BotonEntrarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PantallaInicial extends VBox {

    Stage stage;

    public PantallaInicial(Stage stage, Scene escenaJuego) {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image iconoZerg = new Image("https://github.com/LucasMBarrientos/algo3_tp2/blob/bc0e1f66c59b3cbdae5ef601f794c768dc96d95c/src/main/assets/images/Zerg_SC2_Icon2.png");
        BackgroundImage fondo = new BackgroundImage(iconoZerg, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(fondo));

        Button botonIniciarJuego = new Button();
        botonIniciarJuego.setText("Iniciar Partida!!!");

        TextField nombreJugador1 = new TextField();
        nombreJugador1.setText("abcdef");

        TextField nombreJugador2 = new TextField();
        nombreJugador2.setText("ghijkl");

        BotonEntrarEventHandler botonEntrarEventHandler = new BotonEntrarEventHandler(stage,escenaJuego);
        botonIniciarJuego.setOnAction(botonEntrarEventHandler);

        this.getChildren().addAll(nombreJugador1,nombreJugador2,botonIniciarJuego);
    }
}
