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

    public int devolverX() {
        return this.x;
    }

    public int devolverY() {
        return this.y;
    }

    public boolean dentroDeCoordenadas(Coordenada dimension) {
        Boolean contenidoDentroDeX = (x >= 0 && x < dimension.devolverX());
        Boolean contenidoDentroDeY = (y >= 0 && y < dimension.devolverY());
        return (contenidoDentroDeX && contenidoDentroDeY);
    }

    // Devuelve una lista con las coordendas adyacentes
    public List<Coordenada> devolverCoordenadasAdyacentes() {
        List<Coordenada> coordendas = new ArrayList<Coordenada>();
        coordendas.add(new Coordenada(x,y-1));
        coordendas.add(new Coordenada(x-1,y));
        coordendas.add(new Coordenada(x+1,y));
        coordendas.add(new Coordenada(x,y+1));
        return coordendas;
    }

    public boolean esIgual(Coordenada coordenada) {
        return (coordenada.devolverX() == x && coordenada.devolverY() == y);
    }

}
