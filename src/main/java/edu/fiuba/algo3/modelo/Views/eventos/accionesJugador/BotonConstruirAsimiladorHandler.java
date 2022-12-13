package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.ReproductorDeSonidos;
import edu.fiuba.algo3.modelo.edificios.protoss.Asimilador;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BotonConstruirAsimiladorHandler implements EventHandler<ActionEvent> {

    AlgoStar algoStar;
    AlgoStarView algoStarView;
    Coordenada coordenada;

    public BotonConstruirAsimiladorHandler(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        this.coordenada = coordenada;
    }

    public void construirEdificio() {
        algoStar.hallarJugadorActual().construirEdificio(coordenada, new Asimilador());
    }

    public void lanzarMensajeDeFaltaDeRecursos() {
        Text texto = new Text("No tienes suficientes recursos para construir un Asimilador");
        texto.setY(15);
        texto.setX(15);
        texto.setFill(Color.INDIANRED);
        texto.setFont(Font.font("Lucida Sans Unicode", FontWeight.NORMAL, FontPosture.REGULAR, 13));
        algoStarView.mostrarMensajeDeAccionProhibida(texto);
    }

    @Override
    public void handle(ActionEvent evento) {
        try {
            construirEdificio();
            algoStarView.setPantallaDeStatsJugador();
            ReproductorDeSonidos.devolverInstancia().reproducirSonido("/construccionCompletada.mp3", false);
        } catch (RecursosInsuficientes e) {
            lanzarMensajeDeFaltaDeRecursos();
        }
        algoStarView.actualizarMapa();
    }

}
