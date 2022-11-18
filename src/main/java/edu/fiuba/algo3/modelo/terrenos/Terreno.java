package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;

public class Terreno {
    
    private EstadoTerreno estado;
    public GasVespeno gasVespeno;
    public Minerales minerales;

    public Terreno() {
        this.gasVespeno = new GasVespeno(5000);
        this.minerales = new Minerales(2000);
        establecerEstado(new TerrenoVacio());
    }

    public void establecerEstado(EstadoTerreno estado) {
        this.estado = estado;
        this.estado.setTerreno(this);
    }

    public void ocuparPorEdificio(Edificio edificio, Casilla casilla) {
        this.estado.ocuparPorEdificio(edificio,casilla);
    }

    public void vaciarTerreno() {
        this.estado.vaciarTerreno();
    }

    public void energizarTerreno() {
        this.estado.energizarTerreno();
    }

    public void cubrirTerrenoDeMoho() {
        this.estado.cubrirTerrenoDeMoho();
    }

    public void generarVolcan() {
        this.estado.generarVolcan();
    }

    public void generarMina() {
        this.estado.generarMina();
    }

    public EstadoTerreno DEBUGDEVOLVERESTADO() {
        return estado;
    }

}
