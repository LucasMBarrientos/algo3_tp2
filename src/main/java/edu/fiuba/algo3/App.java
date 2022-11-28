package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Views.AlgoStarView;
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
        new AlgoStarView(stage);
    }
    public static void main(String[] args) {
        launch();
    }

}