package edu.fiuba.algo3;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.PantallaBienvenida;
import edu.fiuba.algo3.modelo.Views.PantallaDeCreacionDeJugador;
import edu.fiuba.algo3.modelo.Views.ReproductorDeSonidos;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
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

        List<Integer> coloresRemovidos = new ArrayList<Integer>();;
        List<Integer> razasRemovidas = new ArrayList<Integer>();

        // Creacion de las pantallas de creacion de jugadoress
        PantallaDeCreacionDeJugador pantallaInicialDelJugadorZerg = new PantallaDeCreacionDeJugador(stage, escenaJuego, algoStar, pantallaPrincipal, coloresRemovidos, razasRemovidas);
    //pantallaInicialDelJugadorZerg.getChildren().addAll(imgView);
        Scene escenaDeCreacionDelJugadorZerg = new Scene(pantallaInicialDelJugadorZerg, 1620, 780);
    //ImageView imgView = new ImageView("/descarga.png");
        PantallaDeCreacionDeJugador pantallaInicialDelJugadorProtoss = new PantallaDeCreacionDeJugador(stage, escenaDeCreacionDelJugadorZerg, algoStar, pantallaPrincipal, coloresRemovidos, razasRemovidas);
    //pantallaInicialDelJugadorProtoss.getChildren().addAll(imgView);
        Scene escenaDeCreacionDelJugadorProtoss = new Scene(pantallaInicialDelJugadorProtoss, 1620, 780);


        // Creacion de la pantalla de bienvenida
        PantallaBienvenida pantallaBienvenida = new PantallaBienvenida(stage, escenaDeCreacionDelJugadorProtoss, algoStar);
        Scene escenaBienvenidos = new Scene(pantallaBienvenida,1280,720);


      /*

        StackPane root = new StackPane();
        root.getChildren().add(imgView);
        Scene es = new Scene(root,1620,780);

      * */

        // Cargar la imagen crear objeto ImageView
        //Image img = new Image(getClass().getResourceAsStream("/iconozerg.png"));

        // Añadir el ImageView al panel principal de la pantalla


        // DEBUG_ code for debug purposes only
        boolean DEBUG_MODE = false;
        if (DEBUG_MODE) {




            algoStar.empezarJuego();
            pantallaPrincipal.actualizarMapa();
            stage.setScene(escenaJuego);

            ReproductorDeSonidos reproductorDeSonidos = new ReproductorDeSonidos();
            reproductorDeSonidos.reproducirSonido("/bg.mp3");
            stage.show();
            return;
        }
        // End of DEBUG_ code for debug purposes only


        stage.setScene(escenaBienvenidos);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}