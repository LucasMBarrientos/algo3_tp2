package edu.fiuba.algo3.modelo.terrenos;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.acceso.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.asimilador.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.nexoMineral.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.protoss.puertoEstelar.PuertoEstelar;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.espiral.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.extractor.Extractor;
import edu.fiuba.algo3.modelo.edificios.zerg.guarida.Guarida;
import edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaTalUnidad;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.*;

public class TerrenoMineral extends Terreno {
    private Recurso mineral = new Mineral(2000);

    public TerrenoMineral(Coordenada coordenada) {
        this.coordenada = coordenada;
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
        verificarTerrenoSinEdificio();
        verificarTerrenoSinUnidad();
        this.edificio = nexoMineral;
    }

    public void ocuparPorEdificio(PuertoEstelar puertoEstelar) {
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(Criadero criadero) {
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(Espiral espiral) {
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(Extractor extractor) {
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(Guarida guarida) {
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(ReservaDeReproduccion reservaDeReproduccion) {
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorUnidad(Dragon unidad) {
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(Zealot unidad) {
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(Scout unidad) {
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(Zangano unidad) {
        verificarTerrenoSinUnidad();
        verificarTerrenoSinEdificio();
        this.unidad = unidad;
        unidad.establecerCoordenada(this.coordenada);
    } 

    public void ocuparPorUnidad(Zerling unidad) {
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(Hidralisco unidad) {
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(Mutalisco unidad) {
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(Guardian unidad) {
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(Devorador unidad) {
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void ocuparPorUnidad(AmoSupremo unidad){
        throw new TerrenoNoAptoParaTalUnidad();
    }

    public void energizarTerreno() { }

    public void cubrirTerrenoDeMoho() { }

    public void vaciarTerreno() { }
    
    @Override
    public Mineral extraerMinerales(Mineral mineral) {
        this.mineral.gastar(mineral);
        return mineral;
    }

    @Override
    public String toData() {
        return "Mineral";
    }

    @Override
    public ObjectNode toDataOcupantes() {
        ObjectNode nodo = Json.createObjectNode();
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

    @Override
    public void actualizar() {

    }

}
