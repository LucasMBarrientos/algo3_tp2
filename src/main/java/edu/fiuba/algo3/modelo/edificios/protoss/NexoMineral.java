package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioConRecursos;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.recursos.Recursos;

public class NexoMineral extends Edificio implements EdificioConRecursos {


    private Boolean recursosRecolectados = false;

    public NexoMineral() {
        this.tiempoConstruccion = 4;
    }
    @Override
    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return false;
    }

    @Override
    public void actualizar() {

    }


    public Recursos recolectarRecursos() {
        recursosRecolectados = true;
        return new Minerales(10);
    }


    public boolean tieneRecursos() {
        return !(recursosRecolectados);
    }
}
