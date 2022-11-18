package edu.fiuba.algo3.modelo.jugadores;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoPoseeUnaUnidad;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class JugadorZerg extends Jugador {

    public JugadorZerg(String nombre, String color) {
        establecerAtributosBasicos(nombre, color, 0, 200);
    }

    public JugadorZerg(String nombre, String color, int recursosExtra) {
        establecerAtributosBasicos(nombre, color, recursosExtra, 200 + recursosExtra);
    }

    public int contarLarvas() {
        return inventario.contarLarvas();
    }

    public void actualizar() {
        //inventario.actualizar();
    }

    public void atacar(Coordenada coordenadaUnidad, Direccion direccion){
        Unidad unidad = mapa.buscarCasilla(coordenadaUnidad).devolverUnidad();
        if(unidad == null){
            throw new TerrenoNoPoseeUnaUnidad();
        }
        unidad.atacar(direccion, mapa);
    }

    protected void iniciarseEnMapa() {
        Criadero criaderoInicial = mapa.establecerInicioZerg(id);
        this.inventario.agregarEdificio(criaderoInicial);
    }

    public void generarUnidad(Casilla casilla) {
        Unidad unidadNueva = inventario.generarUnidad(casilla);
        casilla.establecerUnidad(unidadNueva);
    }

    public void generarUnidad(Coordenada coordenada){
        Casilla casilla = mapa.buscarCasilla(coordenada);
        generarUnidad(casilla);
    }

}
