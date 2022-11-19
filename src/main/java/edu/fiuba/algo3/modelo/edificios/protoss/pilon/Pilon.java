package edu.fiuba.algo3.modelo.edificios.protoss.pilon;

import java.util.List;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.EdificioDestruido;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoEnergizado;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class Pilon extends EdificioProtoss {
    private EstadoPilon estado;

    public Pilon() {
        this.costoEnMinerales = new Mineral(100);
        this.tiempoDeConstruccion = 5;
        this.vida = new Vida(300);
        this.escudo = new Escudo(300);
        this.nombre = new Nombre("Pilon");
        establecerEstado(new PilonEnConstruccion());
    }

    public void actualizar() {
        this.estado.actualizar();
    }

    @Override
    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Mineral mineral, Coordenada coordenada) {
        return null;
    }

    public void establecerEstado(EstadoPilon estado){
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


    @Override
    public void recibirGolpe(Danio danioTerestre, Danio danioAereo) {
        int escudoRestante;
        escudoRestante = escudo.recibirDanio(danioTerestre);
        if(escudoRestante < 0){
            vida.recibirDanio(new Danio(escudoRestante * (-1)));
        }
    }

    public void ocupar(Terreno terreno){
        terreno.ocuparPorEdificio(this);
    }


    public void validarCorrelativasDeConstruccion(Inventario inventario){

    }
}
