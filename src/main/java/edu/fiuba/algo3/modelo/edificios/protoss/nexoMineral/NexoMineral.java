package edu.fiuba.algo3.modelo.edificios.protoss.nexoMineral;

import java.util.List;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMineral;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class NexoMineral extends EdificioProtoss {
    private EstadoNexoMineral estado;

    public NexoMineral(){
        this.costoEnMinerales = new Minerales(50);
        this.posiblesTerrenos = List.of(new TerrenoMineral());
        this.edificiosNecesarios = List.of();
        this.tiempoDeConstruccion = 4;
        this.vida = new Vida(300);
        this.escudo = new Escudo(300);
        setState(new NexoMineralEnConstruccion());
    }

    public void ocupar(Casilla casilla, Terreno terreno){
        terreno.ocuparPorEdificio(this, casilla);
        this.terreno= terreno;
    }

    
    public void actualizar() {
      this.estado.actualizar();
    }

    @Override
    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Minerales minerales, Coordenada coordenada) {
        return null;
    }


    public void setState(EstadoNexoMineral estado){
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
}
