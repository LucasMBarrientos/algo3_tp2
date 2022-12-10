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

public class TerrenoMoho implements EstadoTerreno {
        
    private TerrenoBase terreno;

    public TerrenoMoho(TerrenoBase terreno) {
        this.terreno = terreno;
    }

    public void ocuparPorEdificio(Pilon pilon) {
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(Acceso acceso) {
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(Asimilador asimilador) {
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(NexoMineral nexoMineral) {
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(PuertoEstelar puertoEstelar) {
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(Criadero criadero) {
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarZanganoOcupante();
        terreno.establecerEdificio(criadero);
    }
    public void ocuparPorEdificio(Espiral espiral) {
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarZanganoOcupante();
        terreno.establecerEdificio(espiral);
    }

    public void ocuparPorEdificio(Extractor extractor) {
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(Guarida guarida) {
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarZanganoOcupante();
        terreno.establecerEdificio(guarida);
    }

    public void ocuparPorEdificio(ReservaDeReproduccion reservaDeReproduccion) {
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarZanganoOcupante();
        terreno.establecerEdificio(reservaDeReproduccion);
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
        return;
    }

    @Override
    public ObjectNode toData() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("nombre","Moho");
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
        return;
    }

    public void desenergizarTerreno() {
        return;
    }


}