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
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import javafx.scene.layout.CornerRadii;

public class JugadorZerg extends Jugador {

    public JugadorZerg(String nombre, String color) {
        establecerAtributosBasicos(nombre, color, 0, 200);
    }

    public JugadorZerg(String nombre, String color, int gasInicial, int mineralesIniciales) {
        establecerAtributosBasicos(nombre, color, gasInicial, mineralesIniciales);
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
            mapa.establecerUnidadDelMapa(coordenada, zanganoConstructor);//si el terreno no era apto, vuelvo a meter al zangano
            throw new TerrenoNoAptoParaConstruirTalEdificio();
        }

        inventario.eliminarUnidad(coordenada);
        inventario.agregarEdificio(edificio);
    }

    public Unidad verificacionDeUnidadConstructora(Coordenada coordenada, Inventario inventario) throws NoHayUnZanganoEnEsaCoordenada{
        Unidad unidad = inventario.buscarUnidad(coordenada);
        Nombre nombreUnidadConstructora = new Nombre("Zangano");

        if(!nombreUnidadConstructora.esIgual(unidad.devolverNombre())){
            throw new UnidadNoEncontrada();
        }
        return unidad;
    }

    public void evolucionar(Coordenada coordenada, Unidad unidadAEvolucionar){

    }

    public void atacar(Coordenada coordenadaUnidad, Coordenada coordenadaObjetivo) {
        /*
        Unidad unidad = mapa.buscarTerreno(coordenadaUnidad).devolverUnidad();
        Unidad unidadObjetivo = mapa.buscarCasilla(coordenadaObjetivo).devolverUnidad();
        if(unidad == null || unidadObjetivo  == null){
            throw new TerrenoNoPoseeUnaUnidad();
        }
        unidad.atacar(coordenadaObjetivo, mapa);
        */
    }

    protected void iniciarseEnMapa() {
        Zangano zanganoInicial = mapa.establecerZanganoInicial(id);
        inventario.agregarUnidad(zanganoInicial);
        // Establecer el "amo supremo" inicial

        /*
        Criadero criaderoInicial = new Criadero();
        this.inventario.agregarEdificio(criaderoInicial);
        mapa.establecerEdificio(new Coordenada(1,1),criaderoInicial);
        */
        /*
        Criadero criaderoInicial = mapa.establecerInicioZerg(id);
        this.inventario.agregarEdificio(criaderoInicial);
        */
    }

 }



