package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.edificios.Edificio;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    public int unidadesGas = 100, unidadesMineral = 100;


    public int devolverCantidadGas(){
        return unidadesGas;
    }

    public int devolverCantidadMinerales(){
        return unidadesMineral;
    }

    public void agregarGas(int cantidadGas){
        unidadesGas += cantidadGas;
    }

    public void agregarMinerales(int cantidadMinerales){
        unidadesMineral += cantidadMinerales;
    }



}
