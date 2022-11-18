package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.unidades.edificios.protoss.pilon.Pilon;

public class JugadorProtoss extends Jugador {

    public JugadorProtoss(String nombre, String color) {
        establecerAtributosBasicos(nombre, color, 0, 200);
    }

    public JugadorProtoss(String nombre, String color, int recursosExtra) {
        establecerAtributosBasicos(nombre, color, recursosExtra, 200 + recursosExtra);
    }

    @Override
    public void generarUnidad(Coordenada coordenada) {

    }

    protected void iniciarseEnMapa() {
        Pilon pilonInicial = mapa.establecerInicioProtoss(id);
        this.inventario.agregarEdificio(pilonInicial);
    }

/*
    public void moverse(Coordenada coordenadaUnidad, Direccion direccion){
        Unidad unidad = mapa.buscarCasilla(coordenadaUnidad).devolverUnidad();
        if(unidad == null){
            throw new UnidadInexistente();
        }
        unidad.moverse(direccion, mapa);

    }
*/



    /*

    public JugadorProtoss(Mapa mapa) {
        Pilon pilonInicial = new Pilon();
        mapa.buscarCasilla(9,9).establecerEdificio(pilonInicial);
        mapa.generarEnergizadosIniciales();
        this.establecerMapa(mapa);
    }

    public Casilla generarUnidad(Casilla casilla) {
        return casilla;
    }

    public void construirEdificio(int x, int y, Edificio edificio) {
        boolean requerimientosAlcanzados = edificio.validarRequirimientos(inventario) && mapa.buscarCasilla(x,y).devolverEdificio() == null;
        if (requerimientosAlcanzados) {
            if (edificio instanceof PuertoEstelar) {
                if (mapa.buscarEdificioAcceso()) {
                    mapa.buscarCasilla(x,y).establecerUnidad(new ConstruccionProtoss(edificio, mapa.buscarCasilla(x,y)));
                    edificio.consumirRecursosDelJugador(inventario);
                }
            } else {
                mapa.buscarCasilla(x,y).establecerUnidad(new ConstruccionProtoss(edificio, mapa.buscarCasilla(x,y)));
                edificio.consumirRecursosDelJugador(inventario);
            }
        }
    }

    public void recogerRecursos() {
        TieneRecursos edificioConRecursos = this.mapa.buscarEdificiosProtossConRecursos();
        while (edificioConRecursos != null) {
            inventario.agregarRecursos(edificioConRecursos.recolectarRecursos());
            edificioConRecursos = this.mapa.buscarEdificiosProtossConRecursos();
        }
    }
*/
}
