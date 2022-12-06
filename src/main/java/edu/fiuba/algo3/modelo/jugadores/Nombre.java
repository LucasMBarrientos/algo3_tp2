package edu.fiuba.algo3.modelo.jugadores;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;

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
        ObjectNode node = Json.createObjectNode();
        node.put("nombre",nombre);
        return node;
    }

}
