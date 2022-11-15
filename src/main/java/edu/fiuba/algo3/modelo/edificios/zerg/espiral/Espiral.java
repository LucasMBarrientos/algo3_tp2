package edu.fiuba.algo3.modelo.edificios.zerg.espiral;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.guarida.Guarida;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.EdificioDestruido;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMoho;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class Espiral extends EdificioZerg {
    private EstadoEspiral estado;
    Terreno terreno;

    public Espiral() {
        this.costoEnMinerales = new Minerales(150);
        this.costoEnGas = new GasVespeno(100);
        this.posiblesTerrenos = List.of(new TerrenoMoho());
        this.edificiosNecesarios = List.of(new Guarida());
        this.vida = new Vida(300);
        this.tiempoDeConstruccion = 10;
        setState(new EspiralEnConstruccion());
    }

    public void ocupar(Casilla casilla, Terreno terreno){
      terreno.ocuparPorEdificio(this, casilla);
      this.terreno = terreno;
    }
    
    public void actualizar() {
      this.estado.actualizar();
    }

    @Override
    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespenoDelJugador, Minerales mineralesDelJugador) {
        return estado.generarUnidad(edificioConLarvas , gasVespenoDelJugador, mineralesDelJugador);
    }

    public void setState(EstadoEspiral estado){
      this.estado = estado;
      this.estado.setEspiral(this);
    }
  
    public Espiral terminarConstruccion(){
      return this.estado.terminarConstruccion();
    }
  
    public Espiral deshacerConstruccion(){
      return this.estado.deshacerConstruccion();
    }


    public void recibirGolpe(Danio danio) throws EdificioDestruido {
        vida.recibirDanio(danio);
    }
    

}
