package edu.fiuba.algo3.modelo.unidades;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Nombre;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.AtaqueImposibleDeRealizarse;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.excepciones.InvalidaEvolucionDeUnidad;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.estados.EstadoUnidad;
import edu.fiuba.algo3.modelo.unidades.estados.UnidadEnConstruccion;
import edu.fiuba.algo3.modelo.unidades.modificadores.Invisible;
import edu.fiuba.algo3.modelo.unidades.modificadores.Visibilidad;

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
    protected int cantidadDeKills = 0;
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

    public void establecerVisibilidad(Visibilidad visibilidad){ }

    public boolean reducirTiempoConstruccion(int tiempoAReducir) {
      if (this.tiempoConstruccion-tiempoAReducir > 0) {
        this.tiempoConstruccion = this.tiempoConstruccion-tiempoAReducir;
        return false;
      } else {
          return true;
      }
    }

    public abstract ObjectNode toData();

    public void terminarConstruccion(){
      this.estado.terminarConstruccion();
    }

    public void establecerCoordenada(Coordenada coordenada){
        this.coordenada = coordenada;
    }

    public void moverse(Direccion direccion) {
        estado.moverse(direccion, coordenada);
    }

    public void atacar(Coordenada objetivo) {
        estado.atacar(objetivo);
    }


    public void recibirDanio(Danio danioTerrestre, Danio danioAereo) {
        this.estado.recibirDanio(danioTerrestre, danioAereo);
    }
    
    public abstract void ejecutarDanio(Danio danio, Danio danioAereo);

    public void ejecutarAtaque(Coordenada objetivo) {
        if (coordenada.seEncuentraACiertoRangoDeOtraCoordenada(objetivo, rango)) {
            try {
                Mapa.devolverInstancia().buscarTerreno(objetivo).recibirDanio(danioTerrestre,danioAereo);
            }catch (UnidadEstaDestruida e){
                cantidadDeKills++;
                volverInvisible();
                Mapa.devolverInstancia().eliminarUnidad(objetivo);
                throw new UnidadEstaDestruida();
            }catch (EdificioEstaDestruido u){
                Mapa.devolverInstancia().eliminarEdificio(objetivo);
                cantidadDeKills++;
                volverInvisible();
                throw new EdificioEstaDestruido();
            }
        } else {
            throw new AtaqueImposibleDeRealizarse();
        }

    }

    public void volverInvisible(){
        if(cantidadDeKills >= 3){
            establecerVisibilidad(new Invisible()); //todas las unidades lo entienden pero solo el zealot lo hace
        }
    }

    public Nombre devolverNombre(){
        return nombre;
    }

    public abstract void consumirRecursosParaGenerarse(Inventario inventario);
    public void devolverSuministro(Inventario inventario){
      inventario.agregarSuministro(costoSuministro);
    }
    public void restaurarRecursosParaConstruccion(Inventario inventario) {
        inventario.devolverMinerales(costoEnMinerales);
        inventario.devolverGasVespeno(costoEnGas);
        inventario.agregarSuministro(costoSuministro);
    }

    public Unidad evolucionar(Unidad unidad) {
        throw new InvalidaEvolucionDeUnidad();
    }

    public void destruirse(Inventario inventario) {
        inventario.eliminarUnidad(coordenada);
    }

    public void agregarSuministro(Inventario inventario) {
    }

    public void extraerRecursos(Inventario inventario){
        return;
    }

    public abstract Unidad generarse(Edificio edificio, Inventario inventario);

    public abstract boolean ocupar(Terreno terreno);

}
