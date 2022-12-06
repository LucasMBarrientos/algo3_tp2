package edu.fiuba.algo3.modelo.jugadores;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.AmoSupremo;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import javafx.scene.layout.CornerRadii;

public class JugadorZerg extends Jugador {

    public JugadorZerg(String nombre, String color) {
        establecerAtributosBasicos(nombre, color, 0, 200,0);
    }

    public JugadorZerg(String nombre, String color, int gasInicial, int mineralesIniciales, int suministroInicial) {
        establecerAtributosBasicos(nombre, color, gasInicial, mineralesIniciales,suministroInicial);
    }

    // DEBUG ONLY
    public JugadorZerg(Inventario inventario) {
        this.inventario = inventario;
    }

    public void construirEdificio(Coordenada coordenada, Edificio edificio) {
        Unidad zanganoConstructor = verificacionDeUnidadConstructora(coordenada, inventario);
        edificio.construir(coordenada, inventario);
        mapa.eliminarUnidad(coordenada); //primero elimino al zangano porque no puedo construir sobre terrenoOcupado

        try {
            mapa.establecerEdificio(coordenada, edificio);
        }catch(TerrenoNoAptoParaConstruirTalEdificio e) {
            edificio.devolverRecursosParaConstruccion(inventario);
            mapa.establecerUnidad(coordenada, zanganoConstructor);//si el terreno no era apto, vuelvo a meter al zangano
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
        inventario.evolucionarUnidad(mapa, coordenada, unidadAEvolucionar);
    }

    public void ingresarUnidad(Coordenada coordenada){
        Unidad unidad = inventario.buscarUnidad(coordenada);
        unidad.ocupar(mapa.buscarTerreno(coordenada));
    }

    @Override
    public void ingresarUnidadAUnEdificio(Coordenada coordenadaDelEdificio, Coordenada coordenadaDeLaUnidad){
        Unidad unidad = inventario.buscarUnidad(coordenadaDeLaUnidad);
        Edificio edificio = inventario.buscarEdificio(coordenadaDelEdificio);
        edificio.ingresarUnidad(unidad);
        mapa.eliminarUnidad(coordenadaDeLaUnidad);
        inventario.eliminarUnidad(coordenadaDeLaUnidad);
    }

    protected void iniciarseEnMapa() {
        Zangano zanganoInicial = mapa.establecerZanganoInicial(id);
        inventario.agregarUnidad(zanganoInicial);
    }

    public String devolverMensajeDeVictoria() {
        return "El jugador " + nombre + " logro repeeler a los Zerg de la zona";
    }

 }



