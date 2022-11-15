package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.direcciones.Direccion;
import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;

public abstract class Unidad { // seguramente deba ser abstracta

    protected int requerimientosMinerales = 0;
    protected int requerimientosGas = 0;
    protected int tiempoConstruccion = 1;
    protected Coordenada coordenada;
    protected Danio danioAereo;
    protected Danio danioTerrestre;
    protected int rango = 0;
    protected Vida vida;
    protected boolean aerea = false;

    public int devolverRequerimientosDeGas() {
        return requerimientosGas;
    }

    public int devolverRequerimientosMinerales() {
        return requerimientosMinerales;
    }

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



    public void moverse(Direccion direccion, Mapa mapa){
        Coordenada nuevaPosicion = direccion.siguiente(coordenada);
        //chequear que se pueda para aca
        mapa.buscarCasilla(nuevaPosicion).establecerUnidad(this);

    }

    public void atacar (Direccion direccion, Mapa mapa){
        Coordenada coordenadaDelObjetivo= direccion.siguiente(coordenada);

        for (int i = 0; i < rango; i++) {
            coordenadaDelObjetivo = direccion.siguiente(coordenadaDelObjetivo);
        }

        Casilla casillaDelObjetivo = mapa.buscarCasilla(coordenadaDelObjetivo);
        casillaDelObjetivo.devolverEdificio().recibirGolpe(danioTerrestre);
        //implementar el recibir daño a una unidad
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