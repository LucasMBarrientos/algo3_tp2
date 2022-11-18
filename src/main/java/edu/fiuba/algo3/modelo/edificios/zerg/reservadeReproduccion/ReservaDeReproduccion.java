package edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.NoHayLarvasSuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMoho;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class ReservaDeReproduccion extends EdificioZerg {
    private EstadoReservaDeReproduccion estado;
    Terreno terreno;

    public ReservaDeReproduccion() {
        this.costoEnMinerales = new Minerales(150);
        this.posiblesTerrenos = List.of(new TerrenoMoho());
        this.edificiosNecesarios = List.of();
        this.vida = new Vida(1000);
        this.tiempoDeConstruccion = 12;
        establecerEstado(new ReservaDeReproduccionEnConstruccion());
    }

    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespenoDelJugador, Minerales mineralesDelJugador, Coordenada coordenada) throws NoHayLarvasSuficientes {
        return estado.generarUnidad(edificioConLarvas, gasVespenoDelJugador, mineralesDelJugador, coordenada);
    }

    public void actualizar() {
      this.estado.actualizar();
    }

    public void ocupar(Casilla casilla, Terreno terreno){
      terreno.ocuparPorEdificio(this, casilla);
      this.terreno = terreno;
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

    /*  
    public void recibirGolpe(Danio danio) throws EdificioDestruido {
        vida.recibirDanio(danio);
    }
    */

}
