package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.excepciones.AtaqueImposibleDeRealizarse;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

import java.util.List;

public class BotonAtacarHandler implements EventHandler<ActionEvent> {

    AlgoStar algoStar;
    AlgoStarView algoStarView;

    Coordenada coordenadaUnidad;
    Coordenada coordenadaObjetivo;

    TextField textFieldCoord1;
    TextField textFieldCoord2;

    public BotonAtacarHandler(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenadaUnidad, TextField textField1, TextField textField2) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        this.coordenadaUnidad = coordenadaUnidad;
        this.textFieldCoord1 = textField1;
        this.textFieldCoord2 = textField2;
    }

    @Override
    public void handle(ActionEvent evento) {
        Coordenada coordenadaObjetivo = new Coordenada(Integer.parseInt(textFieldCoord1.getText()),Integer.parseInt(textFieldCoord2.getText()));
        try {
            algoStar.devolverJugadorActual().atacar(coordenadaUnidad, coordenadaObjetivo);

        }catch (UnidadEstaDestruida e) {
            //avisar al jugador que destruyo una unidad

        }catch (EdificioEstaDestruido e) {
            //avisar al jugador que destruyo un edificio

        }catch (AtaqueImposibleDeRealizarse e) {
            //avisar al jugador que el objetivo se encuentra fuera del rango

        }

        algoStarView.actualizarMapa();
    }
}
