package edu.fiuba.algo3.modelo.terrenos;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
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
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaTalUnidad;
import edu.fiuba.algo3.modelo.excepciones.TerrenoOcupadoPorUnaUnidad;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.*;

public class TerrenoAereo extends Terreno{

    public TerrenoAereo(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public void ocuparPorEdificio(Pilon pilon){
        throw new TerrenoNoAptoParaConstruirTalEdificio();
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
        throw new TerrenoNoAptoParaConstruirTalEdificio();
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
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(Zealot unidad){
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(Scout unidad){
        verificarTerrenoSinUnidad();
        this.unidad = unidad;
        unidad.establecerCoordenada(this.coordenada);
    }

    public void ocuparPorUnidad(AmoSupremo unidad){
        verificarTerrenoSinUnidad();
        this.unidad = unidad;
        unidad.establecerCoordenada(this.coordenada);
    }

    public void ocuparPorUnidad(Zangano unidad) throws TerrenoNoAptoParaTalUnidad {
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(Zerling unidad){
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(Hidralisco unidad) {
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(Mutalisco unidad) {
        verificarTerrenoSinUnidad();
        this.unidad = unidad;
        unidad.establecerCoordenada(this.coordenada);
    }

    public void ocuparPorUnidad(Guardian unidad) {
        verificarTerrenoSinUnidad();
        this.unidad = unidad;
        unidad.establecerCoordenada(this.coordenada);
    }

    public void ocuparPorUnidad(Devorador unidad) {
        verificarTerrenoSinUnidad();
        this.unidad = unidad;
        unidad.establecerCoordenada(this.coordenada);
    }

    public void vaciarTerreno() { }

    public void energizarTerreno() { }

    public void cubrirTerrenoDeMoho() { }

    @Override
    public String toData() {
        return "Aereo";
    }

    @Override
    public ObjectNode toDataOcupantes() {
        ObjectNode node = Json.createObjectNode();
        ObjectNode node2 = Json.createObjectNode();
        node.put("Ocupante",node2.put("nombre","Desocupado"));
        return node;
    }
}
