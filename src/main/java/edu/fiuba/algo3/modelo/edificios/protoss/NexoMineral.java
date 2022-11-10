package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.TieneRecursos;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.recursos.Recursos;

public class NexoMineral extends Edificio implements TieneRecursos {


    private Boolean recursosRecolectados = false;

    public NexoMineral() {
        this.tiempoConstruccion = 4;
        this.requerimientosGas = 0;
        this.requerimientosMinerales = 50;
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
