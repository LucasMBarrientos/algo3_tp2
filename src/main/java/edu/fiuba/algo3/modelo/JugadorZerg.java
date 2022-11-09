package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class JugadorZerg extends Jugador {

    private List<Zangano> zanganosDisponibles;
    private List<Criadero> criaderos = new ArrayList<Criadero>();

    public JugadorZerg(Mapa mapa) {
        Criadero criaderoInicial = new Criadero();
        mapa.buscarCasilla(1,1).establecerOcupante(criaderoInicial);
        criaderos.add(criaderoInicial);
        mapa.generarMoho();
        this.establecerMapa(mapa);
    }

    public Casilla generarUnidad(Casilla casillaDelGenerador) {
        GeneradorDeUnidades edificioGenerador = (GeneradorDeUnidades)casillaDelGenerador.devolverOcupante();
        Casilla casillaDisponible = mapa.hallarCasillaAdyacenteDesocupada(casillaDelGenerador);
        Unidad unidadGenerada = edificioGenerador.generarUnidad(casillaDisponible);
        unidadGenerada.establecerCasilla(casillaDisponible);
        this.unidadesDisponibles.add(unidadGenerada);
        return casillaDisponible;
    }
}
