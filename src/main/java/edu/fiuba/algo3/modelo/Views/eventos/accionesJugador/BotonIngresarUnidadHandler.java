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

public class BotonIngresarUnidadHandler implements EventHandler<ActionEvent> {

    AlgoStar algoStar;
    AlgoStarView algoStarView;

    Coordenada coordenadaDeLaUnidad;
    Coordenada coordenadaDelEdificio;

    public BotonIngresarUnidadHandler(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenadaUnidad, Coordenada coordenadaEdificio) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        this.coordenadaDeLaUnidad = coordenadaUnidad;
        this.coordenadaDelEdificio = coordenadaEdificio;
    }

    @Override
    public void handle(ActionEvent evento) {
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
