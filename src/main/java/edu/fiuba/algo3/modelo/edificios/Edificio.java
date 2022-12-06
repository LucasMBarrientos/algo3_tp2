package edu.fiuba.algo3.modelo.edificios;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoConoceEstaUnidad;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.EstadoTerreno;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.*;

import java.util.List;

public abstract class Edificio {
    protected EstadoEdificio estadoConstruccion = new EdificioEnConstruccion();
    protected EstadoEdificio estadoDestruido = new EdificioDestruido();
    protected EstadoEdificio estadoOperativo = new EdificioOperativo();
    protected EstadoEdificio estadoActual = estadoConstruccion;
    public Terreno terreno;
    public Recurso costoEnMinerales;
    public Recurso costoEnGas;
    public Vida vida;
    public Nombre nombre;
    public int tiempoDeConstruccion;
    public Coordenada coordenada;
    
    public void deshacerConstruccion() {
        this.estadoActual.deshacerConstruccion();
    }
    public Edificio construir(Coordenada coordenada, Inventario inventario) {
        validarCorrelativasDeConstruccion(inventario);
        consumirRecursosParaConstruccion(inventario);
        this.coordenada = coordenada;
        return this;
    }
    public void consumirRecursosParaConstruccion(Inventario inventario) {
        inventario.consumirMinerales(costoEnMinerales);
        inventario.consumirGasVespeno(costoEnGas);
    }

    public void agregarSuministro(Inventario inventario) {
    }

    public void restarSuministros(Inventario inventario){
    }

    public void devolverRecursosParaConstruccion(Inventario inventario) {
        inventario.devolverMinerales(costoEnMinerales);
        inventario.devolverGasVespeno(costoEnGas);
    }

    public void validarCorrelativasDeConstruccion(Inventario inventario) {
        return;
    }

    public abstract void ocupar(Terreno terreno);

    public abstract void establecerTerreno(Terreno terreno);

    public void actualizar(Inventario inventario) {
      this.estadoActual.actualizar(inventario);
    }

    public abstract void actualizarEdificio(Inventario inventario);

    public void ingresarUnidad(Unidad unidad) {
      estadoActual.ingresarUnidad(unidad);
    }

    public void ingresarUnidadTrabajadora(Unidad unidad) {
        return;
    }

    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Mineral mineral, Coordenada coordenada) {
        return null;
    }

    public Unidad generarUnidad(Scout unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad  {
        throw new EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(Zealot unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(Dragon unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad {
        throw new EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(Zerling unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(Zangano unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(Hidralisco unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad {
        throw new EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(Mutalisco unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad {
        throw new EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(AmoSupremo unidad, Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new EdificioNoConoceEstaUnidad();
    }

    public abstract ObjectNode toData();

    public Nombre devolverNombre(){
        return nombre;
    }

    public void establecerPosicion(Coordenada ubicacion){
        coordenada = ubicacion;
    }

    public boolean reducirTiempoConstruccion(int tiempoAReducir) {
      if (this.tiempoDeConstruccion-tiempoAReducir > 0) {
          this.tiempoDeConstruccion = this.tiempoDeConstruccion-tiempoAReducir;
          return false;
      } else {
          return true;
      }
    }

    public void terminarConstruccion(){
      this.estadoActual.terminarConstruccion();
    }

    public void establecerEstado(EstadoEdificio estado){
      this.estadoActual = estado;
      this.estadoActual.setEdificio(this);
    }

  //  public Unidad generarUnidad(Unidad unidad){
   //     return null; //terminar bien
    //}

    public void recibirDanio(Danio danioTerrestre, Danio danioAereo) {
        this.estadoActual.recibirDanio(danioTerrestre);
    }

    public abstract void ejecutarDanio(Danio danio);

    public abstract void regenerar();

    public boolean consumirLarva() {
        return false;
    }

    public boolean compararCoordenadas(Coordenada coordenadaAComparar) {
        return coordenada.esIgual(coordenadaAComparar);
    }

    public void actualizarListasDeCoordenadas(List<Coordenada> coordenadasConCriaderos, List<Coordenada> coordenadasConPilones) {
        this.estadoActual.actualizarListasDeCoordenadas(coordenadasConCriaderos, coordenadasConPilones);
    }

    public void actualizarListasDeCoordenadasSegunEdificio(List<Coordenada> coordenadasConCriaderos, List<Coordenada> coordenadasConPilones) {
        return;
    }

    

}
