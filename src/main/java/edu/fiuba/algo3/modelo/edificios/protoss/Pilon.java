package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.recursos.Recursos;

public class Pilon extends EdificioProtoss {

    private int tiempoDeConstruccion = 5;
    private Coordenada coordenada;

    private int costoEnMinerales = 50;

    public Pilon(Coordenada coordenada) {
        
    }
    public Pilon() {

    }

    public boolean generaTerrenoEnergizado() {
        return true;
    }

    public void consumirRecursos(Recursos recurso){
        recurso.gastarUnidades(costoEnMinerales);
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
