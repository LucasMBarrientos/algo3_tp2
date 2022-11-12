package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.NoHayLarvasDisponibles;
import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.Casilla;

public class Espiral extends EdificioZerg {

    private EstadoEspiral estado = new EspiralEnConstruccion();

    private int tiempoDeConstruccion = 10;
    private Coordenada coordenada;

    public Espiral(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public Unidad generarUnidad(Criadero criadero) throws NoHayLarvasDisponibles {
        return estado.generarUnidad(criadero);
    }
    public void actualizar() {
        estado.actualizar();
        tiempoDeConstruccion--;
        if (tiempoDeConstruccion == 0) {
            estado = new EspiralOperativa();
        }
    }
/*
    public Espiral() {
        this.tiempoConstruccion = 10;
        this.requerimientosGas = 100;
        this.requerimientosMinerales = 150;
    }

    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return true;
    }

    public void actualizar() {
        regenerarVida();
    }*/
    
}
