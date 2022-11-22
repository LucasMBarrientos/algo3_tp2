package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Ocupante;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Jugador;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadOperativa;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;

public class JugadorMock extends Jugador {

    public JugadorMock(int a,int b) {
        this.inventario = new Inventario(new GasVespeno(b), new Mineral(a));
    }

    public void construirEdificio(Coordenada coordenada, Edificio edificio) {
        //todo: verificar que haya un zangano en la coordenada, sino lanzar excepcion
        Edificio edificioNuevo = edificio.construir(coordenada,inventario);
        try {
            mapa.establecerEdificio(coordenada, edificioNuevo);
        }catch(TerrenoNoAptoParaConstruirTalEdificio e) {
            edificio.devolverRecursosParaConstruccion(inventario);
            throw new TerrenoNoAptoParaConstruirTalEdificio();
        }
        //si se llego hasta aca, eliminar al zangano (del inventario y del mapa)
        inventario.agregarEdificio(edificioNuevo);
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




    public void mover(Direccion direccion, Coordenada coordenada) {
        Terreno terrenoUnidad = mapa.buscarTerreno(coordenada);
        Unidad unidad = terrenoUnidad.DEBUG_DEVOLERUNIDAD();
        unidad.moverse(direccion,mapa);
    }
}