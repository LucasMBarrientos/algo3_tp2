package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.excepciones.NoHayLarvasSuficientes;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.zerg.AmoSupremo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BotonGenerarAmoSupremoHandler implements EventHandler<ActionEvent> {

    AlgoStar algoStar;
    AlgoStarView algoStarView;

    Coordenada coordenadaDelEdificio;

    public BotonGenerarAmoSupremoHandler(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        coordenadaDelEdificio = coordenada;
    }

    private void lanzarMensajeDeFaltaDeRecursos() {
        Text texto = new Text("No tienes suficientes recursos para generar un Amo Supremo");
        texto.setY(15);
        texto.setX(15);
        texto.setFill(Color.INDIANRED);
        texto.setFont(Font.font("Lucida Sans Unicode", FontWeight.NORMAL, FontPosture.REGULAR, 13));
        algoStarView.mostrarMensajeDeAccionProhibida(texto);
    }

    private void lanzarMensajeDeLarvasInsuficientes() {
        Text texto = new Text("No hay larvas disponibles en ningun criadero!\n Debes esperar al siguiente turno");
        texto.setY(15);
        texto.setX(15);
        texto.setFill(Color.INDIANRED);
        texto.setFont(Font.font("Lucida Sans Unicode", FontWeight.NORMAL, FontPosture.REGULAR, 13));

        algoStarView.mostrarMensajeDeAccionProhibida(texto);
    }

    private void lanzarMensajeDeEdificioNoOperativo() {
        Text texto = new Text("Criadero no termino de construirse aun!\n " +
                "Deberas esperar un poco mas para tener un Amo Supremo en tu ejercito");
        texto.setY(15);
        texto.setX(15);
        texto.setFill(Color.INDIANRED);
        texto.setFont(Font.font("Lucida Sans Unicode", FontWeight.NORMAL, FontPosture.REGULAR, 13));
        algoStarView.mostrarMensajeDeAccionProhibida(texto);
    }

    @Override
    public void handle(ActionEvent evento) {
        try {
            algoStar.hallarJugadorActual().generarUnidad(coordenadaDelEdificio, new AmoSupremo());
            algoStarView.setPantallaDeStatsJugador();

        } catch (RecursosInsuficientes e) {
            lanzarMensajeDeFaltaDeRecursos();

        } catch (NoHayLarvasSuficientes exeption ){
          lanzarMensajeDeLarvasInsuficientes();

        } catch (EdificioNoTerminoDeConstruirse exeption2) {
            lanzarMensajeDeEdificioNoOperativo();
        }

        algoStarView.actualizarMapa();
    }
}
