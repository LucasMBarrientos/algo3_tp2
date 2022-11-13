package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.recursos.Minerales;

public class ReservaDeReproduccion extends EdificioZerg {


    private EstadoReserva estado = new ReservaEnConstruccion();

    private int tiempoDeConstruccion = 12;
    private Coordenada coordenada;

    public ReservaDeReproduccion() {
        this.costoEnMinerales = new Minerales(150);
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
