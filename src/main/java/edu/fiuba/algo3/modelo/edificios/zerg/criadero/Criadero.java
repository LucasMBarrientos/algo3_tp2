package edu.fiuba.algo3.modelo.edificios.zerg.criadero;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMoho;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public class Criadero extends EdificioZerg {
    private EstadoCriadero estado;
    Terreno terreno;

    public Criadero() {
        this.costoEnMinerales = new Minerales(50);
        this.posiblesTerrenos = List.of(new TerrenoMoho());
        this.edificiosNecesarios = List.of();
        this.tiempoDeConstruccion = 4;
        this.vida = new Vida(300);
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
    
    @Override
    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespenoDelJugador, Minerales mineralesDelJugador, Coordenada coordenada) {
        return estado.generarUnidad(new Zangano(gasVespenoDelJugador, mineralesDelJugador, coordenada));
    }


    public void ocupar(Casilla casilla, Terreno terreno){
      terreno.ocuparPorEdificio(this, casilla);
      this.terreno = terreno;
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

    @Override
    public void recibirGolpe(Danio danioTerestre, Danio danioAereo) {

    }
}
