package edu.fiuba.algo3.modelo;

public class Criadero extends Edificio {

    private int larvas;



    Criadero(Casilla ubicacion){

    }

    public Zangano generarZangano(){
        larvas = larvas - 1;
        return new Zangano(ubicacion.desplazarUno());
    }
}
