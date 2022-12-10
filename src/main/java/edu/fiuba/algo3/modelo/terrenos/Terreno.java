package edu.fiuba.algo3.modelo.terrenos;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.NoHayUnZanganoEnEsaCoordenada;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.excepciones.TerrenoOcupadoPorUnaUnidad;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.modificadores.Visibilidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.*;

public abstract class Terreno {

    public Coordenada coordenada;

    protected Edificio edificio;

    protected Unidad unidad;

    private Zangano zanganoOcupante;

    protected void establecerEdificio(Edificio edificio){
        this.edificio = edificio;
        edificio.establecerPosicion(coordenada);
        eliminarUnidad(); //si el edificio era zerg debe eliminarse el zanganoConstructor, sino ya se verifico que no hay otra unidad
    }
    protected void establecerUnidad(Unidad unidad){
        this.unidad = unidad;
        unidad.establecerCoordenada(coordenada);
    }

    public boolean compararCoordenadas(Coordenada coordenada) {
        return this.coordenada.esIgual(coordenada);
    }

    public abstract void ocuparPorEdificio(Pilon pilon);

    public abstract void ocuparPorEdificio(Acceso acceso);

    public abstract void ocuparPorEdificio(Asimilador asimilador);

    public abstract void ocuparPorEdificio(NexoMineral nexoMineral);

    public abstract void ocuparPorEdificio(PuertoEstelar puertoEstelar);

    public abstract void ocuparPorEdificio(Criadero criadero);

    public abstract void ocuparPorEdificio(Espiral espiral);

    public abstract void ocuparPorEdificio(Extractor extractor);

    public abstract void ocuparPorEdificio(Guarida guarida);

    public abstract void ocuparPorEdificio(ReservaDeReproduccion reservaDeReproduccion);

    public abstract void ocuparPorUnidad(Dragon unidad);

    public abstract void ocuparPorUnidad(Zealot unidad);

    public abstract void ocuparPorUnidad(Scout unidad);

    public abstract void ocuparPorUnidad(Zangano unidad);

    public abstract void ocuparPorUnidad(Zerling unidad);

    public abstract void ocuparPorUnidad(Hidralisco unidad);

    public abstract void ocuparPorUnidad(Mutalisco unidad);

    public abstract void ocuparPorUnidad(Guardian unidad);

    public abstract void ocuparPorUnidad(Devorador devorador);

    public abstract void ocuparPorUnidad(AmoSupremo unidad);


    public void verificarTerrenoSinEdificio(){
        if(this.edificio != null){
            throw new TerrenoNoAptoParaConstruirTalEdificio(); //se podria usar otra excepcion mejor
        }
    }

    public void actualizar(){

    }

    public void verificarTerrenoSinUnidad(){
        if(this.unidad != null){
            throw new TerrenoOcupadoPorUnaUnidad(); //se podria usar otra excepcion mejor
        }
    }

    public void eliminarEdificio() {
        this.edificio = null;
    }

    public void eliminarUnidad() {
        this.unidad = null;
        eliminarZanganoOcupante();
    }

    public abstract void vaciarTerreno();

    public abstract void energizarTerreno();

    public void desenergizarTerreno() {
        return;
    }

    public abstract void cubrirTerrenoDeMoho();

    public void recibirDanio(Danio danioTerrestre, Danio danioAereo) {
        if(edificio != null){
            edificio.recibirDanio(danioTerrestre, danioAereo);
        } else if (unidad != null) {
            unidad.recibirDanio(danioTerrestre, danioAereo);
        }
    }

    public void cambiarVisibilidadAUnidad(Visibilidad visibilidad){
        if (unidad != null) {
            unidad.establecerVisibilidad(visibilidad);
        }
    }

    public void volverInvisibleAUnidad(){
        if (unidad != null) {
          unidad.volverInvisible();
        }
    }

    protected void establecerZanganoOcupante(Zangano zangano){
        zanganoOcupante = zangano;
    }

    protected void eliminarZanganoOcupante(){
        zanganoOcupante = null;
    }

    protected void verificarZanganoOcupante(){
        if(zanganoOcupante == null){
            throw new NoHayUnZanganoEnEsaCoordenada();
        }
    }

    public void extraerGasVespeno(Recurso recursoRequerido) {

    }

    public Mineral extraerMinerales(Mineral mineral) {
      return new Mineral(0);
    }
    
    public abstract ObjectNode toData();

    public abstract ObjectNode toDataOcupantes();
}
