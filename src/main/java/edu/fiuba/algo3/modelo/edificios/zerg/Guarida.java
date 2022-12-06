package edu.fiuba.algo3.modelo.edificios.zerg;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
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
import edu.fiuba.algo3.modelo.unidades.zerg.*;

public class Guarida extends EdificioZerg {
    
    private Terreno terreno;
    
    public Guarida() {
        this.costoEnMinerales = new Mineral(200);
        this.costoEnGas = new GasVespeno(100);
        this.vida = new Vida(1250);
        this.tiempoDeConstruccion = 12;
        this.nombre = new Nombre("Guarida");
        establecerEstado(this.estadoConstruccion);
    }

    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespenoDelJugador, Mineral mineralDelJugador, Coordenada coordenada) {
        return null;
    }

    public void ocupar(Terreno terreno){
        terreno.ocuparPorEdificio(this);
    }

    public void validarCorrelativasDeConstruccion(Inventario inventario) throws ConstruccionRequiereDeOtroEdificio {
        if(!inventario.tieneEdificio(new Nombre("ReservaDeReproduccion"))){
            throw new ConstruccionRequiereDeOtroEdificio();
        }
    }

    /*public void recibirDanio(Danio danioTerestre, Danio danioAereo) {

    }*/

    public Unidad generarUnidad(Hidralisco unidad,Inventario inventario){
        return estadoActual.generarUnidad(unidad,inventario);
    }
    public Unidad generarUnidad(Zangano unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Zerling unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Mutalisco unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(Scout unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Zealot unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Dragon unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(AmoSupremo unidad, Inventario inventario)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }

    @Override
    public void actualizarEdificio(Inventario inventario) {
      regenerar();
    }

    /*
    public Unidad generarUnidad(Criadero criadero) throws NoHayLarvasDisponibles {
      return estado.generarUnidad(criadero);
    }

    public void recibirDanio(Danio danio) throws EdificioDestruido {
        vida.recibirDanio(danio);
    }
    */

}
