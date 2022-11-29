package edu.fiuba.algo3.modelo.terrenos;

import java.util.List;

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
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.*;

public class TerrenoEnergizado implements EstadoTerreno {

    private TerrenoBase terreno;

    public TerrenoEnergizado(TerrenoBase terreno){
        this.terreno = terreno;
    }

    public void ocuparPorEdificio(Pilon pilon){
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarTerrenoSinUnidad();
        terreno.establecerEdificio(pilon);
    }

    public void ocuparPorEdificio(Acceso acceso){
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarTerrenoSinUnidad();
        terreno.establecerEdificio(acceso);
    }

    public void ocuparPorEdificio(Asimilador asimilador){
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(NexoMineral nexoMineral){
        throw new TerrenoNoAptoParaConstruirTalEdificio();
    }

    public void ocuparPorEdificio(PuertoEstelar puertoEstelar){
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarTerrenoSinUnidad();
        terreno.establecerEdificio(puertoEstelar);
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

    public void ocuparPorUnidad(Hidralisco unidad){
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarTerrenoSinUnidad();
        terreno.establecerUnidad(unidad);
    }

    public void ocuparPorUnidad(Mutalisco unidad){
        terreno.verificarTerrenoSinEdificio();
        terreno.verificarTerrenoSinUnidad();
        terreno.establecerUnidad(unidad);
    }

    public void ocuparPorUnidad(Guardian unidad){
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
        terreno.establecerEstado(new TerrenoMoho(terreno));
    }

    @Override
    public String getString() {
        return "e";
    }

    public void energizarTerreno() {
        return;
    }

    public void desenergizarTerreno() {
        terreno.establecerEstado(new TerrenoVacio(terreno));
    }
  
    public boolean tieneMoho() {
        return false;
    }

}
