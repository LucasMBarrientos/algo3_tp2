package edu.fiuba.algo3.modelo.terrenos;

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
    public String getString() {
        return "h";
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