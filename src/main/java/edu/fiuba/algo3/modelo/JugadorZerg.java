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
        this.establecerMapa(mapa);
    }

    public void construirEdificio(int x, int y, Edificio edificio) {
        if (mapa.buscarCasilla(x,y).devolverOcupante() instanceof Zangano) {
            // Si ya esta construyendo algo entonces empieza otra construccion nueva
            Casilla ubicacionDelEdificio = mapa.buscarCasilla(x,y);
            Zangano zanganoConstructor = (Zangano)ubicacionDelEdificio.devolverOcupante();
            zanganoConstructor.construir(edificio, ubicacionDelEdificio);
        }
    };

    public Casilla generarUnidad(Casilla casillaDelGenerador) {
        GeneraUnidades edificioGenerador = (GeneraUnidades)casillaDelGenerador.devolverOcupante();
        Casilla casillaDisponible = mapa.hallarCasillaAdyacenteDesocupada(casillaDelGenerador);
        edificioGenerador.generarUnidad(casillaDisponible);
        return casillaDisponible;
    }
}
