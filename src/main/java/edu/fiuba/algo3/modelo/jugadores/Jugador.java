package edu.fiuba.algo3.modelo.jugadores;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Nombre;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.unidades.Unidad;


public abstract class Jugador {

    protected int id;
    public Inventario inventario;
    protected Nombre nombre;
    protected String color;
    protected boolean edificioInicialConstruido = false;

    public void establecerNombre(String nombre) throws NombreDeJugadorInvalido {
        if (nombre.length() < 6) {
            throw new NombreDeJugadorInvalido();
        }
        this.nombre = new Nombre(nombre);
    }

    public abstract ObjectNode toData();

    public void construirEdificio(Coordenada coordenada, Edificio edificio) {
        edificio.construir(coordenada, inventario);
        inventario.agregarEdificio(edificio);
        edificioInicialConstruido = true;
        Logger.log("Se inicio la construccion del edificio: \"" + edificio.devolverNombre().devolverValor() + "\"");
    }

    public void generarUnidad(Coordenada coordenadaDelEdificio, Unidad unidad) {
        Edificio edificio = inventario.buscarEdificio(coordenadaDelEdificio);
        unidad.generarse(edificio, inventario);
        try {
            Mapa.devolverInstancia().establecerUnidadEnCoordenadaAdyacente(coordenadaDelEdificio, unidad);
        } catch(TerrenoNoAptoParaTalUnidad e){
            unidad.restaurarRecursosParaConstruccion(inventario);
            throw new TerrenoNoAptoParaConstruirTalEdificio();
        }
        inventario.agregarUnidad(unidad);
        Logger.log("Se inicio la creacion de la unidad: \"" + unidad.devolverNombre().devolverValor() + "\"");
    }

    protected void establecerAtributosBasicos(String nombre, String color, int gasInicial, int mineralesIniciales, int suministroInicial) {
        this.establecerNombre(nombre);
        this.color = color;
        this.inventario = new Inventario(new GasVespeno(gasInicial), new Mineral(mineralesIniciales), new Suministro(suministroInicial));
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

    public boolean nombreEsIgual(Nombre nombre) {
        return this.nombre.esIgual(nombre);
    }

    protected void compararColor(Jugador jugador) throws ColorDeJugadorInvalido {
        if (jugador.colorEsIgual(this.color)) {
            throw new ColorDeJugadorInvalido();
        }
    }

    protected boolean colorEsIgual(String color) {
        return this.color.equals(color);
    }

    protected void compararRaza(Jugador jugador) throws RazaInvalida {
        if (this.getClass() == jugador.getClass()) {
            throw new RazaInvalida();
        }
    }

    public void moverUnidad(Coordenada coordenadaDeLaUnidad, Direccion direccionDelMovimiento) {
        Unidad unidad = inventario.buscarUnidad(coordenadaDeLaUnidad);
        unidad.moverse(direccionDelMovimiento);
    }

    public void destruirUnidad(Coordenada coordenada) {
        Mapa.devolverInstancia().eliminarUnidad(coordenada);
        inventario.eliminarUnidad(coordenada);
    }

    public void destruirEdificio(Coordenada coordenada) {
        Mapa.devolverInstancia().eliminarEdificio(coordenada);
        inventario.eliminarEdificio(coordenada);
    }

    public void atacar(Coordenada coordenadaUnidad, Coordenada coordenadaObjetivo) {
        Unidad unidad = inventario.buscarUnidad(coordenadaUnidad);
        unidad.atacar(coordenadaObjetivo);
    }

    public void establecerId(int id) {
        this.id = id;
    }

    public void evolucionar(Coordenada coordenada, Unidad unidadAEvolucionar) { }

    public void actualizar() {
        inventario.actualizar();
    }

    public void aniadirseAListaSiNoFueDerrotado(List<Jugador> jugadoresQueNoPerdieron) {
        if (!(fueDerrotado())) {
            jugadoresQueNoPerdieron.add(this);
        }
    }

    protected boolean fueDerrotado() {
        return inventario.fueDerrotado(edificioInicialConstruido);
    }

    public abstract List<String> devolverMediaDeVictoria();

    public abstract void ingresarUnidadAUnEdificio(Coordenada coordenadaDelEdificio, Coordenada coordenadaDeLaUnidad);

    public abstract void iniciarseEnMapa();

    public String devolverNombre() {
        return this.nombre.devolverValor();
    }

}
