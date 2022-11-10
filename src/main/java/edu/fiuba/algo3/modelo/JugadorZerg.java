package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;

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

    public void construirEdificio(int x, int y, Edificio edificio) {
        if (this.mapa.buscarCasilla(x,y).devolverUnidad() instanceof Constructor) {
            Constructor unidadConstructora = (Constructor) this.mapa.buscarCasilla(x,y).devolverUnidad();
            unidadConstructora.construir(edificio,mapa.buscarCasilla(x,y));
        }
    }
}
