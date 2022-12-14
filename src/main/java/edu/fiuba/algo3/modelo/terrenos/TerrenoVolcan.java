package edu.fiuba.algo3.modelo.terrenos;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaTalUnidad;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.*;

public class TerrenoVolcan extends Terreno {

    private Recurso gasVespeno = new GasVespeno(5000);

    public TerrenoVolcan(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public void ocuparPorEdificio(Pilon pilon){
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(Acceso acceso){
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(Asimilador asimilador){
        verificarTerrenoSinEdificio();
        verificarTerrenoSinUnidad();
        edificio = asimilador;
        edificio.establecerPosicion(coordenada);
    }

    public void ocuparPorEdificio(NexoMineral nexoMineral){
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(PuertoEstelar puertoEstelar){
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(Criadero criadero){
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(Espiral espiral){
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(Extractor extractor){
        verificarTerrenoSinEdificio();
        verificarZanganoOcupante();
        establecerEdificio(extractor);
    }

    public void ocuparPorEdificio(Guarida guarida){
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(ReservaDeReproduccion reservaDeReproduccion){
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorUnidad(Dragon unidad){
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(Zealot unidad){
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(Scout unidad){
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(Zangano unidad){
        verificarTerrenoSinEdificio();
        verificarTerrenoSinUnidad();
        establecerUnidad(unidad);
        establecerZanganoOcupante(unidad);
    }

    public void ocuparPorUnidad(Zerling unidad){
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(Hidralisco unidad){
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(Mutalisco unidad){
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(Guardian unidad){
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(Devorador unidad){
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(AmoSupremo unidad){
        throw new TerrenoNoAptoParaTalUnidad();
    }

    @Override
    public void extraerGasVespeno(Recurso recursoRequerido) {
        gasVespeno.gastar(recursoRequerido);
    }

    @Override
    public ObjectNode toData() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("nombre","Volcan");
        nodo.put("coordenada",coordenada.toData());
        return nodo;
    }
    
    @Override
    public ObjectNode toDataOcupantes() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("coordenada", coordenada.toData());
        if(edificio != null){
            nodo.put("Ocupante",edificio.toData());
        }else if (unidad != null){
            nodo.put("Ocupante",unidad.toData());
        }else{
            ObjectNode node2 = Json.createObjectNode();
            nodo.put("Ocupante",node2.put("nombre","Desocupado"));
        }
        return nodo;
    }

}
