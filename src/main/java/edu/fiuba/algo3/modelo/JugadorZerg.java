package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.edificios.TieneRecursos;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.recursos.*;

import java.util.ArrayList;
import java.util.List;

public class JugadorZerg extends Jugador {

    public JugadorZerg(String nombre, String color) {
        establecerAtributosBasicos(nombre, color, 0, 200);
    }

    public JugadorZerg(String nombre, String color, int recursosExtra) {
        establecerAtributosBasicos(nombre, color, recursosExtra, 200 + recursosExtra);
    }

    public void actualizar() {
        inventario.actualizar();
    }

    public Inventario devolInventario() {
        return this.inventario;
    }

    protected void iniciarseEnMapa() {
        mapa.establecerInicioZerg(id);
    }



    /*
    public JugadorZerg(Mapa mapa) {
        Criadero criaderoInicial = new Criadero();
        mapa.buscarCasilla(1,1).establecerEdificio(criaderoInicial);
        mapa.generarMoho(5);
        this.establecerMapa(mapa);
    }


    public Casilla generarUnidad(Casilla casillaDelGenerador) {
        GeneradorDeUnidades edificioGenerador = (GeneradorDeUnidades) casillaDelGenerador.devolverEdificio();
        edificioGenerador.generarUnidad(casillaDelGenerador);
       // unidadGenerada.establecerCasilla(casillaDisponible);
       // this.unidadesDisponibles.add(unidadGenerada);
        return casillaDelGenerador;
    }

    public void construirEdificio(int x, int y, Edificio edificio) {        
        boolean requerimientosAlcanzados = edificio.validarRequirimientos(inventario) && mapa.buscarCasilla(x,y).devolverEdificio() == null;
        if (this.mapa.buscarCasilla(x,y).devolverUnidad() instanceof Constructor && requerimientosAlcanzados) {
            if (edificio instanceof Espiral) {
                if (mapa.buscarEdificioGuarida()) {
                    mapa.buscarCasilla(x,y).establecerUnidad(new ConstruccionProtoss(edificio, mapa.buscarCasilla(x,y)));
                    edificio.consumirRecursosDelJugador(inventario);
                }
            } else {
                Constructor unidadConstructora = (Constructor) this.mapa.buscarCasilla(x,y).devolverUnidad();
                unidadConstructora.construir(edificio,mapa.buscarCasilla(x,y));
                edificio.consumirRecursosDelJugador(inventario);
            }
        }
    }

    public void recogerRecursos() {
        TieneRecursos edificioConRecursos = this.mapa.buscarEdificiosZergConRecursos();
        while (edificioConRecursos != null) {
            inventario.agregarRecursos(edificioConRecursos.recolectarRecursos());
            edificioConRecursos = this.mapa.buscarEdificiosZergConRecursos();
        }
        recogerRecursosDeZanganosMineros();
    }

    public void recogerRecursosDeZanganosMineros() {
        TieneRecursos zanganoExtrayendoMinerales = this.mapa.buscarMineralesConZanganos();
        while (zanganoExtrayendoMinerales != null) {
            Recursos nuevosRecursos = zanganoExtrayendoMinerales.recolectarRecursos();
            if (nuevosRecursos != null) {
                inventario.agregarRecursos(zanganoExtrayendoMinerales.recolectarRecursos());
            }
            zanganoExtrayendoMinerales = this.mapa.buscarMineralesConZanganos();
        }
    }*/
}
