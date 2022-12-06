package edu.fiuba.algo3.modelo.Views.eventos.botoneras;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Views.AlgoStarView;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonGenerarDragonHandler;
import edu.fiuba.algo3.modelo.Views.eventos.accionesJugador.BotonGenerarZealotHandler;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BotoneraAcceso extends HBox {
    public BotoneraAcceso(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){
        List<VBox> buttons = crearBotones(algoStar, algoStarView, coordenada);
        
        HBox contenedorHorizontal = new HBox();
        contenedorHorizontal.getChildren().clear();
        contenedorHorizontal.getChildren().addAll(buttons);
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(25));
        algoStarView.setBottom(contenedorHorizontal);
    }

    private List<VBox> crearBotones(AlgoStar algoStar, AlgoStarView algoStarView, Coordenada coordenada){
                
        Button generarDragon = new Button();
        generarDragon.setText("generar Dragon");
        Label costoGasDragon = new Label("COSTO GAS: 50");
        Label costoMineralDragon  = new Label("COSTO MINERAL: 125");
        Label costoSuministroDragon  = new Label("COSTO Suministro: 3");
        VBox generarDragonbox = new VBox(costoGasDragon,costoMineralDragon,costoSuministroDragon,generarDragon);

        Button generarZealot = new Button();
        generarZealot.setText("generar Zealot");
        Label costoGasZealot = new Label("COSTO GAS: 0");
        Label costoMineralZealot  = new Label("COSTO MINERAL: 100");
        Label costoSuministroZealot  = new Label("COSTO Suministro: 2");
        VBox generarZealotbox = new VBox(costoGasZealot,costoMineralZealot,costoSuministroZealot,generarDragon);


        BotonGenerarZealotHandler botonGenerarZealotHandler = new BotonGenerarZealotHandler(algoStar, algoStarView, coordenada);
        generarZealot.setOnAction(botonGenerarZealotHandler);
        BotonGenerarDragonHandler botonGenerarDragonHandler = new BotonGenerarDragonHandler(algoStar, algoStarView, coordenada);
        generarDragon.setOnAction(botonGenerarDragonHandler);

        List<VBox> botones = new ArrayList<>();
        botones.add(generarDragonbox);
        botones.add(generarZealotbox);

        return botones;
    }
}
