package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.direcciones.Direccion;
import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.recursos.Recursos;

public abstract class Unidad {

    protected Recursos costoEnMinerales;
    protected Recursos costoEnGas;
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

    public void actualizar(){
        tiempoConstruccion--;
        if(tiempoConstruccion == 0){
            estado = new UnidadOperativa(danioAereo, danioTerrestre, rango);
        }
        vida.regenerar();
    }

    public void moverse(Direccion direccion, Mapa mapa){
        estado.moverse(direccion,mapa, coordenada, this);
    }

    public void atacar (Direccion direccion, Mapa mapa){
        estado.atacar(direccion, mapa, coordenada);
    }




/*
    protected boolean disponible = true;

    public boolean devolverDisponibilidad() {
        return disponible;
    }

    public boolean intentarMoverse(Casilla nuevaCasilla) {
        if (this.disponible) {
            this.disponible = false;
            return true;
        }
        return false;
    }

    protected void actualizarDisponibilidad() {
        this.disponible = true;
    }

    public int emitirDanio() {
        this.disponible = false;
        return 100;
    }

    public abstract void actualizar();
*/
}