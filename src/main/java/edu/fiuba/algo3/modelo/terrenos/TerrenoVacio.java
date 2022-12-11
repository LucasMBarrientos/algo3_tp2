package edu.fiuba.algo3.modelo.terrenos;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.*;

public class TerrenoVacio implements EstadoTerreno {

    private TerrenoBase terreno;

    public TerrenoVacio(TerrenoBase terreno){
        this.terreno = terreno;
    }

    public void ocuparPorEdificio(Pilon pilon){
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarTerrenoSinUnidad();
        terreno.establecerEdificio(pilon);
    }

    public void ocuparPorEdificio(Acceso acceso){
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(Asimilador asimilador){
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(NexoMineral nexoMineral){
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(PuertoEstelar puertoEstelar){
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(Criadero criadero){
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarZanganoOcupante();
        terreno.establecerEdificio(criadero);
    }

    public void ocuparPorEdificio(Espiral espiral){
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(Extractor extractor){
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(Guarida guarida){
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(ReservaDeReproduccion reservaDeReproduccion){
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }


    public void ocuparPorUnidad(Dragon unidad){
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarTerrenoSinUnidad();
        terreno.establecerUnidad(unidad);
    }

    public void ocuparPorUnidad(Zealot unidad){
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarTerrenoSinUnidad();
        terreno.establecerUnidad(unidad);
    }

    public void ocuparPorUnidad(Scout unidad){
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarTerrenoSinUnidad();
        terreno.establecerUnidad(unidad);
    }

    public void ocuparPorUnidad(Zangano unidad){
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarTerrenoSinUnidad();
        terreno.establecerUnidad(unidad);
        terreno.establecerZanganoOcupante(unidad);
    }

    public void ocuparPorUnidad(Zerling unidad){
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarTerrenoSinUnidad();
        terreno.establecerUnidad(unidad);
    }

    public void ocuparPorUnidad(Hidralisco unidad) {
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarTerrenoSinUnidad();
        terreno.establecerUnidad(unidad);
    }

    public void ocuparPorUnidad(Mutalisco unidad) {
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarTerrenoSinUnidad();
        terreno.establecerUnidad(unidad);
    }
    
    public void ocuparPorUnidad(Guardian unidad) {
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarTerrenoSinUnidad();
        terreno.establecerUnidad(unidad);
    }

    public void ocuparPorUnidad(Devorador unidad) {
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarTerrenoSinUnidad();
        terreno.establecerUnidad(unidad);
    }

    public void ocuparPorUnidad(AmoSupremo unidad) {
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarTerrenoSinUnidad();
        terreno.establecerUnidad(unidad);
    }

    public void cubrirTerrenoDeMoho() {
        if(terreno.edificio == null){
            terreno.establecerEstado(new TerrenoMoho(terreno));
        }
    }

    @Override
    public ObjectNode toData() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("nombre","Vacio");
        nodo.put("coordenada",terreno.coordenada.toData());
        return nodo;
    }

    @Override
    public ObjectNode toDataOcupantes() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("coordenada",terreno.coordenada.toData());
        if(terreno.edificio != null){
            nodo.put("Ocupante",terreno.edificio.toData());
        }else if (terreno.unidad != null){
            nodo.put("Ocupante",terreno.unidad.toData());
        }else{
            ObjectNode node2 = Json.createObjectNode();
            nodo.put("Ocupante",node2.put("nombre","Desocupado"));
        }
        return nodo;
    }

    public void energizarTerreno() {
        terreno.habilitarEdificioOcupante();
        terreno.establecerEstado(new TerrenoEnergizado(terreno));
    }

    public void desenergizarTerreno() {
        return;
    }


}
