package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoConoceEstaUnidad;
import edu.fiuba.algo3.modelo.excepciones.NoHayEspacioDisponible;
import edu.fiuba.algo3.modelo.geometria.Coordenada;

public class BotonIngresarUnidadHandler {

    AlgoStar algoStar;
    AlgoStarView algoStarView;
    Coordenada coordenadaDeLaUnidad;
    Coordenada coordenadaDelEdificio;


    public BotonIngresarUnidadHandler(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenadaUnidad, Coordenada coordenadaDelEdificio) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        this.coordenadaDeLaUnidad = coordenadaUnidad;
        this.coordenadaDelEdificio = coordenadaDelEdificio;

    }

    public void handle() {

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
