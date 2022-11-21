package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadProtoss;

public class Dragon extends UnidadProtoss {

    public Dragon() {
        this.costoEnMinerales = new Mineral(125);
        this.costoEnGas = new GasVespeno(50);
        this.tiempoConstruccion = 6;
        this.danioAereo = new Danio(20);
        this.danioTerrestre = new Danio(20);
        this.rango = 4;
        this.vida = new Vida(100);
        this.escudo = new Escudo(80);
    }
    public Unidad generarse(Edificio edificio){
        return edificio.generarUnidad(this);
    }

    public boolean ocupar(Terreno terreno){
        boolean sePudoOcupar = true;

        try {
            terreno.ocuparPorUnidad(this);
        } catch (RuntimeException e){ //ver que esto ande, porque puede lanzar excepciones diferentes
            sePudoOcupar = false;
        }

        return sePudoOcupar;
    }

}
