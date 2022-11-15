package edu.fiuba.algo3.modelo.edificios.protoss.puertoEstelar;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.edificios.protoss.acceso.Acceso;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoEnergizado;
import java.util.List;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class PuertoEstelar extends EdificioProtoss {

    private EstadoPuertoEstelar estado = new PuertoEstelarEnConstruccion();

    public PuertoEstelar(){
        this.costoEnMinerales = new Minerales(150);
        this.costoEnGas = new GasVespeno(150);
        this.posiblesTerrenos = List.of(new TerrenoEnergizado());
        this.edificiosNecesarios = List.of(new Acceso());;
        this.tiempoDeConstruccion = 10;
        this.vida = new Vida(600);
        this.escudo = new Escudo(600);
    }

    public void ocupar(Casilla casilla, Terreno terreno){
        terreno.ocuparPorEdificio(this, casilla);
    }

    public void actualizar() {
      this.estado.actualizar();
    }

    public void setState(EstadoPuertoEstelar estado){
      this.estado = estado;
      this.estado.setPuertoEstelar(this);
    }

    public PuertoEstelar terminarConstruccion(){
      return this.estado.terminarConstruccion();
    }

    public PuertoEstelar deshacerConstruccion(){
      return this.estado.deshacerConstruccion();
    }

    public Unidad generarUnidad(Unidad unidad) {
      return estado.generarUnidad(unidad);
    }
}
