package edu.fiuba.algo3.modelo.terrenos;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.*;

public class TerrenoBase extends Terreno {

    private EstadoTerreno estado = new TerrenoVacio(this);

    public TerrenoBase(Coordenada coordenada) {
        this.coordenada = coordenada;
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
    }

    public void ocuparPorUnidad(Zealot unidad){
        estado.ocuparPorUnidad(unidad);
    }

    public void ocuparPorUnidad(Scout unidad){
        estado.ocuparPorUnidad(unidad);
    }

    public void ocuparPorUnidad(Zangano unidad){
        estado.ocuparPorUnidad(unidad);
    }

    public void ocuparPorUnidad(Zerling unidad){
        estado.ocuparPorUnidad(unidad);
    }

    public void ocuparPorUnidad(Hidralisco unidad){
        estado.ocuparPorUnidad(unidad);
    }

    public void ocuparPorUnidad(Mutalisco unidad){
        estado.ocuparPorUnidad(unidad);
    }
    public void ocuparPorUnidad(Guardian unidad) {
        estado.ocuparPorUnidad(unidad);
    }
    
    public void ocuparPorUnidad(Devorador unidad) {
        estado.ocuparPorUnidad(unidad);
    }

    public void ocuparPorUnidad(AmoSupremo unidad){
        estado.ocuparPorUnidad(unidad);
    }

    @Override
    public void energizarTerreno() {
        estado.energizarTerreno();
    }
    @Override
    public void desenergizarTerreno() {
        estado.desenergizarTerreno();
    }
    @Override
    public void cubrirTerrenoDeMoho() {
        estado.cubrirTerrenoDeMoho();
    }

    public void habilitarEdificioOcupante() {
        if(edificio != null){
            edificio.volverNuevamenteOperativo();
        }
    }

    public void deshabilitarEdificioOcupante() {
        if(edificio != null){
            edificio.volverEdificioInoperativo();
        }
    }

    @Override
    public ObjectNode toData() {
        return estado.toData();
    }

    @Override
    public ObjectNode toDataOcupantes() {
        return estado.toDataOcupantes();
    }

}
