package edu.fiuba.algo3.modelo.jugadores;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.excepciones.NombreDeJugadorInvalido;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoPoseeUnaUnidad;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.ArrayList;
import java.util.List;

public abstract class Jugador {

    protected int id;
    protected Mapa mapa;
    public Inventario inventario;
    protected String nombre;
    protected String color;

    public void establecerNombre(String nombre) throws NombreDeJugadorInvalido {
        if (nombre.length() < 6) {
            throw new NombreDeJugadorInvalido();
        }
        this.nombre = nombre;
    }

    protected void establecerAtributosBasicos(String nombre, String color, int gasInicial, int mineralesIniciales) {
        this.establecerNombre(nombre);
        this.color = color;
        this.inventario = new Inventario(new GasVespeno(gasInicial), new Minerales(mineralesIniciales));
    }

    public void moverUnidad(Casilla casillaUnidad, Direccion direccion){
        Unidad unidad = casillaUnidad.devolverUnidad();
        if(unidad == null) {
            throw new TerrenoNoPoseeUnaUnidad();
        }
        unidad.moverse(direccion, mapa);
    }

    public void moverUnidad(Coordenada coordenadaUnidad, Direccion direccion) {
        Casilla casillaUnidad = mapa.buscarCasilla(coordenadaUnidad);
        moverUnidad(casillaUnidad, direccion);
    }

    public abstract void generarUnidad(Coordenada coordenada);

    public void construirEdificio(Coordenada coordenada, Edificio edificio) {
        this.construirEdificio(mapa.buscarCasilla(coordenada), edificio);
    }

    public void construirEdificio(Casilla casilla, Edificio edificio) {
        casilla.ponerEdificio(edificio.construir(inventario));
    }

    public Casilla hallarCasillaConVolcanInicial() {
        return mapa.hallarVolcanInicialDelJugador(id);
    }

    public List<Casilla> hallarCasillasConMineralesIniciales() {
        return mapa.hallarMineralesInicialesDelJugador(id);
    }

    public Casilla hallarCasillaConEdificioInicial() {
        return mapa.hallarCasillaConEdificioInicialDelJugador(id);
    }

    public void establecerMapa(Mapa mapa) {
        this.mapa = mapa;
        iniciarseEnMapa();
    }

    protected abstract void iniciarseEnMapa();

    public void establecerId(int id) {
        this.id = id;
    }

}
