package edu.fiuba.algo3.modelo.Views;

import java.util.List;

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

        //BackgroundImage fondo2 = new BackgroundImage(imgFondo, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.AUTO(this.getBaselineOffset()));
        List<String> objetos = jugadorGanador.devolverMediaDeVictoria();
        BackgroundImage fondo = new BackgroundImage(new Image(objetos.get(0)), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(fondo));
        Label mensajeDeVictoria = new Label(objetos.get(1));
        this.getChildren().add(mensajeDeVictoria);

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
