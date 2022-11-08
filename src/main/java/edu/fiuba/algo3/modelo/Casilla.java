package edu.fiuba.algo3.modelo;

public class Casilla {

    private int x,y;
    public Ocupante unidadActual;


    public Casilla(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Casilla(int x, int y,Ocupante o){
        this.x = x;
        this.y = y;
        this.unidadActual = o;
    }

    public Casilla desplazarUno(){
        return new Casilla(x +1, y);
    }

    public void ocupar(Ocupante o){
        unidadActual = o;
    }

    public Ocupante devolverOcupante(){
        return unidadActual;
    }

    public boolean ocupada(){
        return unidadActual != null;
    }

    public boolean devolverCasilla(Object c){
        Casilla e = (Casilla)c;
        return this.x == e.x && this.y == e.y;
    }

}
