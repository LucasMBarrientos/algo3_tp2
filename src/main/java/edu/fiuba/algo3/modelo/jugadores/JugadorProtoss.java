package edu.fiuba.algo3.modelo.jugadores;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;

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

    public ObjectNode toData() {
        ObjectNode node = Json.createObjectNode();
        node.put("nombre", nombre);
        node.put("inventario", inventario.toData());
        node.put("raza","protoss");
        node.put("color",color);
        return node;
    }
    public void construirEdificio(Coordenada coordenada, Edificio edificio) {
        Edificio edificioNuevo = edificio.construir(coordenada, inventario);
        try {
            Mapa.devolverInstancia().establecerEdificio(coordenada, edificioNuevo);
        } catch(TerrenoNoAptoParaConstruirTalEdificio e) {
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

    public void iniciarseEnMapa() {
        return;
    }

    public String devolverMensajeDeVictoria() {
        return "El jugador " + nombre + " a llevado a la raza Zerg a la victoria";
    }

}
