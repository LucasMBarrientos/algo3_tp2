package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.terrenos.TerrenoEnergizado;

public class Pilon extends Edificio {

    public Pilon(){
        tiempoConstruccion = 5;
        this.requerimientosGas = 0;
        this.requerimientosMinerales = 100;
    }

    @Override
    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return casilla.devolverTerreno() instanceof TerrenoEnergizado;
    }

    @Override
    public void actualizar() {

    }
}
