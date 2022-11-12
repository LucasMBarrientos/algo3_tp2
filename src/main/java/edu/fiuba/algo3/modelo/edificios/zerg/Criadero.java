package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.recursos.Recursos;

public class Criadero extends EdificioZerg {

    private EstadoCriadero estado = new CriaderoEnConstruccion();
    private int tiempoDeConstruccion = 4;
    private Coordenada coordenada;

    private int costoEnMinerales;

    public Criadero(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public Zangano generarZangano() throws NoHayLarvasDisponibles{
        return estado.generarZangano();
    }

    public Unidad generarUnidad(Unidad unidad) throws NoHayLarvasDisponibles{
        return estado.generarUnidad(unidad);
    }

    public void actualizar() {
        estado.actualizar();
        tiempoDeConstruccion--;
        if(tiempoDeConstruccion == 0){
            estado = new CriaderoOperativo();
        }
    }

    public void consumirRecursos(Recursos recurso){
        recurso.gastarUnidades(costoEnMinerales);
    }


/*
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
        regenerarVida();
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
    */
}
