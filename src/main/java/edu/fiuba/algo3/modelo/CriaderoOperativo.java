package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;

public class CriaderoOperativo implements EstadoDeConstruccion {

    private int larvas = 3; //hacer clase Larva (?

    public Zangano generarZangano() throws NoHayLarvasDisponibles{ //ZANGANO NO ES UNA UNIDAD, TIENE COMPORTAMIENTO DISTINTO!!
        if (larvas <= 0) {
            throw new NoHayLarvasDisponibles();
        }
        this.larvas--;
        return new Zangano();
    }


    public Unidad generarUnidad(Unidad unidad) throws NoHayLarvasDisponibles{
        if (larvas <= 0) {
            throw new NoHayLarvasDisponibles();
        }
        this.larvas--;
        return unidad;
    }

    public void actualizar() {
        if (larvas < 3) {
            this.larvas++;
        }
    }
}
