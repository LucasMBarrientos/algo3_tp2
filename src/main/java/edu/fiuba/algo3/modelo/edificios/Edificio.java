package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.EstadoTerreno;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.List;

public abstract class Edificio  {

    public boolean generaTerrenoEnergizado() {
        return false;
    }

    public Edificio construir(Inventario inventario){
        this.validarCorrelativasDeConstruccion(inventario);
        this.consumirRecursosParaConstruccion(inventario);
        return this;
    }

    protected abstract void consumirRecursosParaConstruccion(Inventario inventario);

    public abstract void validarCorrelativasDeConstruccion(Inventario inventario);

    public abstract void ocupar(Terreno terreno);

    public abstract void establecerTerreno(Terreno terreno);
    
    //public abstract void recibirGolpe(int danio);

    public abstract void actualizar();

    public abstract Nombre devolverNombre();

    public abstract Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespenoDelJugador, Mineral mineralDelJugador, Coordenada coordenada);

    public Unidad consumirLarvasYGenerarUnidad(Unidad unidad) {
        return null;
    }

    public abstract void recibirGolpe(Danio danioTerestre, Danio danioAereo);

    public int contarLarvas() {
        return 0;
    }

    public void consumirLarva() {
        return;
    }

}
