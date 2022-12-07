package edu.fiuba.algo3.modelo.Views;

import edu.fiuba.algo3.modelo.jugadores.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PantallaFinDelJuego extends VBox {
    
    public PantallaFinDelJuego(Jugador jugadorGanador) {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Label mensajeDeVictoria = new Label(jugadorGanador.devolverMensajeDeVictoria());
        this.getChildren().add(mensajeDeVictoria);
    }
    
}
