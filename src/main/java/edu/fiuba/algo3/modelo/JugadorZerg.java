package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class JugadorZerg {

    private List<Zangano> zanganosDisponibles;
    private List<Edificio> edificios = new ArrayList<Edificio>();

    public void construirCriadero(Casilla dondeConstruir){
        edificios.add(new Criadero(dondeConstruir));
    }

    public void generarZangano(Casilla ubicacionCriadero){
        for (int i = 0; i < edificios.size(); i++){
            if(edificios.get(i).esLaMismaCasilla(ubicacionCriadero)){
                //edificios.get(i).generarZangano()
            }
        }
    }
}
