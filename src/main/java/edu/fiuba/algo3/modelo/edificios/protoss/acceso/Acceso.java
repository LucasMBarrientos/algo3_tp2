package edu.fiuba.algo3.modelo.edificios.protoss.acceso;

import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;

import java.util.List;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoEnergizado;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class Acceso extends EdificioProtoss {
    private EstadoAcceso estado;
    public Acceso(){
        this.costoEnMinerales = new Minerales(150);
        this.posiblesTerrenos = List.of(new TerrenoEnergizado());
        this.edificiosNecesarios = List.of();
        this.tiempoDeConstruccion = 8;
        this.vida = new Vida(500);
        this.escudo = new Escudo(500);
        setState(new AccesoEnConstruccion());
    }

    public void ocupar(Casilla casilla, Terreno terreno){
        terreno.ocuparPorEdificio(this, casilla);
    }

    public void setState(EstadoAcceso estado){
      this.estado = estado;
      this.estado.setAcceso(this);
    }

    public Unidad generarUnidad(Unidad unidad) {
        return estado.generarUnidad(unidad);
    }

    public void actualizar() {
      this.estado.actualizar();
    }
}
