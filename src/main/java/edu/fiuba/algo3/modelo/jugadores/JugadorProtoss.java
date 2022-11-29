package edu.fiuba.algo3.modelo.jugadores;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class JugadorProtoss extends Jugador {

    public JugadorProtoss(String nombre, String color) {
        establecerAtributosBasicos(nombre, color, 0, 200,0);
    }
    public JugadorProtoss(String nombre, String color, int gasInicial, int mineralesIniciales) {
        establecerAtributosBasicos(nombre, color, gasInicial, mineralesIniciales,0);
    }

    public JugadorProtoss(String nombre, String color, int gasInicial, int mineralesIniciales, int suministroInicial) {
        establecerAtributosBasicos(nombre, color, gasInicial, mineralesIniciales,suministroInicial);
    }

    public void construirEdificio(Coordenada coordenada, Edificio edificio) {
        Edificio edificioNuevo = edificio.construir(coordenada, inventario);
        try {
            mapa.establecerEdificio(coordenada, edificioNuevo);
        }catch(TerrenoNoAptoParaConstruirTalEdificio e) {
            edificio.devolverRecursosParaConstruccion(inventario);
            throw new TerrenoNoAptoParaConstruirTalEdificio();
        }
        edificioNuevo.establecerPosicion(coordenada);
        inventario.agregarEdificio(edificioNuevo);
        edificioInicialConstruido = true;
    }

    public void actualizar() {
        inventario.actualizar();
    }

    protected void iniciarseEnMapa() {
        //  TODO: Spawnear alguna unidad inicial si hace falta
    }

}
