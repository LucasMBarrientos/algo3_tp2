package edu.fiuba.algo3.modelo.jugadores;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;

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
            mapa.establecerEdificioEn(coordenada, edificioNuevo);
        }catch(TerrenoNoAptoParaConstruirTalEdificio e) {
            edificio.devolverRecursosParaConstruccion(inventario);
            throw new TerrenoNoAptoParaConstruirTalEdificio();
        }
        inventario.agregarEdificio(edificioNuevo);
    }

    @Override
    public void generarUnidad(Coordenada coordenada) {
    }

    protected void iniciarseEnMapa() {
        Pilon pilonInicial = mapa.establecerInicioProtoss(id);
        this.inventario.agregarEdificio(pilonInicial);
    }

}
