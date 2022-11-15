package edu.fiuba.algo3.modelo.edificios.zerg;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMoho;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class ReservaDeReproduccion extends EdificioZerg {


    private EstadoReserva estado = new ReservaEnConstruccion();

    private int tiempoDeConstruccion = 12;
    private Coordenada coordenada;

    public ReservaDeReproduccion() {
        this.costoEnMinerales = new Minerales(150);
        this.posiblesTerrenos = List.of(new TerrenoMoho());
        this.edificiosNecesarios = List.of();
    }

    public ReservaDeReproduccion(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public Unidad generarUnidad(Criadero criadero) throws NoHayLarvasDisponibles {
        return estado.generarUnidad(criadero);
    }
    public void actualizar() {
        estado.actualizar();
        tiempoDeConstruccion--;
        if(tiempoDeConstruccion == 0){
            estado = new ReservaOperativa();
        }
    }

    public void ocupar(Casilla casilla, Terreno terreno){
        terreno.ocuparPorEdificio(this, casilla);
    }

    public void actualizar(Inventario inventario){}
/*
    public ReservaDeReproduccion() {
        this.tiempoConstruccion = 12;
        this.requerimientosGas = 0;
        this.requerimientosMinerales = 150;
    }

    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return true;
    }

    public void actualizar() {
        regenerarVida();
    }
*/
}
