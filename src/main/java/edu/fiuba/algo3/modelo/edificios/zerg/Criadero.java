package edu.fiuba.algo3.modelo.edificios.zerg;

import java.util.List;

import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.edificios.estados.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.*;

public class Criadero extends EdificioZerg {

    private int larvas = 3;
    private Recurso suministroAAgregar = new Suministro(5);
    
    public Criadero() {
        this.costoEnMinerales = new Mineral(200);
        this.costoEnGas = new GasVespeno(0);
        this.tiempoDeConstruccion = 4;
        this.vida = new Vida(500);
        this.nombre = new Nombre("Criadero");
        establecerEstado(new EdificioEnConstruccion());
    }

    @Override
    public void actualizarEdificio(Inventario inventario) {
        regenerar();
        if (larvas < 3) {
            this.larvas++;
        }
    }

    @Override
    public boolean consumirLarva() {
      if(estadoActual.consumirLarva(larvas)){
        this.larvas--;
        return true;
      }

      return false;
    }

    @Override
    public void agregarSuministro(Inventario inventario) {
        inventario.agregarSuministro(suministroAAgregar);
    }

    @Override
    public void actualizarListasDeCoordenadasSegunEdificio(List<Coordenada> coordenadasConCriaderos, List<Coordenada> coordenadasConPilones) {
        coordenadasConCriaderos.add(coordenada);
    }

    @Override
    public void restarSuministros(Inventario inventario) {
        inventario.restarSuministro(suministroAAgregar);
    }

    public void ocupar(Terreno terreno){
        terreno.ocuparPorEdificio(this);
    }

    public Unidad generarUnidad(Zangano unidad, Inventario inventario) {
        return estadoActual.generarUnidad(unidad,inventario);
    }

    public Unidad generarUnidad(AmoSupremo unidad, Inventario inventario) {
        return estadoActual.generarUnidad(unidad,inventario);
    }

}
