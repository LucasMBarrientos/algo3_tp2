package edu.fiuba.algo3.modelo.jugadores;

import java.util.Objects;

public class Nombre {
    private String nombre;

    public Nombre(String nombre){
        this.nombre = nombre;
    }

    boolean esIgual(Nombre nombre){
        return (Objects.equals(this.nombre, nombre.devolverNombre()));
    }

    private String devolverNombre(){
        return nombre;
    }
}
