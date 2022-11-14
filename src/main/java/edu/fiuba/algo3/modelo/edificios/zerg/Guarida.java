package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public class Guarida extends EdificioZerg {

    private EstadoGuarida estado = new GuaridaEnConstruccion();
    private int tiempoDeConstruccion = 12;
    private Recursos costoEnGas;
    private Coordenada coordenada;

    public Guarida() {
        this.costoEnMinerales = new Minerales(200);
        this.costoEnGas = new GasVespeno(100);
    }
    public Guarida(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public Unidad generarUnidad(Criadero criadero) throws NoHayLarvasDisponibles {
        return estado.generarUnidad(criadero);
    }
    public void actualizar() {
        estado.actualizar();
        tiempoDeConstruccion--;
        if (tiempoDeConstruccion == 0) {
            estado = new GuaridaOperativa();
        }
    }
    @Override
    public void consumirRecursosParaConstruccion(Inventario inventario){
        inventario.consumirMinerales(costoEnMinerales);
        inventario.consumirGasVespeno(costoEnGas);
    }

    public void ocupar(Casilla casilla, Terreno terreno){
        terreno.ocuparPorEdificio(this, casilla);
    }

    public void actualizar(Inventario inventario){}

/*
    public Guarida() {
        this.tiempoConstruccion = 12;
        this.requerimientosGas = 100;
        this.requerimientosMinerales = 200;
    }

    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return true;
    }

    public void actualizar() {
        regenerarVida();
    }*/
}
