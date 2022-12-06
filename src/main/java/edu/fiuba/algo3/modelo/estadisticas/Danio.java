package edu.fiuba.algo3.modelo.estadisticas;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.excepciones.AtaqueImposibleDeRealizarse;

public class Danio {

    private int poder;

    public Danio(int poder) {
        this.poder = poder;
    }

    public int aplicarDanio(int estadistica) {
        return estadistica - this.poder;
    }

    public ObjectNode toData() {
        ObjectNode node = Json.createObjectNode();
        node.put("danio", poder);
        return node;
    }

}
