package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaTalUnidad;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;
import edu.fiuba.algo3.modelo.unidades.estados.UnidadEnConstruccion;
import edu.fiuba.algo3.modelo.estadisticas.Vida;

public class Zangano extends UnidadZerg {

    private Terreno terreno;

    public Zangano() {
        this.costoEnGas = new GasVespeno(0);
        this.costoEnMinerales = new Mineral(25);
        this.costoSuministro = new Suministro(1);
        this.tiempoConstruccion = 1;
        this.danioAereo = new Danio(0);
        this.danioTerrestre = new Danio(0);
        this.rango = 0;
        this.vida = new Vida(25);
        this.nombre = new Nombre("Zangano");
        establecerEstado(new UnidadEnConstruccion());
    }

    public Zangano(GasVespeno costoEnGas, Mineral costoEnMinerales, Suministro costoSuministro) {
        this.costoEnGas = costoEnGas;
        this.costoEnMinerales = costoEnMinerales;
        this.costoSuministro = costoSuministro;
        this.tiempoConstruccion = 1;
        this.danioAereo = new Danio(0);
        this.danioTerrestre = new Danio(0);
        this.rango = 0;
        this.vida = new Vida(25);
        this.nombre = new Nombre("Zangano");
        establecerEstado(new UnidadEnConstruccion());
    }

    public Unidad generarse(Edificio edificio, Inventario inventario){
        return edificio.generarUnidad(this, inventario);
    }

    public boolean ocupar(Terreno terreno){
        boolean sePudoOcupar = true;

        try {
            terreno.ocuparPorUnidad(this);
            this.terreno = terreno;
        } catch (RuntimeException e){
            sePudoOcupar = false;
        }

        return sePudoOcupar;
    }

    @Override
    public void intentarOcuparAlMoverse(Terreno terreno) throws TerrenoNoAptoParaTalUnidad {
        terreno.ocuparPorUnidad(this);
    }

    public void extraerRecursos(Inventario inventario){
        inventario.agregarMinerales(this.terreno.extraerMinerales(new Mineral(10)));
    }

    @Override
    public void actualizarUnidad(Inventario inventario) {
      regenerar();
      extraerRecursos(inventario);
    }

}
