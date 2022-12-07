package edu.fiuba.algo3.modelo.unidades.modificadores;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.estados.UnidadDestruida;

public class Visible implements Visibilidad {

    public void ejecutarDanio(Danio danioTerrestre, Vida vida, Escudo escudo, Unidad unidad) {
        if (vida.recibirDanio(new Danio(escudo.recibirDanio(danioTerrestre) * (-1)))) {
            unidad.establecerEstado(new UnidadDestruida());
            throw new UnidadEstaDestruida();
        }
    }

    public ObjectNode toData() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("visibilidad", "visible" );
        return nodo;
    }

}
