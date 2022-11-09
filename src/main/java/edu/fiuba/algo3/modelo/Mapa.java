package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Mapa {

    private List<Casilla> casillas = new ArrayList<Casilla>();

    public Mapa(int dimensionX, int dimensionY) {
        for (int x = 0; x < dimensionX; x++){
            for (int y = 0; y < dimensionY; y++){
                this.casillas.add(new Casilla(x,y));
            }
        }
    }
    
    public boolean validarCasillaDeUnGenerador(Casilla casilla) {
        return (casilla.devolverOcupante() instanceof GeneraUnidades); // ???????
    }

    public Casilla buscarCasilla(int x, int y) {
        Casilla casillaBuscada = new Casilla(x,y);
        for(Casilla casilla : this.casillas) {
           if(casilla.compararUbicaciones(casillaBuscada)){
               return casilla;
           }
        }
        return casillaBuscada;
    }

    public Casilla hallarCasillaAdyacenteDesocupada(Casilla casillaCentral) {
        int x = casillaCentral.devolverX() - 1;
        int y = casillaCentral.devolverY() - 1;
        Casilla casillaPosible;
        for (int i = 0; i < 9; i++) {
            casillaPosible = new Casilla(x,y);
            for (Casilla casilla : casillas) {
                if (casillaPosible.compararUbicaciones(casilla)) {
                    // Encontre la casilla del mapa en la misma posicion que casillaPosible
                    if (!casilla.ocupada()) {
                        return casilla;
                    }
                }
            }
            x++;
            if (x == casillaCentral.devolverX() + 1) {
                x -= 2;
                y++;
            }
        }
        return null;

    }

    public void actualizar() {
        for (Casilla casilla : casillas){
            if(casilla.ocupada()){
                casilla.devolverOcupante().actualizar();
            }
        }
    }
}
