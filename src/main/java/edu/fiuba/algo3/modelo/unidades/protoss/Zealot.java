package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.Nombre;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadProtoss;
import edu.fiuba.algo3.modelo.unidades.estados.UnidadEnConstruccion;
import edu.fiuba.algo3.modelo.unidades.modificadores.Visibilidad;
import edu.fiuba.algo3.modelo.unidades.modificadores.Visible;

public class Zealot extends UnidadProtoss {

    protected Visibilidad visibilidad;

    public Zealot() {
        this.costoEnMinerales = new Mineral(100);
        this.costoEnGas = new GasVespeno(0);
        this.costoSuministro = new Suministro(2);
        this.tiempoConstruccion = 4;
        this.danioTerrestre = new Danio(8);
        this.rango = 1;
        this.vida = new Vida(100);
        this.escudo = new Escudo(60);
        this.nombre = new Nombre("Zealot");
        establecerVisibilidad(new Visible());
        establecerEstado(new UnidadEnConstruccion());
    }

    @Override
    public void actualizarUnidad(Inventario inventario) {
      regenerar();
    }
    
    public boolean ocupar(Terreno terreno) {
        boolean sePudoOcupar = true;
        try {
            terreno.ocuparPorUnidad(this);
        } catch (RuntimeException e){
            sePudoOcupar = false;
        }
        return sePudoOcupar;
    }

    @Override
    public void ejecutarDanio(Danio danioTerrestre, Danio danioAereo) {
        visibilidad.ejecutarDanio(danioTerrestre, vida, escudo, this);
    }

    @Override
    public void establecerVisibilidad(Visibilidad visibilidad) {
        this.visibilidad = visibilidad;
    }

    public Unidad generarse(Edificio edificio, Inventario inventario) {
        return edificio.generarUnidad(this,inventario);
    }

}
