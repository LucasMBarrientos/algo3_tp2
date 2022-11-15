package edu.fiuba.algo3.modelo.edificios.zerg;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.EdificioDestruido;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMoho;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public class Criadero extends EdificioZerg {

    private EstadoCriadero estado = new CriaderoEnConstruccion();
    private int tiempoDeConstruccion = 4;
    private Coordenada coordenada;

    public Criadero() {
        this.costoEnMinerales = new Minerales(50);
        this.posiblesTerrenos = List.of(new TerrenoMoho());
        this.edificiosNecesarios = List.of();
        this.vida = new Vida(300);
    }


    public Criadero(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public Zangano generarZangano() throws NoHayLarvasDisponibles{ //Leti: refactor aca.
        return estado.generarZangano();
    }

    public Unidad generarUnidad(Unidad unidad) throws NoHayLarvasDisponibles{
        return estado.generarUnidad(unidad);
    }

    public void actualizar(){
        estado.actualizar();
        tiempoDeConstruccion--;
        if(tiempoDeConstruccion == 0){
            estado = new CriaderoOperativo();
        }
        vida.regenerar();
    }


    public void actualizar(Inventario inventario) {
        estado.actualizar();
        tiempoDeConstruccion--;
        if(tiempoDeConstruccion == 0){
            estado = new CriaderoOperativo();
        }
        vida.regenerar();
    }
    @Override
    public void consumirRecursosParaConstruccion(Inventario inventario){
        inventario.consumirMinerales(costoEnMinerales);
    }


    public void ocupar(Casilla casilla, Terreno terreno){

        terreno.ocuparPorEdificio(this, casilla);
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
