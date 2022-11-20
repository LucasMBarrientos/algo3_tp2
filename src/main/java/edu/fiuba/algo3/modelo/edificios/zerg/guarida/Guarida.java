package edu.fiuba.algo3.modelo.edificios.zerg.guarida;

import java.util.List;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.ConstruccionRequiereDeOtroEdificio;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoConoceEstaUnidad;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMoho;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

public class Guarida extends EdificioZerg {

    private EstadoGuarida estado;
    private Terreno terreno;
    
    public Guarida() {
        this.costoEnMinerales = new Mineral(200);
        this.costoEnGas = new GasVespeno(100);
        this.vida = new Vida(1250);
        this.tiempoDeConstruccion = 12;
        establecerEstado(new GuaridaEnConstruccion());
    }

    public void actualizar() {
        this.estado.actualizar();
    }

    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespenoDelJugador, Mineral mineralDelJugador, Coordenada coordenada) {
        return null;
    }

    public void ocupar(Terreno terreno){
        terreno.ocuparPorEdificio(this);
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

    public void validarCorrelativasDeConstruccion(Inventario inventario) throws ConstruccionRequiereDeOtroEdificio {
        if(!inventario.tieneEdificio(new Nombre("ReservaDeReproduccion"))){
            throw new ConstruccionRequiereDeOtroEdificio();
        }
    }

    public void recibirGolpe(Danio danioTerestre, Danio danioAereo) {

    }

    public Unidad generarUnidad(Hidralisco unidad){
        return estado.generarUnidad(unidad);
    }
    public Unidad generarUnidad(Zangano unidad) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Zerling unidad)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Mutalisco unidad)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(Scout unidad) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Zealot unidad) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Dragon unidad)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
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
