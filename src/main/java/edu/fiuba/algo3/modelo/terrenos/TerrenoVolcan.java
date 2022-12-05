package edu.fiuba.algo3.modelo.terrenos;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.*;
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
import edu.fiuba.algo3.modelo.excepciones.UnidadNoEncontrada;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.*;

import java.util.List;

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
        verificarTerrenoSinUnidad();
        edificio = extractor;
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
        this.unidad = unidad;
        unidad.establecerCoordenada(coordenada);
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

    public void energizarTerreno() { }

    public void cubrirTerrenoDeMoho() { }

    public void vaciarTerreno() { }

    @Override
    public void extraerGasVespeno(Recurso recursoRequerido) {
        gasVespeno.gastar(recursoRequerido);
    }

    @Override
    public String toData() {
        return "Volcan";
    }

    @Override
    public ObjectNode toDataOcupantes() {
        ObjectNode node = Json.createObjectNode();
        if(edificio != null){
            node.put("Ocupante",edificio.toData());
        }else if (unidad != null){
            node.put("Ocupante",unidad.toData());
        }else{
            ObjectNode node2 = Json.createObjectNode();
            node.put("Ocupante",node2.put("nombre","Desocupado"));
        }
        return node;
    }

}
