package edu.fiuba.algo3.modelo.jugadores;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.unidades.Unidad;

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

    public abstract void construirEdificio(Coordenada coordenada, Edificio edificio);

    public void generarUnidad(Coordenada coordenadaDelEdificio, Unidad unidad){
        Edificio edificio = inventario.buscarEdificio(coordenadaDelEdificio);
        unidad.generarse(edificio,inventario);
        unidad.consumirRecursosParaGenerarse(inventario);

        try {
            mapa.establecerUnidad(coordenadaDelEdificio, unidad);
        } catch(TerrenoNoAptoParaTalUnidad e){
            unidad.restaurarRecursosParaConstruccion(inventario);
            throw new TerrenoNoAptoParaConstruirTalEdificio();
        }
        inventario.agregarUnidad(unidad);
    }

    protected void establecerAtributosBasicos(String nombre, String color, int gasInicial, int mineralesIniciales) {
        this.establecerNombre(nombre);
        this.color = color;
        this.inventario = new Inventario(new GasVespeno(gasInicial), new Mineral(mineralesIniciales));
    }

    public void compararAtributosBasicoConOtrosJugadores(List<Jugador> otrosJugadores) {
        for (Jugador otroJugador : otrosJugadores) {
            compararNombre(otroJugador);
            compararColor(otroJugador);
            compararRaza(otroJugador);
        }
    }

    protected void compararNombre(Jugador jugador) throws NombreDeJugadorInvalido {
        if (jugador.nombreEsIgual(this.nombre)) {
            throw new NombreDeJugadorInvalido();
        }
    }

    public boolean nombreEsIgual(String nombre) {
        return this.nombre.equals(nombre);
    }

    protected void compararColor(Jugador jugador) throws ColorDeJugadorInvalido {
        if (jugador.colorEsIgual(this.color)) {
            throw new ColorDeJugadorInvalido();
        }
    }

    protected boolean colorEsIgual(String color) {
        return this.color.equals(color);
    }

    protected void compararRaza(Jugador jugador) throws RazaYaElegidaPorElOtroJugador {
        if (this.getClass() == jugador.getClass()) {
            throw new RazaYaElegidaPorElOtroJugador();
        }
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
