package edu.fiuba.algo3.modelo.edificios.zerg.criadero;

import java.util.List;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMoho;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public class Criadero extends EdificioZerg {

    private EstadoCriadero estado;
    Terreno terreno;

    public Criadero() {
        this.costoEnMinerales = new Mineral(200);
        this.costoEnGas = new GasVespeno(0);
        this.tiempoDeConstruccion = 4;
        this.vida = new Vida(500);
        this.nombre = new Nombre("Criadero");
        establecerEstado(new CriaderoEnConstruccion());
    }

    public void consumirLarva() {
        estado.consumirLarva();
    }

    public int contarLarvas() {
        return estado.contarLarvas();
    }

    @Override
    public Unidad consumirLarvasYGenerarUnidad(Unidad unidad) {
        return estado.generarUnidad(unidad);
    }

    /*public Criadero(Coordenada coordenada) {
        this.coordenada = coordenada;
    }*/
    
    /*
    @Override
    public Unidad generarUnidad(Unidad unidad) throws NoHayLarvasDisponibles {
        return estado.generarUnidad(unidad);
    }
    */

    public Unidad generarUnidad(Unidad unidad) {
        return estado.generarUnidad(unidad);
    }

    @Override
    public void actualizarListaDeCoordenadas(List<Coordenada> coordenadasConCriaderos, List<Coordenada> coordenadasConPilones) {
        estado.actualizarListaDeCoordenadasConCriaderosOperativos(coordenada, coordenadasConCriaderos);
    }

    /*@Override
    public void consumirRecursosParaConstruccion(Inventario inventario){
        inventario.consumirMinerales(costoEnMinerales);
    }*/


    /*public void ocupar(Casilla casilla, Terreno terreno){

        terreno.ocuparPorEdificio(this, casilla);
    }*/

    public void ocupar(Terreno terreno){
        terreno.ocuparPorEdificio(this);
    }


    public void actualizar() {
      this.estado.actualizar();
    }

    public void establecerEstado(EstadoCriadero estado){
      this.estado = estado;
      this.estado.setCriadero(this);
    }

    public Criadero terminarConstruccion(){
      return this.estado.terminarConstruccion();
    }

    public Criadero deshacerConstruccion(){
      return this.estado.deshacerConstruccion();
    }

    public void validarCorrelativasDeConstruccion(Inventario inventario) {

    }

    @Override
    public void recibirGolpe(Danio danioTerestre, Danio danioAereo) {}


}
