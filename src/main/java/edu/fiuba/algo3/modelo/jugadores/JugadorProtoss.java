package edu.fiuba.algo3.modelo.jugadores;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
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
        node.put("nombre", nombre.devolverValor());
        node.put("inventario", inventario.toData());
        node.put("raza","protoss");
        node.put("color",color);
        return node;
    }

    public void ingresarUnidadAUnEdificio(Coordenada coordenadaDelEdificio, Coordenada coordenadaDeLaUnidad) {
        return;
    }

    public void iniciarseEnMapa() {
        return;
    }

    public List<String> devolverMediaDeVictoria() {
        List<String> objetos = new ArrayList<String>();
        objetos.add("/victoriaProtoss.jpg");
        objetos.add( nombre.devolverValor() + " logro repeeler a los Zerg de la zona");
        return objetos;
    }

}
