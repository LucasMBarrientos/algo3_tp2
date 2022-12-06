package edu.fiuba.algo3.modelo.recursos;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;

public class Suministro extends Recurso {

    protected int unidadesMaxima;

    public Suministro(int unidades) {
      super(unidades);
      this.unidadesMaxima = 200;
    }

    public void agregarUnidades(Recurso recurso){
        this.unidadesDisponibles = Math.min(this.unidadesMaxima, this.unidadesDisponibles + recurso.unidadesDisponibles);
    }

    public ObjectNode toData() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("suministro", unidadesDisponibles);
        return nodo;
    }

}