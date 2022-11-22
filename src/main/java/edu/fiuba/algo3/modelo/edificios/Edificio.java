package edu.fiuba.algo3.modelo.edificios;

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
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

import java.util.List;

public abstract class Edificio  {
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

    public boolean generaTerrenoEnergizado() {
        return estadoActual.generaTerrenoEnergizado();
    }
    
    public void deshacerConstruccion(){
      this.estadoActual.deshacerConstruccion();
    }

    public Edificio construir(Inventario inventario){
        validarCorrelativasDeConstruccion(inventario);
        consumirRecursosParaConstruccion(inventario);
        return this;
    }
    public Edificio construir(Coordenada coordenada,Inventario inventario) {
        validarCorrelativasDeConstruccion(inventario);
        consumirRecursosParaConstruccion(inventario);
        this.coordenada = coordenada;
        return this;
    }
    public void consumirRecursosParaConstruccion(Inventario inventario) {
        inventario.consumirMinerales(costoEnMinerales);
        inventario.consumirGasVespeno(costoEnGas);
    }

    public void devolverRecursosParaConstruccion(Inventario inventario){
        inventario.devolverMinerales(costoEnMinerales);
        inventario.devolverGasVespeno(costoEnGas);
    }

    public abstract void validarCorrelativasDeConstruccion(Inventario inventario);

    public abstract void ocupar(Terreno terreno);

    public abstract void establecerTerreno(Terreno terreno);

    public void actualizar(Inventario inventario) {
      this.estadoActual.actualizar(inventario);
    }

    public abstract void actualizarEdificio(Inventario inventario);

    public void ingresarUnidad(Zangano zangano) {
      estadoActual.ingresarUnidad(zangano);
    }

    public void ingresarUnidadTrabajadora(Zangano zangano){};

    public abstract Unidad generarUnidad(Zerling unidad,Inventario inventario);
    public abstract Unidad generarUnidad(Zangano unidad,Inventario inventario);
    public abstract Unidad generarUnidad(Hidralisco unidad,Inventario inventario);
    public abstract Unidad generarUnidad(Mutalisco unidad,Inventario inventario);
    public abstract Unidad generarUnidad(Scout unidad,Inventario inventario);
    public abstract Unidad generarUnidad(Zealot unidad,Inventario inventario);
    public abstract Unidad generarUnidad(Dragon unidad,Inventario inventario);

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

    public void recibirGolpe(Danio danioTerrestre, Danio danioAereo) {
      this.estadoActual.recibirGolpe(danioTerrestre);
    }

    public abstract void ejecutarDanio(Danio danio);

    public abstract void regenerar();

    public boolean validarLarva(){
      return estadoActual.validarLarva();
    }

    public boolean consumirLarva() {
        return false;
    }

    public boolean compararCoordenadas(Coordenada coordenadaAComparar) {
        return coordenada.esIgual(coordenadaAComparar);
    }

    public void actualizarListaDeCoordenadas(List<Coordenada> coordenadasConCriaderos, List<Coordenada> coordenadasConPilones) {
      estadoActual.actualizarListaDeCoordenadasConPilonesOperativos(coordenada, coordenadasConPilones);
    }

}
