package edu.fiuba.algo3.modelo.edificios.protoss.nexoMineral;

import java.util.List;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMineral;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class NexoMineral extends EdificioProtoss {
    private EstadoNexoMineral estado;

    public NexoMineral(){
        this.costoEnMinerales = new Mineral(50);
        this.costoEnGas = new GasVespeno(0);
        this.tiempoDeConstruccion = 4;
        this.vida = new Vida(300);
        this.escudo = new Escudo(300);
        this.nombre = new Nombre("NexoMineral");
        establecerEstado(new NexoMineralEnConstruccion());
    }

    public void ocupar(Terreno terreno){
        terreno.ocuparPorEdificio(this);
        this.terreno= terreno;
    }

    @Override
    public void recibirGolpe(Danio danioTerestre, Danio danioAereo) {
        int escudoRestante;
        escudoRestante = escudo.recibirDanio(danioTerestre);
        if(escudoRestante < 0){
            vida.recibirDanio(new Danio(escudoRestante * (-1)));
        }
    }

    public void actualizar() {
      this.estado.actualizar();
    }

    @Override
    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Mineral mineral, Coordenada coordenada) {
        return null;
    }

    public void establecerEstado(EstadoNexoMineral estado){
      this.estado = estado;
      this.estado.setNexoMineral(this);
    }

    public NexoMineral terminarConstruccion(){
      return this.estado.terminarConstruccion();
    }

    public NexoMineral deshacerConstruccion(){
      return this.estado.deshacerConstruccion();
    }

    //TODO: REVISAR
    public void recolectarRecursos(Inventario inventario) {
      estado.recolectarRecursos(terreno, inventario);
  }

    public void validarCorrelativasDeConstruccion(Inventario inventario){

    }
}
