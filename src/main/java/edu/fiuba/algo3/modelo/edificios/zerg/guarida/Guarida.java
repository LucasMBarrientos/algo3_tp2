package edu.fiuba.algo3.modelo.edificios.zerg.guarida;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMoho;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class Guarida extends EdificioZerg {

    private EstadoGuarida estado;
    private Terreno terreno;
    
    public Guarida() {
        this.costoEnMinerales = new Minerales(200);
        this.costoEnGas = new GasVespeno(100);
        this.posiblesTerrenos = List.of(new TerrenoMoho());
        this.edificiosNecesarios = List.of();
        this.vida = new Vida(1250);
        this.tiempoDeConstruccion = 12;
        establecerEstado(new GuaridaEnConstruccion());
    }

    public void actualizar() {
        this.estado.actualizar();
    }

    @Override
    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespenoDelJugador, Minerales mineralesDelJugador, Coordenada coordenada) {
        return null;
    }

    @Override
    public void recibirGolpe(Danio danioTerestre, Danio danioAereo) {

    }

    public void ocupar(Casilla casilla, Terreno terreno){
        terreno.ocuparPorEdificio(this, casilla);
        this.terreno = terreno;
    }

    public void establecerEstado(EstadoGuarida estado){
        this.estado = estado;
        this.estado.establecerGuarida(this);
    }
  
    public Guarida terminarConstruccion(){
        return this.estado.terminarConstruccion();
    }
  
    public Guarida deshacerConstruccion(){
        return this.estado.deshacerConstruccion();
    }

    /*
    public Unidad generarUnidad(Criadero criadero) throws NoHayLarvasDisponibles {
      return estado.generarUnidad(criadero);
    }

    public void recibirGolpe(Danio danio) throws EdificioDestruido {
        vida.recibirDanio(danio);
    }
    */

}
