package edu.fiuba.algo3;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.PantallaBienvenida;
import edu.fiuba.algo3.modelo.Views.PantallaDeCreacionDeJugador;
import edu.fiuba.algo3.modelo.Views.ReproductorDeSonidos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage){
        stage.setTitle("AlgoStar V 0.4.2");
        AlgoStar algoStar = new AlgoStar();
        // Creacion de la pantalla principal
        AlgoStarView pantallaPrincipal = new AlgoStarView(stage, algoStar);
        Scene escenaJuego = new Scene(pantallaPrincipal,1620,780);
        // Creacion de las pantallas de creacion de jugadoress
        List<Integer> coloresRemovidos = new ArrayList<Integer>();
        List<Integer> razasRemovidas = new ArrayList<Integer>();
        PantallaDeCreacionDeJugador pantallaInicialDelJugadorZerg = new PantallaDeCreacionDeJugador(stage, escenaJuego, algoStar, pantallaPrincipal, coloresRemovidos, razasRemovidas);
        Scene escenaDeCreacionDelJugadorZerg = new Scene(pantallaInicialDelJugadorZerg, 1620, 780);
        PantallaDeCreacionDeJugador pantallaInicialDelJugadorProtoss = new PantallaDeCreacionDeJugador(stage, escenaDeCreacionDelJugadorZerg, algoStar, pantallaPrincipal, coloresRemovidos, razasRemovidas);
        Scene escenaDeCreacionDelJugadorProtoss = new Scene(pantallaInicialDelJugadorProtoss, 1620, 780);
        // Creacion de la pantalla de bienvenida
        PantallaBienvenida pantallaBienvenida = new PantallaBienvenida(stage, escenaDeCreacionDelJugadorProtoss, algoStar);
        Scene escenaBienvenidos = new Scene(pantallaBienvenida,1280,720);

        stage.setScene(escenaBienvenidos);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}