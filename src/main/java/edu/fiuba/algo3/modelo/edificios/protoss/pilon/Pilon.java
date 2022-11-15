package edu.fiuba.algo3.modelo.edificios.protoss.pilon;

import java.util.List;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.EdificioDestruido;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoEnergizado;

public class Pilon extends EdificioProtoss {
    private EstadoPilon estado;

    public Pilon() {
        this.costoEnMinerales = new Minerales(100);
        this.posiblesTerrenos = List.of(new TerrenoEnergizado());
        this.edificiosNecesarios = List.of();
        this.tiempoDeConstruccion = 5;
        this.vida = new Vida(300);
        this.escudo = new Escudo(300);
        setState(new PilonEnConstruccion());
    }

    public void actualizar() {
        this.estado.actualizar();
    }

    public void setState(EstadoPilon estado){
      this.estado = estado;
      this.estado.setPilon(this);
    }

    public Pilon terminarConstruccion(){
      return this.estado.terminarConstruccion();
    }

    public Pilon deshacerConstruccion(){
      return this.estado.deshacerConstruccion();
    }
  
    public boolean generaTerrenoEnergizado() {
      return estado.generaTerrenoEnergizado();
    }

    public void recibirGolpe(Danio danio) throws EdificioDestruido {
        int escudoRestante;
        escudoRestante = escudo.recibirDanio(danio);
        if(escudoRestante < 0){
            vida.recibirDanio(new Danio(escudoRestante * (-1)));
        }
    }

    public void ocupar(Casilla casilla, Terreno terreno){
        terreno.ocuparPorEdificio(this, casilla);
    }
}
