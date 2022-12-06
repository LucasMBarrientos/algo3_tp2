package edu.fiuba.algo3.modelo.unidades;

import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.estados.UnidadDestruida;

public abstract class UnidadProtoss extends Unidad {

    protected Escudo escudo;
    
    public Escudo devolverEscudo() {
        return escudo;
    }

    public abstract boolean ocupar(Terreno terreno);

    public void consumirRecursosParaGenerarse(Inventario inventario){
        inventario.consumirMinerales(costoEnMinerales);
        inventario.consumirGasVespeno(costoEnGas);
        inventario.consumirSuministro(costoSuministro);
    }

    public void ejecutarDanio(Danio danioTerrestre, Danio danioAereo) {
      if (aerea) {
        if(this.vida.recibirDanio(new Danio(escudo.recibirDanio(danioAereo) * (-1)))){
          this.establecerEstado(new UnidadDestruida());
          throw new UnidadEstaDestruida();
        }
      } else {
        if(this.vida.recibirDanio(new Danio(escudo.recibirDanio(danioTerrestre) * (-1)))){
          this.establecerEstado(new UnidadDestruida());
            throw new UnidadEstaDestruida();
        }
      }
    }

    public void regenerar(){
      escudo.regenerar();
    }

    public ObjectNode toData() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("nombre", nombre.toData().get("nombre"));
        nodo.put("raza", "protoss");
        nodo.put("coordenada", coordenada.toData());
        nodo.put("estado", estado.toData().get("estado"));
        nodo.put("vida", vida.toData().get("vida"));
        nodo.put("escudo", vida.toData().get("escudo"));
        nodo.put("danioTerrestre", danioTerrestre.toData().get("danio"));
        nodo.put("danioAereo", danioAereo.toData().get("danio"));
        nodo.put("tiempoDeConstruccion", tiempoConstruccion);
        nodo.put("unidadAerea", aerea);
        return nodo;
    }
}
