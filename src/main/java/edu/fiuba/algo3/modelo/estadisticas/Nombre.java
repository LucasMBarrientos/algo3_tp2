package edu.fiuba.algo3.modelo.estadisticas;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;

import java.util.Objects;

public class Nombre {
    
    private String nombre;

    public Nombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean esIgual(Nombre nombre) {
        return (Objects.equals(this.nombre, nombre.devolverValor()));
    }

    public String devolverValor() {
        return nombre;
    }

    public ObjectNode toData() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("nombre",nombre);
        return nodo;
    }

}
