package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BotonGenerarZealotHandler implements EventHandler<ActionEvent> {

    AlgoStar algoStar;
    AlgoStarView algoStarView;

    Coordenada coordenadaDelEdificio;

    public BotonGenerarZealotHandler(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        coordenadaDelEdificio = coordenada;
    }

    private void lanzarMensajeDeEdificioNoOperativo() {
        Text texto = new Text("Acceso no termino de construirse aun!\n " +
                "Deberas esperar un poco mas para tener un Zealot en tu ejercito");
        texto.setY(15);
        texto.setX(15);
        texto.setFill(Color.INDIANRED);
        texto.setFont(Font.font("Lucida Sans Unicode", FontWeight.NORMAL, FontPosture.REGULAR, 13));
        algoStarView.mostrarMensajeDeAccionProhibida(texto);
    }

    @Override
    public void handle(ActionEvent evento) {
        try {
            algoStar.hallarJugadorActual().generarUnidad(coordenadaDelEdificio, new Zealot());
            algoStarView.setPantallaDeStatsJugador();
        } catch (RecursosInsuficientes e) {
            Text texto = new Text("No tienes suficientes recursos para generar un Zealot");
            texto.setY(15);
            texto.setX(15);
            texto.setFill(Color.INDIANRED);
            texto.setFont(Font.font("Lucida Sans Unicode", FontWeight.NORMAL, FontPosture.REGULAR, 13));

            algoStarView.mostrarMensajeDeAccionProhibida(texto);
        }catch (EdificioNoTerminoDeConstruirse exeption2) {
            lanzarMensajeDeEdificioNoOperativo();
        }

        algoStarView.actualizarMapa();
    }

}
