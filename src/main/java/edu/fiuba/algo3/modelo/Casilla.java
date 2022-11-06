package edu.fiuba.algo3.modelo;

public class Casilla {

    private int x,y;


    Casilla(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Casilla desplazarUno(){
        return new Casilla(x +1, y);
    }

    @Override
    public boolean equals(Object c){
        Casilla e = (Casilla)c;
        return this.x == e.x && this.y == e.y;
    }

}
