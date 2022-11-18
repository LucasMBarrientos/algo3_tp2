package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.terrenos.EstadoTerreno;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.List;

public abstract class Edificio  {

    public boolean generaTerrenoEnergizado() {
        return false;
    }

    public abstract Edificio construir(Inventario inventario);
    
    public abstract List<EstadoTerreno> posiblesEstados();

    protected abstract void consumirRecursosParaConstruccion(Inventario inventario);

    public abstract boolean validarCorrelativas(Inventario inventario);

    public abstract void ocupar(Casilla casilla, Terreno terreno);

    public abstract void establecerTerreno(Terreno terreno);
    
    //public abstract void recibirGolpe(int danio);

    public abstract void actualizar();

    public abstract boolean compararCon(Edificio edificoAComparar);

    public abstract String devolverNombre();

    public abstract Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespenoDelJugador, Minerales mineralesDelJugador, Coordenada coordenada);

    public Unidad consumirLarvasYGenerarUnidad(Unidad unidad) {
        return null;
    }

    public abstract void recibirGolpe(Danio danio);

    public int contarLarvas() {
        return 0;
    }

    public void consumirLarva() {
        return;
    }

}
