package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.edificios.protoss.Asimilador;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoConoceEstaUnidad;
import edu.fiuba.algo3.modelo.excepciones.NoHayEspacioDisponible;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BotonIngresarUnidadHandler implements EventHandler<ActionEvent> {

    AlgoStar algoStar;
    AlgoStarView algoStarView;

    Coordenada coordenadaDeLaUnidad;
    TextField textFieldCoord1;
    TextField textFieldCoord2;

    public BotonIngresarUnidadHandler(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenadaUnidad, TextField textField1, TextField textField2) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        this.coordenadaDeLaUnidad = coordenadaUnidad;
        this.textFieldCoord1 = textField1;
        this.textFieldCoord2 = textField2;
    }

    @Override
    public void handle(ActionEvent evento) {

        Coordenada coordenadaObjetivo = new Coordenada(Integer.parseInt(textFieldCoord1.getText()),Integer.parseInt(textFieldCoord2.getText()));
        try {
            algoStar.devolverJugadorActual().ingresarUnidadAUnEdificio(coordenadaObjetivo, coordenadaDeLaUnidad);

        } catch (NoHayEspacioDisponible e) {
            //avisar al jugador que el extractor ya tiene 3 zanganos
        } catch (EdificioNoConoceEstaUnidad e) {
            //avisar al jugador que la unidad que trato de ingresar no es un zangano, y que solo los zanganos trabajan en el extractor
        }

        algoStarView.actualizarMapa();
    }
}
