package edu.fiuba.algo3.modelo.edificios;

import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.edificios.estados.EdificioDestruido;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public abstract class EdificioZerg extends Edificio {

    public abstract void ocupar(Terreno terreno);

    public void establecerTerreno(Terreno terreno) {
        this.terreno = terreno;
    }

    public void ejecutarDanio(Danio danio) {
        if (this.vida.recibirDanio(danio)) {
            this.establecerEstado(new EdificioDestruido());
            throw new EdificioEstaDestruido();
        }
    }

    public void regenerar(){
        vida.regenerar();
    }

    public ObjectNode toData() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("nombre", nombre.toData().get("nombre"));
        nodo.put("coordenada", coordenada.toData());
        nodo.put("estado", estadoActual.toData().get("estado"));
        nodo.put("costoEnGasVespeno", costoEnGas.toData().get("gasVespeno"));
        nodo.put("costoEnMinerales", costoEnMinerales.toData().get("mineral"));
        nodo.put("tiempoDeConstruccion", tiempoDeConstruccion);
        nodo.put("vida", vida.toData().get("vida"));
        return nodo;
    }

}
