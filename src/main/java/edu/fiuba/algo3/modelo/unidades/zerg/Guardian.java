package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;

public class Guardian extends UnidadZerg {

    public Guardian(Coordenada coordenadaDeLaUnidad) {
        this.costoEnGas = new GasVespeno(100);
        this.costoEnMinerales = new Mineral(50);
        this.tiempoConstruccion = 4;
        this.danioTerrestre = new Danio(25);
        this.rango = 10;
        this.vida = new Vida(100);
        this.aerea = true;
        this.coordenada = coordenadaDeLaUnidad;
    }

    public Guardian() {
        this.costoEnGas = new GasVespeno(100);
        this.costoEnMinerales = new Mineral(50);
        this.tiempoConstruccion = 4;
        this.danioTerrestre = new Danio(25);
        this.rango = 10;
        this.vida = new Vida(100);
        this.nombre = new Nombre("Guardian");
        this.aerea = true;
    }

    @Override
    public Unidad generarse(Edificio edificio, Inventario inventario) {
        return null;
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
