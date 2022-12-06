package edu.fiuba.algo3.modelo.recursos;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;

public class GasVespeno extends Recurso {

    public GasVespeno(int unidades) {
        super(unidades);
    }

    public ObjectNode toData() {
        ObjectNode node = Json.createObjectNode();
        node.put("gasVespeno", unidadesDisponibles);
        return node;
    }
    
}
