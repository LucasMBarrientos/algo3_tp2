package edu.fiuba.algo3.modelo.edificios;

import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.estados.EdificioDestruido;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.excepciones.NoHayUnZanganoEnEsaCoordenada;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public abstract class EdificioZerg extends Edificio {

    public Edificio construir(Coordenada coordenada, Inventario inventarioDelJugador) {
        validarCorrelativasDeConstruccion(inventarioDelJugador);
        consumirRecursosParaConstruccion(inventarioDelJugador);

        try {
            Mapa.devolverInstancia().establecerEdificio(coordenada, this);
        }catch(TerrenoNoAptoParaConstruirTalEdificio | NoHayUnZanganoEnEsaCoordenada exception) {
            devolverRecursosParaConstruccion(inventarioDelJugador);
            throw exception;
        }

        inventarioDelJugador.eliminarUnidad(coordenada); //elimino al zangano que construyo el edificio
        return this;
    }

    public abstract void ocupar(Terreno terreno);

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
        nodo.put("raza", "zerg");
        nodo.put("coordenada", coordenada.toData());
        nodo.put("estado", estadoActual.toData().get("estado"));
        nodo.put("costoEnGasVespeno", costoEnGas.toData().get("gasVespeno"));
        nodo.put("costoEnMinerales", costoEnMinerales.toData().get("mineral"));
        nodo.put("tiempoDeConstruccion", tiempoDeConstruccion);
        nodo.put("vida", vida.toData().get("vida"));
        return nodo;
    }

}
