package edu.fiuba.algo3.modelo.jugadores;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class JugadorProtoss extends Jugador {

    public JugadorProtoss(String nombre, String color) {
        establecerAtributosBasicos(nombre, color, 0, 200);
    }

    public JugadorProtoss(String nombre, String color, int recursosExtra) {
        establecerAtributosBasicos(nombre, color, recursosExtra, 200 + recursosExtra);
    }

    public void construirEdificio(Coordenada coordenada, Edificio edificio) {
        Edificio edificioNuevo = edificio.construir(inventario);
        try {
            mapa.establecerEdificio(coordenada, edificioNuevo);
        }catch(TerrenoNoAptoParaConstruirTalEdificio e) {
            edificio.devolverRecursosParaConstruccion(inventario);
            throw new TerrenoNoAptoParaConstruirTalEdificio();
        }
        edificioNuevo.establecerPosicion(coordenada);
        inventario.agregarEdificio(edificioNuevo);
    }


    public void actualizar() {
        inventario.actualizar();
    }


    protected void iniciarseEnMapa() {
        //  TODO: Spawnear alguna unidad inicial si hace falta
    }

}
