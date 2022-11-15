package edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMoho;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class ReservaDeReproduccion extends EdificioZerg {
    private EstadoReserva estado;
    Terreno terreno;

    public ReservaDeReproduccion() {
        this.costoEnMinerales = new Minerales(150);
        this.posiblesTerrenos = List.of(new TerrenoMoho());
        this.edificiosNecesarios = List.of();
        this.vida = new Vida(1000);
        this.tiempoDeConstruccion = 12;
        setState(new ReservaEnConstruccion());
    }

    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespenoDelJugador, Minerales mineralesDelJugador) throws NoHayLarvasDisponibles {
        return estado.generarUnidad(edificioConLarvas,  gasVespenoDelJugador,  mineralesDelJugador);
    }
    public void actualizar() {
      this.estado.actualizar();
    }

    public void ocupar(Casilla casilla, Terreno terreno){
      terreno.ocuparPorEdificio(this, casilla);
      this.terreno = terreno;
    }

    public void setState(EstadoReserva estado){
      this.estado = estado;
      this.estado.setReserva(this);
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
