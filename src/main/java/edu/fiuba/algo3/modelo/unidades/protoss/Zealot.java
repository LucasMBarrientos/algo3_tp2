package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadProtoss;

public class Zealot extends UnidadProtoss {

    public Zealot() {
        this.costoEnMinerales = new Mineral(100);
        this.costoEnGas = new GasVespeno(0);
        this.tiempoConstruccion = 4;
        this.danioTerrestre = new Danio(8);
        this.rango = 1;
        this.vida = new Vida(100);
        this.escudo = new Escudo(60);
    }
    public Unidad generarse(Edificio edificio){
        return edificio.generarUnidad(this);
    }
}
