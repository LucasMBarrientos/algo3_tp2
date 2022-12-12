package edu.fiuba.algo3.modelo.Views;

import edu.fiuba.algo3.modelo.jugadores.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class PantallaFinDelJuego extends VBox {
    
    public PantallaFinDelJuego(Jugador jugadorGanador) {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image imgFondo = new Image("/fondo1.jpg");

        BackgroundImage fondo = new BackgroundImage(imgFondo, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        //BackgroundImage fondo2 = new BackgroundImage(imgFondo, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.AUTO(this.getBaselineOffset()));
        this.setBackground(new Background(fondo));
        Label mensajeDeVictoria = new Label(jugadorGanador.devolverMensajeDeVictoria());
        this.getChildren().add(mensajeDeVictoria);
    }
    
}
