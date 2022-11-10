package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMineral;

public class Zangano extends Unidad implements Actualizable, Constructor, TieneRecursos {

    private Construccion construccion;
    private boolean recolectandoMinerales = false;
    private Boolean recursosRecolectados = false;

    public void actualizar() {
        this.actualizarDisponibilidad();
        if (this.construccion != null) {
            boolean construccionTerminada = this.construccion.continuar();
            if (construccionTerminada) {
                this.construccion.finalizar();
            }
        }
        recursosRecolectados = false;
    }

    public boolean intentarMoverse(Casilla nuevaCasilla) {
        if (this.disponible) {
            nuevaCasilla.establecerUnidad(this);            
            if (nuevaCasilla.devolverTerreno() instanceof TerrenoMineral) {
                recolectandoMinerales = true;
            } else {
                recolectandoMinerales = false;
            }
            this.disponible = false;
            return true;
        }
        return false;
    }

    public void construir(Edificio edificio, Casilla casilla) {
        this.construccion = new Construccion(edificio, casilla);
    }


    public Recursos recolectarRecursos() {
        if (recolectandoMinerales) {
            recursosRecolectados = true;
            return new Minerales(10);
        }
        return null;
    }

    public boolean tieneRecursos() {
        return !(recursosRecolectados);
    }

}
