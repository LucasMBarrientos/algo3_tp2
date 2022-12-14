package edu.fiuba.algo3.modelo.estadisticas;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;

public class Danio {

    private int poder;

    public Danio(int poder) {
        this.poder = poder;
    }

    public int aplicarDanio(int estadistica) {
        return estadistica - this.poder;
    }

    public ObjectNode toData() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("danio", poder);
        return nodo;
    }

}
