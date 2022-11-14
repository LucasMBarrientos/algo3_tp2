package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class Espiral extends EdificioZerg {

    private EstadoEspiral estado = new EspiralEnConstruccion();

    private int tiempoDeConstruccion = 10;

    private Recursos costoEnGas;

    private Coordenada coordenada;
    private final Vida vida = new Vida(300);

    public Espiral() {
        this.costoEnMinerales = new Minerales(150);
        this.costoEnGas = new GasVespeno(100);
    }

    public Espiral(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public Unidad generarUnidad(Criadero criadero) throws NoHayLarvasDisponibles {
        return estado.generarUnidad(criadero);
    }

    @Override
    public void consumirRecursosParaConstruccion(Inventario inventario){
        inventario.consumirMinerales(costoEnMinerales);
        inventario.consumirGasVespeno(costoEnGas);
    }

    public void ocupar(Casilla casilla, Terreno terreno){
        terreno.ocuparPorEdificio(this, casilla);
    }

    public void actualizar(Inventario inventario) {
        estado.actualizar();
        tiempoDeConstruccion--;
        if (tiempoDeConstruccion == 0) {
            estado = new EspiralOperativa();
        }
        vida.regenerar();
    }

    public void actualizar() {
        estado.actualizar();
        tiempoDeConstruccion--;
        if (tiempoDeConstruccion == 0) {
            estado = new EspiralOperativa();
        }
        vida.regenerar();
    }

/*
    public Espiral() {
        this.tiempoConstruccion = 10;
        this.requerimientosGas = 100;
        this.requerimientosMinerales = 150;
    }

    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return true;
    }

    public void actualizar() {
        regenerarVida();
    }*/
    
}
