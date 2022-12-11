package edu.fiuba.algo3.modelo.edificios;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.estados.EdificioDestruido;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public abstract class EdificioProtoss extends Edificio {

    public Escudo escudo;

    public abstract void ocupar(Terreno terreno);

    public Edificio construir(Coordenada coordenada, Inventario inventarioDelJugador) {
        validarCorrelativasDeConstruccion(inventarioDelJugador);
        consumirRecursosParaConstruccion(inventarioDelJugador);

        try {
            Mapa.devolverInstancia().establecerEdificio(coordenada, this);
        }catch(TerrenoNoAptoParaConstruirTalEdificio exception) {
            devolverRecursosParaConstruccion(inventarioDelJugador);
            throw exception;
        }

        return this;
    }


    public void ejecutarDanio(Danio danio) {
        if(this.vida.recibirDanio(new Danio(escudo.recibirDanio(danio) * (-1)))){
            establecerEstado(new EdificioDestruido());
            throw new EdificioEstaDestruido();
        }
    }

    public void desenergizarTerrenos(){}

    @Override
    public void volverNuevamenteOperativo(){
        estadoActual.volverOperativo();
    }

    public void regenerar(){
      escudo.regenerar();
    }

    public ObjectNode toData() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("nombre", nombre.toData().get("nombre"));
        nodo.put("raza", "protoss");
        nodo.put("coordenada", coordenada.toData());
        nodo.put("estado", estadoActual.toData().get("estado"));
        nodo.put("costoEnGasVespeno", costoEnGas.toData().get("gasVespeno"));
        nodo.put("costoEnMinerales", costoEnMinerales.toData().get("mineral"));
        nodo.put("tiempoDeConstruccion", tiempoDeConstruccion);
        nodo.put("vida", vida.toData().get("vida"));
        nodo.put("escudo", escudo.toData().get("escudo"));
        return nodo;
    }

}
