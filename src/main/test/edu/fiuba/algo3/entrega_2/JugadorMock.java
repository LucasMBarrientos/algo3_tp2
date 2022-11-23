package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Ocupante;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.NoHayUnZanganoEnEsaCoordenada;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.excepciones.UnidadNoEncontrada;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Jugador;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadOperativa;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public class JugadorMock extends Jugador {

    public JugadorMock(int a,int b,int c) {
        this.inventario = new Inventario(new GasVespeno(b), new Mineral(a), new Suministro(c));

    }
    public Unidad verificacionDeUnidadConstructora(Coordenada coordenada, Inventario inventario) throws NoHayUnZanganoEnEsaCoordenada {
        Unidad unidad = inventario.buscarUnidad(coordenada);
        Nombre nombreUnidadConstructora = new Nombre("Zangano");

        if(!nombreUnidadConstructora.esIgual(unidad.devolverNombre())){
            throw new UnidadNoEncontrada();
        }
        return unidad;
    }
    public void construirEdificio(Coordenada coordenada, Edificio edificio) {
        Unidad zanganoConstructor = verificacionDeUnidadConstructora(coordenada, inventario);
        edificio.construir(coordenada,inventario);
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

    public void iniciarseEnMapa(){

    }
    public void actualizar() {

        inventario.actualizar();
    }
/*
    public void establecerUnidad(Coordenada coordenada, Unidad unidad) {
        mapa.establecerUnidad(coordenada, unidad);
    }*/
    public void atacar(Coordenada unidadAtacante,Coordenada objetivo, Mapa mapa) {
        //mapa.buscarUnidad(unidadAtacante);
    }


    public void establecerMapa(Mapa mapa) {
        this.mapa = mapa;
        iniciarseEnMapa();
        Unidad unidad = new Zangano();
        unidad.establecerCoordenada(new Coordenada(2,3 ));
       this.mapa.establecerUnidad(new Coordenada(2,3 ),unidad);
       this.inventario.agregarUnidad(unidad);
    }

    public void mover(Direccion direccion, Coordenada coordenada) {
        Terreno terrenoUnidad = mapa.buscarTerreno(coordenada);
        Unidad unidad = terrenoUnidad.DEBUG_DEVOLERUNIDAD();
        unidad.moverse(direccion,mapa);
    }
}