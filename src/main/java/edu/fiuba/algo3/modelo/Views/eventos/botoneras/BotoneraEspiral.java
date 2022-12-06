package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonGenerarMutaliscoHandler;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BotoneraEspiral extends HBox {

    public BotoneraEspiral(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){
      HBox contenedorHorizontal = new HBox();  
      List<VBox> buttons = crearBotones(algoStar, algoStarView, coordenada);
      
      Label coordenadaX = new Label("CORDENADA X: " + coordenada.toData().get("x"));
      Label coordenadaY  = new Label("CORDENADA Y: "  + coordenada.toData().get("y"));
      VBox coordenadaBox = new VBox(coordenadaX,coordenadaY);
      
      contenedorHorizontal.getChildren().clear();
      contenedorHorizontal.getChildren().add(coordenadaBox);
      contenedorHorizontal.getChildren().addAll(buttons);
      contenedorHorizontal.setSpacing(10);
      contenedorHorizontal.setPadding(new Insets(25));
      algoStarView.setBottom(contenedorHorizontal);
    }

    private List<VBox> crearBotones(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){

        Button generarMutalisco = new Button();
        generarMutalisco.setText("generar Mutalisco");
        Label costoGasMutalisco = new Label("COSTO GAS: 100");
        Label costoMineralMutalisco  = new Label("COSTO MINERAL: 100");
        Label costoSuministroMutalisco  = new Label("COSTO Suministro: 4");
        VBox generarMutaliscobox = new VBox(costoGasMutalisco,costoMineralMutalisco,costoSuministroMutalisco,generarMutalisco);

        BotonGenerarMutaliscoHandler botonGenerarMutaliscoHandler = new BotonGenerarMutaliscoHandler(algoStar, algoStarView, coordenada);
        generarMutalisco.setOnAction(botonGenerarMutaliscoHandler);

        List<VBox> botones = new ArrayList<>();
        botones.add(generarMutaliscobox);

        return botones;
    }
}
