package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.NoHayLarvasDisponibles;
import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.Casilla;

public class Guarida extends EdificioZerg {

    private EstadoGuarida estado = new GuaridaEnConstruccion();

    private int tiempoDeConstruccion = 12;
    private Coordenada coordenada;

    public Guarida(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public Unidad generarUnidad(Criadero criadero) throws NoHayLarvasDisponibles {
        return estado.generarUnidad(criadero);
    }
    public void actualizar() {
        estado.actualizar();
        tiempoDeConstruccion--;
        if (tiempoDeConstruccion == 0) {
            estado = new GuaridaOperativa();
        }
    }
/*
    public Guarida() {
        this.tiempoConstruccion = 12;
        this.requerimientosGas = 100;
        this.requerimientosMinerales = 200;
    }

    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return true;
    }

    public void actualizar() {
        regenerarVida();
    }*/
}
