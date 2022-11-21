package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadProtoss;
import edu.fiuba.algo3.modelo.estadisticas.Danio;

public class Scout extends UnidadProtoss {

    public Scout() {
        this.costoEnMinerales = new Mineral(300);
        this.costoEnGas = new GasVespeno(150);
        this.tiempoConstruccion = 9;
        this.danioAereo = new Danio(14);
        this.danioTerrestre = new Danio(8);
        this.rango = 4;
        this.vida = new Vida(150);
        this.escudo = new Escudo(100);
        this.aerea = true;
    }
    public Unidad generarse(Edificio edificio){
        return edificio.generarUnidad(this);
    }

    public boolean ocupar(Terreno terreno){
        boolean sePudoOcupar = true;

        try {
            terreno.ocuparPorUnidad(this);
        } catch (RuntimeException e){
            sePudoOcupar = false;
        }

        return sePudoOcupar;
    }
}
