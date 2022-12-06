package edu.fiuba.algo3.modelo;

import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Objects;

public class Nombre {
    
    private String nombre;

    public Nombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean esIgual(Nombre nombre) {
        return (Objects.equals(this.nombre, nombre.devolverNombre()));
    }

    private String devolverNombre() {
        return nombre;
    }

    public ObjectNode toData() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("nombre",nombre);
        return nodo;
    }

}
