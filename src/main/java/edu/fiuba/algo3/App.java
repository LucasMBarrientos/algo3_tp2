package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.PantallaInicial;
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

        AlgoStarView pantallaPrincipal = new AlgoStarView(stage);
        Scene escenaJuego = new Scene(pantallaPrincipal,1620,780);

        PantallaInicial pantallaInicial = new PantallaInicial(stage,escenaJuego);
        Scene escenaBienvenidos = new Scene(pantallaInicial,1620,780);

        stage.setScene(escenaBienvenidos);
        stage.show();


    }
    public static void main(String[] args) {
        launch();
    }

}