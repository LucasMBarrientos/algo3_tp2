package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.recursos.Minerales;

public class Pilon extends EdificioProtoss {

    private int tiempoDeConstruccion = 5;
    private Coordenada coordenada;

    public Pilon(Coordenada coordenada) {
    }
    public Pilon() {
        this.costoEnMinerales = new Minerales(100);
    }

    @Override
    public boolean generaTerrenoEnergizado() {
        return true;
    }



    /*
    public Pilon() {
        this.tiempoConstruccion = 5;
        this.requerimientosGas = 0;
        this.requerimientosMinerales = 100;
        this.vida = 300;
        this.escudo = 300;
        this.vidaMax = 300;
        this.escudoMax = 300;
    }

    @Override
    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return casilla.devolverTerreno() instanceof TerrenoEnergizado;
    }

    @Override
    public void actualizar() {
        regenerarEscudo();
    }*/
}
