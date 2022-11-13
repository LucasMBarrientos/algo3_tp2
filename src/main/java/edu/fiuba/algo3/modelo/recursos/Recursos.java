package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.edificios.Edificio;

public abstract class Recursos {

    private int unidadesDisponibles;

    public Recursos(int unidades) {
        this.unidadesDisponibles = unidades;
    }

    public void gastar(Recursos recurso) throws RecursosInsuficientes{
        if(unidadesDisponibles < recurso.devolverCantidadUnidades()){
            throw new RecursosInsuficientes();
        }
        unidadesDisponibles -= recurso.devolverCantidadUnidades();
    }


    public void gastarUnidades(int unidadesAConsumir) throws RecursosInsuficientes{
        if(unidadesDisponibles < unidadesAConsumir){
            throw new RecursosInsuficientes();
        }
        unidadesDisponibles -= unidadesAConsumir;
    }

    public void devolverUnidades(int costoEnMinerales){
        unidadesDisponibles += costoEnMinerales;
    }

    public int devolverCantidadUnidades(){
        return this.unidadesDisponibles;
    }



/*
    private int unidades;

    public Recursos(int unidades) {
        this.unidades = unidades;
    }

    public int devolverUnidades() {
        return this.unidades;
    }

    public int restar(int unidadesAExtraer) {
        int unidadesQueSeExtraeran = unidadesAExtraer;
        if (unidadesAExtraer >= this.unidades) {
            unidadesQueSeExtraeran = this.unidades;
        }
        int unidadesExtraidas = unidadesQueSeExtraeran;
        this.unidades -= unidadesExtraidas;
        return unidadesExtraidas;
    }

    public int restarTodo() {
        int unidadesExtraidas = this.unidades;
        this.unidades = 0;
        return unidadesExtraidas;
    }

    public boolean agotado() {
        return unidades == 0;
    }

    public void agregarUnidades(int nuevasUnidades) {
        unidades += nuevasUnidades;
    }
*/
}
