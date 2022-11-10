package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMoho;

public class Criadero extends Edificio implements GeneradorDeUnidades, Actualizable {

    private int larvas;

    public Criadero() {
        this.larvas = 3;
        this.tiempoConstruccion = 4;
        this.requerimientosGas = 0;
        this.requerimientosMinerales = 50;
    }

    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return (casilla.devolverTerreno() instanceof TerrenoMoho);
    }

    public void actualizar() {
        if (larvas < 3) {
            this.larvas++;
        }
    }

    public int devolverCantidadDeLarvas() {
        return this.larvas;
    }

    public void generarUnidad(Casilla casilla) {
        Unidad unidadGenerada = null;
        if (larvas > 0) {
            unidadGenerada = new Zangano();
            this.larvas--;
             casilla.establecerUnidad(unidadGenerada);
        }
    }
    
}
