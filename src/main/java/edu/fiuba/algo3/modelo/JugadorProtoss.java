package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;

import java.util.ArrayList;
import java.util.List;

public class JugadorProtoss extends Jugador {


    public JugadorProtoss(Mapa mapa) {
        Pilon pilonInicial = new Pilon();
        mapa.buscarCasilla(9,9).establecerEdificio(pilonInicial);
        mapa.generarEnergizadosIniciales();
        this.establecerMapa(mapa);
    }

    public Casilla generarUnidad(Casilla casilla) {
        return casilla;
    }

    public void construirEdificio(int x, int y, Edificio edificio) {
        
    }

}
