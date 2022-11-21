package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;

public class Zangano extends UnidadZerg {

    public Zangano(Coordenada coordenadaDeLaUnidad) {
        this.costoEnGas = new GasVespeno(0);
        this.costoEnMinerales = new Mineral(25);
        this.tiempoConstruccion = 1;
        this.danioAereo = new Danio(0);
        this.danioTerrestre = new Danio(0);
        this.rango = 0;
        this.vida = new Vida(25);
        this.coordenada = coordenadaDeLaUnidad;
    }

    public Zangano() {
        this.costoEnGas = new GasVespeno(0);
        this.costoEnMinerales = new Mineral(25);
        this.tiempoConstruccion = 1;
        this.danioAereo = new Danio(0);
        this.danioTerrestre = new Danio(0);
        this.rango = 0;
        this.vida = new Vida(25);
    }

    public void construirEdificio(EdificioZerg edificio, Coordenada coordenada) {
        // TODO: Implementar esto
    }

    public void consumirRecursosParaGenerarse(Inventario inventario){

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
