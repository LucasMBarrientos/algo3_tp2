package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoEnergizado;
import edu.fiuba.algo3.modelo.Casilla;

public class PuertoEstelar extends EdificioProtoss {

    private Recursos costoEnGas;

    public PuertoEstelar(){
        this.costoEnMinerales = new Minerales(150);
        this.costoEnGas = new GasVespeno(150);
    }

    @Override
    public void consumirRecursosParaConstruccion(Inventario inventario){
        inventario.consumirMinerales(costoEnMinerales);
        inventario.consumirGasVespeno(costoEnGas);
    }

    public void ocupar(Casilla casilla, Terreno terreno){
        //terreno.ocuparPorEdificio(this, casilla);
    }
/*
    public PuertoEstelar() {
        this.tiempoConstruccion = 10;
        this.requerimientosGas = 150;
        this.requerimientosMinerales = 150;
        this.vida = 600;
        this.escudo = 600;
        this.vidaMax = 600;
        this.escudoMax = 600;
    }

    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return casilla.devolverTerreno() instanceof TerrenoEnergizado;
    }

    public void actualizar() {
        regenerarEscudo();
    }*/
}
