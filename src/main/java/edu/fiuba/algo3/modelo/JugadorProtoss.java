package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.TieneRecursos;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;

import java.util.ArrayList;
import java.util.List;

public class JugadorProtoss extends Jugador {

    public JugadorProtoss(Mapa mapa) {
        this.id = 1;
        this.mapa = mapa;
        this.inventario = new Inventario(new GasVespeno(0), new Minerales(200));
    }

    @Override
    public void construirEdificio(Coordenada coord, Edificio edificio) {
        mapa.buscarCasilla(coord).ponerEdificio(edificio.construir(inventario));
        inventario.agregarEdificio(edificio);
    }

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
