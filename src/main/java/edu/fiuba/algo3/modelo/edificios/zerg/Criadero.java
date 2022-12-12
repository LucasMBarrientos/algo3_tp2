package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Nombre;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.edificios.estados.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.CoordenadaFueraDelMapa;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.AmoSupremo;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

import java.util.ArrayList;
import java.util.List;

public class Criadero extends EdificioZerg {

    private int larvas = 3;
    private int turno = 0;

    private int radioInicial = 5;
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
        actualizarLarvas();
        actualizarMapa();
    }

    private void actualizarLarvas(){
        if (larvas < 3) {
            this.larvas++;
        }
    }

    private void actualizarMapa() {
        if(turno % 4 == 0) {
            int radioActual = radioInicial + (turno / 4);
            List<Terreno> terrenosQueDeberianTenerMoho = Mapa.devolverInstancia().buscarTerrenosAdyacentes(coordenada, radioActual);
            for (Terreno terrenoQueDeberiaTenerMoho : terrenosQueDeberianTenerMoho) {
                terrenoQueDeberiaTenerMoho.cubrirTerrenoDeMoho();
            }
        }
        turno++;
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
