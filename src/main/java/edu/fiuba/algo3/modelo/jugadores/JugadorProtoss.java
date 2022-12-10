package edu.fiuba.algo3.modelo.jugadores;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;

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


    public void iniciarseEnMapa() {
        return;
    }

    public String devolverMensajeDeVictoria() {
        return "El jugador " + nombre + " a llevado a la raza Zerg a la victoria";
    }

}
