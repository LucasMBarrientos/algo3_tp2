package edu.fiuba.algo3.modelo.edificios.zerg.extractor;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoConoceEstaUnidad;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

import java.util.ArrayList;
import java.util.List;

public class Extractor extends EdificioZerg {
    Terreno terreno;
    private List<Zangano> zanganosTrabajando = new ArrayList<Zangano>();

    public Extractor() {
      this.costoEnMinerales = new Mineral(50);
      this.costoEnGas = new GasVespeno(0);
      this.vida = new Vida(750);
      this.tiempoDeConstruccion = 6;
      this.nombre = new Nombre("Extractor");
      establecerEstado(this.estadoConstruccion);
    }

    public void ocupar(Terreno terreno){
      terreno.ocuparPorEdificio(this);
      this.terreno = terreno;
    }
    

    public void ingresarUnidadTrabajadora(Zangano zangano) {
      if(zanganosTrabajando.size() < 3){
        zanganosTrabajando.add(zangano);
      }
    }

    public void validarCorrelativasDeConstruccion(Inventario inventario) { }

    public Unidad generarUnidad(Zerling unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Zangano unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Hidralisco unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Mutalisco unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Scout unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Zealot unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Dragon unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }

    public void extraerRecursos(Inventario inventario) {
      terreno.extraerGasVespeno(new GasVespeno(10* zanganosTrabajando.size()));
      inventario.agregarGasVespeno(new GasVespeno(10* zanganosTrabajando.size()));
    }

    @Override
    public void actualizarEdificio(Inventario inventario) {
      regenerar();
      extraerRecursos(inventario);
    }



    /*
    public void recibirDanio(Danio danio) throws EdificioDestruido {
        vida.recibirDanio(danio);
    }


    //recolectarRecursos(inventario);
    public void recolectarRecursos(Inventario inventario) {
        estado.recolectarRecursos(terreno, inventario);
    }
    */

/*
    public List<Unidad> zanganosTrabajando = new ArrayList<Unidad>();

    private Boolean recursosRecolectados = false;

    public int recursosRestantes = 5000;

    public Extractor() {
        this.tiempoConstruccion = 6;
        this.requerimientosGas = 0;
        this.requerimientosMinerales = 100;
    }

    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return (casilla.devolverTerreno() instanceof TerrenoVolcan);
    }

    public void actualizar() {
        recursosRecolectados = false;
        regenerarVida();
    }

    public boolean ingresarUnidad(Unidad unidad) {
        if(zanganosTrabajando.size() < 3){
            zanganosTrabajando.add(unidad);
            return true;
        }
        return false;
    }

    @Override
    public void recibirDanio(Danio danioTerestre, Danio danioAereo) {

    }*/


}
