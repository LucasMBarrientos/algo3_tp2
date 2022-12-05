package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.PantallaBienvenida;

import edu.fiuba.algo3.modelo.Views.PantallaInicial;
import edu.fiuba.algo3.modelo.Views.PantallaInicial2;
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

        AlgoStarView pantallaPrincipal = new AlgoStarView(stage, algoStar);
        Scene escenaJuego = new Scene(pantallaPrincipal,1620,780);

        PantallaInicial2 pantallaInicial2 = new PantallaInicial2(stage,escenaJuego, algoStar);
        //pantallaInicial.getChildren().addAll(imgView);
        Scene escenaMenu2 = new Scene(pantallaInicial2,1620,780);


      //  ImageView imgView = new ImageView("/descarga.png");
        PantallaInicial pantallaInicial = new PantallaInicial(stage,escenaMenu2, algoStar);
        //pantallaInicial.getChildren().addAll(imgView);
        Scene escenaMenu = new Scene(pantallaInicial,1620,780);



        PantallaBienvenida pantallaBienvenida = new PantallaBienvenida (stage,escenaMenu, algoStar);
        Scene escenaBienvenidos = new Scene(pantallaBienvenida,1280,720);
      /*
      *
      *

        StackPane root = new StackPane();
        root.getChildren().add(imgView);
        Scene es = new Scene(root,1620,780);

      * */

        // Cargar la imagen crear objeto ImageView
        //Image img = new Image(getClass().getResourceAsStream("/iconozerg.png"));

        // Añadir el ImageView al panel principal de la pantalla

        stage.setScene(escenaBienvenidos);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}