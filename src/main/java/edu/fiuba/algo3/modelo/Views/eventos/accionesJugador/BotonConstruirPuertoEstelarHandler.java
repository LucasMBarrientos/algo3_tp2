package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.ReproductorDeSonidos;
import edu.fiuba.algo3.modelo.edificios.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.excepciones.ConstruccionRequiereDeOtroEdificio;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BotonConstruirPuertoEstelarHandler implements EventHandler<ActionEvent> {
    AlgoStar algoStar;
    AlgoStarView algoStarView;
    Coordenada coordenada;

    public BotonConstruirPuertoEstelarHandler(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        this.coordenada = coordenada;
    }

    public void construirEdificio() {
        algoStar.hallarJugadorActual().construirEdificio(coordenada, new PuertoEstelar());
    }

    public void lanzarMensajeDeFaltaDeRecursos() {
        Text texto = new Text("No tienes suficientes recursos para construir un Puerto Estelar");
        texto.setY(15);
        texto.setX(15);
        texto.setFill(Color.INDIANRED);
        texto.setFont(Font.font("Lucida Sans Unicode", FontWeight.NORMAL, FontPosture.REGULAR, 13));
        algoStarView.mostrarMensajeDeAccionProhibida(texto);
    }

    private void lanzarMensajeDeTerrenoNoApto() {
        Text texto = new Text("Puerto Estelar solo puede construirse sobre un terreno con Moho");
        texto.setY(15);
        texto.setX(15);
        texto.setFill(Color.INDIANRED);
        texto.setFont(Font.font("Lucida Sans Unicode", FontWeight.NORMAL, FontPosture.REGULAR, 13));
        algoStarView.mostrarMensajeDeAccionProhibida(texto);
    }

    private void lanzarMensajeDeCorrelativasDeConstruccion() {
        Text texto = new Text("Para construir un Puerto Estelar primero debes construir un Acceso");
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
        } catch (TerrenoNoAptoParaConstruirTalEdificio exception){
            lanzarMensajeDeTerrenoNoApto();
        } catch (ConstruccionRequiereDeOtroEdificio exception2){
            lanzarMensajeDeCorrelativasDeConstruccion();
        }
        algoStarView.actualizarMapa();
    }
}
