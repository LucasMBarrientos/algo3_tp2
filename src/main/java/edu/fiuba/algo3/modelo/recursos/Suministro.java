package edu.fiuba.algo3.modelo.recursos;

public class Suministro extends Recurso {
    protected int unidadesMaxima;

    public Suministro(int unidades) {
      super(unidades);
      this.unidadesMaxima = 200;
    }

    public void agregarUnidades(Recurso recurso){
      this.unidadesDisponibles = Math.min(this.unidadesMaxima, this.unidadesDisponibles + recurso.unidadesDisponibles);
  }

}