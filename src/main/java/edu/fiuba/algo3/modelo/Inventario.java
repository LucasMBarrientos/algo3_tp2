package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.recursos.Recursos;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    public Recursos unidadesGas = new Recursos(100), unidadesMineral = new Recursos(100);

    public int devolverCantidadGas(){
        return unidadesGas.devolverUnidades();
    }

    public int devolverCantidadMinerales(){
        return unidadesMineral.devolverUnidades();
    }

    public void agregarGas(int cantidadGas) {
        unidadesGas.agregarUnidades(cantidadGas);
    }

    public void agregarMinerales(int cantidadMinerales){
        unidadesMineral.agregarUnidades(cantidadMinerales);
    }

    public void agregarRecursos(Recursos recursos) {
        int nuevasUnidades = recursos.restarTodo();
        if (recursos instanceof GasVespeno) {
            unidadesGas.agregarUnidades(nuevasUnidades);
        } else if (recursos instanceof Minerales) {
            unidadesMineral.agregarUnidades(nuevasUnidades);
        }
    }

}
