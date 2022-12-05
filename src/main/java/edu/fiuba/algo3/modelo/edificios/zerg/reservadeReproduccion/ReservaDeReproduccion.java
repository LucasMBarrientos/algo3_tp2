package edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoConoceEstaUnidad;
import edu.fiuba.algo3.modelo.excepciones.NoHayLarvasSuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

public class ReservaDeReproduccion extends EdificioZerg {
    Terreno terreno;

    public ReservaDeReproduccion() {
        this.costoEnMinerales = new Mineral(150);
        this.costoEnGas = new GasVespeno(0);
        this.vida = new Vida(1000);
        this.tiempoDeConstruccion = 12;
        this.nombre = new Nombre("ReservaDeReproduccion");
        establecerEstado(this.estadoConstruccion);
    }

    public void ocupar(Terreno terreno){
        terreno.ocuparPorEdificio(this);
    }

    public void validarCorrelativasDeConstruccion(Inventario inventario) { }
    @Override
    public ObjectNode toData() {
        ObjectNode node = Json.createObjectNode();
        node.put("nombre","Reserva");
        return node;
    }
    public Unidad generarUnidad(Zerling unidad,Inventario inventario){
        return estadoActual.generarUnidad(unidad,inventario);
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
    public Unidad generarUnidad(Scout unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Zealot unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Dragon unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }

    @Override
    public void actualizarEdificio(Inventario inventario) {
      regenerar();
    }

}
