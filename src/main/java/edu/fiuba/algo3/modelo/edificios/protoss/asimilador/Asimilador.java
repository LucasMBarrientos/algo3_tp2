package edu.fiuba.algo3.modelo.edificios.protoss.asimilador;

import java.util.List;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class Asimilador extends EdificioProtoss {

    private EstadoAsimilador estado;

    public Asimilador(){
        this.costoEnMinerales = new Minerales(100);
        this.posiblesTerrenos = List.of(new TerrenoVolcan());
        this.edificiosNecesarios = List.of();
        this.tiempoDeConstruccion = 6;
        this.vida = new Vida(450);
        this.escudo = new Escudo(450);
        setState(new AsimiladorEnConstruccion());
    }

    public void ocupar(Casilla casilla, Terreno terreno){
        terreno.ocuparPorEdificio(this, casilla);
        this.terreno = terreno;
    }
    
    //TODO: REVISAR
    public void recolectarRecursos(Inventario inventario) {
        estado.recolectarRecursos(terreno, inventario);
    }

    public void actualizar() {
      this.estado.actualizar();
    }

    @Override
    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespenoDelJugador, Minerales mineralesDelJugador) {
        return null;
    }


    public void setState(EstadoAsimilador estado){
      this.estado = estado;
      this.estado.setAsimilador(this);
    }

    public Asimilador terminarConstruccion(){
      return this.estado.terminarConstruccion();
    }

    public Asimilador deshacerConstruccion(){
      return this.estado.deshacerConstruccion();
    }
}