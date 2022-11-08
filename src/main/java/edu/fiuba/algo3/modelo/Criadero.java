package edu.fiuba.algo3.modelo;

public class Criadero extends Edificio implements generadorUnidades{

    private int larvas = 3;



    public Criadero(){

    }

    public int getLarvas(){
        return larvas;
    }

    public void generarUnidad(Casilla c){
        larvas = larvas - 1;
        c.ocupar(new Zangano());
    }
}
