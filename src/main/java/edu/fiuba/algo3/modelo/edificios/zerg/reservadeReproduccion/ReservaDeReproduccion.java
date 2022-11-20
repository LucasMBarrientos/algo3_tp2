package edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion;

import java.util.List;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.NoHayLarvasSuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMoho;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class ReservaDeReproduccion extends EdificioZerg {
    private EstadoReservaDeReproduccion estado;
    Terreno terreno;

    public ReservaDeReproduccion() {
        this.costoEnMinerales = new Mineral(150);
        this.costoEnGas = new GasVespeno(0);
        this.vida = new Vida(1000);
        this.tiempoDeConstruccion = 12;
        this.nombre = new Nombre("ReservaDeReproduccion");
        establecerEstado(new ReservaDeReproduccionEnConstruccion());
    }

    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespenoDelJugador, Mineral mineralDelJugador, Coordenada coordenada) throws NoHayLarvasSuficientes {
        return estado.generarUnidad(edificioConLarvas, gasVespenoDelJugador, mineralDelJugador, coordenada);
    }

    public void actualizar() {
      this.estado.actualizar();
    }

    public void ocupar(Terreno terreno){
        terreno.ocuparPorEdificio(this);
    }

    public void establecerEstado(EstadoReservaDeReproduccion estado){
        this.estado = estado;
        this.estado.establecerReservaDeReproduccion(this);
    }
  
    public ReservaDeReproduccion terminarConstruccion(){
      return this.estado.terminarConstruccion();
    }
  
    public ReservaDeReproduccion deshacerConstruccion(){
      return this.estado.deshacerConstruccion();
    }

    public void validarCorrelativasDeConstruccion(Inventario inventario) { }

    public void recibirGolpe(Danio danioTerestre, Danio danioAereo) {
    }

    /*
    public void recibirGolpe(Danio danio) throws EdificioDestruido {
        vida.recibirDanio(danio);
    }
    */

}
