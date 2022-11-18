package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.unidades.edificios.EdificioZerg;

public class Zangano extends UnidadZerg {

    public Zangano(GasVespeno gasVespenoDelJugador, Minerales mineralesDelJugador, Coordenada coordenadaDeLaUnidad) {
        gasVespenoDelJugador.gastar(new GasVespeno(0));
        mineralesDelJugador.gastar(new Minerales(25));
        this.tiempoConstruccion = 1;
        this.danioAereo = new Danio(0);
        this.danioTerrestre = new Danio(0);
        this.rango = 0;
        this.vida = new Vida(25);
        this.coordenada = coordenadaDeLaUnidad;
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
