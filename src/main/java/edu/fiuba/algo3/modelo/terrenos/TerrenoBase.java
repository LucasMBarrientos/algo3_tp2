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
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.*;

public class TerrenoBase extends Terreno {

    private EstadoTerreno estado = new TerrenoVacio(this);

    public TerrenoBase(Coordenada coordenada) {
        this.coordenada = coordenada;
    }
    public void establecerEdificio(Edificio edificio){
        this.edificio = edificio;
    }
    public void establecerUnidad(Unidad unidad){
        this.unidad = unidad;
    }

    public void establecerEstado(EstadoTerreno estado){
        this.estado = estado;
    }

    public void ocuparPorEdificio(Pilon pilon){
        estado.ocuparPorEdificio(pilon);
    }

    public void ocuparPorEdificio(Acceso acceso){
        estado.ocuparPorEdificio(acceso);
    }

    public void ocuparPorEdificio(Asimilador asimilador){
        estado.ocuparPorEdificio(asimilador);
    }

    public void ocuparPorEdificio(NexoMineral nexoMineral){
        estado.ocuparPorEdificio(nexoMineral);
    }

    public void ocuparPorEdificio(PuertoEstelar puertoEstelar){
        estado.ocuparPorEdificio(puertoEstelar);
    }

    public void ocuparPorEdificio(Criadero criadero){
        estado.ocuparPorEdificio(criadero);
    }

    public void ocuparPorEdificio(Espiral espiral){
        estado.ocuparPorEdificio(espiral);
    }

    public void ocuparPorEdificio(Extractor extractor){
        estado.ocuparPorEdificio(extractor);
    }

    public void ocuparPorEdificio(Guarida guarida){
        estado.ocuparPorEdificio(guarida);
    }

    public void ocuparPorEdificio(ReservaDeReproduccion reservaDeReproduccion){
        estado.ocuparPorEdificio(reservaDeReproduccion);
    }

    public void ocuparPorUnidad(Dragon unidad){
        estado.ocuparPorUnidad(unidad);
        unidad.establecerCoordenada(coordenada);
    }

    public void ocuparPorUnidad(Zealot unidad){
        estado.ocuparPorUnidad(unidad);
        unidad.establecerCoordenada(coordenada);
    }

    public void ocuparPorUnidad(Scout unidad){
        estado.ocuparPorUnidad(unidad);
        unidad.establecerCoordenada(coordenada);
    }

    public void ocuparPorUnidad(Zangano unidad){
        estado.ocuparPorUnidad(unidad);
        unidad.establecerCoordenada(coordenada);
    }

    public void ocuparPorUnidad(Zerling unidad){
        estado.ocuparPorUnidad(unidad);
        unidad.establecerCoordenada(coordenada);
    }

    public void ocuparPorUnidad(Hidralisco unidad){
        estado.ocuparPorUnidad(unidad);
        unidad.establecerCoordenada(coordenada);
    }

    public void ocuparPorUnidad(Mutalisco unidad){
        estado.ocuparPorUnidad(unidad);
        unidad.establecerCoordenada(coordenada);
    }
    public void ocuparPorUnidad(Guardian unidad) {
        estado.ocuparPorUnidad(unidad);
        unidad.establecerCoordenada(coordenada);
    }
    
    public void ocuparPorUnidad(Devorador unidad) {
        estado.ocuparPorUnidad(unidad);
        unidad.establecerCoordenada(coordenada);
    }

    public void ocuparPorUnidad(AmoSupremo unidad){
        estado.ocuparPorUnidad(unidad);
        unidad.establecerCoordenada(coordenada);
    }

    public void energizarTerreno() {
        estado.energizarTerreno();
    }

    public void desenergizarTerreno() {
        estado.desenergizarTerreno();
    }

    public void cubrirTerrenoDeMoho() {
        estado.cubrirTerrenoDeMoho();
    }

    public void vaciarTerreno() { 
        establecerEstado(new TerrenoVacio(null));
    }

    @Override
    public void actualizarListaDeCoordenadas(List<Coordenada> coordenadasConMoho,List<Coordenada> coordenadasConCriaderos,List<Coordenada> coordenadasConPilones) {
        if (edificio != null) {
            edificio.actualizarListasDeCoordenadas(coordenadasConCriaderos, coordenadasConPilones);
        }
        if (estado.tieneMoho()) {
            coordenadasConMoho.addAll(coordenada.hallarCoordenadasAdyacentes());
        }
    }

    @Override
    public String getString() {
        return estado.getString();
    }

    // Metodos DEBUG_ unicamente para probar el funcionamiento el programa

    public EstadoTerreno DEBUG_DEVOLVERESTADO() {
        return estado;
    }

}
