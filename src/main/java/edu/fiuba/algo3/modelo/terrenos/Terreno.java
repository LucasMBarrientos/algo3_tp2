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
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaTalUnidad;
import edu.fiuba.algo3.modelo.excepciones.TerrenoOcupadoPorUnEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.*;

public abstract class Terreno {

    public Coordenada coordenada;

    protected Edificio edificio;

    protected Unidad unidad;
    /*
    public void establecerEstado(EstadoTerreno estado) {
        this.estado = estado;
        this.estado.setTerreno(this);
    }*/

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


    public void verificarTerrenoSinEdificio(){
        if(this.edificio != null){
            throw new TerrenoNoAptoParaConstruirTalEdificio(); //se podria usar otra excepcion mejor
        }
    }

    public void actualizar(){

    }

    public void verificarTerrenoSinUnidad(){
        if(this.unidad != null){
            throw new TerrenoNoAptoParaTalUnidad(); //se podria usar otra excepcion mejor
        }
    }

    public void eliminarEdificio() {
        this.edificio = null;
    }
    
    public void establecerUnidad(Unidad unidad){
        this.unidad = unidad;
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

    public void actualizarListaDeCoordenadas(List<Coordenada> coordenadasConMoho, List<Coordenada> coordenadasConCriaderos, List<Coordenada> coordenadasConPilones) {
        if (edificio != null) {
            edificio.actualizarListasDeCoordenadas(coordenadasConCriaderos, coordenadasConPilones);
        }
    }

    //TODO: Hacer que sea un solo mensaje "extraer recurso"
    public void extraerGasVespeno(Recurso recursoRequerido) {

    }

    public void extraerMinerales(Recurso recursoRequerido) {

    }
    
    // Metodos DEBUG_ unicamente para probar el funcionamiento el programa

    public Edificio DEBUG_DEVOLVEREDIFICIO() {
        return edificio;
    }

    public Unidad DEBUG_DEVOLERUNIDAD() {
        return unidad;
    }

}
