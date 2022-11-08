package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
    private List<Casilla> casillas = new ArrayList<Casilla>();
    public Mapa(){
        for (int i = 0; i< 10; i++){
            for (int j = 0; j< 10; j++){
                casillas.add(new Casilla(i,j));
            }
        }
    }

    public Casilla esLaMismaCasilla(Casilla c){
        for(Casilla casilla : casillas) {
           if(casilla.devolverCasilla(c)){
               return casilla;
           }
        }
        return c;
    }

    public boolean compararUbicaciones(Casilla c1, Casilla c2){
        return c1.devolverCasilla(c2);
    }

    public Casilla obtenerAdyacenteDisponible(Casilla c){
        for (int i = 0; i< casillas.size(); i++){
            if(compararUbicaciones(c,casillas.get(i))){ //resolver esto
                return casillas.get(i+1);
            }
        }
        return c;
    }
}
