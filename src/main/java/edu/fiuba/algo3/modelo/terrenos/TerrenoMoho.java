package edu.fiuba.algo3.modelo.terrenos;

import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.fiuba.algo3.modelo.edificios.protoss.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.edificios.zerg.Guarida;
import edu.fiuba.algo3.modelo.edificios.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaTalUnidad;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.*;

import java.util.List;

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
        terreno.verificarTerrenoSinUnidad();
        terreno.establecerEdificio(criadero);
    }
    public void ocuparPorEdificio(Espiral espiral) {
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarTerrenoSinUnidad();
        terreno.establecerEdificio(espiral);
    }

    public void ocuparPorEdificio(Extractor extractor) {
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(Guarida guarida) {
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarTerrenoSinUnidad();
        terreno.establecerEdificio(guarida);
    }

    public void ocuparPorEdificio(ReservaDeReproduccion reservaDeReproduccion) {
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarTerrenoSinUnidad();
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
  
    public boolean tieneMoho() {
        return true;
    }

}