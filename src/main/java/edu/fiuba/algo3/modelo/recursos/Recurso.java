package edu.fiuba.algo3.modelo.recursos;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;

public abstract class Recurso {

    protected int unidadesDisponibles;

    public Recurso(int unidades) {
        this.unidadesDisponibles = unidades;
    }

    public void gastar(Recurso recurso) throws RecursosInsuficientes {
        if(unidadesDisponibles < recurso.devolverCantidadUnidades()){
            throw new RecursosInsuficientes();
        }
        unidadesDisponibles -= recurso.devolverCantidadUnidades();
    }

    public void agregarUnidades(Recurso recurso){
        unidadesDisponibles += recurso.devolverCantidadUnidades();
    }

    public void restarUnidades(Recurso recurso){
      unidadesDisponibles -= recurso.devolverCantidadUnidades();
  }

    public void gastarUnidades(int unidadesAConsumir) throws RecursosInsuficientes{
        if(unidadesDisponibles < unidadesAConsumir){
            throw new RecursosInsuficientes();
        }
        unidadesDisponibles -= unidadesAConsumir;
    }

    private int devolverCantidadUnidades(){
        return this.unidadesDisponibles;
    }

    public abstract ObjectNode toData();

}
