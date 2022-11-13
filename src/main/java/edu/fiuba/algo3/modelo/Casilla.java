package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.terrenos.*;

import java.util.ArrayList;
import java.util.List;

public class Casilla {

    private Coordenada coordenada;
    private Edificio edificio;
    private Unidad unidad;
    private Terreno terreno;

    public Casilla (Coordenada coordenada) {
        this.coordenada = coordenada;
        this.terreno = new TerrenoVacio();
    }
/*
    public void ocuparPorEdificio(Edificio edificio) {
        if (this.edificio != null) {
            throw new TerrenoNoAptoParaConstruirEsteEdificio(); //cambiar por excepcion TerrenoOcupado?
        }
        terreno.ocuparPorEdificio(edificio, this);
    }*/
    public void establecerEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public void establecerUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public void establecerTerreno(Terreno terreno) {
        if (this.terreno.esReemplazable()) {
            this.terreno = terreno;
        }
    }

    public List<Coordenada> devolverCoordenadasAdyacentes() {
        return coordenada.devolverCoordenadasAdyacentes();
    }

    public boolean compararCoordenadas(Coordenada coordenada) {
        return this.coordenada.esIgual(coordenada);
    }

    public boolean compararCoordenadas(Casilla casilla) {
        return this.coordenada.esIgual(casilla.devolverCoordendas());
    }

    public Coordenada devolverCoordendas() {
        return coordenada;
    }

    public Edificio devolverEdificio() {
        return edificio;
    }

    public Terreno devolverTerreno() {
        return terreno;
    }
    
    public boolean generaTerrenoEnergizado() {
        if (edificio == null) { return false; }
        return this.edificio.generaTerrenoEnergizado();
    }

    public boolean terrenoEsReemplazable() {
        return this.terreno.esReemplazable();
    }

    public boolean terrenoRepeleeMoho() {
        return this.terreno.repeleeMoho();
    }


/*
    private int x,y;
    public Edificio edificio;
    public Unidad unidad;
    public Terreno terreno;

    public Casilla(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Casilla(int x, int y, Edificio edificio) {
        this.x = x;
        this.y = y;
        this.edificio = edificio;
    }

    public Casilla(int x, int y, Terreno terreno) {
        this.x = x;
        this.y = y;
        this.terreno = terreno;
    }

    public int devolverX() {
        return this.x;
    }

    public int devolverY() {
        return this.y;
    }
    
    public Unidad devolverUnidad() {
        return this.unidad;
    }

    public Edificio devolverEdificio() {
        return this.edificio;
    }

    public void establecerTerreno(Terreno terreno) {
        this.terreno = terreno;
    }

    public Terreno devolverTerreno() {
        return this.terreno;
    }

    public void establecerEdificio(Edificio edificio) {
        if (this.terreno.validarEdificio(edificio)) {
            this.edificio = edificio;
        }
    }
    public void establecerUnidad(Unidad unidad) {
        if (this.terreno.validarTransitable(unidad)) {
            this.unidad = unidad;
        }
    }

    /*
    public Casilla obtenerCasillaRelativa(int distanciaX, int distanciaY){
        return new Casilla(this.x + distanciaX, this.y + distanciaY);
    }
    */

    /*
    public void construirEdificio(){
        if(devolverOcupante() instanceof Zangano){
            ((Zangano) devolverOcupante()).construir(this);
        }else{
            //hacemos otra cosa
        }
    }
    */
    /*
    public boolean validarCasillaAdyacente(Casilla casillaComparada) {
        int x = casillaComparada.devolverX();
        int y = casillaComparada.devolverY();
        return (x > this.x - 1 && x < this.x + 1 && y > this.y - 1 && y < this.y + 1);
    }
    
    public boolean ocupada() {
        return (this.edificio != null || this.unidad != null);
    }

    public boolean compararUbicaciones(Casilla casillaComparada) {
        return (this.x == casillaComparada.devolverX() && this.y == casillaComparada.devolverY());
    }

    public boolean compararUbicaciones(int x, int y) {
        return (this.x == x && this.y == y);
    }

    @Override
    public void actualizar() {
        if(edificio != null){
            edificio.actualizar();
        }
        if(unidad != null){
            unidad.actualizar();
        }
    }*/
}
