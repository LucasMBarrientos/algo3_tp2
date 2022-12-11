package edu.fiuba.algo3.modelo.Views.eventos.accionesJugador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.ReproductorDeSonidos;
import edu.fiuba.algo3.modelo.excepciones.AtaqueImposibleDeRealizarse;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.scene.control.TextField;

import java.util.List;

public class BotonAtacarHandler {

    AlgoStar algoStar;
    AlgoStarView algoStarView;

    Coordenada coordenadaUnidad;
    Coordenada coordenadaObjetivo;

    List<TextField> casillasDeTextoConCoordenadas;

    public BotonAtacarHandler(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenadaUnidad, Coordenada coordenadaObjetivo) {
        this.algoStar = algoStar;
        this.algoStarView = algoStarView;
        this.coordenadaUnidad = coordenadaUnidad;
        this.coordenadaObjetivo = coordenadaObjetivo;
    }

    public void handle() {
        try {
            algoStar.devolverJugadorActual().atacar(coordenadaUnidad, coordenadaObjetivo);
            ReproductorDeSonidos.devolverInstancia().reproducirSonido("/boom.mp3", false);
        } catch (UnidadEstaDestruida e) {
            //avisar al jugador que destruyo una unidad

        } catch (EdificioEstaDestruido e) {
            //avisar al jugador que destruyo un edificio

        } catch (AtaqueImposibleDeRealizarse e) {
            //avisar al jugador que el objetivo se encuentra fuera del rango
        }
        algoStarView.actualizarMapa();

    }
}
