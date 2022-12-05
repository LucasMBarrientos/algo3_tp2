package edu.fiuba.algo3.modelo.edificios.protoss.nexoMineral;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoConoceEstaUnidad;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMineral;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

public class NexoMineral extends EdificioProtoss {

    public NexoMineral(){
        this.costoEnMinerales = new Mineral(50);
        this.costoEnGas = new GasVespeno(0);
        this.tiempoDeConstruccion = 4;
        this.vida = new Vida(300);
        this.escudo = new Escudo(300);
        this.nombre = new Nombre("NexoMineral");
        establecerEstado(this.estadoConstruccion);
    }

    public void ocupar(Terreno terreno){
        terreno.ocuparPorEdificio(this);
        this.terreno= terreno;
    }

    /*public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Mineral mineral, Coordenada coordenada) {
        return null;
    }*/
    @Override
    public ObjectNode toData() {
        ObjectNode node = Json.createObjectNode();
        node.put("nombre","Nexo");
        return node;
    }
    public Unidad generarUnidad(Scout unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Zealot unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Dragon unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Zerling unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Zangano unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Hidralisco unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Mutalisco unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }

    public void extraerRecursos(Inventario inventario) {
      inventario.agregarMinerales(terreno.extraerMinerales(new Mineral(10)));
    }

    public void validarCorrelativasDeConstruccion(Inventario inventario){

    }

    @Override
    public void actualizarEdificio(Inventario inventario) {
      regenerar();
      extraerRecursos(inventario);
    }
}
