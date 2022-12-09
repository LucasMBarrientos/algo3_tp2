package edu.fiuba.algo3.modelo.jugadores;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Nombre;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoEncontrado;
import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoAlcanzado;
import edu.fiuba.algo3.modelo.excepciones.NoHayLarvasSuficientes;
import edu.fiuba.algo3.modelo.excepciones.NoHaySuministrosSuficientes;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.excepciones.UnidadNoEncontrada;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Edificio> edificios = new ArrayList<Edificio>();
    private List<Unidad> unidades = new ArrayList<Unidad>();
    public GasVespeno gasVespeno;
    public Mineral mineral;
    public Suministro suministro;
    
    public Inventario(GasVespeno gasVespeno, Mineral mineral, Suministro suministro) {
        this.gasVespeno = gasVespeno;
        this.mineral = mineral;
        this.suministro = suministro;
    }

    public void fueDerrotado(boolean edificioInicialConstruido) {
        if (edificioInicialConstruido && this.edificios.size() == 0) {
            throw new FinDelJuegoAlcanzado();
        }
    }

    public Edificio buscarEdificio(Coordenada coordenada) {
        return edificios.get(buscarIdDeEdificio(coordenada));
    }

    public Unidad buscarUnidad(Coordenada coordenada) {
        return unidades.get(buscarIdDeUnidad(coordenada));
    }

    private int buscarIdDeUnidad(Coordenada coordenada) throws UnidadNoEncontrada {
        int indiceHallado = -1;
        for (int i = 0; i < this.unidades.size(); i++) {
            if (this.unidades.get(i).compararCoordenadas(coordenada)) {
                indiceHallado = i;
            }
        }
        if (indiceHallado == -1) {
            throw new UnidadNoEncontrada();
        }
        return indiceHallado;
    }

    private int buscarIdDeEdificio(Coordenada coordenada) throws EdificioNoEncontrado {
        int indiceHallado = -1;
        for (int i = 0; i < this.edificios.size(); i++) {
            if (this.edificios.get(i).compararCoordenadas(coordenada)) {
                indiceHallado = i;
            }
        }
        if (indiceHallado == -1) {
            throw new EdificioNoEncontrado();
        }
        return indiceHallado;
    }

    public boolean tieneEdificio(Nombre nombreDelEdifico) {
        boolean edificioHallado = false;
        for (Edificio edificio : edificios) {
            edificioHallado = edificioHallado || nombreDelEdifico.esIgual(edificio.devolverNombre());
        }
        return edificioHallado;
    }

    public void consumirLarva(){
        for(Edificio edificio : edificios){
            if(edificio.consumirLarva()){
                return;
            }
        }
        throw new NoHayLarvasSuficientes();
    }


    public void evolucionarUnidad(Coordenada coordenada, Unidad unidadAEvolucionar) {
        Unidad unidadGenerada = buscarUnidad(coordenada).evolucionar(unidadAEvolucionar);
        this.unidades.set(buscarIdDeUnidad(coordenada), unidadGenerada);
    }


    public void agregarEdificio(Edificio edificioNuevo) {
        edificios.add(edificioNuevo);
    }

    public void agregarUnidad(Unidad unidadNueva) {
        unidades.add(unidadNueva);
    }

    public void eliminarUnidad(Coordenada coordenada) {
        int indiceHallado = buscarIdDeUnidad(coordenada);
        unidades.get(indiceHallado).devolverSuministro(this);
        unidades.remove(unidades.get(indiceHallado));
    }

    public void eliminarEdificio(Coordenada coordenada) {
        int indiceHallado = buscarIdDeEdificio(coordenada);
        edificios.get(indiceHallado).restarSuministros(this);
        edificios.remove(edificios.get(indiceHallado));
    }

    public void agregarSuministro(Recurso suministro) {
        this.suministro.agregarUnidades(suministro);
    }

    public void agregarGasVespeno(Recurso gasVespeno) {
        this.gasVespeno.agregarUnidades(gasVespeno);
    }

    public void agregarMinerales(Recurso minerales) {
        this.mineral.agregarUnidades(minerales);
    }

    public void consumirSuministro(Recurso recursoRequerido) {
      try {            
          suministro.gastar(recursoRequerido);
      } catch (RecursosInsuficientes e) {
          throw new NoHaySuministrosSuficientes();
      }
    }

    public void restarSuministro(Recurso recursoRequerido) {
      suministro.restarUnidades(recursoRequerido);
  }

    public void consumirGasVespeno(Recurso recursoRequerido) {
        gasVespeno.gastar(recursoRequerido);
    }

    public void consumirMinerales(Recurso recursoRequerido) {
        mineral.gastar(recursoRequerido);
    }

    public void devolverGasVespeno(Recurso recursoUtilizado) {
        gasVespeno.agregarUnidades(recursoUtilizado);
    }

    public void devolverMinerales(Recurso recursoUtilizado) {
        mineral.agregarUnidades(recursoUtilizado);
    }

    public ObjectNode toData() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("edificios", edificios.size());
        nodo.put("unidades", unidades.size());
        nodo.put("cantidadGasVespeno", gasVespeno.toData());
        nodo.put("cantidadMineral", mineral.toData());
        nodo.put("suministroActual", suministro.toData());
        return nodo;
    }


    public void actualizar() {
        for(int i = 0;i<this.edificios.size();i++) {
            edificios.get(i).actualizar(this);
        }
        for(int i = 0;i<this.unidades.size();i++){
            unidades.get(i).actualizar(this);
        }
    }

}
