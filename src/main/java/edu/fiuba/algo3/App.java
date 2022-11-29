package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.PantallaInicial;
import edu.fiuba.algo3.modelo.Views.eventos.BotonEntrarEventHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {


    @Override
    public void start(Stage stage){
        stage.setTitle("AlgoStar V 0.4.2");

        AlgoStar algoStar = new AlgoStar();

        AlgoStarView pantallaPrincipal = new AlgoStarView(stage, algoStar);
        Scene escenaJuego = new Scene(pantallaPrincipal,1620,780);


        PantallaInicial pantallaInicial = new PantallaInicial(stage,escenaJuego, algoStar);
        Scene escenaBienvenidos = new Scene(pantallaInicial,1620,780);

        stage.setScene(escenaBienvenidos);
        stage.show();


    }
    public static void main(String[] args) {
        launch();
    }

}