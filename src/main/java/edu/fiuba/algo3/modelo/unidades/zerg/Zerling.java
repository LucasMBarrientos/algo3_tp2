package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;
import edu.fiuba.algo3.modelo.estadisticas.Danio;

public class Zerling extends UnidadZerg {
    
    public Zerling(Coordenada coordenadaDeLaUnidad) {
        this.costoEnGas = new GasVespeno(0);
        this.costoEnMinerales = new Mineral(25);
        this.tiempoConstruccion = 2;
        this.danioAereo = new Danio(0);
        this.danioTerrestre = new Danio(4);
        this.rango = 1;
        this.vida = new Vida(35);
        this.coordenada = coordenadaDeLaUnidad;
    }

}
