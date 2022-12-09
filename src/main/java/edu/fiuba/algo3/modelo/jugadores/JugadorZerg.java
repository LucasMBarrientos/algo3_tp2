package edu.fiuba.algo3.modelo.jugadores;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Nombre;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

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
        node.put("nombre", nombre);
        node.put("inventario", inventario.toData());
        node.put("raza","zerg");
        node.put("color",color);

        return node;
    }


    public void construirEdificio(Coordenada coordenada, Edificio edificio) {
        Unidad zanganoConstructor = verificacionDeUnidadConstructora(coordenada, inventario);
        edificio.construir(coordenada, inventario);
        Mapa.eliminarUnidad(coordenada); // Primero elimino al zangano porque no puedo construir sobre terrenoOcupado
        try {
            Mapa.establecerEdificio(coordenada, edificio);
        }catch(TerrenoNoAptoParaConstruirTalEdificio e) {
            edificio.devolverRecursosParaConstruccion(inventario);
            Mapa.establecerUnidad(coordenada, zanganoConstructor); // Si el terreno no era apto, vuelvo a meter al zangano
            throw new TerrenoNoAptoParaConstruirTalEdificio();
        }

        inventario.eliminarUnidad(coordenada);
        inventario.agregarEdificio(edificio);
        edificioInicialConstruido = true;
    }

    public Unidad verificacionDeUnidadConstructora(Coordenada coordenada, Inventario inventario) throws NoHayUnZanganoEnEsaCoordenada {
        Unidad unidad = inventario.buscarUnidad(coordenada);
        Nombre nombreUnidadConstructora = new Nombre("Zangano");

        if(!nombreUnidadConstructora.esIgual(unidad.devolverNombre())){
            throw new NoHayUnZanganoEnEsaCoordenada();
        }
        return unidad;
    }

    @Override
    public void evolucionar(Coordenada coordenada, Unidad unidadAEvolucionar) {
        inventario.evolucionarUnidad(coordenada, unidadAEvolucionar);
    }

    public void ingresarUnidad(Coordenada coordenada){
        Unidad unidad = inventario.buscarUnidad(coordenada);
        unidad.ocupar(Mapa.buscarTerreno(coordenada));
    }

    @Override
    public void ingresarUnidadAUnEdificio(Coordenada coordenadaDelEdificio, Coordenada coordenadaDeLaUnidad){
        Unidad unidad = inventario.buscarUnidad(coordenadaDeLaUnidad);
        Edificio edificio = inventario.buscarEdificio(coordenadaDelEdificio);
        edificio.ingresarUnidad(unidad);
        Mapa.eliminarUnidad(coordenadaDeLaUnidad);
        inventario.eliminarUnidad(coordenadaDeLaUnidad);
    }

    public void iniciarseEnMapa() {
        Zangano zanganoInicial = Mapa.establecerZanganoInicial(id);
        inventario.agregarUnidad(zanganoInicial);
    }

    public String devolverMensajeDeVictoria() {
        return "El jugador " + nombre + " logro repeeler a los Zerg de la zona";
    }

 }



