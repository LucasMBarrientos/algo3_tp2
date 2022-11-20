package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.EstadoTerreno;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.List;

public abstract class Edificio  {

    public Terreno terreno;
    public Recurso costoEnMinerales;
    public Recurso costoEnGas;
    public Vida vida;
    protected Nombre nombre;
    public int tiempoDeConstruccion;
    public Coordenada coordenada;

    public boolean generaTerrenoEnergizado() {
        return false;
    }

    public Edificio construir(Inventario inventario){
        validarCorrelativasDeConstruccion(inventario);
        consumirRecursosParaConstruccion(inventario);
        return this;
    }

    public void consumirRecursosParaConstruccion(Inventario inventario) {
        inventario.consumirMinerales(costoEnMinerales);
        inventario.consumirGasVespeno(costoEnGas);
    }

    public void devolverRecursosParaConstruccion(Inventario inventario){
        inventario.devolverMinerales(costoEnMinerales);
        inventario.devolverGasVespeno(costoEnGas);
    }

    public abstract void validarCorrelativasDeConstruccion(Inventario inventario);

    public abstract void ocupar(Terreno terreno);

    public abstract void establecerTerreno(Terreno terreno);

    public abstract void actualizar();

    public Nombre devolverNombre(){
        return nombre;
    }

    public void establecerPosicion(Coordenada ubicacion){
        coordenada = ubicacion;
    }

    public Unidad generarUnidad(Unidad unidad){
        return null; //terminar bien
    }

    public abstract Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespenoDelJugador, Mineral mineralDelJugador, Coordenada coordenada);

    public Unidad consumirLarvasYGenerarUnidad(Unidad unidad) {
        return null;
    }

    public abstract void recibirGolpe(Danio danioTerestre, Danio danioAereo);

    public int contarLarvas() {
        return 0;
    }

    public void consumirLarva() {
        return;
    }

    public boolean compararCoordenadas(Coordenada coordenadaAComparar) {
        return coordenada.esIgual(coordenadaAComparar);
    }

    public void actualizarListaDeCoordenadas(List<Coordenada> coordenadasConCriaderos, List<Coordenada> coordenadasConPilones) {
        return;
    }

    // public abstract void recibirGolpe(int danio);

}
