package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class JugadorZerg extends Jugador {

    private List<Zangano> zanganosDisponibles;
    private List<Criadero> criaderos = new ArrayList<Criadero>();

    public JugadorZerg(Mapa mapa) {
        mapa.buscarCasilla(1,1).establecerOcupante(new Criadero());
        this.establecerMapa(mapa);
    }

    public void construirCriadero(Casilla dondeConstruir) {
         
    }

    public void generarUnidad(Casilla casillaDelGenerador) {
        (casillaDelGenerador.devolverOcupante()).generarUnidad(mapa.hallarCasillaAdyacenteDesocupada(casillaDelGenerador));
    }
}
