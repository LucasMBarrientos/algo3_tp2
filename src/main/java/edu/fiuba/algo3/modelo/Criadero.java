package edu.fiuba.algo3.modelo;

public class Criadero extends Edificio implements generadorUnidades{

    private int larvas = 3;



    public Criadero(){

    }
    public void actualizar(){
        if(larvas < 3){
            larvas = larvas + 1;
        }
    }

    public int getLarvas(){
        return larvas;
    }

    public void generarUnidad(Casilla c){
        if(larvas > 0){
            larvas = larvas - 1;
            c.ocupar(new Zangano());
        }
    }

    public int larvasDisponibles(){
        return larvas;
    }
}
