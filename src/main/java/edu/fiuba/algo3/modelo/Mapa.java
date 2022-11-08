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
        return (casilla instanceof GeneraUnidades);
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

    public boolean compararUbicaciones(Casilla c1, Casilla c2){
        return c1.compararUbicaciones(c2);
    }

    public Casilla obtenerAdyacenteDisponible(Casilla c){
        for (int i = 0; i< casillas.size(); i++){
            if(compararUbicaciones(c,casillas.get(i))){ //resolver esto
                return casillas.get(i+1);
            }
        }
        return c;
    }

    public void actualizar(){
        for (Casilla c : casillas){
            if(c.ocupada()){
                c.devolverOcupante().actualizar();
            }
        }
    }
}
