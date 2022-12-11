package edu.fiuba.algo3.modelo.Views;

import edu.fiuba.algo3.modelo.Views.eventos.topMenu.OpcionSalirEventHandler;
import edu.fiuba.algo3.modelo.jugadores.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PantallaFinDelJuego extends VBox {
    
    public PantallaFinDelJuego(Jugador jugadorGanador) {
        super();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image imgFondo = new Image("/opcion2.jpg");
        BackgroundImage fondo = new BackgroundImage(imgFondo, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1080,1920,true,true,true,true));
        this.setBackground(new Background(fondo));

        Button botonParaSalir = new Button("Salir del juego");
        botonParaSalir.getStyleClass().add("btn-salir");
        OpcionSalirEventHandler opcionSalirEventHandler = new OpcionSalirEventHandler();
        botonParaSalir.setOnAction(opcionSalirEventHandler);

        Label mensajeDeVictoria = new Label(jugadorGanador.devolverMensajeDeVictoria());
        mensajeDeVictoria.setFont (Font.font("Tahoma", FontWeight.BOLD, 22));
        mensajeDeVictoria.setTextFill(Color.web("#723200"));
        this.getChildren().addAll(mensajeDeVictoria,botonParaSalir);
    }
    
}
