package edu.fiuba.algo3.modelo;

public class JugadorProtoss extends Jugador {
    
    public JugadorProtoss(Mapa mapa) {
        this.establecerMapa(mapa);
    }

    public Casilla generarUnidad(Casilla casilla) {
        return casilla;
    }

    public void construirEdificio(int x, int y, Edificio edificio) {
        
    }

}
