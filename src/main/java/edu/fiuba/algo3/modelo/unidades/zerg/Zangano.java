package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMineral;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;
import edu.fiuba.algo3.modelo.estadisticas.Vida;

public class Zangano extends UnidadZerg {

    public Zangano(Coordenada coordenada ) {
        this.coordenada = coordenada;
        this.vida = new Vida(10);
    }

    public void construirEdificio(EdificioZerg edificio, Coordenada coordenada) {
        
    }



    /*

    public void construir(Edificio edificio, Casilla casilla) {
        this.construccion = new Construccion(this, casilla);
    }
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
*/
}
