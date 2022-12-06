package edu.fiuba.algo3.modelo.unidades;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

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
        ObjectNode node = Json.createObjectNode();
        node.put("nombre", nombre.toData());
        node.put("coordenada", coordenada.toData());
        node.put("estado", estado.toData());
        node.put("vida", vida.toData());
        node.put("escudo", escudo.toData());
        node.put("danioTerrestre", danioTerrestre.toData());
        node.put("danioAereo", danioAereo.toData());
        node.put("tiempoDeConstruccion", tiempoConstruccion);
        node.put("unidadAerea", aerea);
        return node;
    }
}
