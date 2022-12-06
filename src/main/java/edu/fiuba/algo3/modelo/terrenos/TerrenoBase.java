package edu.fiuba.algo3.modelo.terrenos;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.edificios.Edificio;
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
    public String toData() {
        return estado.toData();
    }

    @Override
    public ObjectNode toDataOcupantes() {
        return estado.toDataOcupantes();
    }

}
