package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.excepciones.CoordenadaFueraDelMapa;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaTalUnidad;
import edu.fiuba.algo3.modelo.excepciones.UnidadNoEncontrada;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Izquierda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BotonMoverIzquierdaHandler implements EventHandler<ActionEvent> {
    AlgoStar algoStar;
    AlgoStarView algoStarView;

    Coordenada coordenadaActual;

    public BotonMoverIzquierdaHandler(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        coordenadaActual = coordenada;
    }

    @Override
    public void handle(ActionEvent evento) {
        try {
            algoStar.hallarJugadorActual().moverUnidad(coordenadaActual, new Izquierda());
        } catch (CoordenadaFueraDelMapa | UnidadNoEncontrada | TerrenoNoAptoParaTalUnidad exeption) {
            Text texto = new Text("La unidad seleccionada no puede transitar por este terreno");
            texto.setY(15);
            texto.setX(15);
            texto.setFill(Color.INDIANRED);
            texto.setFont(Font.font("Lucida Sans Unicode", FontWeight.NORMAL, FontPosture.REGULAR, 13));

            algoStarView.mostrarMensajeDeAccionProhibida(texto);
        }
        algoStarView.setBottom(algoStarView.crearBotoneraVacia());
        algoStarView.actualizarMapa();
    }
}
