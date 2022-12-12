package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.Nombre;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;
import edu.fiuba.algo3.modelo.unidades.estados.UnidadEnConstruccion;

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


    public void extraerRecursos(Inventario inventario){
        //Logger.log("Un Zangano en " + coordenada.devolverValorComoString() + " extrajo 10 de Mineral");
        try{
            inventario.agregarMinerales(this.terreno.extraerMinerales(new Mineral(10)));
        } catch (RecursosInsuficientes e){}
    }

    @Override
    public void actualizarUnidad(Inventario inventario) {
      regenerar();
      if(terreno != null){
          extraerRecursos(inventario);
      }
    }

}
