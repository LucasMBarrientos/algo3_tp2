package edu.fiuba.algo3.modelo.recursos;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;

public class Mineral extends Recurso {

    public Mineral(int unidades) {
        super(unidades);
    }

    public ObjectNode toData() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("mineral", unidadesDisponibles);
        return nodo;
    }

}
