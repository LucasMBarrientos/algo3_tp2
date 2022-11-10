package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.edificios.TieneRecursos;
import edu.fiuba.algo3.modelo.recursos.*;

import java.util.ArrayList;
import java.util.List;

public class JugadorZerg extends Jugador {

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

    public void construirEdificio(int x, int y, Edificio edificio) { // eliminar esto
        if (this.mapa.buscarCasilla(x,y).devolverUnidad() instanceof Constructor) {
            Constructor unidadConstructora = (Constructor) this.mapa.buscarCasilla(x,y).devolverUnidad();
            unidadConstructora.construir(edificio,mapa.buscarCasilla(x,y));
        }
    }

    public void construirEdificioUsandoMinerales(int x, int y, Edificio edificio) {
        int requerimientosDelEdificio = edificio.devolverRequerimientosDeMinerales();
        if (this.mapa.buscarCasilla(x,y).devolverUnidad() instanceof Constructor) {
            if (this.inventario.devolverCantidadMinerales() >= requerimientosDelEdificio && requerimientosDelEdificio != 0) {
                Constructor unidadConstructora = (Constructor) this.mapa.buscarCasilla(x,y).devolverUnidad();
                unidadConstructora.construir(edificio,mapa.buscarCasilla(x,y));
                inventario.restarMinerales(edificio.devolverRequerimientosDeMinerales());
            }
        }
    }

    public void construirEdificioUsandoGas(int x, int y, Edificio edificio) {
        int requerimientosDelEdificio = edificio.devolverRequerimientosDeGas();
        if (this.mapa.buscarCasilla(x,y).devolverUnidad() instanceof Constructor) {
            if (this.inventario.devolverCantidadGas() >= requerimientosDelEdificio && requerimientosDelEdificio != 0) {
                Constructor unidadConstructora = (Constructor) this.mapa.buscarCasilla(x,y).devolverUnidad();
                unidadConstructora.construir(edificio,mapa.buscarCasilla(x,y));
                inventario.restarGas(edificio.devolverRequerimientosDeGas());
            }
        }
    }

    public void recogerRecursos() {
        recogerRecursosDeEdificios();
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
    }
}
