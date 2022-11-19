package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.Recurso;

public abstract class Unidad {

    protected Recurso costoEnMinerales;
    protected Recurso costoEnGas;
    protected int tiempoConstruccion = 1;
    protected Coordenada coordenada;
    protected Danio danioAereo;
    protected Danio danioTerrestre;
    protected int rango = 0;
    protected Vida vida;
    protected EstadoUnidad estado = new UnidadEnConstruccion();
    protected boolean aerea = false;

    public int devolverTiempoConstruccion() {
        return tiempoConstruccion;
    }

    public Vida devolverVida() {
        return vida;
    }

    public int devolverRango() {
        return rango;
    }

    public boolean esAerea() {
        return aerea;
    }

    public void actualizar() {
        tiempoConstruccion--;
        if(tiempoConstruccion == 0){
            estado = new UnidadOperativa(danioAereo, danioTerrestre, rango);
        }
        vida.regenerar();
    }

    public void moverse(Direccion direccion, Mapa mapa) {
        estado.moverse(direccion,mapa, coordenada, this);
    }

    public void atacar(Coordenada objetivo, Mapa mapa) {
        estado.atacar(objetivo, mapa);
    }

    public Unidad generarse(Coordenada coordenadaDelEdificio, Inventario inventario){
        Edificio edificioConstructor = inventario.buscarEdificio(coordenadaDelEdificio);
        //edificioConstructor.generarUnidad(this);
        consumirRecursosParaGenerarse(inventario); //hacer que el generar unidad de los edificios se encargue de esto (?
        return  this;
    }

    public void consumirRecursosParaGenerarse(Inventario inventario){
        inventario.consumirMinerales(costoEnMinerales);
        inventario.consumirGasVespeno(costoEnGas);
    }
}
