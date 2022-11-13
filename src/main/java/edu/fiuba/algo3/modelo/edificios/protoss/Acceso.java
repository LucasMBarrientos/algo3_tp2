package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public class Acceso extends EdificioProtoss {

    public Acceso(){
        this.costoEnMinerales = new Minerales(150);
    }

    public void ocupar(Casilla casilla, Terreno terreno){
        terreno.ocuparPorEdificio(this, casilla);
    }

/*
    public Acceso() {
        this.tiempoConstruccion = 8;
        this.requerimientosGas = 0;
        this.requerimientosMinerales = 150;
        this.vida = 500;
        this.escudo = 500;
        this.vidaMax = 500;
        this.escudoMax = 500;
    }

    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return true;
    }

    public void actualizar() {
        regenerarEscudo();
    }
*/
}
