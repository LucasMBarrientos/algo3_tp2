package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Coordenada {

    private int x;
    private int y;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean completamenteMayorA(Coordenada coordenada) {
        return (!compararX(coordenada) && !compararY(coordenada));
    }

    public boolean completamenteMenorA(Coordenada coordenada) { // retorna true si esta coordenada es menor en xy que la pasado por parametro
        return (compararX(coordenada) && compararY(coordenada));
    }

    public boolean compararX(Coordenada coordenada) { // retorna true si esta coordenada es mayor en x que la pasado por parametro
        return (this.x >= coordenada.devolverX());
    }

    public boolean compararY(Coordenada coordenada) {
        return (this.y >= coordenada.devolverY()); // retorna true si esta coordenada es mayor en y que la pasado por parametro
    }

    public int devolverX() {
        return this.x;
    }

    public int devolverY() {
        return this.y;
    }

    /* 
    public boolean dentroDeCoordenadas(Coordenada dimension) {
        Boolean contenidoDentroDeX = (x >= 0 && x < dimension.devolverX());
        Boolean contenidoDentroDeY = (y >= 0 && y < dimension.devolverY());
        return (contenidoDentroDeX && contenidoDentroDeY);
    }
    */

    // Devuelve una lista con las coordendas adyacentes
    public List<Coordenada> hallarCoordenadasAdyacentes() {
        List<Coordenada> coordendas = new ArrayList<Coordenada>();
        coordendas.add(new Coordenada(x,y-1));
        coordendas.add(new Coordenada(x-1,y));
        coordendas.add(new Coordenada(x+1,y));
        coordendas.add(new Coordenada(x,y+1));
        return coordendas;
    }

    public List<Coordenada> hallarCoordenadasAdyacentes(Coordenada coordenadaCentral, int radio) {
        List<Coordenada> coordenadasAdyacentesTotales = new ArrayList<Coordenada>();
        coordenadasAdyacentesTotales.addAll(this.hallarCoordenadasAdyacentes());
        List<Coordenada> nuevasCoordenadasAdyacentes = new ArrayList<Coordenada>();
        for (int i = 0; i < radio - 1; i++) {
            for (Coordenada coordenada : coordenadasAdyacentesTotales) {
                nuevasCoordenadasAdyacentes.addAll(coordenada.hallarCoordenadasAdyacentes());
            }
            coordenadasAdyacentesTotales.addAll(nuevasCoordenadasAdyacentes);
        }
        return coordenadasAdyacentesTotales;
    }

    public Coordenada devolverCoordenadaRelativa(int distanciaX, int distanciaY) {
        return new Coordenada(this.x + distanciaX, this.y + distanciaY);
    }

    public boolean noSeInterpolaConCoordenadas(List<Coordenada> coordenadas) {
        boolean noSeInterpola = true;
        for (Coordenada coordenada : coordenadas) {
            if (this.esIgual(coordenada))  {
                noSeInterpola = false;
            }
        }
        return noSeInterpola;
    }


    public boolean esIgual(Coordenada coordenada) {
        return (coordenada.devolverX() == x && coordenada.devolverY() == y);
    }

}
