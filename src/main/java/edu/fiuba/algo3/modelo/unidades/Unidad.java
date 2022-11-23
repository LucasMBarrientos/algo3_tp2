package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.AtaqueImposibleDeRealizarse;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public abstract class Unidad {

    protected Recurso costoEnMinerales;
    protected Recurso costoEnGas;    
    protected Recurso costoSuministro;
    protected int tiempoConstruccion = 1;
    protected Coordenada coordenada;
    protected Danio danioAereo = new Danio(0);
    protected Danio danioTerrestre = new Danio(0);
    protected int rango = 0;
    protected Vida vida;
    protected EstadoUnidad estado = new UnidadEnConstruccion();
    protected Nombre nombre;
    protected boolean aerea = false;

    public boolean compararCoordenadas(Coordenada coordenadaAComparar) {
        return coordenada.esIgual(coordenadaAComparar);
    }

    public void actualizar(Inventario inventario) {
      this.estado.actualizar(inventario);
    }

    public abstract void actualizarUnidad(Inventario inventario);

    public abstract void regenerar();

    public void establecerEstado(EstadoUnidad estado){
      this.estado = estado;
      this.estado.setUnidad(this);
    }

    public boolean reducirTiempoConstruccion(int tiempoAReducir) {
      if (this.tiempoConstruccion-tiempoAReducir > 0) {
        this.tiempoConstruccion = this.tiempoConstruccion-tiempoAReducir;
        return false;
      } else {
          return true;
      }
    }

    public void terminarConstruccion(){
      this.estado.terminarConstruccion();
    }
    

    public void establecerCoordenada(Coordenada coordenada){
        this.coordenada = coordenada;
    }

    public void moverse(Direccion direccion, Mapa mapa) {
        estado.moverse(direccion,mapa, coordenada);
    }

    public void atacar(Coordenada objetivo, Mapa mapa) {
        estado.atacar(objetivo, mapa);
    }

    public abstract void ejecutarAtaque(Coordenada objetivo, Mapa mapa);

    public void intentarOcuparAlMoverse(Terreno terreno){    }

    public void recibirDanio(Danio danioTerrestre, Danio danioAereo) {
        this.estado.recibirDanio(danioTerrestre, danioAereo);
    }
    
    public abstract void ejecutarDanio(Danio danio, Danio danioAereo);

    public void extraerRecursos(Inventario inventario){}

    public abstract Unidad generarse(Edificio edificio, Inventario inventario);

    public abstract boolean ocupar(Terreno terreno);

    public Nombre devolverNombre(){
        return nombre;
    }

    public abstract void consumirRecursosParaGenerarse(Inventario inventario);
    public void devolverSuministro(Inventario inventario){
      inventario.agregarSuministro(costoSuministro);
    }
    public void restaurarRecursosParaConstruccion(Inventario inventario){
        inventario.devolverMinerales(costoEnMinerales);
        inventario.devolverGasVespeno(costoEnGas);
    }
}
