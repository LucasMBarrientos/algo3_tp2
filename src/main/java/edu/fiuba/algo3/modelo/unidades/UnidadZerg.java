package edu.fiuba.algo3.modelo.unidades;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public abstract class UnidadZerg extends Unidad {


    public abstract boolean ocupar(Terreno terreno);

    public void consumirRecursosParaGenerarse(Inventario inventario){
        inventario.consumirLarva();
        inventario.consumirMinerales(costoEnMinerales);
        inventario.consumirGasVespeno(costoEnGas);
        inventario.consumirSuministro(costoSuministro);
    }

    public void ejecutarDanio(Danio danioTerrestre, Danio danioAereo) {
      if (aerea) {
        if(this.vida.recibirDanio(danioAereo)){
          this.establecerEstado(new UnidadDestruida());
          throw new UnidadEstaDestruida();
        }
      } else {
        if(this.vida.recibirDanio(danioTerrestre)){
          this.establecerEstado(new UnidadDestruida());
          throw new UnidadEstaDestruida();
        }
      }
    }

    public void regenerar(){
      vida.regenerar();
    }

    public ObjectNode toData() {
        ObjectNode node = Json.createObjectNode();
        node.put("nombre", nombre.toData().get("nombre"));
        node.put("coordenada", coordenada.toData());
        node.put("estado", estado.toData().get("estado"));
        node.put("vida", vida.toData().get("vida"));
        node.put("danioTerrestre", danioTerrestre.toData().get("danio"));
        node.put("danioAereo", danioAereo.toData().get("danio"));
        node.put("tiempoDeConstruccion", tiempoConstruccion);
        node.put("unidadAerea", aerea);
        return node;
    }

}
