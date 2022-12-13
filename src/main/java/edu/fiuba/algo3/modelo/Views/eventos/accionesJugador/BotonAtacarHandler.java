package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.ReproductorDeSonidos;
import edu.fiuba.algo3.modelo.excepciones.AtaqueImposibleDeRealizarse;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.excepciones.UnidadNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BotonAtacarHandler {

    AlgoStar algoStar;
    AlgoStarView algoStarView;

    Coordenada coordenadaUnidad;
    Coordenada coordenadaObjetivo;


    public BotonAtacarHandler(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenadaUnidad, Coordenada coordenadaObjetivo) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        this.coordenadaUnidad = coordenadaUnidad;
        this.coordenadaObjetivo = coordenadaObjetivo;
    }

    private void lanzarMensajeDeUnidadNoOperativo() {
        Text texto = new Text("Parece que esta unidad aun esta construccion\n" +
                "Deberas esperar un poco mas para atacar con ella!");
        texto.setY(15);
        texto.setX(15);
        texto.setFill(Color.INDIANRED);
        texto.setFont(Font.font("Lucida Sans Unicode", FontWeight.NORMAL, FontPosture.REGULAR, 13));
        algoStarView.mostrarMensajeDeAccionProhibida(texto);
    }

    private void lanzarMensajeDeObjetivoFuraDelRango() {
        Text texto = new Text("El objetivo que intentas atacar se encuentra fuera del rango de esta unidad\n" +
                "Deberas acercarte primero! ");
        texto.setY(15);
        texto.setX(15);
        texto.setFill(Color.INDIANRED);
        texto.setFont(Font.font("Lucida Sans Unicode", FontWeight.NORMAL, FontPosture.REGULAR, 13));
        algoStarView.mostrarMensajeDeAccionProhibida(texto);
    }

    private void lanzarMensajeDeUnidadDestruida() {
        Text texto = new Text("Felicidades! Has destruido una Unidad enemiga" );
        texto.setY(15);
        texto.setX(15);
        texto.setFill(Color.INDIANRED);
        texto.setFont(Font.font("Lucida Sans Unicode", FontWeight.NORMAL, FontPosture.REGULAR, 13));
        algoStarView.mostrarMensajeDeAccionProhibida(texto);
    }

    private void lanzarMensajeDeEdificioDestruido() {
        Text texto = new Text("Felicidades! Has destruido un Edificio enemigo" );
        texto.setY(15);
        texto.setX(15);
        texto.setFill(Color.INDIANRED);
        texto.setFont(Font.font("Lucida Sans Unicode", FontWeight.NORMAL, FontPosture.REGULAR, 13));
        algoStarView.mostrarMensajeDeAccionProhibida(texto);
    }

    public void handle() {
        try {
            algoStar.hallarJugadorActual().atacar(coordenadaUnidad, coordenadaObjetivo);
            ReproductorDeSonidos.devolverInstancia().reproducirSonido("/boom.mp3", false);

        } catch (UnidadEstaDestruida e) {
            lanzarMensajeDeUnidadDestruida();

        } catch (EdificioEstaDestruido e) {
            lanzarMensajeDeEdificioDestruido();

        } catch (AtaqueImposibleDeRealizarse e) {
            lanzarMensajeDeObjetivoFuraDelRango();

        } catch (UnidadNoTerminoDeConstruirse e){
            lanzarMensajeDeUnidadNoOperativo();
        }
        algoStarView.actualizarMapa();

    }
}
