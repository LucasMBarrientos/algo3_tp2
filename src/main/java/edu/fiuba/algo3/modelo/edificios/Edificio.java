package edu.fiuba.algo3.modelo.edificios;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Nombre;
import edu.fiuba.algo3.modelo.edificios.estados.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.edificios.estados.EstadoEdificio;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoConoceEstaUnidad;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.*;

public abstract class Edificio {

    protected EstadoEdificio estadoActual = new EdificioEnConstruccion();
    protected Terreno terreno;
    protected Recurso costoEnMinerales;
    protected Recurso costoEnGas;
    protected Vida vida;
    protected Nombre nombre;
    protected int tiempoDeConstruccion;
    protected Coordenada coordenada;
    
    public void deshacerConstruccion() {
        this.estadoActual.deshacerConstruccion();
    }
    
    public abstract Edificio construir(Coordenada coordenada, Inventario inventarioDelJugador);

    public void consumirRecursosParaConstruccion(Inventario inventario) {
        inventario.consumirMinerales(costoEnMinerales);
        inventario.consumirGasVespeno(costoEnGas);
    }

    public void devolverRecursosParaConstruccion(Inventario inventario) {
        inventario.devolverMinerales(costoEnMinerales);
        inventario.devolverGasVespeno(costoEnGas);
    }

    public void actualizar(Inventario inventario) {
        this.estadoActual.actualizar(inventario);
    }

    public abstract void actualizarEdificio(Inventario inventario);

    public void ingresarUnidad(Unidad unidad) {
        estadoActual.ingresarUnidad(unidad);
    }

    public void establecerPosicion(Coordenada ubicacion) {
        coordenada = ubicacion;
    }

    public boolean reducirTiempoConstruccion(int tiempoAReducir) {
        this.tiempoDeConstruccion = Math.max(0, this.tiempoDeConstruccion - tiempoAReducir);
        return this.tiempoDeConstruccion == 0;
    }

    public void terminarConstruccion() {
        this.estadoActual.terminarConstruccion();
    }

    public void establecerEstado(EstadoEdificio estado) {
        this.estadoActual = estado;
        this.estadoActual.establecerEdificio(this);
    }

    public void recibirDanio(Danio danioTerrestre, Danio danioAereo) {
        this.estadoActual.recibirDanio(danioTerrestre);
    }

    public boolean compararCoordenadas(Coordenada coordenadaComparada) {
        return this.coordenada.esIgual(coordenadaComparada);
    }

    public Nombre devolverNombre() {
        return nombre;
    }

    public boolean consumirLarva() {
        return false;
    }

    public void agregarSuministro(Inventario inventario) {
        return;
    }

    public void restarSuministros(Inventario inventario) {
        return;
    }

    public void validarCorrelativasDeConstruccion(Inventario inventario) {
        return;
    }


    public void destruirse(Inventario inv){
        inv.eliminarEdificio(coordenada);
    }

    public void ingresarUnidadTrabajadora(Unidad unidad) {
        return;
    }

    public Unidad generarUnidad(Scout unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(Zealot unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(Dragon unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad {
        throw new EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(Zerling unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(Zangano unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(Hidralisco unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad {
        throw new EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(Mutalisco unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad {
        throw new EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(AmoSupremo unidad, Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new EdificioNoConoceEstaUnidad();
    }

    public abstract void ejecutarDanio(Danio danio);

    public abstract void regenerar();

    public abstract ObjectNode toData();

    public abstract void ocupar(Terreno terreno);


}
