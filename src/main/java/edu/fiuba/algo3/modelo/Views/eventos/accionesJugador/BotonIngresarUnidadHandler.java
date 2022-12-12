package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoConoceEstaUnidad;
import edu.fiuba.algo3.modelo.excepciones.NoHayEspacioDisponible;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BotonIngresarUnidadHandler implements EventHandler<ActionEvent> {

    AlgoStar algoStar;
    AlgoStarView algoStarView;
    Coordenada coordenadaDeLaUnidad;
    //Coordenada coordenadaDelEdificio;

    TextField x;
    TextField y;


    public BotonIngresarUnidadHandler(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenadaUnidad, TextField text1, TextField text2) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        this.coordenadaDeLaUnidad = coordenadaUnidad;
        this.x = text1;
        this.y= text2;
        //this.coordenadaDelEdificio = coordenadaDelEdificio;

    }

    public void handle(ActionEvent evento) {
        Coordenada coordenadaDelEdificio = new Coordenada(Integer.parseInt(x.getText()), Integer.parseInt(y.getText()));

        try {
            algoStar.devolverJugadorActual().ingresarUnidadAUnEdificio(coordenadaDelEdificio, coordenadaDeLaUnidad);

        } catch (NoHayEspacioDisponible e) {
            //avisar al jugador que el extractor ya tiene 3 zanganos
        } catch (EdificioNoConoceEstaUnidad e) {
            //avisar al jugador que la unidad que trato de ingresar no es un zangano, y que solo los zanganos trabajan en el extractor
        }

        algoStarView.actualizarMapa();
    }
}
