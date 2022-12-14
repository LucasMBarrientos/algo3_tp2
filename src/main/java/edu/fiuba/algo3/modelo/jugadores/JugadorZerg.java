package edu.fiuba.algo3.modelo.jugadores;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

import java.util.ArrayList;
import java.util.List;

public class JugadorZerg extends Jugador {

    public JugadorZerg(String nombre, String color) {
        establecerAtributosBasicos(nombre, color, 0, 200,0);
    }

    public JugadorZerg(String nombre, String color, int gasInicial, int mineralesIniciales, int suministroInicial) {
        establecerAtributosBasicos(nombre, color, gasInicial, mineralesIniciales,suministroInicial);
    }

    public JugadorZerg(Inventario inventario) {
        this.inventario = inventario;
    }

    public ObjectNode toData(){
        ObjectNode node = Json.createObjectNode();
        node.put("nombre", nombre.devolverValor());
        node.put("inventario", inventario.toData());
        node.put("raza","zerg");
        node.put("color",color);

        return node;
    }

    @Override
    public void evolucionar(Coordenada coordenada, Unidad unidadAEvolucionar) {
        Unidad unidad = inventario.buscarUnidad(coordenada);
        unidad.evolucionar(unidadAEvolucionar, inventario);
    }

    @Override
    public void ingresarUnidadAUnEdificio(Coordenada coordenadaDelEdificio, Coordenada coordenadaDeLaUnidad){
        Unidad unidad = inventario.buscarUnidad(coordenadaDeLaUnidad);
        Edificio edificio = inventario.buscarEdificio(coordenadaDelEdificio);
        edificio.ingresarUnidad(unidad);
        Mapa.devolverInstancia().eliminarUnidad(coordenadaDeLaUnidad);
        inventario.eliminarUnidad(coordenadaDeLaUnidad);
    }

    public void iniciarseEnMapa() {
        Zangano zanganoInicial = Mapa.devolverInstancia().establecerZanganoInicial(id);
        inventario.agregarUnidad(zanganoInicial);
    }

    public List<String> devolverMediaDeVictoria() {
        List<String> objetos = new ArrayList<String>();
        objetos.add("/victoriaZerg.jpg");
        objetos.add( nombre.devolverValor() + " a llevado a la raza Zerg a la victoria");
        return objetos;
    }

}



